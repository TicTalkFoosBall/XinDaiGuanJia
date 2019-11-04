package hxz.www.commonbase.model


data class PopModel(val imgRes: Int, val text: String, val imgUrl:String="",val extend:String="",val type: Int=0, var showUnReadStat: Boolean = false) {
    constructor(text: String,imgUrl:String="", extend:String="") : this(0, text,imgUrl=imgUrl,extend=extend)
}