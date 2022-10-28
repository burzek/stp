package sk.mysko.stp.gui.component

import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.event.DocumentEvent
import com.intellij.openapi.editor.event.DocumentListener
import com.intellij.openapi.util.IconLoader
import com.intellij.ui.EditorTextField
import sk.mysko.stp.gui.action.ActionsRequestListener
import java.awt.Dimension
import java.awt.Graphics

class InputTextEditor(trl: ActionsRequestListener) : EditorTextField() {
    private var showWarning = false

    init {
        initializeGUI(trl)
    }

    private fun initializeGUI(trl: ActionsRequestListener) {
        isOneLineMode = false
        preferredSize = Dimension(350, 100)
        minimumSize = Dimension(350, 100)

        document.addDocumentListener(object : DocumentListener {
            override fun documentChanged(event: DocumentEvent) {
                trl.transformationRequested()
            }
        })
    }

    fun showWarning(showWarning: Boolean) {
        this.showWarning = showWarning
        repaint()
    }

    override fun paint(g: Graphics?) {
        super.paint(g)
        if (showWarning) {
            val icon = IconLoader.getTransparentIcon(AllIcons.General.Error)
            icon.paintIcon(this, g, width - icon.iconWidth - 5, height - icon.iconHeight - 5)
        }
    }
}