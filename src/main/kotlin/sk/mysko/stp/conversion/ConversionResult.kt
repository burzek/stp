package sk.mysko.stp.conversion

import sk.mysko.stp.i18n.ResourceKey

class ConversionResult {

    var result: String? = null;
    var errorResourceKey: ResourceKey? = null

    fun withError(errorResourceKey: ResourceKey): ConversionResult {
        this.errorResourceKey = errorResourceKey
        return this
    }

    fun withResult(result: String): ConversionResult {
        this.result = result
        return this
    }

    fun getConversionResult(): String? {
        return result
    }

    fun isError(): Boolean {
        return errorResourceKey != null
    }

    fun getError(): ResourceKey? {
        return errorResourceKey
    }

}