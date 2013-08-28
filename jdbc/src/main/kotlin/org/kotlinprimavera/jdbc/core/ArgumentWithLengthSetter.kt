package org.kotlinprimavera.jdbc.core

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 21/08/13
 * Time: 22:04
 */
public class ArgumentWithLengthSetter<T>(override val setter: (Int, T) -> Unit,
                                         override val setter2: (Int, T, Int) -> Unit,
                                         val setterWithLong: (Int, T, Long) -> Unit) : ArgumentSetter<T>,ArgumentSetter2<T,Int> {

    public fun set(i: Int, lenght: Long, t: T) {
        setterWithLong(i, t, lenght)
    }
}