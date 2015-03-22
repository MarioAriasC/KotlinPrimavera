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

package org.kotlinprimavera.web.servlet

import org.springframework.web.servlet.ModelAndView

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
* Date: 7/09/13
* Time: 1:24
 */

public fun ModelAndView.set(attributeName: String, attributeValue: Any?) {
    this.addObject(attributeName, attributeValue)
}

public fun ModelAndView.addAllObjects(vararg objects: Pair<String, Any?>): ModelAndView {
    this.addAllObjects(mapOf(*objects))
    return this
}


