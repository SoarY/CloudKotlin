package com.soarsy.cloud.constants

/**
 * NAME：YONG_
 * Created at: 2023/3/23 18
 * Describe:
 */
open class RouteConstants {
    /**
     * 未分类模块
     */
    open class Rule {
        companion object {
            const val MAIN_ACTIVITY = "/rule/main"
        }
    }

    /**
     * 音乐模块
     */
    open class Music {
        companion object {
            const val ARTICLE = "/androidplay/article"
        }
    }

    /**
     * 迪斯科模块
     */
    open class Discover {
        companion object {
            const val WELFARE_IMG = "/androidplay/welfareimg"
        }
    }
}