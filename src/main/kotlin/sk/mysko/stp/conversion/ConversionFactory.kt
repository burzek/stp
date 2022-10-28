package sk.mysko.stp.conversion

import sk.mysko.stp.data.Operation


class ConversionFactory {

//    private val op2Hash: MutableMap<Operation, HashType> = HashMap<Operation, HashType>()
//    static
//    {
//        op2Hash[Operation.MD5_HASH] = HashType.MD5
//        op2Hash[Operation.SHA1_HASH] = HashType.SHA1
//        op2Hash[Operation.SHA256_HASH] = HashType.SHA_256
//        op2Hash[Operation.SHA384_HASH] = HashType.SHA_384
//        op2Hash[Operation.SHA512_HASH] = HashType.SHA_512
//        op2Hash[Operation.SHA3_256_HASH] = HashType.SHA3_256
//        op2Hash[Operation.SHA3_384_HASH] = HashType.SHA3_256
//        op2Hash[Operation.SHA3_512_HASH] = HashType.SHA3_512
//    }

    fun getConverter(transformation: Operation): Converter? {
        TODO()
//        return when (transformation) {
//            Operation.STRING_TO_BIN -> StringToBinary()
//            Operation.BIN_TO_STRING -> BinaryToString()
//            Operation.STRING_TO_HEX -> StringToHex()
//            Operation.HEX_TO_STRING -> HexToString()
//            Operation.STRING_TO_OCT -> StringToOct()
//            Operation.OCT_TO_STRING -> OctToString()
//            Operation.BASE_64_DECODE -> Base64Decode()
//            Operation.BASE_64_ENCODE -> Base64Encode()
//            Operation.URL_DECODE -> UrlDecode()
//            Operation.URL_ENCODE -> UrlEncode()
//            Operation.HTML_ENCODE -> HtmlEncode()
//            Operation.HTML_DECODE -> HtmlDecode()
//            Operation.ROT13 -> ROT13String()
//            Operation.MD5_HASH,
//            Operation.SHA1_HASH,
//            Operation.SHA256_HASH,
//            Operation.SHA512_HASH,
//            Operation.SHA384_HASH,
//            Operation.SHA3_256_HASH,
//            Operation.SHA3_384_HASH,
//            Operation.SHA3_512_HASH -> HashConverter(op2Hash[transformation])
//                break;
//            Operation.CRC32 -> CRC32CheckSum()
//            Operation.LUHN_DIGIT_GENERATOR -> LuhnDigitAppender()
//            else -> throw IllegalStateException("Invalid transformation:$transformation")
//        }
    }
}