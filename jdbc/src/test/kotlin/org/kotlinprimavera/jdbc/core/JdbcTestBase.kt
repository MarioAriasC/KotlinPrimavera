package org.kotlinprimavera.jdbc.core

import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests
import java.sql.ResultSet
import org.kotlinprimavera.jdbc.TestBean
import java.sql.PreparedStatement
import org.testng.Assert.*
import org.springframework.dao.EmptyResultDataAccessException

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 20/08/13
 * Time: 23:28
 */
public abstract class JdbcTestBase : AbstractTransactionalTestNGSpringContextTests() {
    val select = "select * from test_bean "
    val selectId = "select id from test_bean "
    val selectIdByDescription = "$selectId where description = ?"
    val python = "python"
    val description = "description"

    val mapperFunction = {(rs: ResultSet?, i: Int)->
        rs!!.build {
            TestBean(int["id"]!!,
                    string["description"]!!,
                    date["create_date"]!!)
        }
    }

    val action = {(st: PreparedStatement?)->
        val rs = st!!.executeQuery()
        rsFunction(rs)
    }

    val rsFunction = {(rs: ResultSet?)->
        rs!!.build{
            next()
            int["id"]
        }
    }

    protected fun count(): Int {
        return countRowsInTable("test_bean")
    }

    protected fun validateEmptyResult(body: ()->Unit) {
        try{
            body()
            fail("Function $body don't throw a exception")
        }
        catch(e: EmptyResultDataAccessException){
            //expected
        }
    }
}