package sk.mysko.stp.conversion.converters

import sk.mysko.stp.conversion.ConversionResult
import sk.mysko.stp.conversion.Converter
import java.util.regex.Pattern

/**
 * @author boris.brinza 12-Apr-2017.
 */
class HtmlDecode: Converter {

	override fun convert(input: String): ConversionResult {
		return ConversionResult().withResult(htmlUnescape(input));
	}

	private fun htmlUnescape(htmlString: String) : String {
		val matcher = Pattern.compile("(&#\\d+;|&amp;|&quot;|&lt;|&gt;)").matcher(htmlString);
		var ret = htmlString;
		while (matcher.find()) {
			val element = matcher.group(1);
			val replacement = when (element) {
				"&amp;" -> "&"
				"&quot;" -> "'"
				"&lt;" -> "<"
				"&gt;" -> ">"
				else -> Integer.parseInt(element.substring(2, element.length - 1)).toString()
			}
			ret = ret.replace(element, replacement)
		}
		return ret
	}

}
