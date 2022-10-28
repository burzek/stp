package sk.mysko.stp.conversion.converters

import sk.mysko.stp.conversion.ConversionResult
import sk.mysko.stp.conversion.Converter
import kotlin.experimental.and

/**
 * @author boris.brinza 12-Apr-2017.
 */
class StringToBinary: Converter {

	override fun convert(input: String): ConversionResult {
		return ConversionResult().withResult(asBinary(input))
	}

	private fun asBinary(input: String) : String {
		val str = StringBuilder()
		for (c in input.toByteArray()) {
			for (bit in 7 downTo 0) {
				val tstBit = (1 shl bit).toByte()
				str.append(if (c.and(tstBit) == 0.toByte()) '0' else '1')
			}
		}
		return str.toString()
	}
}