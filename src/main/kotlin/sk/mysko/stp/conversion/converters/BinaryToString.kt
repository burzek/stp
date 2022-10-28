package sk.mysko.stp.conversion.converters

/**
 * @author boris.brinza 12-Apr-2017.
 */
class BinaryToString : NumBaseToString() {

    override fun getRadix(): Int {
        return 2
    }

    override fun getNumberDigits(): Int {
        return 8
    }

    override fun getAllowedDigits(): String {
        return "01";
    }
}
