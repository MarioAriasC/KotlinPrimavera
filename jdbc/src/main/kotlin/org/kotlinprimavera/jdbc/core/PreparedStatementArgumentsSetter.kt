/*
 * Copyright 2013 Mario Arias
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kotlinprimavera.jdbc.core


import java.io.InputStream
import java.io.Reader
import java.math.BigDecimal
import java.net.URL
import java.sql.*
import java.sql.Date
import java.util.*

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 21/08/13
 * Time: 22:02
 */
class PreparedStatementArgumentsSetter(prepareStatement: PreparedStatement) : PreparedStatement by prepareStatement {

    val array: DefaultArgumentSetter<java.sql.Array>
        get() {
            return DefaultArgumentSetter { i, v -> setArray(i, v) }
        }

    val asciiStream: ArgumentWithLengthSetter<InputStream>
        get() {
            return ArgumentWithLengthSetter(
                    { i, v -> setAsciiStream(i, v) },
                    { i, v, l -> setAsciiStream(i, v, l) },
                    { i, v, l -> setAsciiStream(i, v, l) })
        }

    val bigDecimal: DefaultArgumentSetter<BigDecimal>
        get() {
            return DefaultArgumentSetter { i, v -> setBigDecimal(i, v) }
        }

    val binaryStream: ArgumentWithLengthSetter<InputStream>
        get() {
            return ArgumentWithLengthSetter(
                    { i, v -> setBinaryStream(i, v) },
                    { i, v, l -> setBinaryStream(i, v, l) },
                    { i, v, l -> setBinaryStream(i, v, l) })
        }

    val blob: BlobArgumentSetter
        get() {
            return BlobArgumentSetter(
                    { i, v -> setBlob(i, v) },
                    { i, v -> setBlob(i, v) },
                    { i, v, l -> setBlob(i, v, l) })
        }

    val boolean: DefaultArgumentSetter<Boolean>
        get() {
            return DefaultArgumentSetter { i, v -> setBoolean(i, v) }
        }

    val byte: DefaultArgumentSetter<Byte>
        get() {
            return DefaultArgumentSetter { i, v -> setByte(i, v) }
        }

    val bytes: DefaultArgumentSetter<ByteArray>
        get() {
            return DefaultArgumentSetter { i, v -> setBytes(i, v) }
        }

    val characterStream: ArgumentWithLengthSetter<Reader>
        get() {
            return ArgumentWithLengthSetter(
                    { i, v -> setCharacterStream(i, v) },
                    { i, v, l -> setCharacterStream(i, v, l) },
                    { i, v, l -> setCharacterStream(i, v, l) })
        }

    val clob: ClobArgumentSetter
        get() {
            return ClobArgumentSetter(
                    { i, b -> setClob(i, b) },
                    { i, v -> setClob(i, v) },
                    { i, v, l -> setClob(i, v, l) })
        }

    val date: CombinedArgumentSetter<Date, Calendar>
        get() {
            return CombinedArgumentSetter(
                    { i, d -> setDate(i, d) },
                    { i, d, c -> setDate(i, d, c) })
        }

    val double: DefaultArgumentSetter<Double>
        get() {
            return DefaultArgumentSetter { i, v -> setDouble(i, v) }
        }

    val float: DefaultArgumentSetter<Float>
        get() {
            return DefaultArgumentSetter { i, v -> setFloat(i, v) }
        }

    val int: DefaultArgumentSetter<Int>
        get() {
            return DefaultArgumentSetter { i, v -> setInt(i, v) }
        }

    val long: DefaultArgumentSetter<Long>
        get() {
            return DefaultArgumentSetter { i, v -> setLong(i, v) }
        }

    val nCharacterStream: CombinedArgumentSetter<Reader, Long>
        get() {
            return CombinedArgumentSetter(
                    { i, r -> setNCharacterStream(i, r) },
                    { i, r, l -> setNCharacterStream(i, r, l) })
        }

    val nClob: NClobArgumentSetter
        get() {
            return NClobArgumentSetter(
                    { i, b -> setNClob(i, b) },
                    { i, v -> setNClob(i, v) },
                    { i, v, l -> setNClob(i, v, l) })
        }

    val nString: DefaultArgumentSetter<String>
        get() {
            return DefaultArgumentSetter { i, v -> setNString(i, v) }
        }

    val `null`: CombinedArgumentSetter<Int, String>
        get() {
            return CombinedArgumentSetter(
                    { i, s -> setNull(i, s) },
                    { i, s, t -> setNull(i, s, t) })
        }

    val `object`: ObjectArgumentSetter
        get() {
            return ObjectArgumentSetter(
                    { i, x -> setObject(i, x) },
                    { i, x, t -> setObject(i, x, t) },
                    { i, x, t, s -> setObject(i, x, t, s) }

            )
        }

    val ref: DefaultArgumentSetter<Ref>
        get() {
            return DefaultArgumentSetter { i, v -> setRef(i, v) }
        }

    val rowId: DefaultArgumentSetter<RowId>
        get() {
            return DefaultArgumentSetter { i, v -> setRowId(i, v) }
        }

    val sqlXml: DefaultArgumentSetter<SQLXML>
        get() {
            return DefaultArgumentSetter { i, v -> setSQLXML(i, v) }
        }

    val string: DefaultArgumentSetter<String>
        get() {
            return DefaultArgumentSetter { i, v -> setString(i, v) }
        }

    val time: CombinedArgumentSetter<Time, Calendar>
        get() {
            return CombinedArgumentSetter(
                    { i, d -> setTime(i, d) },
                    { i, d, c -> setTime(i, d, c) })
        }

    val timestamp: CombinedArgumentSetter<Timestamp, Calendar>
        get() {
            return CombinedArgumentSetter(
                    { i, d -> setTimestamp(i, d) },
                    { i, d, c -> setTimestamp(i, d, c) })
        }

    val url: DefaultArgumentSetter<URL>
        get() {
            return DefaultArgumentSetter { i, v -> setURL(i, v) }
        }

    val uuid : DefaultArgumentSetter<UUID>
        get() {
            return DefaultArgumentSetter { i, v -> setString(i, v.toString())  }
        }
}