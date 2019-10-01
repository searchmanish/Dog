package com.softcodeinfotech.dog.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.softcodeinfotech.dog.model.DogBreed

class DetailViewModel : ViewModel() {
    val dogLiveData =MutableLiveData<DogBreed>()

    fun fetch()
    {
        val dog1 = DogBreed("1","Labradog","15","breedGroup","bredFor","temperament","null")
        dogLiveData.value = dog1
    }
}