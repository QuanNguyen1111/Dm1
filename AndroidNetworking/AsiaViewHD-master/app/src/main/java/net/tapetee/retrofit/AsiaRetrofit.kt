package net.tapetee.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AsiaRetrofit {

    companion object {
        fun create(): AsiaService {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl("http://asian.dotplays.com")
                .build()


            return retrofit.create(AsiaService::class.java)
        }
    }

}