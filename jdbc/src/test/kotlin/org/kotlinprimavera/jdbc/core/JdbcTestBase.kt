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

import org.kotlinprimavera.jdbc.TestBean
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests
import org.testng.Assert.fail
import java.sql.PreparedStatement
import java.sql.ResultSet

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 20/08/13
 * Time: 23:28
 */
abstract class JdbcTestBase : AbstractTransactionalTestNGSpringContextTests() {

    val select = "select * from test_bean "

    val selectId = "select id from test_bean "
    val selectIdByDescription = "$selectId where description = ?"
    val python = "python"
    val description = "description"

    val mapperFunction = { rs: ResultSet, i: Int ->
        rs.extract {
            TestBean(int["id"]!!,
                    string["description"]!!,
                    date["create_date"]!!)
        }
    }


    val action = { st: PreparedStatement ->
        val rs = st.executeQuery()
        rsFunction(rs)
    }

    val rsFunction = { rs: ResultSet ->
        rs.extract {
            next()
            int["id"]
        }
    }

    protected fun count(): Int {
        return countRowsInTable("test_bean")
    }

    protected fun validateEmptyResult(body: () -> Unit) {
        try {
            body()
            fail("Function $body don't throw a exception")
        } catch(e: EmptyResultDataAccessException) {
            //expected
        }
    }
}