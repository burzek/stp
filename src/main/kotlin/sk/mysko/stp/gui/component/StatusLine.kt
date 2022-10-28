package sk.mysko.stp.gui.component

import com.intellij.ui.JBColor
import sk.mysko.stp.gui.action.UpdateStatusListener
import sk.mysko.stp.i18n.Resource
import sk.mysko.stp.i18n.ResourceKey
import sk.mysko.stp.i18n.STATUS_DEFAULT_TEXT
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.swing.BoxLayout
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.SwingConstants
import javax.swing.border.LineBorder

class StatusLine() : JPanel(), UpdateStatusListener {

    private val resources = Resource()
    private var statusLabel = JLabel()

    init {
        initializeGUI()
    }

    private fun initializeGUI() {
        border = LineBorder(JBColor.LIGHT_GRAY)
        layout = BoxLayout(this, BoxLayout.X_AXIS)

        statusLabel.text = resources.getText(STATUS_DEFAULT_TEXT)
        statusLabel.horizontalAlignment = SwingConstants.LEFT
        statusLabel.background = JBColor.red
        statusLabel.foreground = JBColor.gray
        statusLabel.isOpaque = false
        add(statusLabel)
    }

    override fun updateStatus(status: ResourceKey) {
        statusLabel.foreground = JBColor.gray
        statusLabel.isOpaque = false
        statusLabel.text = resources.getText(status)
        Executors.newSingleThreadScheduledExecutor()
            .schedule({ statusLabel.text = resources.getText(STATUS_DEFAULT_TEXT) }, 1, TimeUnit.SECONDS)
    }

    override fun updateErrorStatus(status: ResourceKey) {
        val text: String
        val opaque: Boolean
        val fgColor: JBColor
        if (status != null) {
            text = resources.getText(status)
            opaque = true
            fgColor = JBColor.black
        } else {
            text = resources.getText(STATUS_DEFAULT_TEXT)
            opaque = false
            fgColor = JBColor.gray
        }
        statusLabel.text = text
        statusLabel.foreground = fgColor
        statusLabel.isOpaque = opaque
    }

}