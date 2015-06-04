/*
 * Copyright 2013 Mario Arias
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kotlinprimavera.jdbc.core

import org.springframework.dao.EmptyResultDataAccessException
import org.funktionale.option.*
import java.sql.ResultSet
import java.sql.PreparedStatement
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.RowCallbackHandler

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 20/08/13
 * Time: 23:07
 */

@suppress("BASE_WITH_NULLABLE_UPPER_BOUND")
public fun emptyResultToNull<T>(body: () -> T): T? = try {
    body()
} catch(e: EmptyResultDataAccessException) {
    null
}

public fun emptyResultToOption<T>(body: () -> T): Option<T> = try {
    Some(body())
} catch(e: EmptyResultDataAccessException) {
    None()
}

public fun rowMapperObject<T>(rowMapper: (ResultSet, Int) -> T): RowMapper<T> = object : RowMapper<T> {
    public override fun mapRow(rs: ResultSet, rowNum: Int): T {
        return rowMapper(rs, rowNum)
    }

}

public inline fun<T> ResultSet.extract(body: ResultSetGetFieldTokens.() -> T): T {
    return ResultSetGetFieldTokens(this).body()
}

@deprecated("use ResultSet.extract. Will be deleted in 0.5")
public fun<T> ResultSet.build(body: ResultSetGetFieldTokens.() -> T): T {
    return extract(body)
}

public fun PreparedStatement.arguments(body: PreparedStatementArgumentsSetter.() -> Unit) {
    PreparedStatementArgumentsSetter(this).body()
}

public fun JdbcOperations.query<T>(sql: String, vararg args: Any, rse: (ResultSet) -> T): T {
    return this.query(sql, object : ResultSetExtractor<T> {
        public override fun extractData(rs: ResultSet): T {
            return rse(rs)
        }
    }, *args)
}

public fun JdbcOperations.query(sql: String, rse: (ResultSet) -> Unit): Unit {
    return this.query(sql, object : RowCallbackHandler {
        override fun processRow(rs: ResultSet) {
            rse(rs)
        }
    })
}

public fun JdbcOperations.query<T>(sql: String, rse: (ResultSet) -> T): T {
    return this.query(sql, object : ResultSetExtractor<T> {
        public override fun extractData(rs: ResultSet): T {
            return rse(rs)
        }
    })
}

public fun JdbcOperations.query<T>(sql: String, vararg args: Any, rowMapper: (ResultSet, Int) -> T): List<T> {
    return this.query(sql, rowMapperObject(rowMapper), *args)
}

public fun JdbcOperations.queryForObject<T>(sql: String, vararg args: Any, rowMapper: (ResultSet, Int) -> T): T {
    return this.queryForObject(sql, rowMapperObject(rowMapper), *args)
}


