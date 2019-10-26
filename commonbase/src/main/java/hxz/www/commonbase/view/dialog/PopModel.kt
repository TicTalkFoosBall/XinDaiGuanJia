package hxz.www.commonbase.view.dialog

data class PopModel(val imgRes: Int=0, val text: Int, val type: Int=0, var showUnReadStat: Boolean = false) {
    constructor(text: Int, type: Int) : this(0, text, type)
}