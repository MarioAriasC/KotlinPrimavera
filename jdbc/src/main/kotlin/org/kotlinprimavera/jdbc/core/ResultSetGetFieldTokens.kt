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
import java.time.LocalDateTime

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 20/08/13
 * Time: 23:04
 */
class ResultSetGetFieldTokens(resultSet: ResultSet) : ResultSet by resultSet {
    val array: GetFieldsToken<java.sql.Array?>
        get() {
            return GetFieldsToken(
                    { columnName -> getArray(columnName) },
                    { columnIndex -> getArray(columnIndex) })
        }

    val asciiStream: GetFieldsToken<InputStream?>
        get() {
            return GetFieldsToken(
                    { columnName -> getAsciiStream(columnName) },
                    { columnIndex -> getAsciiStream(columnIndex) })
        }

    val bigDecimal: GetFieldsToken<BigDecimal?>
        get() {
            return GetFieldsToken(
                    { columnName -> getBigDecimal(columnName) },
                    { columnIndex -> getBigDecimal(columnIndex) })
        }

    val binaryStream: GetFieldsToken<InputStream?>
        get() {
            return GetFieldsToken(
                    { columnName -> getBinaryStream(columnName) },
                    { columnIndex -> getBinaryStream(columnIndex) })
        }

    val blob: GetFieldsToken<Blob?>
        get() {
            return GetFieldsToken(
                    { columnName -> getBlob(columnName) },
                    { columnIndex -> getBlob(columnIndex) })
        }

    val boolean: GetFieldsToken<Boolean?>
        get() {
            return GetFieldsToken(
                    { columnName -> getBoolean(columnName) },
                    { columnIndex -> getBoolean(columnIndex) })
        }


    val byte: GetFieldsToken<Byte?>
        get() {
            return GetFieldsToken(
                    { columnName -> getByte(columnName) },
                    { columnIndex -> getByte(columnIndex) })
        }


    val bytes: GetFieldsToken<ByteArray?>
        get() {
            return GetFieldsToken(
                    { columnName -> getBytes(columnName) },
                    { columnIndex -> getBytes(columnIndex) })
        }


    val characterStream: GetFieldsToken<Reader?>
        get() {
            return GetFieldsToken(
                    { columnName -> getCharacterStream(columnName) },
                    { columnIndex -> getCharacterStream(columnIndex) })
        }


    val clob: GetFieldsToken<Clob?>
        get() {
            return GetFieldsToken(
                    { columnName -> getClob(columnName) },
                    { columnIndex -> getClob(columnIndex) })
        }


    val date: GetFieldsToken<java.sql.Date?>
        get() {
            return GetFieldsToken(
                    { columnName -> getDate(columnName) },
                    { columnIndex -> getDate(columnIndex) })
        }


    val double: GetFieldsToken<Double?>
        get() {
            return GetFieldsToken(
                    { columnName -> getDouble(columnName) },
                    { columnIndex -> getDouble(columnIndex) })
        }


    val float: GetFieldsToken<Float?>
        get() {
            return GetFieldsToken(
                    { columnName -> getFloat(columnName) },
                    { columnIndex -> getFloat(columnIndex) })
        }


    val int: GetFieldsToken<Int?>
        get() {
            return GetFieldsToken(
                    { columnName -> getInt(columnName) },
                    { columnIndex -> getInt(columnIndex) })
        }


    val long: GetFieldsToken<Long?>
        get() {
            return GetFieldsToken(
                    { columnName -> getLong(columnName) },
                    { columnIndex -> getLong(columnIndex) })
        }


    val nCharacterStream: GetFieldsToken<Reader?>
        get() {
            return GetFieldsToken(
                    { columnName -> getNCharacterStream(columnName) },
                    { columnIndex -> getNCharacterStream(columnIndex) })
        }


    val nClob: GetFieldsToken<NClob?>
        get() {
            return GetFieldsToken(
                    { columnName -> getNClob(columnName) },
                    { columnIndex -> getNClob(columnIndex) })
        }


    val nString: GetFieldsToken<String?>
        get() {
            return GetFieldsToken(
                    { columnName -> getNString(columnName) },
                    { columnIndex -> getNString(columnIndex) })
        }


    val ref: GetFieldsToken<Ref?>
        get() {
            return GetFieldsToken(
                    { columnName -> getRef(columnName) },
                    { columnIndex -> getRef(columnIndex) })
        }


    val rowId: GetFieldsToken<RowId?>
        get() {
            return GetFieldsToken(
                    { columnName -> getRowId(columnName) },
                    { columnIndex -> getRowId(columnIndex) })
        }


    val short: GetFieldsToken<Short?>
        get() {
            return GetFieldsToken(
                    { columnName -> getShort(columnName) },
                    { columnIndex -> getShort(columnIndex) })
        }


    val SQLXML: GetFieldsToken<SQLXML?>
        get() {
            return GetFieldsToken(
                    { columnName -> getSQLXML(columnName) },
                    { columnIndex -> getSQLXML(columnIndex) })
        }


    val string: GetFieldsToken<String?>
        get() {
            return GetFieldsToken(
                    { columnName -> getString(columnName) },
                    { columnIndex -> getString(columnIndex) })
        }


    val time: GetFieldsToken<Time?>
        get() {
            return GetFieldsToken(
                    { columnName -> getTime(columnName) },
                    { columnIndex -> getTime(columnIndex) })
        }


    val timestamp: GetFieldsToken<Timestamp?>
        get() {
            return GetFieldsToken(
                    { columnName -> getTimestamp(columnName) },
                    { columnIndex -> getTimestamp(columnIndex) })
        }

    val localDateTime : GetFieldsToken<LocalDateTime?>
        get() {
            return GetFieldsToken(
                { columnName -> getTimestamp(columnName)?.toLocalDateTime() },
                { columnIndex -> getTimestamp(columnIndex)?.toLocalDateTime() })
        }


    val URL: GetFieldsToken<URL?>
        get() {
            return GetFieldsToken(
                    { columnName -> getURL(columnName) },
                    { columnIndex -> getURL(columnIndex) })
        }
}