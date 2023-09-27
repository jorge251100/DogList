package com.example.doglist

import com.google.gson.annotations.SerializedName

data class DogsResponse (
    @SerializedName("status") var status:String,
    @SerializedName("message") var images:List<String>)

//Las clases de datos en Kotlin son utilizadas comúnmente para representar estructuras de datos simples, como respuestas de API

//define una propiedad llamada status en la clase DogsResponse y utiliza la anotación @SerializedName("status") para indicar que el campo JSON llamado "status" se mapeará a esta propiedad.

//la clase DogsResponse se utiliza para representar la respuesta de una API que proporciona información sobre imágenes de perros.
// Tiene dos propiedades: status, que es una cadena que representa el estado de la respuesta, y images, que es una lista de cadenas
// que contiene las URL de las imágenes de perros.