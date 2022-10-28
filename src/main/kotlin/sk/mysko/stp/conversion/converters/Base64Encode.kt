package sk.mysko.stp.conversion.converters


import sk.mysko.stp.conversion.ConversionResult
import sk.mysko.stp.conversion.Converter
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author boris.brinza 12-Apr-2017.
 */
class Base64Encode : Converter {
	override fun convert(input: String): ConversionResult {
		return ConversionResult().withResult(Base64.getEncoder().encodeToString(input.toByteArray(Charset.defaultCharset())));
	}
}