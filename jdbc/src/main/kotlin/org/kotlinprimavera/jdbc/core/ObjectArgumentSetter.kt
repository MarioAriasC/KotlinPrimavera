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

package org.kotlinprimavera.jdbc.core

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 24/08/13
 * Time: 21:16
 */
class ObjectArgumentSetter(setter: (Int, Any) -> Unit,
                                  setter2: (Int, Any, Int) -> Unit,
                                  val setter4: (Int, Any, Int, Int) -> Unit) : CombinedArgumentSetter<Any, Int>(setter, setter2) {

    operator fun set(index: Int, targetSqlType: Int, scaleOrLenght: Int, x: Any) {
        setter4(index, x, targetSqlType, scaleOrLenght)
    }
}