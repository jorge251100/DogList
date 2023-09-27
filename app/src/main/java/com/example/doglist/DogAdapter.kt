package com.example.doglist

import android.view.LayoutInflater  //Estas líneas importan las clases necesarias de Android para trabajar
import android.view.ViewGroup // con vistas de reciclaje (RecyclerView) y la inflación de diseños (LayoutInflater).
import androidx.recyclerview.widget.RecyclerView

class DogAdapter(private val images:List<String>):RecyclerView.Adapter<DogViewHolder>() {  //toma la lista de las url's, con DogViewHolder para gestionar las vistas de los elementos individuales.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val layoutInflater:LayoutInflater = LayoutInflater.from(parent.context)
        return DogViewHolder(layoutInflater.inflate(R.layout.item_dog,parent, false))
        //se infla el diseño del elemento de perro (R.layout.item_dog) utilizando un LayoutInflater y se crea una nueva instancia de DogViewHolder con la vista inflada como argumento.
    }

    override fun getItemCount(): Int = images.size
    //devuelve el número total de elementos en la lista de imágenes de perros. En este caso, el número de elementos es igual al tamaño de la lista images.

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val item:String = images[position]
        holder.bind(item)
        //enlazar un elemento de la lista con una instancia de DogViewHolder. En este método, se obtiene el elemento
    // en la posición actual de la lista de imágenes de perros, y se llama al método bind del DogViewHolder para vincular
    // los datos del elemento con la vista de la tarjeta que representa ese elemento.
    }
}