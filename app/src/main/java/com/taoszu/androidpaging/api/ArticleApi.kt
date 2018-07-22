package com.taoszu.androidpaging.api

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by 阿涛 on 2018/7/22.
 */
interface ArticleApi {
    @GET("/r/androiddev/hot.json")
    fun getAfter(
            @Query("after") after: String,
            @Query("limit") limit: Int = 20): Call<JSONObject>

    companion object {
        private const val BASE_URL = "https://www.reddit.com/"
        fun create(): ArticleApi = create(HttpUrl.parse(BASE_URL)!!)
        fun create(httpUrl: HttpUrl): ArticleApi {
            val client = OkHttpClient.Builder()
                    .build()
            return Retrofit.Builder()
                    .baseUrl(httpUrl)
                    .client(client)
                    .build()
                    .create(ArticleApi::class.java)
        }
    }

}