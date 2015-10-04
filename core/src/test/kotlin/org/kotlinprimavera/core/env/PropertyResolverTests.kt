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

package org.kotlinprimavera.core.env

import org.springframework.core.env.MutablePropertySources
import org.springframework.core.env.PropertiesPropertySource
import org.springframework.core.env.PropertyResolver
import org.springframework.core.env.PropertySourcesPropertyResolver
import org.testng.Assert.assertEquals
import org.testng.Assert.assertNull
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.util.*
import kotlin.properties.Delegates

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 22/07/14
 * Time: 0:57
 */
public class PropertyResolverTests {
    private var testProperties: Properties by Delegates.notNull()
    private var propertySources: MutablePropertySources by Delegates.notNull()
    private var propertyResolver: PropertyResolver by Delegates.notNull()

    @BeforeMethod
    public fun setUp() {
        propertySources = MutablePropertySources()
        propertyResolver = PropertySourcesPropertyResolver(propertySources)
        testProperties = Properties()
        propertySources.addFirst(PropertiesPropertySource("testProperties", testProperties))
    }

    @Test
    public fun getProperty() {
        assertNull(propertyResolver["foo"])
        assertNull(propertyResolver["num"])
        testProperties["foo"] = "bar"
        testProperties["num"] = 5
        assertEquals(propertyResolver["foo"], "bar")
        assertEquals(propertyResolver["num", Int::class.java], 5)
    }

    @Test
    public fun getPropertyWithDefaultValue() {
        assertEquals(propertyResolver["foo", "myDefault"], "myDefault")
        assertEquals(propertyResolver["num", Int::class.java, 42], 42)
        testProperties["foo"] = "bar"
        testProperties["num"] = 5
        assertEquals(propertyResolver["foo", "myDefault"], "bar")
        assertEquals(propertyResolver["num", Int::class.java, 13], 5)
    }

}