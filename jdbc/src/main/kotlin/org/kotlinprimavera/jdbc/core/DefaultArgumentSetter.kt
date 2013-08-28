package org.kotlinprimavera.jdbc.core

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 23/08/13
 * Time: 21:01
 */
public class DefaultArgumentSetter<T>(override val setter: (Int, T) -> Unit) : ArgumentSetter<T>