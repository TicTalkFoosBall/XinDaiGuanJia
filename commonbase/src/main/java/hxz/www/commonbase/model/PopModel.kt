package hxz.www.commonbase.model


data class PopModel(val imgRes: Int, val text: Int, val type: Int, var showUnReadStat: Boolean = false) {
    constructor(text: Int, type: Int) : this(0, text, type)
}