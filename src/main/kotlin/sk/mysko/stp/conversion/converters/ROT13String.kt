package sk.mysko.stp.conversion.converters

import sk.mysko.stp.conversion.ConversionResult
import sk.mysko.stp.conversion.Converter

/**
 * @author boris.brinza 12-Apr-2017.
 */
class ROT13String: Converter {

	override fun  convert(input: String) : ConversionResult {
		val rot13 = input.map { c ->
			when (c) {
				in 'a'..'z' -> Char('a'.code + (((c.code - 'a'.code + 13).mod(26))))
				in 'A'..'Z' -> Char('A'.code + (((c.code - 'A'.code + 13).mod(26))))
				else -> c
			}
		}.joinToString(separator = "")

		return ConversionResult().withResult(rot13);
	}

}