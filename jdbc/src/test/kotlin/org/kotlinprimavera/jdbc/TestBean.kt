package org.kotlinprimavera.jdbc

import java.util.Date

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 20/08/13
 * Time: 23:22
 */
public data class TestBean(var id: Int? = null,
                           var description: String? = null,
                           var createDate: Date? = null)