package com.soar.cloud.bean


/**
 * Created by jingbin on 2016/11/25.
 */
class PersonBean {
    /**
     * alt : https://movie.douban.com/celebrity/1050059/
     * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/1691.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1691.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1691.jpg"}
     * name : 范冰冰  or
     * name : 冯小刚
     * id : 1050059
     * type: 导演 或 演员
     */
    var alt: String? = null

    // 导演或演员
    var type: String? = null
    var avatars: ImagesBean? = null
    var name: String? = null
    var id: String? = null
}