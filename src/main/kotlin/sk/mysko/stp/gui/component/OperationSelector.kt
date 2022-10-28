package sk.mysko.stp.gui.component

import com.intellij.ui.components.JBRadioButton
import sk.mysko.stp.data.Operation
import sk.mysko.stp.gui.action.ActionsRequestListener
import java.awt.event.ActionEvent

class OperationSelector(private val operation: Operation,
                        requestListener: ActionsRequestListener) : JBRadioButton() {

    init {
        addActionListener { _: ActionEvent -> requestListener.transformationRequested() }
    }

    fun getOperation(): Operation {
        return operation
    }
}