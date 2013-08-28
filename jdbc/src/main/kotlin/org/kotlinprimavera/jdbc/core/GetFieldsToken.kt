package org.kotlinprimavera.jdbc.core

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 20/08/13
 * Time: 22:59
 */
public class GetFieldsToken<T>(val withFieldName: (String) -> T, val withIndex: (Int) -> T) {

    public fun get(columnIndex: Int): T {
        return withIndex(columnIndex)
    }

    public fun get(columnLabel: String): T {
        return withFieldName(columnLabel)
    }
}