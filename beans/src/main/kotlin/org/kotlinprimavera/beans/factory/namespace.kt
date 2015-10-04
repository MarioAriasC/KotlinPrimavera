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

import org.springframework.beans.BeansException
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.BeanFactoryUtils
import org.springframework.beans.factory.ListableBeanFactory

/**
 * Util function extension to add array like access to [org.springframework.beans.factory.BeanFactory]
 */
operator public fun BeanFactory.get(name: String): Any {
    return getBean(name)
}

/**
 * Util function extension to add array like access to [org.springframework.beans.factory.BeanFactory]
 */
operator public fun<T> BeanFactory.get(requiredType: Class<T>): T {
    return getBean(requiredType)
}

/**
 * Util function extension to add array like access to [org.springframework.beans.factory.BeanFactory]
 */
operator public fun<T> BeanFactory.get(name: String, requiredType: Class<T>): T {
    return getBean(name, requiredType)
}

/**
 * Util function extension to add array like access to [org.springframework.beans.factory.BeanFactory]
 */
operator public fun BeanFactory.get(name: String, vararg args: Any): Any {
    return getBean(name, *args)
}

public fun String.isFactoryDereference(): Boolean {
    return BeanFactoryUtils.isFactoryDereference(this)
}


public fun String.transformedBeanName(): String {
    return BeanFactoryUtils.transformedBeanName(this)
}


public fun String.isGeneratedBeanName(): Boolean {
    return BeanFactoryUtils.isGeneratedBeanName(this)
}


public fun String.originalBeanName(): String {
    return BeanFactoryUtils.originalBeanName(this)
}


public fun ListableBeanFactory.countBeansIncludingAncestors(): Int {
    return BeanFactoryUtils.countBeansIncludingAncestors(this)
}


public fun ListableBeanFactory.beanNamesIncludingAncestors(): Array<String> {
    return BeanFactoryUtils.beanNamesIncludingAncestors(this)
}


public fun ListableBeanFactory.beanNamesForTypeIncludingAncestors(type: Class<*>, includeNonSingletons: Boolean, allowEagerInt: Boolean): Array<String> {
    return BeanFactoryUtils.beanNamesForTypeIncludingAncestors(this, type, includeNonSingletons, allowEagerInt)
}


public fun ListableBeanFactory.beanNamesForTypeIncludingAncestors(type: Class<*>): Array<String> {
    return BeanFactoryUtils.beanNamesForTypeIncludingAncestors(this, type)
}


@Throws(BeansException::class)
public fun<T> ListableBeanFactory.beansOfTypeIncludingAncestors(type: Class<T>, includeNonSingletons: Boolean, allowEagerInt: Boolean): Map<String, T> {
    return BeanFactoryUtils.beansOfTypeIncludingAncestors(this, type, includeNonSingletons, allowEagerInt)
}


@Throws(BeansException::class)
public fun<T> ListableBeanFactory.beansOfTypeIncludingAncestors(type: Class<T>): Map<String, T> {
    return BeanFactoryUtils.beansOfTypeIncludingAncestors(this, type)
}


@Throws(BeansException::class)
public fun<T> ListableBeanFactory.beanOfTypeIncludingAncestors(type: Class<T>, includeNonSingletons: Boolean, allowEagerInt: Boolean): T {
    return BeanFactoryUtils.beanOfTypeIncludingAncestors(this, type, includeNonSingletons, allowEagerInt)
}


@Throws(BeansException::class)
public fun<T> ListableBeanFactory.beanOfTypeIncludingAncestors(type: Class<T>): T {
    return BeanFactoryUtils.beanOfTypeIncludingAncestors(this, type)
}


@Throws(BeansException::class)
public fun<T> ListableBeanFactory.beanOfType(type: Class<T>, includeNonSingletons: Boolean, allowEagerInt: Boolean): T {
    return BeanFactoryUtils.beanOfType(this, type, includeNonSingletons, allowEagerInt)
}


@Throws(BeansException::class)
public fun<T> ListableBeanFactory.beanOfType(type: Class<T>): T {
    return BeanFactoryUtils.beanOfType(this, type)
}
