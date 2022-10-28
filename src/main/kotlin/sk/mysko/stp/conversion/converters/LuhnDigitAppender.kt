package sk.mysko.stp.conversion.converters

import sk.mysko.stp.conversion.ConversionResult
import sk.mysko.stp.conversion.Converter
import sk.mysko.stp.i18n.ERR_INVALID_INPUT

/**
 * @author boris.brinza 10-Oct-2017.
 */
class LuhnDigitAppender: Converter {

	override fun convert(input: String): ConversionResult {
		var result = ConversionResult();
		if (input.isNotEmpty()) {
			if (!isValid(input)) {
				result = result.withResult("???").withError(ERR_INVALID_INPUT);
			} else {
				result.withResult(compute(input));
			}
		}

		return result;
	}

	private fun compute(input: String): String {
		var counter = 0;
		var sum = 0;
		for (i in input.length - 1 downTo 0) {
			var value = input[i] - '0';
			if (counter++ % 2 == 0) {
				value *= 2;
			}
			if (value >= 10) {
				value -= 9;
			}
			sum += value;
		}
		sum *= 9;
		return input + Char((sum % 10) + '0'.code)
	}

	private fun isValid(input: String) : Boolean {
		return input.chars().allMatch(Character::isDigit)
	}

}
