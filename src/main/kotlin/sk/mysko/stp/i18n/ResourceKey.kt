package sk.mysko.stp.i18n

import com.intellij.openapi.diagnostic.Logger
import sk.mysko.stp.exception.STPException
import java.util.Collections

val WINDOW_TITLE: ResourceKey = ResourceKey("window.title")
val ORIGINAL_TEXT: ResourceKey = ResourceKey("originalText.text.label")
val CONVERTED_TEXT: ResourceKey = ResourceKey("convertedText.text.label")

val CONVERSION_TITLE: ResourceKey = ResourceKey("conversion.title")
val CODING_TITLE: ResourceKey = ResourceKey("coding.title")
val HASH_CRC_TITLE: ResourceKey = ResourceKey("hash-crc.title")

val HEX_TO_STRING_ACTION: ResourceKey = ResourceKey("hex.to.string.action")
val STRING_TO_HEX_ACTION: ResourceKey = ResourceKey("string.to.hex.action")
val BINARY_TO_STRING_ACTION: ResourceKey = ResourceKey("bin.to.string.action")
val STRING_TO_BINARY_ACTION: ResourceKey = ResourceKey("string.to.bin.action")
val OCT_TO_STRING_ACTION: ResourceKey = ResourceKey("oct.to.string.action")
val STRING_TO_OCT_ACTION: ResourceKey = ResourceKey("string.to.oct.action")

val BASE_64_ENCODE_ACTION: ResourceKey = ResourceKey("base64.encode.action")
val BASE_64_DECODE_ACTION: ResourceKey = ResourceKey("base64.decode.action")
val URL_ENCODE_ACTION: ResourceKey = ResourceKey("url.encode.action")
val URL_DECODE_ACTION: ResourceKey = ResourceKey("url.decode.action")
val HTML_ENCODE_ACTION: ResourceKey = ResourceKey("html.encode.action")
val HTML_DECODE_ACTION: ResourceKey = ResourceKey("html.decode.action")
val ROT13_ACTION: ResourceKey = ResourceKey("rot13.action")
val MD5_HASH_ACTION: ResourceKey = ResourceKey("md5.hash.action")
val SHA_256_ACTION: ResourceKey = ResourceKey("sha256.hash.action")
val SHA_512_ACTION: ResourceKey = ResourceKey("sha512.hash.action")
val CRC32_ACTION: ResourceKey = ResourceKey("crc32.action")
val LUHN_DIGIT_GEN_ACTION: ResourceKey = ResourceKey("luhn.digit.generator.action")


val REPLACE_ACTION: ResourceKey = ResourceKey("replace.action")
val COPY_TO_CPB_ACTION: ResourceKey = ResourceKey("copy.to.cpb.action")
val CLOSE_ACTION: ResourceKey = ResourceKey("cancel.action")

val STATUS_DEFAULT_TEXT: ResourceKey = ResourceKey("status.text.default")
val COPIED_TO_CLIPBOARD_STATUS: ResourceKey = ResourceKey("copied.to.clipboard.status")
val REPLACE_DONE_STATUS: ResourceKey = ResourceKey("replace.done.status")
val NO_SELECTION_STATUS: ResourceKey = ResourceKey("no.selection.status")

val ERR_INVALID_LENGTH: ResourceKey = ResourceKey("err.invalid.length")
val ERR_INVALID_INPUT: ResourceKey = ResourceKey("err.invalid.input")
val ERR_INTERNAL: ResourceKey = ResourceKey("err.internal")

data class ResourceKey(private val resourceKey: String) {
    private val logger = Logger.getInstance(this.javaClass);

    private val params: MutableMap<String, Any> = HashMap()

    fun getResourceKey(): String {
        return resourceKey
    }

    fun withParam(paramName: String, param: Any): ResourceKey {
        val copy: ResourceKey = try {
            this.copy();
        } catch (e: CloneNotSupportedException) {
            logger.error("Internal fatal error, cannot cannot add parameter to resource {getResourceKey()}")
            throw STPException("Internal fatal error, cannot add parameter to resource " + getResourceKey(), e)
        }

        copy.params[paramName] = param
        return copy
    }

    fun getParameterNames(): Collection<String> {
        return Collections.unmodifiableSet(params.keys)
    }

    fun getParameterValueFor(parameterName: String): String {
        val value = params.getOrDefault(parameterName, "???")
        return value.toString()
    }


}