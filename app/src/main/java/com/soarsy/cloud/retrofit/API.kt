package com.soarsy.cloud.retrofit


import com.soarsy.cloud.bean.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * YONG_
 */
interface API {
    //---------------------------------GankIo-API---------------------------------//
    /**
     * 每日推荐
     * eg:http://gank.io/api/day/2015/08/06
     */
    @GET("day/{year}/{month}/{day}")
    fun getGankIoDay(
        @Path("year") year: String?,
        @Path("month") month: String?,
        @Path("day") day: String?
    ): Observable<GankIoDayBean>

    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * 请求个数： 数字，大于0
     * 第几页：数字，大于0
     * eg: http://gank.io/api/data/Android/10/1
     * // 分类api
     * https://gank.io/api/v2/categories/<category_type>
     * https://gank.io/api/v2/categories/Article
     * // 分类数据api
     * https://gank.io/api/v2/data/category/<category>/type/<type>/page/<page>/count/<count>
     * // 旧：@GET("data/{type}/{pre_page}/{page}")
     */
    @GET("v2/data/category/{category}/type/{type}/page/{page}/count/{count}")
    fun getGankIoData(
        @Path("category") category: String?,
        @Path("type") type: String?,
        @Path("page") page: Int,
        @Path("count") count: Int
    ): Observable<GankIoDataBean>
    //---------------------------------PlayAndroid-API---------------------------------//

    //---------------------------------PlayAndroid-API---------------------------------//
    /**
     * 玩安卓轮播图
     */
    @GET("banner/json")
    fun getAndroidPlayBanner(): Observable<BaseResultBean<List<AndroidPlayBannerBean>>>

    /**
     * 玩安卓，文章列表、知识体系下的文章
     *
     * @param page 页码，从0开始
     * @param cid  体系id
     */
    @GET("article/list/{page}/json")
    fun getHomeList(
        @Path("page") page: Int,
        @Query("cid") cid: Int?
    ): Observable<BaseResultBean<DataBean>>

    /**
     * 导航数据
     */
    @GET("navi/json")
    fun getNaviJson(): Observable<BaseResultBean<List<NaviBean>>>


    //---------------------------------DOUBAN-API---------------------------------//

    //---------------------------------DOUBAN-API---------------------------------//
    /**
     * 豆瓣热映电影，每日更新
     */
    @GET("v2/movie/in_theaters")
    fun getHotMovie(): Observable<HotMovieBean>
}