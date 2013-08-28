package org.kotlinprimavera.jdbc.core

import org.springframework.dao.EmptyResultDataAccessException
import org.funktionale.option.*
import java.sql.ResultSet
import java.sql.PreparedStatement
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.jdbc.core.RowMapper

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 20/08/13
 * Time: 23:07
 */

public fun emptyResultToNull<T>(body: ()->T): T? {
    return try{
        body()
    }catch(e: EmptyResultDataAccessException){
        null
    }
}

public fun emptyResultToOption<T>(body: ()->T): Option<T> {
    return try {
        Some(body())
    } catch(e: EmptyResultDataAccessException) {
        none
    }
}

public fun rowMapperObject<T>(rowMapper: (ResultSet, Int) -> T): RowMapper<T> {
    return object:RowMapper<T>{
        public override fun mapRow(rs: ResultSet?, rowNum: Int): T? {
            rowMapper(rs!!, rowNum)
        }

    }
}

public fun<T> ResultSet.build(body: ResultSetGetFieldTokens.() -> T): T {
    return ResultSetGetFieldTokens(this).body()
}

public fun PreparedStatement.arguments(body: PreparedStatementArgumentsSetter.() -> Unit) {
    PreparedStatementArgumentsSetter(this).body()
}

public fun JdbcOperations.kpQuery<T>(sql: String, vararg args: Any?, rse: (ResultSet)->T): T {
    return this.query(sql, object:ResultSetExtractor<T>{
        public override fun extractData(rs: ResultSet?): T? {
            return rse(rs!!)
        }
    }, *args)!!
}

public fun JdbcOperations.kpQuery<T>(sql: String, vararg args: Any?, rowMapper: (ResultSet, Int) -> T): List<T> {
    return this.query(sql, rowMapperObject(rowMapper), *args)!!
}

public fun JdbcOperations.kpQueryForObject<T>(sql: String, vararg args: Any?, rowMapper: (ResultSet, Int) -> T): T {
    return this.queryForObject(sql, rowMapperObject(rowMapper), *args)!!
}


