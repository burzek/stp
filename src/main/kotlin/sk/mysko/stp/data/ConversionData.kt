package sk.mysko.stp.data

import com.intellij.openapi.editor.Editor
import sk.mysko.stp.i18n.ResourceKey

class ConversionData {

    private var openedEditor: Editor? = null
    private var originalText: String? = null
    private var convertedText: String? = null
    private var operation: Operation? = null
    private var errorMessage: ResourceKey? = null

    constructor(openedEditor: Editor?, originalText: String?, convertedText: String?, operation: Operation?) {
        this.openedEditor = openedEditor
        this.originalText = originalText
        this.convertedText = convertedText
        this.operation = operation
    }

    fun getOriginalText(): String? {
        return originalText
    }

    fun getConvertedText(): String? {
        return convertedText
    }

    fun setConvertedText(convertedText: String?) {
        this.convertedText = convertedText
    }

    fun getOperation(): Operation? {
        return operation
    }

    fun getOpenedEditor(): Editor? {
        return openedEditor
    }

    fun setErrorMessage(errorMessage: ResourceKey?) {
        this.errorMessage = errorMessage
    }

    fun getErrorMessageForInvalidInput(): ResourceKey? {
        return errorMessage
    }

    fun isInvalidInput(): Boolean {
        return errorMessage != null
    }
}