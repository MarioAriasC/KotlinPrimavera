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

package org.kotlinprimavera.beans.factory

import org.springframework.beans.factory.BeanFactory

/**
 * Util function extension to add array like access to [org.springframework.beans.factory.BeanFactory]
 */
public fun BeanFactory.get(name: String): Any {
    return getBean(name)
}

/**
 * Util function extension to add array like access to [org.springframework.beans.factory.BeanFactory]
 */
public fun<T> BeanFactory.get(requiredType: Class<T>): T {
    return getBean(requiredType)
}

/**
 * Util function extension to add array like access to [org.springframework.beans.factory.BeanFactory]
 */
public fun<T> BeanFactory.get(name: String, requiredType: Class<T>): T {
    return getBean(name, requiredType)
}

/**
 * Util function extension to add array like access to [org.springframework.beans.factory.BeanFactory]
 */
public fun BeanFactory.get(name: String, vararg args: Any): Any {
    return getBean(name, *args)
}


