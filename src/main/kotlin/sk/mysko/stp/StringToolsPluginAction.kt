package sk.mysko.stp

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.DialogBuilder
import sk.mysko.stp.gui.component.GuiFactory

class StringToolsPluginAction : AnAction() {

    override fun actionPerformed(anActionEvent: AnActionEvent) {
        val dlg: DialogBuilder = GuiFactory().createMainDialog(AnAction.getEventProject(anActionEvent))
        dlg.show()
    }
}