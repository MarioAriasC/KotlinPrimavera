package org.kotlinprimavera.core.style

import org.springframework.core.style.ToStringCreator

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 29/08/13
 * Time: 21:09
 */
public class ToStringCreatorAppendTokens(private val toStringCreator: ToStringCreator) {

    public fun set(fieldName: String, value: Byte?) {
        toStringCreator.append(fieldName, value)
    }

    public fun set(fieldName: String, value: Short?) {
        toStringCreator.append(fieldName, value)
    }

    public fun set(fieldName: String, value: Int?) {
        toStringCreator.append(fieldName, value)
    }

    public fun set(fieldName: String, value: Long?) {
        toStringCreator.append(fieldName, value)
    }

    public fun set(fieldName: String, value: Float?) {
        toStringCreator.append(fieldName, value)
    }

    public fun set(fieldName: String, value: Double?) {
        toStringCreator.append(fieldName, value)
    }

    public fun set(fieldName: String, value: Boolean?) {
        toStringCreator.append(fieldName, value)
    }

    public fun set(fieldName: String, value: Any?) {
        toStringCreator.append(fieldName, value)
    }
}