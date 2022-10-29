package sk.mysko.stp.gui.action

interface ActionsRequestListener {

    fun transformationRequested() : Unit;
    fun exitRequested() : Unit;
}