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

package org.kotlinprimavera.beans.factory.support

import org.springframework.beans.factory.BeanDefinitionStoreException
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.beans.factory.config.BeanDefinitionHolder
import org.springframework.beans.factory.support.AbstractBeanDefinition
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils
import org.springframework.beans.factory.support.BeanDefinitionRegistry

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 13/06/15
 * Time: 2:29 PM
 */

@Throws(ClassNotFoundException::class)
public fun String.createBeanDefinition(className: String, classLoader: ClassLoader): AbstractBeanDefinition {
    return BeanDefinitionReaderUtils.createBeanDefinition(this, className, classLoader)
}


@Throws(BeanDefinitionStoreException::class)
public fun BeanDefinition.generateBeanName(registry: BeanDefinitionRegistry): String {
    return BeanDefinitionReaderUtils.generateBeanName(this, registry)
}


@Throws(BeanDefinitionStoreException::class)
public fun BeanDefinition.generateBeanName(registry: BeanDefinitionRegistry, isInnerBean: Boolean): String {
    return BeanDefinitionReaderUtils.generateBeanName(this, registry, isInnerBean)
}


@Throws(BeanDefinitionStoreException::class)
public fun BeanDefinitionHolder.registerBeanDefinition(registry: BeanDefinitionRegistry) {
    return BeanDefinitionReaderUtils.registerBeanDefinition(this, registry)
}


@Throws(BeanDefinitionStoreException::class)
public fun AbstractBeanDefinition.registerWithGeneratedName(registry: BeanDefinitionRegistry): String {
    return BeanDefinitionReaderUtils.registerWithGeneratedName(this, registry)
}
