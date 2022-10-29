package sk.mysko.stp

import sk.mysko.stp.conversion.ConversionProcessor
import sk.mysko.stp.data.ConversionData
import sk.mysko.stp.data.DataProvider
import sk.mysko.stp.gui.action.ActionsRequestListener
import sk.mysko.stp.gui.component.MainPanel
import sk.mysko.stp.gui.component.StringToolsDialog


class StringToolsController(private val dialog: StringToolsDialog) : ActionsRequestListener, DataProvider {
    private val conversionProcessor: ConversionProcessor = ConversionProcessor(this)

    override fun getConversionData() : ConversionData = ConversionData(
        dialog.getOpenedEditor(),
        dialog.getMainPanel().getInputContent(),
        dialog.getMainPanel().getOutputContent(),
        dialog.getMainPanel().getSelectedOperation()
    )

    override fun exitRequested() {
        dialog.dialogWrapper.close(0, true)
    }

    override fun transformationRequested() {
        val transformationData: ConversionData = conversionProcessor.doConversion()
        dialog.getMainPanel().showWarning(transformationData)
        dialog.getMainPanel().setOutputContent(transformationData.getConvertedText())
    }


}