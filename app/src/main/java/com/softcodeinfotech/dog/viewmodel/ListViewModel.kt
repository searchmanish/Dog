package com.softcodeinfotech.dog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.softcodeinfotech.dog.model.DogBreed

class ListViewModel : ViewModel() {
    val dogs = MutableLiveData<List<DogBreed>>()
    val dogsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        val dog1 = DogBreed("1","Labradog","15","breedGroup","bredFor","temperament","null")
        val dog2 = DogBreed("2","cat","15","breedGroup","bredFor","temperament","null")
        val dog3 = DogBreed("3","Suparco","15","breedGroup","bredFor","temperament","null")

        val dogList = arrayListOf<DogBreed>(dog1,dog2,dog3)
        dogs.value = dogList
        dogsLoadError.value = false
        loading.value = false


    }
}