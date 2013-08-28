package org.kotlinprimavera.jdbc.core

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 21/08/13
 * Time: 22:04
 */
public trait ArgumentSetter<T> {

    val setter: (Int, T) -> Unit

    public fun set(index: Int, t: T) {
        setter(index, t)
    }
}