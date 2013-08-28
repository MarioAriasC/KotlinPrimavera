package org.kotlinprimavera.jdbc.core

import org.springframework.test.context.ContextConfiguration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.testng.annotations.Test
import java.sql.*
import org.testng.Assert.*
import org.springframework.jdbc.core.ResultSetExtractor
import org.kotlinprimavera.jdbc.TestBean


/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 20/08/13
 * Time: 23:27
 */
[ContextConfiguration]
public class JdbcOperationsTest : JdbcTestBase(){

    private val select1: String = "$select where id = 1"
    private val selectIdPython = "$selectId where description = 'python'"
    private val selectGreaterThan = "$select where id > ?"
    private val selectById = "$select where id = ?"
    private val insert = "insert into test_bean(description) values(?)"


    private val statementCreator = {(con: Connection?)->
        val st = con!!.prepareStatement(selectIdByDescription)
        st!!.arguments {
            string[1] = python
        }
        st
    }

    [Autowired] var template: JdbcTemplate? = null

    [Test] fun testExecute() {
        template!!.execute{(connection: Connection?) ->
            val prepareStatement = connection!!.prepareStatement(selectIdByDescription)!!
            prepareStatement.arguments{
                string[1] = python
            }
            val resultSet = prepareStatement.executeQuery()
            resultSet.build {
                assertTrue(next())
                assertEquals(int["id"], 1)
                close()
            }
        }

        template!!.execute{(statement: Statement?) ->
            val resultSet = statement!!.executeQuery(select1)
            resultSet.build{
                assertTrue(next())
                assertEquals(string[description], python)
                close()
            }

        }

        assertEquals(template!!.execute(statementCreator, action), 1)

        assertEquals(template!!.execute(selectIdPython, action), 1)
    }

    [Test] fun testQuery() {
        assertEquals(template!!.query(sql = select1, rse = { rs ->
            rs!!.build{
                next()
                string[description]
            }
        }), python)

        template!!.query(sql = select1, rch = { rs ->
            rs!!.build{
                assertEquals(string[description], python)
            }
        })

        assertEquals(template!!.query(select, mapperFunction)!!.size(), 5)

        assertEquals(template!!.query(statementCreator, rsFunction), 1)

        assertEquals(template!!.query(selectIdByDescription, { statement ->
            statement!!.arguments{
                string[1] = python
            }
        }, rsFunction), 1)

        assertEquals(template!!.query(selectIdByDescription, array<Any>(python), intArray(Types.VARCHAR), rsFunction), 1)

        assertEquals(template!!.query(selectIdByDescription, array<Any>(python), rsFunction), 1)

        assertEquals(template!!.kpQuery(selectIdByDescription, python) { rs -> rsFunction(rs) }, 1)

        assertEquals(template!!.query({(con: Connection?)->
            con!!.prepareStatement(select)!!
        }, mapperFunction)!!.size(), 5)

        assertEquals(template!!.query(selectGreaterThan,
                {(stmt: PreparedStatement?)->
                    stmt!!.arguments{
                        int[1] = 1
                    }
                }, mapperFunction)!!.size(), 4)

        assertEquals(template!!.query(selectGreaterThan, array<Any>(1), intArray(Types.INTEGER), mapperFunction)!!.size(), 4)

        assertEquals(template!!.query(selectGreaterThan, array<Any>(1), mapperFunction)!!.size(), 4)

        assertEquals(template!!.kpQuery(selectGreaterThan, 1) { rs, rowNum -> mapperFunction(rs, rowNum) }.size(), 4)


    }

    [Test] fun testQueryForObject() {
        assertEquals(template!!.queryForObject(select1, mapperFunction)!!.description, python)

        assertEquals(template!!.queryForObject(selectById, array<Any>(1), intArray(Types.INTEGER), mapperFunction)!!.description, python)

        assertEquals(template!!.queryForObject(selectById, array<Any>(1), mapperFunction)!!.description, python)

        assertEquals(template!!.kpQueryForObject(selectById, 1) { rs, rowNum -> mapperFunction(rs, rowNum) }.description, python)

    }

    [Test] fun testUpdate() {
        assertEquals(template!!.update{(con: Connection?)->
            val ps = con!!.prepareStatement("update test_bean set create_date = ?")!!
            ps.arguments{
                date[1] = Date(System.currentTimeMillis())
            }
            ps
        }, 5)


        assertEquals(template!!.update({(con: Connection?)->
            val ps = con!!.prepareStatement(insert)
            ps!!.arguments {
                string[1] = "Haxe"
            }
            ps
        }, GeneratedKeyHolder()), 1)

        assertEquals(template!!.update("update test_bean set create_date = ?") {(ps: PreparedStatement?)->
            ps!!.arguments{
                date[1] = Date(System.currentTimeMillis())
            }

        }, 6)

    }

    [Test] fun testBatchUpdate() {
        template!!.batchUpdate(insert, listOf("clojure", "haxe", "objective-c", "erlang"), 4) {
            (ps: PreparedStatement?, t: String?)->
            ps!!.arguments {
                string[1] = t!!
            }
        }
        assertEquals(count(), 9)
    }
}
