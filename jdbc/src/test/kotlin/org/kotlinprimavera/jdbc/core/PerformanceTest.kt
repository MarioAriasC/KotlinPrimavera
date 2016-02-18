/*
 * Copyright 2015 Mario Arias
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

import org.funktionale.partials.invoke
import org.funktionale.partials.partially3
import org.kotlinprimavera.beans.uninitialized
import org.kotlinprimavera.jdbc.TestBean
import org.kotlinprimavera.util.stopWatch
import org.kotlinprimavera.util.task
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.test.context.ContextConfiguration
import org.testng.Assert
import org.testng.annotations.Test
import java.sql.ResultSet


@ContextConfiguration class PerformanceTest : JdbcTestBase() {

    @Autowired var template: JdbcTemplate = uninitialized()


    @Test
    fun performance() {
        val watch = stopWatch() {

            for (i in 1..10) {
                task("With DSL as parameter: $i run") {
                    val result = template.query(select, mapperFunction)
                    Assert.assertEquals(result.size, 1000)
                }

                task("With DSL in line: $i run ") {
                    val result = template.query(select) { rs, i ->
                        rs.extract {
                            TestBean(int["id"]!!,
                                    string["description"]!!,
                                    date["create_date"]!!)
                        }
                    }
                    Assert.assertEquals(result.size, 1000)
                }

                task("Without DSL: $i run") {
                    val result = template.query(select) { rs, i ->
                        TestBean(rs.getInt("id"),
                                rs.getString("description")!!,
                                rs.getDate("create_date")!!)

                    }
                    Assert.assertEquals(result.size, 1000)
                }

                task("Without SAM: $i run") {
                    val result = template.query(select, object : RowMapper<TestBean> {
                        override fun mapRow(rs: ResultSet, rowNum: Int): TestBean {
                            return TestBean(rs.getInt("id"),
                                    rs.getString("description")!!,
                                    rs.getDate("create_date")!!)
                        }
                    })
                    Assert.assertEquals(result.size, 1000)
                }
            }


        }
        println("watch.prettyPrint() = ${watch.prettyPrint()}")
    }

    fun f() {

        val mapper: (ResultSet, Int, String) -> User = { rs, i, prefix ->
            rs.extract { //DSL from KotlinPrimavera
                User(string["${prefix}_name"]!!, int["${prefix}_age"]!!)
            }
        }

        val doctors = template.query("select * from doctors", mapper(p3 = "dr"))

        val nurses = template.query("select * from nurses", mapper.partially3("n"))

        val patients = template.query("select * from patients", mapper(p3 = "p"))
    }
}


data class User(val name: String, val age: Int)

