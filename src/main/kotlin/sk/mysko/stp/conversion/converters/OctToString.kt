package sk.mysko.stp.conversion.converters

/**
 * @author boris.brinza 12-Apr-2017.
 */
class OctToString: NumBaseToString() {

	override fun getRadix(): Int {
		return 8
	}

	 override fun getNumberDigits(): Int {
		return 3
	}

	override fun getAllowedDigits(): String {
		return "01234567";
	}
}
