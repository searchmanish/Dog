package com.softcodeinfotech.dog.model

import io.reactivex.Single
import retrofit2.http.GET

interface DogsApi {

    //https://raw.githubusercontent.com/DevTides/DogsApi/master/dogs.json
    @GET("DevTides/DogsApi/master/dogs.json")
    fun getDogs(): Single<List<DogBreed>>
}