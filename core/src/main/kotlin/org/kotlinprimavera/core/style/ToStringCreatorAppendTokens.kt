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

package org.kotlinprimavera.core.style

import org.springframework.core.style.ToStringCreator

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 29/08/13
 * Time: 21:09
 */
public class ToStringCreatorAppendTokens(private val toStringCreator: ToStringCreator) {

    public fun set(fieldName: String, value: Byte?) {
        toStringCreator.append(fieldName, value)
    }

    public fun set(fieldName: String, value: Short?) {
        toStringCreator.append(fieldName, value)
    }

    public fun set(fieldName: String, value: Int?) {
        toStringCreator.append(fieldName, value)
    }

    public fun set(fieldName: String, value: Long?) {
        toStringCreator.append(fieldName, value)
    }

    public fun set(fieldName: String, value: Float?) {
        toStringCreator.append(fieldName, value)
    }

    public fun set(fieldName: String, value: Double?) {
        toStringCreator.append(fieldName, value)
    }

    public fun set(fieldName: String, value: Boolean?) {
        toStringCreator.append(fieldName, value)
    }

    public fun set(fieldName: String, value: Any?) {
        toStringCreator.append(fieldName, value)
    }
}