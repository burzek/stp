package sk.mysko.stp.conversion.converters

import sk.mysko.stp.conversion.ConversionResult
import sk.mysko.stp.conversion.Converter
import java.nio.charset.Charset


/**
 * @author boris.brinza 12-Apr-2017.
 */
class StringToHex: Converter {
	private val HEX_CHARS: CharArray = "0123456789abcdef".toCharArray()

	override fun convert(input: String): ConversionResult {
		return ConversionResult().withResult(asHex(input.toByteArray(Charset.forName("ASCII"))));
	}

	private fun asHex(buf: ByteArray): String {
		val chars = CharArray(2 * buf.size)
		for ((index, b) in buf.withIndex()) {
			chars[2 * index] = HEX_CHARS[(b.toInt().and(0xF0)).shr(4)];
			chars[2 * index + 1] = HEX_CHARS[b.toInt().and(0x0F)];
		}
		return String(chars);
	}
}
