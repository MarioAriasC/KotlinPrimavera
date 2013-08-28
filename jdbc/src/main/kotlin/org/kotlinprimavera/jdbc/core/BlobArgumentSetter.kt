package org.kotlinprimavera.jdbc.core

import java.io.InputStream

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 23/08/13
 * Time: 21:27
 */

public class BlobArgumentSetter<T, R>(val blobSetter: (Int, T) -> Unit,
                                   override val setter: (Int, R) -> Unit,
                                   override val setter2: (Int, R, Long) -> Unit) : ArgumentSetter<R>, ArgumentSetter2<R, Long>{

    public fun set(index: Int, blob: T) {
        blobSetter(index, blob)
    }
}
