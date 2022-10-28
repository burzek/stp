package sk.mysko.stp.conversion.converters


import sk.mysko.stp.conversion.ConversionResult
import sk.mysko.stp.conversion.Converter
import java.nio.charset.Charset

/**
 * @author boris.brinza 12-Apr-2017.
 */
class StringToOct: Converter {

	private val OCT_CHARS = "012345678".toCharArray()

	override fun convert(input: String): ConversionResult {
		return ConversionResult().withResult(asOct(input.toByteArray(Charset.forName("ASCII"))));
	}

	private fun asOct(buf: ByteArray): String {
		val chars = CharArray(3 * buf.size)
		for ((index, b) in buf.withIndex()) {
			chars[3 * index] = OCT_CHARS[b.toInt()and(192).shr(6)]
			chars[3 * index + 1] = OCT_CHARS[b.toInt().and(56).shr(3)]
			chars[3 * index + 2] = OCT_CHARS[b.toInt().and(7)]
		}
		return String(chars)
	}

}

