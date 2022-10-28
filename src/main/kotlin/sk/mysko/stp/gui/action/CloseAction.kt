package sk.mysko.stp.gui.action

import java.awt.event.ActionEvent
import javax.swing.AbstractAction

class CloseAction(private val actionsRequestListener: ActionsRequestListener) : AbstractAction() {

    override fun actionPerformed(e: ActionEvent) {
        this.actionsRequestListener.exitRequested()
    }
}