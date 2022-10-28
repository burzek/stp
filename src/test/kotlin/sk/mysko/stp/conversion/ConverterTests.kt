package sk.mysko.stp.conversion

import org.junit.Test
import sk.mysko.stp.conversion.converters.Base64Decode
import sk.mysko.stp.conversion.converters.Base64Encode
import sk.mysko.stp.conversion.converters.BinaryToString
import sk.mysko.stp.conversion.converters.CRC32CheckSum
import sk.mysko.stp.conversion.converters.HashConverter
import sk.mysko.stp.conversion.converters.HashType
import sk.mysko.stp.conversion.converters.HexToString
import sk.mysko.stp.conversion.converters.LuhnDigitAppender
import sk.mysko.stp.conversion.converters.OctToString
import sk.mysko.stp.conversion.converters.ROT13String
import sk.mysko.stp.conversion.converters.StringToBinary
import sk.mysko.stp.conversion.converters.StringToHex
import sk.mysko.stp.conversion.converters.StringToOct
import sk.mysko.stp.conversion.converters.UrlDecode
import sk.mysko.stp.conversion.converters.UrlEncode
import sk.mysko.stp.i18n.ERR_INVALID_INPUT
import sk.mysko.stp.i18n.ResourceKey
import kotlin.test.assertEquals

class ConverterTests {
    private val inputTestDataAscii = "0123asdfASDF!@#$"
    private val inputTestDataLocal = "ľščťžýáíéúäôĽŠČŤŽÝÁÍÉÚÄÔ"

    @Test
    fun testBase64() {
        var conv = Base64Encode().convert(inputTestDataAscii)
        assertEquals(false, conv.isError())
        assertEquals("MDEyM2FzZGZBU0RGIUAjJA==", conv.result)

        conv = Base64Encode().convert(inputTestDataLocal)
        assertEquals(false, conv.isError())
        assertEquals("xL7FocSNxaXFvsO9w6HDrcOpw7rDpMO0xL3FoMSMxaTFvcOdw4HDjcOJw5rDhMOU", conv.result)

        conv = Base64Decode().convert("MDEyM2FzZGZBU0RGIUAjJA==")
        assertEquals(false, conv.isError())
        assertEquals(inputTestDataAscii, conv.result)

        conv = Base64Decode().convert("xL7FocSNxaXFvsO9w6HDrcOpw7rDpMO0xL3FoMSMxaTFvcOdw4HDjcOJw5rDhMOU")
        assertEquals(false, conv.isError())
        assertEquals(inputTestDataLocal, conv.result)
    }

    @Test
    fun testRadix() {
        var conv = StringToBinary().convert("0aA")
        assertEquals(false, conv.isError())
        assertEquals("001100000110000101000001", conv.result)

        conv = BinaryToString().convert("001100000110000101000001")
        assertEquals(false, conv.isError())
        assertEquals("0aA", conv.result)

        conv = BinaryToString().convert("110101")   //ascii 5
        assertEquals(false, conv.isError())
        assertEquals("5", conv.result)
        conv = BinaryToString().convert("012")
        assertEquals(true, conv.isError())
        assertEquals(ERR_INVALID_INPUT, conv.getError())

        conv = StringToOct().convert("0aA")
        assertEquals(false, conv.isError())
        assertEquals("060141101", conv.result)

        conv = OctToString().convert("060141101")
        assertEquals(false, conv.isError())
        assertEquals("0aA", conv.result)

        conv = OctToString().convert("0123456789")
        assertEquals(true, conv.isError())
        assertEquals(ERR_INVALID_INPUT, conv.getError())

        conv = StringToHex().convert("0aA")
        assertEquals(false, conv.isError())
        assertEquals("306141", conv.result)

        conv = HexToString().convert("306141")
        assertEquals(false, conv.isError())
        assertEquals("0aA", conv.result)

        conv = HexToString().convert("0123456789abcdeABCDE")
        assertEquals(false, conv.isError())
        conv = HexToString().convert("0123456789abcdeABCDEfghFGH")
        assertEquals(true, conv.isError())
        assertEquals(ERR_INVALID_INPUT, conv.getError())

    }

    @Test
    fun testHash() {
        var conv = HashConverter(HashType.MD5).convert("0123456789abcdefghľščťžý!@#$%")
        assertEquals(false, conv.isError())
        assertEquals("6D490062328DF23B2C025C4470BD2BB7", conv.result)

        conv = HashConverter(HashType.SHA1).convert("0123456789abcdefghľščťžý!@#$%")
        assertEquals(false, conv.isError())
        assertEquals("2AFEEAD1B158DF702D3909A6BAFFCDC1E8341316", conv.result)

        conv = HashConverter(HashType.SHA_256).convert("0123456789abcdefghľščťžý!@#%")
        assertEquals(false, conv.isError())
        assertEquals("F1FB2334EB109B9AD4625C3F0FD1E4B93F76330B94BB46D08BB6D8F03F93BAF2", conv.result)

        conv = HashConverter(HashType.SHA_384).convert("0123456789abcdefghľščťžý!@#$%")
        assertEquals(false, conv.isError())
        assertEquals("76602518FA5A009B6B0F575C18ADA13B8CE0C7A9D4DD15B920E7A584F1EAAFDAFF8A663811CB71A88367C231205805D6", conv.result)

        conv = HashConverter(HashType.SHA_512).convert("0123456789abcdefghľščťžý!@#$%")
        assertEquals(false, conv.isError())
        assertEquals("AAC9CF073DD8451002BDADEAF8A0A36EBE35ACB72908C6F8CB5D6E842B47EBBE84C60813F3A663CE999B0493018227B1815BA87ED170261251D731610ACED943", conv.result)


        conv = HashConverter(HashType.SHA3_256).convert("0123456789abcdefghľščťžý!@#$%")
        assertEquals(false, conv.isError())
        assertEquals("CEF8B503376817EC3C1AFE36CD63BC9C9C585A6117A461CA840470F4AB807EBB", conv.result)

        conv = HashConverter(HashType.SHA3_384).convert("0123456789abcdefghľščťžý!@#$%")
        assertEquals(false, conv.isError())
        assertEquals("869BD085863BDF0E740791FE424FB16018A8E2361C66636F4A22F829F29E6DFD579CB6805CF7F7022EFCED1FA536D27E", conv.result)


        conv = HashConverter(HashType.SHA3_512).convert("0123456789abcdefghľščťžý!@#$%")
        assertEquals(false, conv.isError())
        assertEquals("C466FE8C4D4ADBB6211F41DC05D750F735EA876F70C5242B4AFC7361EB5A24B002725B3EC891C0E5BCFD71C87A46E3E023172C85E1699AD9031083ACE04AC9AE", conv.result)

        conv = ROT13String().convert("0123456789abcdefghľščťžý!@#$%")
        assertEquals(false, conv.isError())
        assertEquals("0123456789nopqrstuľščťžý!@#$%", conv.result)

    }

    @Test
    fun testUrlEncode() {
        var conv = UrlEncode().convert("0123abc/?†¼")
        assertEquals(false, conv.isError())
        assertEquals("0123abc%2F%3F%E2%80%A0%C2%BC%C2%8F", conv.result)

        conv = UrlDecode().convert("0123abc%2F%3F%E2%80%A0%C2%BC%C2%8F")
        assertEquals(false, conv.isError())
        assertEquals("0123abc/?†¼", conv.result)

    }

    @Test
    fun testChecksum() {

        var conv = CRC32CheckSum().convert("0123456789abcdef!@#$%ľščťžý")
        assertEquals(false, conv.isError())
        assertEquals("F34F4A44", conv.result)


        conv = LuhnDigitAppender().convert("0123456789abcdef!@#$%ľščťžý")
        assertEquals(true, conv.isError())
        assertEquals(ERR_INVALID_INPUT, conv.getError())

        conv = LuhnDigitAppender().convert("1234567890")
        assertEquals(false, conv.isError())
        assertEquals("12345678903", conv.getConversionResult())

    }


}