package com.example.doglist

import android.media.Image
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.doglist.databinding.ItemDogBinding
import com.squareup.picasso.Picasso
//RecyclerView.ViewHolder se importa para heredar su funcionalidad básica, Picasso se importa para cargar y mostrar imágenes
// en una vista, y ItemDogBinding se importa para enlazar los elementos de la vista del elemento de la lista.

class DogViewHolder(view: View):RecyclerView.ViewHolder(view) {

    //define la clase DogViewHolder, que es una subclase de RecyclerView.ViewHolder. Toma una vista (view) como parámetro
    // en su constructor. Esta vista representa la vista del elemento de la lista que se utilizará para mostrar una imagen de perro.

    private val binding = ItemDogBinding.bind(view)
    //crea una propiedad llamada binding que se utiliza para enlazar los elementos de la vista del elemento de la lista
    // utilizando ItemDogBinding. Esto se hace mediante el método bind(view) de ItemDogBinding, que se utiliza para enlazar
    // la vista de diseño (view) con los elementos definidos en el archivo de diseño XML correspondiente

    fun bind(image:String){
        Picasso.get().load(image).into(binding.ivDog)
        //Esta función bind se utiliza para vincular los datos del elemento (en este caso, una URL de imagen de perro)
    // con la vista del elemento de la lista.
    }
}