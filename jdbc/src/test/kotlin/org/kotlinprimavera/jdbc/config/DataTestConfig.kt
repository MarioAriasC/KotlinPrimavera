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

package org.kotlinprimavera.jdbc.config

import org.kotlinprimavera.jdbc.core.config.embeddedDatabase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import javax.sql.DataSource

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 25/01/15
 * Time: 1:26 AM
 */
@Configuration
open class DataTestConfig {

    @Bean
    open fun dataSource(): DataSource {
        return embeddedDatabase(type = EmbeddedDatabaseType.HSQL) {
            script(location = "classpath:schema-hsql.sql")
            script(location = "classpath:test-data.sql")
        }
    }
}