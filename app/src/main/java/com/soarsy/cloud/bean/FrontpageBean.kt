package com.soarsy.cloud.bean


import java.io.Serializable

class FrontpageBean : Serializable {
    private var result: ResultBannerBean? = null
    private var error_code = 0
    private var module: List<ModuleBean>? = null
    fun getResult(): ResultBannerBean? {
        return result
    }

    fun setResult(result: ResultBannerBean?) {
        this.result = result
    }

    fun getError_code(): Int {
        return error_code
    }

    fun setError_code(error_code: Int) {
        this.error_code = error_code
    }

    fun getModule(): List<ModuleBean>? {
        return module
    }

    fun setModule(module: List<ModuleBean>?) {
        this.module = module
    }

    class ResultBannerBean : Serializable {
        //        private Mix22Bean mix_22;
        //        private ShowListBean show_list;
        //        private EntryBean entry;
        //        private SceneBean scene;
        //        private Mix5Bean mix_5;
        //        private Mix1Bean mix_1;
        //        private RecsongBean recsong;
        //        private RadioBean radio;
        //        private NewSongBean new_song;
        //        private DiyBean diy;
        //        private Mod7Bean mod_7;
        //        private KingBean king;
        //        public Mix9Bean getMix_9() {
        //            return mix_9;
        //        }
        //        public void setMix_9(Mix9Bean mix_9) {
        //            this.mix_9 = mix_9;
        //        }
        //        private Mix9Bean mix_9;
        private var focus: FocusBean? = null
        fun setFocus(focus: FocusBean?) {
            this.focus = focus
        }

        //        public Mix22Bean getMix_22() {
        //            return mix_22;
        //        }
        //        public void setMix_22(Mix22Bean mix_22) {
        //            this.mix_22 = mix_22;
        //        }
        //        public ShowListBean getShow_list() {
        //            return show_list;
        //        }
        //        public void setShow_list(ShowListBean show_list) {
        //            this.show_list = show_list;
        //        }
        //        public EntryBean getEntry() {
        //            return entry;
        //        }
        //        public void setEntry(EntryBean entry) {
        //            this.entry = entry;
        //        }
        //        public SceneBean getScene() {
        //            return scene;
        //        }
        //        public void setScene(SceneBean scene) {
        //            this.scene = scene;
        //        }
        //        public Mix5Bean getMix_5() {
        //            return mix_5;
        //        }
        //        public void setMix_5(Mix5Bean mix_5) {
        //            this.mix_5 = mix_5;
        //        }
        //        public Mix1Bean getMix_1() {
        //            return mix_1;
        //        }
        //        public void setMix_1(Mix1Bean mix_1) {
        //            this.mix_1 = mix_1;
        //        }
        //        public RecsongBean getRecsong() {
        //            return recsong;
        //        }
        //        public void setRecsong(RecsongBean recsong) {
        //            this.recsong = recsong;
        //        }
        //        public RadioBean getRadio() {
        //            return radio;
        //        }
        //        public void setRadio(RadioBean radio) {
        //            this.radio = radio;
        //        }
        //        public NewSongBean getNew_song() {
        //            return new_song;
        //        }
        //        public void setNew_song(NewSongBean new_song) {
        //            this.new_song = new_song;
        //        }
        //        public DiyBean getDiy() {
        //            return diy;
        //        }
        //        public void setDiy(DiyBean diy) {
        //            this.diy = diy;
        //        }
        //        public Mod7Bean getMod_7() {
        //            return mod_7;
        //        }
        //        public void setMod_7(Mod7Bean mod_7) {
        //            this.mod_7 = mod_7;
        //        }
        //        public KingBean getKing() {
        //            return king;
        //        }
        //        public void setKing(KingBean king) {
        //            this.king = king;
        //        }
        class Mix9Bean {
            /**
             * error_code : 22000
             * result : [{"desc":"","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14881961592cabd31510b72889843bd232e71e6150.jpg","type_id":"http://y.baidu.com/tbang","type":4,"title":"T榜第一期年榜决选","tip_type":0,"author":""},{"desc":"","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148842760200a2d30ad296101a488dd781929454dc.jpg","type_id":"http://y.baidu.com/cms/topic/webapp/2017/xiaolaohu/index.html","type":4,"title":"独家专访\u201c小老虎\u201d","tip_type":0,"author":""},{"desc":"","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488178404cd220d60e2b0b2f98f66987f3c5ff44b.jpg","type_id":"354332843","type":0,"title":"悠悠古调，如约而至","tip_type":0,"author":""}]
             */
            var error_code = 0
            var result: List<ResultBean>? = null

            class ResultBean {
                /**
                 * desc :
                 * pic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_14881961592cabd31510b72889843bd232e71e6150.jpg
                 * type_id : http://y.baidu.com/tbang
                 * type : 4
                 * title : T榜第一期年榜决选
                 * tip_type : 0
                 * author :
                 */
                var desc: String? = null
                var pic: String? = null
                var type_id: String? = null
                var type = 0
                var title: String? = null
                var tip_type = 0
                var author: String? = null
            }
        }

        class FocusBean : Serializable {
            /**
             * error_code : 22000
             * result : [{"randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14885355757dfa7fd7ab2c300433d381dcdf4713c1.jpg","code":"325272266","mo_type":2,"type":2,"is_publish":"111111","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14885355757dfa7fd7ab2c300433d381dcdf4713c1.jpg","randpic_desc":"Green Light"},{"randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488520099caa081bb4eae93b92581475d9c14a8d7.jpg","code":"http://music.baidu.com/h5pc/spec_detail?id=172&columnid=88","mo_type":4,"type":6,"is_publish":"111111","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488520099caa081bb4eae93b92581475d9c14a8d7.jpg","randpic_desc":"华语乐坛的那些幕后大师们\u2014陈小霞（上）"},{"randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488508408be15e6a434fb4f847ae3f82f3a580fc6.jpg","code":"533370111","mo_type":2,"type":2,"is_publish":"111111","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488508408be15e6a434fb4f847ae3f82f3a580fc6.jpg","randpic_desc":"爱又爱"},{"randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14883513291b6d3c35953ee8a240d4d28f7e8a9635.jpg","code":"http://music.baidu.com/cms/webview/bigwig/xusong0229/index.html","mo_type":4,"type":6,"is_publish":"111111","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14883513291b6d3c35953ee8a240d4d28f7e8a9635.jpg","randpic_desc":"许嵩青年晚报演唱会"},{"randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14885265473476d3353b56fb91c17eb64283d67003.jpg","code":"http://music.baidu.com/cms/webview/bigwig/20170303/index.html","mo_type":4,"type":6,"is_publish":"111111","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14885265473476d3353b56fb91c17eb64283d67003.jpg","randpic_desc":"广告"}]
             */
            var error_code = 0
            var result: List<ResultBeanX>? = null

            class ResultBeanX : Serializable {
                var randpic: String? = null
                var code: String? = null
                var mo_type = 0
                var type = 0
                var is_publish: String? = null
                var randpic_iphone6: String? = null
                var randpic_desc: String? = null
            }
        }

        class Mix22Bean {
            var error_code = 0
            var result: List<ResultBeanXX>? = null

            class ResultBeanXX {
                /**
                 * desc : 赵雷
                 * pic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_14853039815a65d461e42ec25c11779195e835ddad.jpg
                 * type_id : 275347355
                 * type : 2
                 * title : 无法长大
                 * tip_type : 0
                 * author : 赵雷
                 */
                var desc: String? = null
                var pic: String? = null
                var type_id: String? = null
                var type = 0
                var title: String? = null
                var tip_type = 0
                var author: String? = null
            }
        }

        class ShowListBean {
            /**
             * error_code : 22000
             * result : [{"type":"learn","picture_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_73fd36cf0747dbe57d614e1bb9619941.jpg","picture":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_6dd2a7b10ce1ec57eeb6ab08e48f227d.jpg","web_url":"http://music.baidu.com/cms/webview/ktv_activity/20170220/index.html"},{"type":"learn","picture_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_016beec46a0dcd0e5f13b833fb48d561.jpg","picture":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_0c1de026bdcde37137344a5b92e73b92.jpg","web_url":"http://music.baidu.com/cms/webview/ktv_activity/20170120/index.html"},{"type":"learn","picture_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_2bc81ed7070a7db830a9c8309080d2f4.jpg","picture":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_2b983ddd40a431e1b66a6cb290f0a770.jpg","web_url":"http://music.baidu.com/cms/webview/ktv_activity/20170112/"}]
             */
            var error_code = 0
            var result: List<ResultBeanXXX>? = null

            class ResultBeanXXX {
                /**
                 * type : learn
                 * picture_iphone6 : http://business.cdn.qianqian.com/qianqian/pic/bos_client_73fd36cf0747dbe57d614e1bb9619941.jpg
                 * picture : http://business.cdn.qianqian.com/qianqian/pic/bos_client_6dd2a7b10ce1ec57eeb6ab08e48f227d.jpg
                 * web_url : http://music.baidu.com/cms/webview/ktv_activity/20170220/index.html
                 */
                var type: String? = null
                var picture_iphone6: String? = null
                var picture: String? = null
                var web_url: String? = null
            }
        }

        class EntryBean {
            /**
             * error_code : 22000
             * result : [{"day":"","title":"歌手","icon":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14639875926652ed7c4988517cab87526f15d8f359.jpg","jump":"2"},{"day":"","title":"歌曲分类","icon":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_146398764316d87d01865b91f90a598777b1569fdf.jpg","jump":"1"},{"day":"03","title":"今日推荐歌曲","icon":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1463987629793f4361391282bde14d9b19156cfac3.jpg","jump":"0"}]
             */
            var error_code = 0
            var result: List<ResultBeanXXXX>? = null

            class ResultBeanXXXX {
                /**
                 * day :
                 * title : 歌手
                 * icon : http://business.cdn.qianqian.com/qianqian/pic/bos_client_14639875926652ed7c4988517cab87526f15d8f359.jpg
                 * jump : 2
                 */
                var day: String? = null
                var title: String? = null
                var icon: String? = null
                var jump: String? = null
            }
        }

        class SceneBean {
            var result: ResultBeanXXXXX? = null
            var error_code = 0
            var config: List<ConfigBean>? = null

            class ResultBeanXXXXX {
                var action: List<ActionBean>? = null
                var emotion: List<EmotionBean>? = null
                var operation: List<OperationBean>? = null
                var other: List<OtherBean>? = null

                class ActionBean {
                    /**
                     * icon_ios : http://b.hiphotos.baidu.com/ting/pic/item/94cad1c8a786c917cd5a64c9cf3d70cf3ac757e0.jpg
                     * scene_name : 在路上
                     * bgpic_android :
                     * icon_android : http://c.hiphotos.baidu.com/ting/pic/item/b999a9014c086e06604a914805087bf40bd1cbd7.jpg
                     * scene_model : 2
                     * scene_desc :
                     * bgpic_ios :
                     * scene_id : 0
                     */
                    var icon_ios: String? = null
                    var scene_name: String? = null
                    var bgpic_android: String? = null
                    var icon_android: String? = null
                    var scene_model: String? = null
                    var scene_desc: String? = null
                    var bgpic_ios: String? = null
                    var scene_id: String? = null
                }

                class EmotionBean {
                    /**
                     * icon_ios : http://d.hiphotos.baidu.com/ting/pic/item/7acb0a46f21fbe094353e1e46d600c338744ad34.jpg
                     * scene_name : 轻松
                     * bgpic_android :
                     * icon_android : http://c.hiphotos.baidu.com/ting/pic/item/bf096b63f6246b609bc02d77ecf81a4c500fa2e3.jpg
                     * scene_model : 1
                     * scene_desc :
                     * bgpic_ios :
                     * scene_id : 40
                     */
                    var icon_ios: String? = null
                    var scene_name: String? = null
                    var bgpic_android: String? = null
                    var icon_android: String? = null
                    var scene_model: String? = null
                    var scene_desc: String? = null
                    var bgpic_ios: String? = null
                    var scene_id: String? = null
                }

                class OperationBean {
                    /**
                     * icon_ios : http://d.hiphotos.baidu.com/ting/pic/item/cb8065380cd79123bb1999f9ab345982b3b78045.jpg
                     * scene_name : 小清新
                     * bgpic_android :
                     * icon_android : http://a.hiphotos.baidu.com/ting/pic/item/80cb39dbb6fd526672003a16ac18972bd407368c.jpg
                     * scene_model : 1
                     * scene_desc :
                     * bgpic_ios :
                     * scene_id : 158
                     */
                    var icon_ios: String? = null
                    var scene_name: String? = null
                    var bgpic_android: String? = null
                    var icon_android: String? = null
                    var scene_model: String? = null
                    var scene_desc: String? = null
                    var bgpic_ios: String? = null
                    var scene_id: String? = null
                }

                class OtherBean {
                    /**
                     * icon_ios : http://d.hiphotos.baidu.com/ting/pic/item/377adab44aed2e7364d7a8dc8101a18b87d6fa00.jpg
                     * scene_name : 2000年代
                     * bgpic_android :
                     * icon_android : http://b.hiphotos.baidu.com/ting/pic/item/aa64034f78f0f736ec9dd4020d55b319ebc41355.jpg
                     * scene_model : 1
                     * scene_desc :
                     * bgpic_ios :
                     * scene_id : 71
                     */
                    var icon_ios: String? = null
                    var scene_name: String? = null
                    var bgpic_android: String? = null
                    var icon_android: String? = null
                    var scene_model: String? = null
                    var scene_desc: String? = null
                    var bgpic_ios: String? = null
                    var scene_id: String? = null
                }
            }

            class ConfigBean {
                /**
                 * color_other :
                 * play_color :
                 * scene_version : 0
                 * desc :
                 * end_time : 0
                 * start_time : 0
                 * scene_color :
                 * bgpic :
                 * bgpic_special :
                 * button_color :
                 */
                var color_other: String? = null
                var play_color: String? = null
                var scene_version = 0
                var desc: String? = null
                var end_time = 0
                var start_time = 0
                var scene_color: String? = null
                var bgpic: String? = null
                var bgpic_special: String? = null
                var button_color: String? = null
            }
        }

        class Mix5Bean {
            /**
             * error_code : 22000
             * result : [{"desc":"鹿晗","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148853469719a1a770aca1f7cafc306a883557c1d2.jpg","type_id":"325634880","type":5,"title":"敢（Roleplay）剧情版","tip_type":0,"author":"鹿晗"},{"desc":"By2","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14883436621dfb3d7d50d4bd38ff075fd5a3a7084d.jpg","type_id":"320364534","type":5,"title":"爱又爱","tip_type":0,"author":"By2"},{"desc":"卢庚戌","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14882693261f3a64ce0a9d86ee13258ff9926e1d30.jpg","type_id":"318357363","type":5,"title":"我们生来就是孤独","tip_type":0,"author":"卢庚戌"},{"desc":"厉娜","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488262643b590490d2ed840c6fed7748d7f615dcf.jpg","type_id":"318221649","type":5,"title":"可疑","tip_type":0,"author":"厉娜"},{"desc":"洛天依","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488261926f7620cc888a21be2f392961ea6f45248.jpg","type_id":"318040376","type":5,"title":"V家萌妹","tip_type":0,"author":"洛天依"},{"desc":"John Legend","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488176748f56c6f1627b5d4541a92da746e7eb8da.jpg","type_id":"316315228","type":5,"title":"电影《爱乐之城》原声串烧 第89届奥斯卡颁奖现场版","tip_type":0,"author":"John Legend"}]
             */
            var error_code = 0
            var result: List<ResultBeanXXXXXX>? = null

            class ResultBeanXXXXXX {
                /**
                 * desc : 鹿晗
                 * pic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_148853469719a1a770aca1f7cafc306a883557c1d2.jpg
                 * type_id : 325634880
                 * type : 5
                 * title : 敢（Roleplay）剧情版
                 * tip_type : 0
                 * author : 鹿晗
                 */
                var desc: String? = null
                var pic: String? = null
                var type_id: String? = null
                var type = 0
                var title: String? = null
                var tip_type = 0
                var author: String? = null
            }
        }

        class Mix1Bean {
            /**
             * error_code : 22000
             * result : [{"desc":"Lorde","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488527156473977b29c7249520a7f196ff8c7a595.jpg","type_id":"325272266","type":2,"title":"Green Light","tip_type":0,"author":"Lorde"},{"desc":"Alan Walker","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148851786790d9a3fcffb5f7602f394a016daf8fbe.jpg","type_id":"536788372","type":2,"title":"Alone (Remixes)","tip_type":0,"author":"Alan Walker"},{"desc":"By2","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148850856365e5894d1b6cf90f7b9c657aa442f0da.jpg","type_id":"533370111","type":2,"title":"爱又爱","tip_type":3,"author":"By2"},{"desc":"刘力扬","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148850658951eed7991aebf73b57c7d829d042fbcb.jpg","type_id":"535079548","type":2,"title":"Warriors (战士)","tip_type":0,"author":"刘力扬"},{"desc":"代岳东","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14885065515211b263ae7186018270c886d0ee6c46.jpg","type_id":"536041177","type":2,"title":"单身日记","tip_type":0,"author":"代岳东"},{"desc":"齐硕","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488452900ddfbc9d3d8fddc4360d694e8b6345d17.jpg","type_id":"533367288","type":2,"title":"我的室友是狐仙之青春未央 网剧原声带","tip_type":0,"author":"齐硕"}]
             */
            var error_code = 0
            var result: List<ResultBeanXXXXXXX>? = null

            class ResultBeanXXXXXXX {
                /**
                 * desc : Lorde
                 * pic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488527156473977b29c7249520a7f196ff8c7a595.jpg
                 * type_id : 325272266
                 * type : 2
                 * title : Green Light
                 * tip_type : 0
                 * author : Lorde
                 */
                var desc: String? = null
                var pic: String? = null
                var type_id: String? = null
                var type = 0
                var title: String? = null
                var tip_type = 0
                var author: String? = null
            }
        }

        class RecsongBean {
            var error_code = 0
            var result: List<ResultBeanXXXXXXXX>? = null

            class ResultBeanXXXXXXXX {
                /**
                 * resource_type_ext : 0
                 * learn : 0
                 * del_status : 0
                 * korean_bb_song : 0
                 * versions :
                 * title : 亲爱的 你在哪里
                 * bitrate_fee : {"0":"0|0","1":"0|0"}
                 * song_id : 130259272
                 * has_mv_mobile : 0
                 * pic_premium : http://musicdata.baidu.com/data2/pic/130255668/130255668.jpg@s_0,w_500
                 * author : 龙飞,门丽
                 */
                var resource_type_ext: String? = null
                var learn: String? = null
                var del_status: String? = null
                var korean_bb_song: String? = null
                var versions: String? = null
                var title: String? = null
                var bitrate_fee: String? = null
                var song_id: String? = null
                var has_mv_mobile: String? = null
                var pic_premium: String? = null
                var author: String? = null
            }
        }

        class RadioBean {
            /**
             * error_code : 22000
             * result : [{"desc":"都市情感","itemid":"13429922","title":"《当我知道你们相爱》：每一场青春注定散场（主播：辰熙澤）","album_id":"12545344","type":"lebo","channelid":"11373553","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_5cdb36efab04981e957bfb61680403af.jpg"},{"desc":"综艺娱乐","itemid":"13428897","title":"Vol.199 \u201c正确\u201d的第89届奥斯卡","album_id":"1088420","type":"lebo","channelid":"11373550","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_ab1a9e18c265459120a96a432be22ad8.jpg"},{"desc":"都市情感","itemid":"13429504","title":"【墨色声弦】一曲旧梦终难醒-NJ胤烟","album_id":"5568804","type":"lebo","channelid":"11373553","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_6cbdc41eaf9e819019b4f464fda8e6aa.jpg"},{"desc":"都市情感","itemid":"13426131","title":"《一个像夏天一个像秋天》 ：\u201c女\u201d朋友（主播：金心人）","album_id":"12545344","type":"lebo","channelid":"11373553","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_27c43d1341a905e52165736be08994d2.jpg"},{"desc":"脱口秀","itemid":"13425511","title":"三好学堂 \u2013 紫微斗数贴身教学","album_id":"1168147","type":"lebo","channelid":"11373548","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_235b9aed64dc5826f862d5877a1c2e54.jpg"},{"desc":"笑话段子","itemid":"13426916","title":"人可以穷到什么地步？","album_id":"11448439","type":"lebo","channelid":"11373547","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_62cdc9aa6457202323cbec73fcc2ec00.jpg"}]
             */
            var error_code = 0
            var result: List<ResultBeanXXXXXXXXX>? = null

            class ResultBeanXXXXXXXXX {
                /**
                 * desc : 都市情感
                 * itemid : 13429922
                 * title : 《当我知道你们相爱》：每一场青春注定散场（主播：辰熙澤）
                 * album_id : 12545344
                 * type : lebo
                 * channelid : 11373553
                 * pic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_5cdb36efab04981e957bfb61680403af.jpg
                 */
                var desc: String? = null
                var itemid: String? = null
                var title: String? = null
                var album_id: String? = null
                var type: String? = null
                var channelid: String? = null
                var pic: String? = null
            }
        }

        class NewSongBean {
            /**
             * error_code : 22000
             * result : {"pic_500":"http://b.hiphotos.baidu.com/ting/pic/item/a50f4bfbfbedab64bcae572ef136afc378311e7b.jpg","listid":"5126","song_info":[{"song_id":"261812117","title":"二十四小时","pic_premium":"http://qukufile2.qianqian.com/data2/pic/261811991/261811991.jpg@s_0,w_500","author":"陈坤,韩庚,大鹏,吴磊,尹正"},{"song_id":"74109283","title":"灵主不悔《画江湖之灵主》手游暨动漫主题曲","author":"汪苏泷"},{"song_id":"261496612","title":"Protocole","pic_premium":"http://qukufile2.qianqian.com/data2/pic/07a830e962bbb4e58e29842f45d44b66/261496583/261496583.jpg@s_0,w_500","author":"Alpha Wann"}]}
             */
            var error_code = 0
            var result: ResultBeanXXXXXXXXXX? = null

            class ResultBeanXXXXXXXXXX {
                /**
                 * pic_500 : http://b.hiphotos.baidu.com/ting/pic/item/a50f4bfbfbedab64bcae572ef136afc378311e7b.jpg
                 * listid : 5126
                 * song_info : [{"song_id":"261812117","title":"二十四小时","pic_premium":"http://qukufile2.qianqian.com/data2/pic/261811991/261811991.jpg@s_0,w_500","author":"陈坤,韩庚,大鹏,吴磊,尹正"},{"song_id":"74109283","title":"灵主不悔《画江湖之灵主》手游暨动漫主题曲","author":"汪苏泷"},{"song_id":"261496612","title":"Protocole","pic_premium":"http://qukufile2.qianqian.com/data2/pic/07a830e962bbb4e58e29842f45d44b66/261496583/261496583.jpg@s_0,w_500","author":"Alpha Wann"}]
                 */
                var pic_500: String? = null
                var listid: String? = null
                var song_info: List<SongInfoBean>? = null

                class SongInfoBean {
                    /**
                     * song_id : 261812117
                     * title : 二十四小时
                     * pic_premium : http://qukufile2.qianqian.com/data2/pic/261811991/261811991.jpg@s_0,w_500
                     * author : 陈坤,韩庚,大鹏,吴磊,尹正
                     */
                    var song_id: String? = null
                    var title: String? = null
                    var pic_premium: String? = null
                    var author: String? = null
                }
            }
        }

        class DiyBean {
            /**
             * error_code : 22000
             * result : [{"position":1,"tag":"华语,流行,伤感","songidlist":[],"pic":"http://musicugc.cdn.qianqian.com/ugcdiy/pic/066e1da7df36504586d539fe6019c661.jpg","title":"【环球之音】直戳泪点的伤感情歌","collectnum":34,"type":"gedan","listenum":14259,"listid":"365146546"},{"position":2,"tag":"日语,流行,美好","songidlist":[],"pic":"http://musicugc.cdn.qianqian.com/ugcdiy/pic/2552050c1c219484b76fd7b234fd663d.jpg","title":"日系温柔，触到心底的旋律","collectnum":20,"type":"gedan","listenum":1893,"listid":"365141303"},{"position":3,"tag":"粤语,流行,午后","songidlist":[],"pic":"http://musicugc.cdn.qianqian.com/ugcdiy/pic/9d4333977c8b92c9a43d5915f09ff89c.jpg","title":"因为一个人，而听懂一首歌","collectnum":9,"type":"gedan","listenum":3847,"listid":"365143172"},{"position":4,"tag":"欧美,怀旧,经典","songidlist":[],"pic":"http://musicugc.cdn.qianqian.com/ugcdiy/pic/bb17e3faa9fc5c0eb477ce28a035a0d6.jpg","title":"【环球之音】Island岛屿音乐时光","collectnum":91,"type":"gedan","listenum":20658,"listid":"364522605"},{"position":5,"tag":"雷鬼,放松","songidlist":[],"pic":"http://musicugc.cdn.qianqian.com/ugcdiy/pic/da07dcec3fc463bcdbc118595bfb08c4.jpg","title":"听雷鬼，一起啦啦啦","collectnum":4,"type":"gedan","listenum":816,"listid":"365142492"},{"position":6,"tag":"华语,流行,安静","songidlist":[],"pic":"http://musicugc.cdn.qianqian.com/ugcdiy/pic/bf19b6c2d7d04606961d2eb4738d6db1.jpg","title":"华语 · 滚滚红尘，似水柔情","collectnum":62,"type":"gedan","listenum":28499,"listid":"364085981"}]
             */
            var error_code = 0
            var result: List<ResultBeanXXXXXXXXXXX>? = null

            class ResultBeanXXXXXXXXXXX {
                /**
                 * position : 1
                 * tag : 华语,流行,伤感
                 * songidlist : []
                 * pic : http://musicugc.cdn.qianqian.com/ugcdiy/pic/066e1da7df36504586d539fe6019c661.jpg
                 * title : 【环球之音】直戳泪点的伤感情歌
                 * collectnum : 34
                 * type : gedan
                 * listenum : 14259
                 * listid : 365146546
                 */
                var position = 0
                var tag: String? = null
                var pic: String? = null
                var title: String? = null
                var collectnum = 0
                var type: String? = null
                var listenum = 0
                var listid: String? = null
                var songidlist: List<*>? = null
            }
        }

        class Mod7Bean {
            var error_code = 0
            var result: List<ResultBeanXXXXXXXXXXXX>? = null

            class ResultBeanXXXXXXXXXXXX {
                /**
                 * desc : 百度音乐独家DJ节目《在云端》 | 第九期
                 * pic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_14885249276512a8d0ff6dfde93028aabd41642c83.jpg
                 * type_id : http://music.baidu.com/h5pc/spec_detail?id=172&columnid=88
                 * type : 4
                 * title : 华语歌坛幕后的大师们之作曲人陈小霞
                 * tip_type : 0
                 * author :
                 */
                var desc: String? = null
                var pic: String? = null
                var type_id: String? = null
                var type = 0
                var title: String? = null
                var tip_type = 0
                var author: String? = null
            }
        }

        class KingBean {
            /**
             * error_code : 22000
             * result : [{"pic_big":"http://musicdata.baidu.com/data2/pic/c1575cf222e45e809bcd2cd9edc7ac4b/533531419/533531419.jpg@s_0,w_150","title":"可疑","author":"厉娜"},{"pic_big":"http://musicdata.baidu.com/data2/pic/6f0360642b613a192e2e9b459ab76341/533553518/533553518.jpg@s_0,w_150","title":"恋をする (恋爱)","author":"中岛美嘉"},{"pic_big":"http://musicdata.baidu.com/data2/pic/dee57a075da12ee283c6e9ba9dbf9b66/531451362/531451362.jpg@s_0,w_150","title":" Goodbye","author":"2NE1"}]
             */
            var error_code = 0
            var result: List<ResultBeanXXXXXXXXXXXXX>? = null

            class ResultBeanXXXXXXXXXXXXX {
                /**
                 * pic_big : http://musicdata.baidu.com/data2/pic/c1575cf222e45e809bcd2cd9edc7ac4b/533531419/533531419.jpg@s_0,w_150
                 * title : 可疑
                 * author : 厉娜
                 */
                var pic_big: String? = null
                var title: String? = null
                var author: String? = null
            }
        }
    }

    class ModuleBean {
        /**
         * link_url :
         * pos : 1
         * title : 焦点图
         * key : focus
         * picurl :
         * title_more :
         * style : 1
         * jump :
         */
        private var link_url: String? = null
        private var pos = 0
        private var title: String? = null
        private var key: String? = null
        private var picurl: String? = null
        private var title_more: String? = null
        private var style = 0
        private var jump: String? = null
        fun getLink_url(): String? {
            return link_url
        }

        fun setLink_url(link_url: String?) {
            this.link_url = link_url
        }

        fun getPos(): Int {
            return pos
        }

        fun setPos(pos: Int) {
            this.pos = pos
        }

        fun getTitle(): String? {
            return title
        }

        fun setTitle(title: String?) {
            this.title = title
        }

        fun getKey(): String? {
            return key
        }

        fun setKey(key: String?) {
            this.key = key
        }

        fun getPicurl(): String? {
            return picurl
        }

        fun setPicurl(picurl: String?) {
            this.picurl = picurl
        }

        fun getTitle_more(): String? {
            return title_more
        }

        fun setTitle_more(title_more: String?) {
            this.title_more = title_more
        }

        fun getStyle(): Int {
            return style
        }

        fun setStyle(style: Int) {
            this.style = style
        }

        fun getJump(): String? {
            return jump
        }

        fun setJump(jump: String?) {
            this.jump = jump
        }
    }
}