package sk.mysko.stp.conversion.converters

import sk.mysko.stp.conversion.ConversionResult
import sk.mysko.stp.conversion.Converter
import sk.mysko.stp.i18n.ERR_INVALID_INPUT
import sk.mysko.stp.i18n.ERR_INVALID_LENGTH

/**
 * @author boris.brinza 09-Oct-2017.
 */
abstract class NumBaseToString : Converter {

	override fun convert(input: String): ConversionResult {

		if (input.isEmpty()) {
			return ConversionResult().withResult("")
		}

		val radix = getRadix()
		val numDigits = getNumberDigits()

		if (!input.all { c -> c in getAllowedDigits() }) {
			return ConversionResult().withError(ERR_INVALID_INPUT)
		}

		val sb = StringBuilder()
		val tmpStr = if (input.length % numDigits == 0) input else '0'.toString().repeat(input.length - input.length % numDigits) + input
		for (split in tmpStr.chunked(numDigits)) {
			if (split.isNotEmpty()) {
				sb.append(split.toInt(radix).toChar())
			}
		}
		return ConversionResult().withResult(sb.toString())
	}


	protected abstract fun getRadix(): Int
	protected abstract fun getNumberDigits(): Int
	protected abstract fun getAllowedDigits() : String

}
