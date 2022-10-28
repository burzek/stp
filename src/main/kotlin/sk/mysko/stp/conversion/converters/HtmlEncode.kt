package sk.mysko.stp.conversion.converters

import sk.mysko.stp.conversion.ConversionResult
import sk.mysko.stp.conversion.Converter

/**
 * @author boris.brinza 12-Apr-2017.
 */
class HtmlEncode: Converter {

	override fun convert(input: String): ConversionResult {
		return ConversionResult().withResult(htmlEscape(input));
	}


	private fun htmlEscape(str: String) : String {
		if (str.length == 0) {
			return str
		}

		val sb = StringBuilder(str.length + 16)
		TODO()
//		for (c in sb.chars()) {
//			when (c) {
//				'&' ->
//					// Avoid double escaping if already escaped
//					if (isHtmlCharEntityRef(str, i)) {
//						sb.append(c);
//					} else {
//						sb.append("&amp;");
//					}
//					break;
//				'<' -> sb.append("&lt;")
//				'>' -> sb.append("&gt;");
//				'"' -> sb.append("&quot;");
//				'\'' -> sb.append("&#39;");
//				'/' -> sb.append("&#47;");
//				else:
//					if (c > 127) {
//						sb.append("&#").append((int) c).append(';');
//					} else {
//						sb.append(c);
//					}
//			}
//
//
//		}

		return sb.toString();
	}

	private fun isHtmlCharEntityRef(str: String, index: Int) : Boolean {
		TODO()
//		if (str[index] != '&') {
//			return false;
//		}
//		val indexOfSemicolon = str.indexOf(';', index + 1);
//		if (indexOfSemicolon == -1) { // is there a semicolon sometime later ?
//			return false;
//		}
//		if (!(indexOfSemicolon > (index + 2))) {   // is the string actually long enough
//			return false;
//		}
//		if (followingCharsAre(str, index, "amp;")
//				|| followingCharsAre(str, index, "lt;")
//				|| followingCharsAre(str, index, "gt;")
//				|| followingCharsAre(str, index, "quot;")) {
//			return true;
//		}
//		if (str[index + 1] == '#') {
//			if (str[index + 2] == 'x' || str[index + 2] == 'X') {
//				// It's presumably a hex value
//				if (str[index + 3] == ';') {
//					return false;
//				}
//				for (int i = index + 3; i < indexOfSemicolon; i++) {
//					char c = str.charAt(i);
//					if (c >= 48 && c <= 57) {  // 0 -- 9
//						continue;
//					}
//					if (c >= 65 && c <= 70) {   // A -- F
//						continue;
//					}
//					if (c >= 97 && c <= 102) {   // a -- f
//						continue;
//					}
//					return false;
//				}
//				return true;   // yes, the value is a hex string
//			} else {
//				// It's presumably a decimal value
//				for (i = index + 2.. indexOfSemicolon ; i++) {
//					char c = str.charAt(i);
//					if (c >= 48 && c <= 57) {  // 0 -- 9
//						continue;
//					}
//					return false;
//				}
//				return true; // yes, the value is decimal
//			}
//		}
//		return false;
	}


	private fun followingCharsAre(str: String, startIndex: Int, nextChars: String) : Boolean {
		return (str.indexOf(nextChars, startIndex + 1) == (startIndex + 1));
	}
}
