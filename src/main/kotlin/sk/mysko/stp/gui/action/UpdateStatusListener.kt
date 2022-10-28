package sk.mysko.stp.gui.action

import sk.mysko.stp.i18n.ResourceKey

interface UpdateStatusListener {
    fun updateStatus(status: ResourceKey)
    fun updateErrorStatus(status: ResourceKey)
}