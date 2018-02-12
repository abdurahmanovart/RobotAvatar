package com.github.arturx.robotavatar.net

import com.github.arturx.robotavatar.bean.BaseResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by arturx on 12.02.18.
 */

public interface RoboService {

    @Headers("X-Mashape-Key:qBLgR5DDcTmshcuSAbLXg6ZGSOWap1hCTM4jsnk2febJ2dJDR4",
            "X-Mashape-Host:robohash.p.mashape.com")
    @GET("index.php")
    fun getAvatar(@Query("text") text: String)
            : Observable<BaseResponse>

    companion object {
        fun create(): RoboService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(JacksonConverterFactory.create())
                    .baseUrl("https://robohash.p.mashape.com/")
                    .build()
            return retrofit.create(RoboService::class.java)
        }
    }
}
