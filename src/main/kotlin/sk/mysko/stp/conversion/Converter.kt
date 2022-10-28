package sk.mysko.stp.conversion

interface Converter {
    fun convert(input: String): ConversionResult
}