package sk.mysko.stp.gui.action

sealed interface ActionsRequestListener {

    fun transformationRequested() : Unit;
    fun exitRequested() : Unit;
}