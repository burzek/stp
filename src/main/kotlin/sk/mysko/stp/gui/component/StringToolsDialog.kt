package sk.mysko.stp.gui.component

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogBuilder
import com.intellij.ui.KeyStrokeAdapter
import java.awt.event.KeyEvent

class StringToolsDialog(private var project: Project?) : DialogBuilder() {
    private val mainPanel: MainPanel =  initialize()

    init {
        private var mainPanel: MainPanel = initialize()
    }

    private fun getProject(): Project? {
        return project
    }

    fun getOpenedEditor(): Editor? {
        return if (project != null) {
            FileEditorManager.getInstance(project!!).selectedTextEditor
        } else null
    }


    private fun initialize() {
        TODO()
//        val controller = StringToolsController(this)
//        mainPanel = MainPanel(controller)
//        loadSelectionFromEditor()
//        setCenterPanel(mainPanel)
//        removeAllActions()
//        resizable(false)
//        dialogWrapper.addKeyListener(object : KeyStrokeAdapter() {
//            override fun keyPressed(event: KeyEvent) {
//                super.keyPressed(event)
//                if (event.keyCode == KeyEvent.VK_ESCAPE) {
//                    controller.exitRequested()
//                }
//            }
//        })
    }

    private fun loadSelectionFromEditor() {
        val editor = FileEditorManager.getInstance(getProject()!!).selectedTextEditor
        if (editor != null) {
            val selectedText = editor.selectionModel.selectedText
            if (selectedText != null && selectedText.length > 0) {
//                getMainPanel().setInputContent(selectedText)
            }
        }
    }

    fun getMainPanel(): MainPanel {
        return mainPanel
    }
}