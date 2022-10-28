package sk.mysko.stp.conversion.converters

import sk.mysko.stp.conversion.ConversionResult
import sk.mysko.stp.conversion.Converter


/**
 * @author boris.brinza 12-Apr-2017.
 */
class UrlEncode: Converter {
	private val NOT_ESCAPED = "-_.!~*'()";

	private fun toHex(ch: Char): String {
		return "%"+ Integer.toHexString(ch.code).uppercase()
	}

	override fun convert(input: String): ConversionResult {

		val sbuf = StringBuilder();
		for (ch in input) {
			if (Character.isDigit(ch) || (ch in 'a'..'z') || (ch in 'A'..'Z') || ch in NOT_ESCAPED) {
				sbuf.append(ch)
			} else if (ch == ' ') {					// space
				sbuf.append("%20");
			} else if (ch.code <= 0x007f) {  		//other ASCII
				sbuf.append(toHex(ch));
			} else if (ch.code <= 0x07FF) {			// non-ASCII <= 0x7FF
				sbuf.append(toHex(Char(0xc0 or (ch.code shr 6 ))))
				sbuf.append(toHex(Char(0x80 or (ch.code and 0x3F))))
			} else {								// 0x7FF < ch <= 0xFFFF
				sbuf.append(toHex(Char(0xe0 or (ch.code shr 12))))
				sbuf.append(toHex(Char(0x80 or ((ch.code shr 6) and 0x3F))))
				sbuf.append(toHex(Char(0x80 or (ch.code and 0x3F))))
			}
		}

		return ConversionResult().withResult(sbuf.toString());
	}

}
