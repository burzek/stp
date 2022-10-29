package sk.mysko.stp.conversion

import com.intellij.openapi.actionSystem.DataProvider
import sk.mysko.stp.data.ConversionData


class ConversionProcessor {

    private var dataProvider: DataProvider? = null

    fun ConversionProcessor(dataProvider: DataProvider?) {
        this.dataProvider = dataProvider
    }

    fun doConversion(): ConversionData {
        TODO()
//        val data: ConversionData? = dataProvider?.getConversionData()
//        val converter: Converter = ConversionFactory.getConverter(data.getOperation())
//        val conversionResult = converter.convert(data.getOriginalText())
//        data.setConvertedText(conversionResult.getResult())
//        if (conversionResult.isError()) {
//            data.setErrorMessage(conversionResult.getErrorResourceKey())
//        }
//        return data
    }
}
