package com.mayakoba.appxone.kotlin_01.data.service

import com.mayakoba.appxone.kotlin_01.data.service.response.AuthResponse
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("login")
    //Suspend*
    //Suspending function are the center of whole coroutines
    //A Suspending is a simple function that can be pause or resume at later time
    //this type of function can execute long running operations and wait for it to comoplete without blocking
   suspend fun userLogin(
        @Field ("email") email:String,
        @Field("password") password:String
    ) : Response<AuthResponse>

    companion object{
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : Api{

            val okHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpclient)
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)

        }
    }
}