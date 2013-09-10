package org.kotlinprimavera.web.servlet

import org.springframework.web.servlet.ModelAndView

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 7/09/13
 * Time: 1:24
 */

public fun ModelAndView.set(attributeName: String, attributeValue: Any?) {
    this.addObject(attributeName, attributeValue)
}

public fun ModelAndView.addAllObjects(vararg objects: Pair<String, Any?>): ModelAndView {
    this.addAllObjects(mapOf(*objects))
    return this
}


