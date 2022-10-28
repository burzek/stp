package sk.mysko.stp.conversion.converters

import sk.mysko.stp.conversion.ConversionResult
import sk.mysko.stp.conversion.Converter
import java.nio.charset.Charset
import java.util.zip.CRC32

/**
 * @author boris.brinza 10-Oct-2017.
 */
class CRC32CheckSum : Converter {

	override fun convert(input: String): ConversionResult {
		val crc32 = CRC32()
		crc32.update(input.toByteArray(Charset.defaultCharset()))
		return ConversionResult().withResult(crc32.value.toString(16).uppercase())
	}
}
