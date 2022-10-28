package sk.mysko.stp.conversion.converters

import sk.mysko.stp.conversion.ConversionResult
import sk.mysko.stp.conversion.Converter
import sk.mysko.stp.i18n.ERR_INVALID_INPUT
import java.io.UnsupportedEncodingException
import java.net.URLDecoder


/**
 *  @author: Bert Bos <bert@w3.org>
 *  changed and formatted code from https://www.w3.org/International/unescape.java
 */
class UrlDecode: Converter {

	override fun convert(input: String): ConversionResult {
		try {
			return ConversionResult().withResult(URLDecoder.decode(input, "UTF-8"))
		} catch (e : UnsupportedEncodingException) {
			return ConversionResult().withError(ERR_INVALID_INPUT);
		}
	}
}
