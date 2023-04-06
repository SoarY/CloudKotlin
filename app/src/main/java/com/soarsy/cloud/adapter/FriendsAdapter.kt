package com.soarsy.cloud.adapter

import android.graphics.Color
import com.soarsy.cloud.BR
import com.soarsy.cloud.MyApplication
import com.soarsy.cloud.R
import com.soarsy.cloud.base.BaseAdapter
import com.soarsy.cloud.bean.PersonBean
import com.soarsy.cloud.bean.SubjectsBean
import com.soarsy.cloud.databinding.ItemFriendsBinding
import java.util.*

/**
 * NAME：YONG_
 * Created at: 2023/4/6 14
 * Describe:
 */
class FriendsAdapter :BaseAdapter<SubjectsBean,ItemFriendsBinding>(){
    override fun initLayoutId(): Int {
        return R.layout.item_friends
    }

    override fun onBindView(holder: RecyclerHolder<ItemFriendsBinding>?, t: SubjectsBean?, position: Int) {
        holder!!.binding.setVariable(BR.item,t)
    }

    companion object{
        /**
         * 格式化导演、主演名字
         */
        @JvmStatic
        fun formatName(casts: List<PersonBean>?): StringBuilder? {
            val stringBuilder = StringBuilder()
            if (casts == null || casts.size == 0)
                return stringBuilder.append(MyApplication.context.getString(R.string.movie_nameless))
            for (i in casts.indices) stringBuilder.append(casts[i].name)
                .append(if (i < casts.size - 1) " / " else "")
            return stringBuilder
        }

        /**
         * 格式化电影类型
         */
        @JvmStatic
        fun formatGenres(genres: List<String?>?): StringBuilder? {
            val stringBuilder = StringBuilder()
            if (genres == null || genres.size == 0) return stringBuilder.append(
                MyApplication.context.getString(R.string.movie_nameless_type)
            )
            for (i in genres.indices) stringBuilder.append(genres[i])
                .append(if (i < genres.size - 1) " / " else "")
            return stringBuilder
        }

        /**
         * 随机颜色
         */
        @JvmStatic
        fun randomColor(): Int {
            val random = Random()
            val red = random.nextInt(150) + 50 //50-199
            val green = random.nextInt(150) + 50 //50-199
            val blue = random.nextInt(150) + 50 //50-199
            return Color.rgb(red, green, blue)
        }
    }

}