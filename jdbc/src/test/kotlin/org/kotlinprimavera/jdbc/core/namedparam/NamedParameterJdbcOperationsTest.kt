package org.kotlinprimavera.jdbc.core.namedparam

import org.kotlinprimavera.jdbc.core.JdbcTestBase
import org.springframework.test.context.ContextConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.testng.Assert.*
import org.testng.annotations.Test
import org.kotlinprimavera.jdbc.TestBean

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 27/08/13
 * Time: 1:04
 */
[ContextConfiguration]
public class NamedParameterJdbcOperationsTest : JdbcTestBase() {
    [Autowired] var template: NamedParameterJdbcTemplate? = null

    private val id = "id"

    private val selectByIdGreatherThan = "$select where id > :id"

    private val descriptionToPythonMap = mapOf(description to python)

    private val selectIdByNamedDescription = "$selectId where description = :description"

    private val selectByNamedId = "$select where id = :id"

    private val parameterSource = TestBean(description = python).toSqlParameterSource()

    [Test] fun testExecute() {


        assertEquals(template!!.execute(selectIdByNamedDescription, parameterSource, action), 1)

        assertEquals(template!!.execute(selectIdByNamedDescription, descriptionToPythonMap, action), 1)
    }

    [Test] fun testQuery() {
        assertEquals(template!!.query(selectIdByNamedDescription, parameterSource, rsFunction), 1)


        assertEquals(template!!.query(selectIdByNamedDescription, descriptionToPythonMap, rsFunction), 1)

        assertEquals(template!!.query(selectByIdGreatherThan, TestBean(id = 1).toSqlParameterSource(), mapperFunction)!!.size(), 4)


        assertEquals(template!!.query(selectByIdGreatherThan, mapOf(id to 1), mapperFunction)!!.size(), 4)
    }

    [Test] fun testQueryForObject() {
        assertEquals(template!!.queryForObject(selectByNamedId, TestBean(id = 1).toSqlParameterSource(), mapperFunction)!!.description, python)

        validateEmptyResult {
            template!!.queryForObject(selectByNamedId, TestBean(id = -1).toSqlParameterSource(), mapperFunction)
        }
    }


}