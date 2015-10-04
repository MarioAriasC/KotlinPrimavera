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

package org.kotlinprimavera.jdbc.core

import java.io.Reader
import java.sql.Clob

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 23/08/13
 * Time: 21:27
 */

public class ClobArgumentSetter(val blobSetter: (Int, Clob) -> Unit,
                                override val setter: (Int, Reader) -> Unit,
                                override val setter2: (Int, Reader, Long) -> Unit) : AbstractBlobArgumentSetter<Reader>(setter, setter2) {

    operator public fun set(index: Int, clob: Clob) {
        blobSetter(index, clob)
    }
}
