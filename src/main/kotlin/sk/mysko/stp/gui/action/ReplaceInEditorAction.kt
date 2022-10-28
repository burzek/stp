package sk.mysko.stp.gui.action

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Editor
import sk.mysko.stp.data.ConversionData
import sk.mysko.stp.data.DataProvider
import sk.mysko.stp.i18n.NO_SELECTION_STATUS
import sk.mysko.stp.i18n.REPLACE_DONE_STATUS
import java.awt.event.ActionEvent
import javax.swing.AbstractAction

class ReplaceInEditorAction(private val dataProvider: DataProvider,
                            private val updateStatusListener: UpdateStatusListener) : AbstractAction() {

    override fun actionPerformed(e: ActionEvent?) {
        val transformationData: ConversionData = dataProvider.getConversionData()
        val editor: Editor? = transformationData.getOpenedEditor()
        if (editor != null) {
            val selectedText = editor.selectionModel.selectedText
            if (selectedText != null && selectedText.isNotEmpty()) {
                val startPosition = editor.selectionModel.selectionStart
                val endPosition = editor.selectionModel.selectionEnd
                WriteCommandAction.runWriteCommandAction(
                    editor.project
                ) {
                    TODO()
                    //editor.document
                      //  .replaceString(startPosition, endPosition, transformationData.getConvertedText())   //TODO : ?
                }
                updateStatusListener.updateStatus(REPLACE_DONE_STATUS)
            } else {
                updateStatusListener.updateStatus(NO_SELECTION_STATUS)
            }
        }
    }
}