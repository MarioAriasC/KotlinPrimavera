/*
 * Copyright 2014 Mario Arias
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

package org.kotlinprimavera.beans.factory

import org.springframework.beans.BeansException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.testng.Assert.*
import org.testng.annotations.Test


class BeanFactoryTest {

    private val context = AnnotationConfigApplicationContext(TestConfig::class.java)

    @Test
    fun testGetA() {
        val a = context["a"]
        assertTrue(a is A)
    }

    @Test
    fun testGetB() {
        try {
            context[B::class.java]
        } catch(e: BeansException) {
            fail()
        }
    }

    @Test
    fun testGetC() {
        val c1 = context["c1", C::class.java]
        assertEquals(c1.value, 1)
    }

    @Test
    fun testGetD() {
        val dAsAny = context["d", 42, "kotlin"]
        assertTrue(dAsAny is D)
        val (num, str) = dAsAny as D
        assertEquals(num, 42)
        assertEquals(str, "kotlin")

    }

}

class A {
}

class B {
}

class C(val value: Int) {
}

data class D(val num: Int, val str: String) {
}


@Configuration
open class TestConfig {

    @Bean
    open fun a(): A {
        return A()
    }

    @Bean
    open fun b(): B {
        return B()
    }

    @Bean
    open fun c1(): C {
        return C(1)
    }

    @Bean
    open fun c2(): C {
        return C(2)
    }

    @Bean @Scope("prototype")
    open fun d(num: Int, str: String): D {
        return D(num, str)
    }
}