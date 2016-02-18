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

package org.kotlinprimavera.util

import org.funktionale.utils.GetterSetterOperation
import org.springframework.util.StopWatch

fun stopWatch(id: String = "", body: StopWatch.() -> Unit): StopWatch {
    val watch = StopWatch(id)
    watch.body()
    return watch
}

/*fun StopWatch.invoke(body:StopWatch.() -> Unit): StopWatch {
    this.body()
    return this
}*/


fun <T> StopWatch.task(name: String = "", body: () -> T): T {
    start(name)
    val result = body()
    stop()
    return result
}

val sysProperty: GetterSetterOperation<String, String> = GetterSetterOperation(
        { k -> System.getProperty(k) },
        { k, v -> System.setProperty(k, v) })
