package sk.mysko.stp.gui.action

import sk.mysko.stp.data.DataProvider
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.ActionEvent
import javax.swing.AbstractAction

class CopyToClipboardAction(private val dataProvider: DataProvider,
                            private val updateStatusListener: UpdateStatusListener) : AbstractAction() {

    override fun actionPerformed(e: ActionEvent) {
        val stringSelection = StringSelection(dataProvider.getConversionData().getConvertedText())
        val clpbrd = Toolkit.getDefaultToolkit().systemClipboard
        clpbrd.setContents(stringSelection, null)
        updateStatusListener.updateStatus(sk.mysko.stp.i18n.COPIED_TO_CLIPBOARD_STATUS)
    }
}