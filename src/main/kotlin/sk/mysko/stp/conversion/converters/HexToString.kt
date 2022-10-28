package sk.mysko.stp.conversion.converters


/**
 * @author boris.brinza 12-Apr-2017.
 */
class HexToString: NumBaseToString() {


	override fun getRadix(): Int {
		return 16
	}

	override fun getNumberDigits(): Int {
		return 2
	}

	override fun getAllowedDigits(): String {
		return "0123456789abcdefABCDEF";
	}
}
