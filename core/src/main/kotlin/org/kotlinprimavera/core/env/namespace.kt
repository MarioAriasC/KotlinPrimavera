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

import org.springframework.core.env.PropertyResolver
import org.funktionale.utils.GetterOperation

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 22/07/14
 * Time: 0:21
 */

fun PropertyResolver.get(key: String): String? {
    return this.getProperty(key)
}

fun PropertyResolver.get(key: String, defaultValue:String): String {
    return this.getProperty(key, defaultValue)
}

fun<T> PropertyResolver.get(key: String, targetType: Class<T>): T? {
    return this.getProperty(key, targetType)
}

fun<T> PropertyResolver.get(key: String, targetType: Class<T>, defaultValue:T): T {
    return this.getProperty(key, targetType, defaultValue)
}

