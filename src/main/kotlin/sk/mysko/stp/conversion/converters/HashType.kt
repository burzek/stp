package sk.mysko.stp.conversion.converters

enum class HashType(private var algName: String) {

    MD5("MD5"),
    SHA1("SHA"),
    SHA_256("SHA-256"), SHA_384("SHA-384"), SHA_512("SHA-512"),
    SHA3_256("SHA3-256"), SHA3_384("SHA3-384"), SHA3_512("SHA3-512");

    fun getAlgorithmName(): String {
        return algName;
    }

}
