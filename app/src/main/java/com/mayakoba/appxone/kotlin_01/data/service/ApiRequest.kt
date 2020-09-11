package com.mayakoba.appxone.kotlin_01.data.service

import com.mayakoba.appxone.kotlin_01.utils.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class ApiRequest {

    //for Aysnc task we use Suspend
    suspend fun<T:Any> apiRequest(call: suspend() -> Response<T>) : T {
        val response = call.invoke()

        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val error = response.errorBody()?.string()
            val message = StringBuilder()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                } catch (e: JSONException) {   }
                message.append("\n")
            }
                message.append("Error CODE : ${response.code()}")
                throw ApiException(message.toString())

            }

    }
}