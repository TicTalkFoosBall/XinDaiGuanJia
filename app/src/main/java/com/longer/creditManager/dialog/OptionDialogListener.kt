package com.longer.creditManager.dialog

/**
@Author  :rickBei
@Date    :2019/10/26 16:34
@Descripe: From bug to bugs
 **/
interface OptionDialogListener {
    fun onResultChoose()

    fun onCommit(content: String)
}