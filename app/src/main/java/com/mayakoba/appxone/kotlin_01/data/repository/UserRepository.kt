package com.mayakoba.appxone.kotlin_01.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mayakoba.appxone.kotlin_01.data.service.Api
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun userLogin(email:String , password:String ):LiveData<String>{

        val loginresponse = MutableLiveData<String>()
        Api().userLogin(email ,password)
            .enqueue(object:Callback<ResponseBody>{
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginresponse.value = t.message
                }

                override fun onResponse( call: Call<ResponseBody>, response: Response<ResponseBody>){
                    if(response.isSuccessful){
                        loginresponse.value = response.body()?.string()
                    }
                    else{
                        loginresponse.value = response.errorBody()?.string()

                    }
                }

            })
        return loginresponse
    }

}