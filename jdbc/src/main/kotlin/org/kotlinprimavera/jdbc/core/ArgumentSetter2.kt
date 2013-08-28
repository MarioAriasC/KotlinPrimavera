package org.kotlinprimavera.jdbc.core

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 21/08/13
 * Time: 22:04
 */
public trait ArgumentSetter2<T, A> {

    val setter2: (Int, T, A) -> Unit

    public fun set(index: Int, a: A, t: T) {
        setter2(index, t, a)
    }
}