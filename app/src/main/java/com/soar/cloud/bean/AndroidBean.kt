package com.soar.cloud.bean

import java.io.Serializable

/**
 * NAME：YONG_
 * Created at: 2023/3/29 16
 * Describe:
 */
class AndroidBean : Serializable {
    // 存储单独设置的值，用来显示title
    var type_title: String? = null

    // 随机图URL
    var image_url: String? = null
    var _id: String? = null
    var createdAt: String? = null
    var desc: String? = null
    var publishedAt: String? = null
    var type: String? = null
    var url: String? = null
    var isUsed = false
    var who: String? = null
    var source: String? = null
    var images: List<String>? = null
}