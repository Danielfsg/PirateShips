package com.danielfsg.pirateships.data.remote

import com.danielfsg.pirateships.data.model.PirateShips
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("pirateships")
    fun getPirateShips(): Single<PirateShips>
}