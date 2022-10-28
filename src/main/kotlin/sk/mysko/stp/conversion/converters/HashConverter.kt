package sk.mysko.stp.conversion.converters

import sk.mysko.stp.conversion.ConversionResult
import sk.mysko.stp.conversion.Converter
import sk.mysko.stp.i18n.ERR_INTERNAL
import java.nio.charset.Charset
import java.security.MessageDigest

/**
 * @author boris.brinza 10-Oct-2017.
 */
class HashConverter(private val hashType: HashType): Converter {


	override fun convert(input: String): ConversionResult {
		try {
			val messageDigest = MessageDigest.getInstance(hashType.getAlgorithmName())
			val dig: ByteArray = messageDigest.digest(input.toByteArray(Charset.defaultCharset()))

			val sb = StringBuilder(dig.size * 2)
			for(b in dig) {
				sb.append(String.format("%02x", b))
			}

			return ConversionResult().withResult(sb.toString().uppercase())
		} catch (e: Exception) {
			return ConversionResult().withResult("???").withError(ERR_INTERNAL.withParam("stacktrace", e.toString()))
		}

	}



}
