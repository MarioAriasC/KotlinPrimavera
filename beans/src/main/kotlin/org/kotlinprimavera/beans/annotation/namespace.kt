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

package org.kotlinprimavera.beans.annotation

import org.springframework.beans.annotation.AnnotationBeanUtils
import org.springframework.util.StringValueResolver

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 13/06/15
 * Time: 2:23 PM
 */

public fun Annotation.copyPropertiesToBean(bean: Any, vararg excludedProperties: String) {
    return AnnotationBeanUtils.copyPropertiesToBean(this, bean, *excludedProperties)
}


public fun Annotation.copyPropertiesToBean(bean: Any, valueResolver: StringValueResolver, vararg excludedProperties: String) {
    return AnnotationBeanUtils.copyPropertiesToBean(this, bean, valueResolver, *excludedProperties)
}