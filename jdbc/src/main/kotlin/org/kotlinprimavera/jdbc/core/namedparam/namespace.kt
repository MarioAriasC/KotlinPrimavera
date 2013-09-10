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

package org.kotlinprimavera.jdbc.core.namedparam

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 27/08/13
 * Time: 0:49
 */

public fun Any.toSqlParameterSource(): BeanPropertySqlParameterSource {
    return BeanPropertySqlParameterSource(this)
}

public fun Map<String, Any>.toSqlParameterSource(): MapSqlParameterSource {
    return MapSqlParameterSource(this)
}

public fun MapSqlParameterSource.set(paramName: String, value: Any?) {
    this.addValue(paramName, value)
}

public fun MapSqlParameterSource.set(paramName: String, sqlType: Int value: Any?) {
    this.addValue(paramName, value, sqlType)
}

public fun MapSqlParameterSource.set(paramName: String, sqlType: Int, typeName: String, value: Any?) {
    this.addValue(paramName, value, sqlType, typeName)
}

public fun MapSqlParameterSource.addValues(vararg args: Pair<String, Any?>): MapSqlParameterSource {
    return this.addValues(mapOf(*args))!!
}

public fun MapSqlParameterSource.get(paramName: String): Any {
    return this.getValue(paramName)!!
}
