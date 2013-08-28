package org.kotlinprimavera.jdbc.core

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 24/08/13
 * Time: 21:16
 */
public class ObjectArgumentSetter(setter: (Int, Any) ->Unit,
                                  setter2: (Int, Any, Int) ->Unit,
                                  val setter4: (Int, Any, Int, Int) ->Unit) : CombinedArgumentSetter<Any, Int>(setter, setter2) {

    public fun set(index: Int, targetSqlType: Int, scaleOrLenght: Int, x: Any) {
        setter4(index, x, targetSqlType, scaleOrLenght)
    }
}