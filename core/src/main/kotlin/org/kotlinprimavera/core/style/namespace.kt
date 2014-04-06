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
import org.springframework.core.style.ValueStyler
import org.springframework.core.style.ToStringStyler

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 29/08/13
 * Time: 21:21
 */

public val ToStringCreator.append: ToStringCreatorAppendTokens
    get(){
        return ToStringCreatorAppendTokens(this)
    }

public fun ToStringCreator(obj: Any, body: ToStringCreator.() -> Unit): ToStringCreator {
    val creator = ToStringCreator(obj)
    creator.body()
    return creator
}

public fun ToStringCreator(obj: Any, styler: ValueStyler, body: ToStringCreator.() -> Unit): ToStringCreator {
    val creator = ToStringCreator(obj, styler)
    creator.body()
    return creator
}

public fun ToStringCreator(obj: Any, styler: ToStringStyler, body: ToStringCreator.() -> Unit): ToStringCreator {
    val creator = ToStringCreator(obj, styler)
    creator.body()
    return creator
}
