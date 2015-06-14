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

package org.kotlinprimavera.beans

import org.springframework.beans.BeanInstantiationException
import org.springframework.beans.BeanUtils
import org.springframework.beans.BeansException
import org.springframework.beans.PropertyAccessorUtils
import org.springframework.core.MethodParameter
import java.beans.PropertyDescriptor
import java.beans.PropertyEditor
import java.lang.reflect.Constructor
import java.lang.reflect.Method

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 9/06/15
 * Time: 11:37 PM
 */


/**
 * For initialize a var with a Not nullable type, specially util for ```@Autowired``` vars
 */
public fun<T> uninitialized(): T = null as T

@throws(BeanInstantiationException::class)
public fun<T> Class<T>.instantiate(): T {
    return BeanUtils.instantiate(this)
}


@throws(BeanInstantiationException::class)
public fun<T> Class<T>.instantiateClass(): T {
    return BeanUtils.instantiateClass(this)
}


@throws(BeanInstantiationException::class)
public fun<T> Constructor<T>.instantiateClass(vararg args: Any): T {
    return BeanUtils.instantiateClass(this, *args)
}


@throws(BeanInstantiationException::class)
public fun<T> Class<*>.instantiateClass(assignableTo: Class<T>): T {
    return BeanUtils.instantiateClass(this, assignableTo)
}


public fun Class<*>.findMethod(methodName: String, vararg paramTypes: Class<*>): Method {
    return BeanUtils.findMethod(this, methodName, *paramTypes)
}


public fun Class<*>.findDeclaredMethod(methodName: String, vararg paramTypes: Class<*>): Method {
    return BeanUtils.findDeclaredMethod(this, methodName, *paramTypes)
}


@throws(IllegalArgumentException::class)
public fun Class<*>.findMethodWithMinimalParameters(methodName: String): Method {
    return BeanUtils.findMethodWithMinimalParameters(this, methodName)
}


@throws(IllegalArgumentException::class)
public fun Array<Method>.findMethodWithMinimalParameters(methodName: String): Method {
    return BeanUtils.findMethodWithMinimalParameters(this, methodName)
}


@throws(IllegalArgumentException::class)
public fun Class<*>.findDeclaredMethodWithMinimalParameters(methodName: String): Method {
    return BeanUtils.findDeclaredMethodWithMinimalParameters(this, methodName)
}


public fun String.resolveSignature(clazz: Class<*>): Method {
    return BeanUtils.resolveSignature(this, clazz)
}


@throws(BeansException::class)
public fun Class<*>.getPropertyDescriptors(): Array<PropertyDescriptor> {
    return BeanUtils.getPropertyDescriptors(this)
}


@throws(BeansException::class)
public fun Class<*>.getPropertyDescriptor(propertyName: String): PropertyDescriptor {
    return BeanUtils.getPropertyDescriptor(this, propertyName)
}


@throws(BeansException::class)
public fun Method.findPropertyForMethod(): PropertyDescriptor {
    return BeanUtils.findPropertyForMethod(this)
}


@throws(BeansException::class)
public fun Method.findPropertyForMethod(clazz: Class<*>): PropertyDescriptor {
    return BeanUtils.findPropertyForMethod(this, clazz)
}


public fun Class<*>.findEditorByConvention(): PropertyEditor {
    return BeanUtils.findEditorByConvention(this)
}


public fun String.findPropertyType(vararg beanClasses: Class<*>): Class<*> {
    return BeanUtils.findPropertyType(this, *beanClasses)
}


public fun PropertyDescriptor.getWriteMethodParameter(): MethodParameter {
    return BeanUtils.getWriteMethodParameter(this)
}


public fun Class<*>.isSimpleProperty(): Boolean {
    return BeanUtils.isSimpleProperty(this)
}


public fun Class<*>.isSimpleValueType(): Boolean {
    return BeanUtils.isSimpleValueType(this)
}


@throws(BeansException::class)
public fun Any.copyProperties(target: Any) {
    return BeanUtils.copyProperties(this, target)
}

@throws(BeansException::class)
public fun Any.copyProperties(target: Any, vararg ignoredProperties: String) {
    return BeanUtils.copyProperties(this, target, *ignoredProperties)
}


@throws(BeansException::class)
public fun Any.copyProperties(target: Any, ignoredProperties: Class<*>) {
    return BeanUtils.copyProperties(this, target, ignoredProperties)
}

public fun String.getPropertyName(): String {
    return PropertyAccessorUtils.getPropertyName(this)
}



public fun String.isNestedOrIndexedProperty(): Boolean {
    return PropertyAccessorUtils.isNestedOrIndexedProperty(this)
}



public fun String.getFirstNestedPropertySeparatorIndex(): Int {
    return PropertyAccessorUtils.getFirstNestedPropertySeparatorIndex(this)
}



public fun String.getLastNestedPropertySeparatorIndex(): Int {
    return PropertyAccessorUtils.getLastNestedPropertySeparatorIndex(this)
}

public fun String.matchesProperty(propertyPath: String): Boolean {
    return PropertyAccessorUtils.matchesProperty(this, propertyPath)
}



public fun String.canonicalPropertyName(): String {
    return PropertyAccessorUtils.canonicalPropertyName(this)
}



public fun Array<String>.canonicalPropertyNames(): Array<String> {
    return PropertyAccessorUtils.canonicalPropertyNames(this)
}