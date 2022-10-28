package sk.mysko.stp.gui.component

import com.intellij.openapi.project.Project
import com.intellij.ui.JBColor
import com.intellij.ui.components.JBLabelDecorator
import com.intellij.ui.components.JBPanel
import sk.mysko.stp.data.Operation
import sk.mysko.stp.gui.action.ActionsRequestListener
import sk.mysko.stp.i18n.Resource
import sk.mysko.stp.i18n.ResourceKey
import sk.mysko.stp.i18n.WINDOW_TITLE
import java.awt.Dimension
import java.awt.LayoutManager
import javax.swing.*
import javax.swing.border.LineBorder

class GuiFactory {
    private val resources : Resource = Resource();


    fun createMainDialog(project: Project?) : StringToolsDialog {
        val dialogBuilder = StringToolsDialog(project);
        dialogBuilder.setTitle(resources.getText(WINDOW_TITLE));
        return dialogBuilder;
    }


    fun addBorder(component : JComponent, title : ResourceKey) : Unit {
        component.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), resources.getText(title)));
    }


    fun createOperationSelector(label: ResourceKey, operation: Operation, requestListener: ActionsRequestListener, buttonGroup: ButtonGroup) : OperationSelector {
        val radioButton = OperationSelector(operation, requestListener);
        radioButton.setText(resources.getText(label));
        addMnemonic(radioButton, label);
        buttonGroup.add(radioButton);
        return radioButton;
    }


    fun  createOutputTextField() : JTextArea {
        val etf = JTextArea()
        //etf.setOneLineMode(false);
        etf.setLineWrap(true)
        etf.setBorder(LineBorder(JBColor.LIGHT_GRAY))
        etf.setPreferredSize(Dimension(350, 100))
        etf.setMinimumSize(Dimension(350, 100))
        return etf;
    }

    fun createInputTextEditor(requestListener : ActionsRequestListener) : InputTextEditor {
        return InputTextEditor(requestListener);
    }


    fun createActionButton(label: ResourceKey, action: Action) : JButton {
        val button = JButton(resources.getText(label));
        button.setAction(action);
        button.setText(resources.getText(label));
        addMnemonic(button, label);
        addIcon(button, label);
        return button;
    }

    fun createLabel(label: ResourceKey): JBLabelDecorator {
        return JBLabelDecorator.createJBLabelDecorator(resources.getText(label));
    }

    fun createStatusLine() : StatusLine {
        return StatusLine();
    }

//    fun  createPanel(layoutManager: LayoutManager) : JBPanel {
//
//        //return JBPanel(layoutManager);
//    }


//    fun getGridBagBuilder() : GridBagBuilder {
//        return GridBagBuilder();
//    }


    private fun addMnemonic(component: AbstractButton, resource: ResourceKey) : Unit {
        val mnemonicChar = resources.getMnemonic(resource)
        if (mnemonicChar != null) {
            TODO()
            //component.mnemonic = mnemonicChar
        }
        
    }

    private fun addIcon(component: AbstractButton, resource: ResourceKey ) : Unit {
        val icon = resources.getIcon(resource);
        if (icon != null) {
            component.icon = icon;
        }

    }


}