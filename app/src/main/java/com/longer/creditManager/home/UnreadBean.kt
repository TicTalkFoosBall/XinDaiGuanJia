package com.longer.creditManager.home

/**
@Author  :rickBei
@Date    :2019/10/24 19:07
@Descripe: From bug to bugs
 **/

data class UnreadBean(
    val notices: Notices,
    val systemMsgs: SystemMsgs,
    val tasks: Tasks
)

data class Notices(
    val createTime: String,
    val title: String,
    val unReadNo: String
)

data class Tasks(
    val createTime: Long,
    val title: String,
    val unReadNo: String
)

data class SystemMsgs(
    val createTime: Long,
    val title: String,
    val unReadNo: String
)