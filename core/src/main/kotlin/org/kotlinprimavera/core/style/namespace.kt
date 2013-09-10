package org.kotlinprimavera.core.style

import org.springframework.core.style.ToStringCreator
import org.springframework.core.style.ValueStyler
import org.springframework.core.style.ToStringStyler

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 29/08/13
 * Time: 21:21
 */

public val ToStringCreator.append: ToStringCreatorAppendTokens
    get(){
        return ToStringCreatorAppendTokens(this)
    }

public fun ToStringCreator(obj: Any, body: ToStringCreator.() -> Unit): ToStringCreator {
    val creator = ToStringCreator(obj)
    creator.body()
    return creator
}

public fun ToStringCreator(obj: Any, styler: ValueStyler, body: ToStringCreator.() -> Unit): ToStringCreator {
    val creator = ToStringCreator(obj, styler)
    creator.body()
    return creator
}

public fun ToStringCreator(obj: Any, styler: ToStringStyler body: ToStringCreator.() -> Unit): ToStringCreator {
    val creator = ToStringCreator(obj, styler)
    creator.body()
    return creator
}
