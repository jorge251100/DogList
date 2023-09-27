package com.example.doglist

import retrofit2.Response     //importan las clases necesarias para la implementacion de una interfaz de Retrofit
import retrofit2.http.GET     //Response es una clase de Retrofit que representa la respuesta de una llamada de red.
import retrofit2.http.Url      //GET es una anotación que se utiliza para marcar un método como una solicitud HTTP GET,
                                // y @Url se utiliza para especificar una URL dinámica en la solicitud.

interface APIService {
    @GET
    suspend fun getDogsByBreeds(@Url url:String):Response<DogsResponse>  //Esta línea define un método llamado getDogsByBreeds que se utilizará para realizar una solicitud GET a una URL específica.
    //suspend indica que este método debe ser llamado desde una función suspend, lo que significa que puede ser llamado de manera asíncrona y suspender la ejecución hasta que la respuesta esté disponible.
}