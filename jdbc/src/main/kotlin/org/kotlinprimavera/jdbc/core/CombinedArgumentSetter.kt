package org.kotlinprimavera.jdbc.core

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 23/08/13
 * Time: 22:07
 */
public open class CombinedArgumentSetter<T, A>(override val setter: (Int, T) -> Unit,
                                          override val setter2: (Int, T, A) -> Unit) : ArgumentSetter<T>, ArgumentSetter2<T, A>