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

package org.kotlinprimavera.jdbc.core.config

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import javax.sql.DataSource

public fun embeddedDatabase(type: EmbeddedDatabaseType, body: EmbeddedDatabaseTag.() -> Unit): DataSource {
    val tag = EmbeddedDatabaseTag()
    tag.body()
    val scripts = tag.scripts

    val factory = EmbeddedDatabaseFactory()
    with(factory) {
        setDatabaseType(type)

    }
    return factory.getDatabase()
}