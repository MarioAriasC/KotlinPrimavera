package org.kotlinprimavera.ui

import org.springframework.ui.Model
import org.springframework.ui.ModelMap

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 7/09/13
 * Time: 1:08
 */

public fun Model.set(attributeName: String, attributeValue: Any?) {
    this.addAttribute(attributeName, attributeValue)
}

public fun Model.addAllAttributes(vararg attributes: Pair<String, Any?>): Model {
    this.addAllAttributes(mapOf(*attributes))
    return this
}

public fun Model.mergeAttributes(vararg attributes: Pair<String, Any?>): Model {
    this.mergeAttributes(mapOf(*attributes))
    return this
}

public fun ModelMap.set(attributeName: String, attributeValue: Any?) {
    this.addAttribute(attributeName, attributeValue)
}

public fun ModelMap.addAllAttributes(vararg attributes: Pair<String, Any?>): ModelMap {
    this.addAllAttributes(mapOf(*attributes))
    return this
}

public fun ModelMap.mergeAttributes(vararg attributes: Pair<String, Any?>): ModelMap {
    this.mergeAttributes(mapOf(*attributes))
    return this
}
