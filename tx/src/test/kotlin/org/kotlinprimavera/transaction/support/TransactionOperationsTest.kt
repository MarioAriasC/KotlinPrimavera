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

package org.kotlinprimavera.transaction.support

import org.springframework.test.context.ContextConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.support.TransactionTemplate
import org.testng.annotations.Test
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests
import org.testng.Assert
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.annotation.Propagation

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 26/12/13
 * Time: 20:06
 */
@ContextConfiguration
public class TransactionOperationsTest : AbstractTransactionalTestNGSpringContextTests() {
    @Autowired var txTemplate: TransactionTemplate? = null
    @Autowired var template: JdbcTemplate? = null

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    fun testExecute() {
        txTemplate!!.execute { status ->
            template!!.update("delete from test_bean")
            status.setRollbackOnly()
        }

        Assert.assertEquals(countRowsInTable("test_bean"), 5)
    }
}