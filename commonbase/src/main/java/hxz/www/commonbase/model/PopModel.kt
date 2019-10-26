package hxz.www.commonbase.model


data class PopModel(val imgRes: Int, val text: String, val type: Int=0, var showUnReadStat: Boolean = false) {
    constructor(text: String) : this(0, text)
}