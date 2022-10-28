package sk.mysko.stp.i18n

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.util.IconLoader
import sk.mysko.stp.exception.STPException
import java.io.IOException
import java.util.PropertyResourceBundle
import javax.swing.Icon

class Resource {
    private val logger = Logger.getInstance(javaClass)
    private val RESOURCE_PATH = "/ui.properties"

    private var resourceBundle = try {
        PropertyResourceBundle(this.javaClass.getResourceAsStream(RESOURCE_PATH))
    } catch (e: IOException) {
        logger.error("Cannot load resource $RESOURCE_PATH", e)
        throw STPException ("Cannot load resource $RESOURCE_PATH", e)
    }


    fun getText(resourceKey: ResourceKey): String {
        var text: String
        if (resourceBundle.containsKey(resourceKey.getResourceKey())) {
            text = resourceBundle.getString(resourceKey.getResourceKey())
            for (param in resourceKey.getParameterNames()) {
                text = text.replace("\\$$param".toRegex(), resourceKey.getParameterValueFor(param))
            }
        } else {
            logger.error("Cannot find resource with key:" + resourceKey.getResourceKey())
            text = "???" + resourceKey.getResourceKey() + "???"
        }
        return text
    }

    fun getIcon(resourceKey: ResourceKey): Icon? {
        var ret: Icon? = null
        val key: String = resourceKey.getResourceKey() + ".icon"
        if (resourceBundle.containsKey(key)) {
            val iconPath = resourceBundle.getString(key)
            ret = IconLoader.getIcon(iconPath, javaClass)
        }
        return ret
    }

    fun getMnemonic(resourceKey: ResourceKey): Char? {
        var ret: Char? = null
        val key: String = resourceKey.getResourceKey() + ".mnemonic"
        if (resourceBundle.containsKey(key)) {
            val mnemonicStr = resourceBundle.getString(key)
            if (mnemonicStr.isNotEmpty()) {
                ret = mnemonicStr[0]
            }
        }
        return ret
    }
}