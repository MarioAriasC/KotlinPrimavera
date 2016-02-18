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

import org.funktionale.option.Option
import org.funktionale.option.Option.None
import org.funktionale.option.Option.Some
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.jdbc.core.RowMapper
import java.sql.PreparedStatement
import java.sql.ResultSet

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 20/08/13
 * Time: 23:07
 */

@Suppress("BASE_WITH_NULLABLE_UPPER_BOUND") fun <T> emptyResultToNull(body: () -> T): T? = try {
    body()
} catch(e: EmptyResultDataAccessException) {
    null
}

fun <T> emptyResultToOption(body: () -> T): Option<T> = try {
    Some(body())
} catch(e: EmptyResultDataAccessException) {
    None
}

fun <T> rowMapperObject(rowMapper: (ResultSet, Int) -> T): RowMapper<T> = RowMapper { rs, rowNum -> rowMapper(rs, rowNum) }

inline fun<T> ResultSet.extract(body: ResultSetGetFieldTokens.() -> T): T {
    return ResultSetGetFieldTokens(this).body()
}

fun PreparedStatement.arguments(body: PreparedStatementArgumentsSetter.() -> Unit) {
    PreparedStatementArgumentsSetter(this).body()
}

fun <T> JdbcOperations.query(sql: String, vararg args: Any, rse: (ResultSet) -> T): T {
    return this.query(sql, ResultSetExtractor<T> { rs -> rse(rs) }, *args)
}

fun JdbcOperations.query(sql: String, rse: (ResultSet) -> Unit): Unit {
    return this.query(sql, { rs -> rse(rs) })
}

fun <T> JdbcOperations.query(sql: String, rse: (ResultSet) -> T): T {
    return this.query(sql, ResultSetExtractor<T> { rs -> rse(rs) })
}

fun <T> JdbcOperations.query(sql: String, vararg args: Any, rowMapper: (ResultSet, Int) -> T): List<T> {
    return this.query(sql, rowMapperObject(rowMapper), *args)
}

fun <T> JdbcOperations.queryForObject(sql: String, vararg args: Any, rowMapper: (ResultSet, Int) -> T): T {
    return this.queryForObject(sql, rowMapperObject(rowMapper), *args)
}


