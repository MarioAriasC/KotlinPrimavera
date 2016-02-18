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

package org.kotlinprimavera.beans

import org.springframework.beans.BeanInstantiationException
import org.testng.Assert.*
import org.testng.annotations.Test

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 9/06/15
 * Time: 11:59 PM
 */
public class BeanUtilsTest {

    @Test fun testInstantiate() {
        //No Parameters
        assertTrue(NoParameters::class.java.instantiate() is NoParameters)

        //Default parameter
        val defaultParameter = DefaultParameter::class.java.instantiate()
        assertTrue(defaultParameter is DefaultParameter)
        assertEquals(defaultParameter.name, "foo")

        //With parameters, will fail
        try {
            WithParameter::class.java.instantiate()
            fail("WithParameter was wrongly instantiated")
        } catch(e: BeanInstantiationException) {
            assertTrue(e.message!!.startsWith("Failed to instantiate [org.kotlinprimavera.beans.WithParameter]"))
        }

    }

    @Test fun testInstantiateClass() {
        //No parameters
        assertTrue(NoParameters::class.java.instantiateClass() is NoParameters)

        //Default parameter
        val defaultParameter = DefaultParameter::class.java.instantiateClass()
        assertTrue(defaultParameter is DefaultParameter)
        assertEquals(defaultParameter.name, "foo")

        //With parameters, will fail
        try {
            WithParameter::class.java.instantiateClass()
            fail("WithParameter was wrongly instantiated")
        } catch(e: BeanInstantiationException) {
            assertTrue(e.message!!.startsWith("Failed to instantiate [org.kotlinprimavera.beans.WithParameter]"))
        }

        //Assignable type
        assertTrue(DefaultParameter::class.java.instantiateClass(TestType::class.java) is TestType)

        //Not assignable, will fail
        try {
            NoParameters::class.java.instantiateClass(TestType::class.java)
            fail("NoParameters was wrongly instantiated")
        } catch(e: IllegalArgumentException) {
            assertEquals(e.message, "class org.kotlinprimavera.beans.NoParameters is not assignable to interface org.kotlinprimavera.beans.TestType")
        }

        //Constructors
        assertTrue(NoParameters::class.java.getDeclaredConstructor().instantiateClass() is NoParameters)

        //With Parameters
        assertEquals(WithParameter::class.java.getDeclaredConstructor(String::class.java).instantiateClass("baz").name, "baz")
        assertEquals(DefaultParameter::class.java.getDeclaredConstructor(String::class.java).instantiateClass("baz").name, "baz")


        //Default Parameter
        assertEquals(DefaultParameter::class.java.getDeclaredConstructor().instantiateClass().name, "foo")

        try {
            WithParameter::class.java.getDeclaredConstructor().instantiateClass()
            fail("WithParameter was wrongly instantiated")
        } catch(e: NoSuchMethodException) {
            assertEquals(e.message, "org.kotlinprimavera.beans.WithParameter.<init>()")
        }

        try {
            DefaultParameter::class.java.getDeclaredConstructor(String::class.java).instantiateClass()
            fail("DefaultParameter wrongly instantiated")
        } catch(e: BeanInstantiationException) {
            assertTrue(e.message!!.startsWith("Failed to instantiate [org.kotlinprimavera.beans.DefaultParameter]: Illegal arguments for constructor"))
        }


    }

    @Test fun testFindMethod() {
        val dp = DefaultParameter()
        //calling ```invoke``` method
        assertEquals(dp.javaClass.findMethod("component1")(dp), "foo")
        try {
            dp.javaClass.findMethod("component2")(dp)
            fail("Method component2 doesn't exist")
        } catch(e: IllegalStateException) {

        }
    }

    @Test fun testFindDeclaredMethod() {
        val dp = DefaultParameter()
        //calling ```invoke``` method
        assertEquals(dp.javaClass.findDeclaredMethod("component1")(dp), "foo")
        try {
            dp.javaClass.findDeclaredMethod("component2")(dp)
            fail("Method component2 doesn't exist")
        } catch(e: IllegalStateException) {

        }
    }

}


interface TestType
class NoParameters
data class DefaultParameter(val name: String = "foo") : TestType
data class WithParameter(val name: String)