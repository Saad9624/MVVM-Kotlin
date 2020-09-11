package com.mayakoba.appxone.kotlin_01.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mayakoba.appxone.kotlin_01.data.db.AppDatabase
import com.mayakoba.appxone.kotlin_01.data.db.entities.User
import com.mayakoba.appxone.kotlin_01.data.service.Api
import com.mayakoba.appxone.kotlin_01.data.service.ApiRequest
import com.mayakoba.appxone.kotlin_01.data.service.response.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(
    private val api:Api,
    private val db : AppDatabase
) :ApiRequest() {

        //suspend function can only be call by another suspend function or from coroutinie scope
        //because here Api().userLogin() function is suspend function
     suspend fun userLogin(email:String , password:String ): AuthResponse{
        return apiRequest {
            api.userLogin(email,password)
        }



    }

    suspend fun saveUser(user:User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()

//    fun userLogin(email:String , password:String ): LiveData<String>{
//
//        val loginresponse = MutableLiveData<String>()
//        Api().userLogin(email ,password)
//            .enqueue(object:Callback<ResponseBody>{
//                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                    loginresponse.value = t.message
//                }
//
//                override fun onResponse( call: Call<ResponseBody>, response: Response<ResponseBody>){
//                    if(response.isSuccessful){
//                        loginresponse.value = response.body()?.string()
//                    }
//                    else{
//                        loginresponse.value = response.errorBody()?.string()
//
//                    }
//                }
//
//            })
//        return loginresponse
//    }

}