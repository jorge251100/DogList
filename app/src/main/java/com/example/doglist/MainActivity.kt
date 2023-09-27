package com.example.doglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doglist.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.QueryName

class MainActivity : AppCompatActivity(), OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter
    private val dogImages = mutableListOf<String>()
    //Estas líneas declaran las variables utilizadas en la actividad. binding se utiliza para acceder a los elementos de la
    // interfaz de usuario definidos en el archivo de diseño adapter es una instancia de DogAdapter que se utilizará para mostrar
    // la lista de imágenes de perros en un RecyclerView. dogImages es una lista mutable que almacena las URL de las imágenes de
    // perros.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svDogs.setOnQueryTextListener(this)
        initRecyclerView()
    }
    //En el método onCreate, se realiza la inicialización de la actividad. Se infla la vista de la actividad a partir del
    // archivo de diseño

    private fun initRecyclerView() {
        adapter = DogAdapter(dogImages)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
//se encarga de inicializar y configurar el RecyclerView. Se crea una instancia del adaptador DogAdapter

    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //crea y configura una instancia de Retrofit para realizar solicitudes de red. Se especifica la URL base de la API
    // de perros y se utiliza GsonConverterFactory para convertir las respuestas JSON en objetos Kotlin.
    }

    private fun searchByName(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<DogsResponse> = getRetrofit().create(APIService::class.java).getDogsByBreeds("$query/images")
            val puppies:DogsResponse? = call.body()
            runOnUiThread{
                if(call.isSuccessful){
                    val images : List<String> = puppies?.images ?: emptyList()
                    dogImages.clear()
                    dogImages.addAll(images)
                    adapter.notifyDataSetChanged()
                    //show recyclerview
                }else{
                    //show error
                    showError()
                }
//El método searchByName se utiliza para realizar una solicitud a la API de perros utilizando Retrofit
            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchByName(query.lowercase())
            //Este método se llama cuando el usuario envía una consulta de búsqueda desde el SearchView. Se verifica si
        // la consulta no está vacía y se llama al método searchByName para realizar la búsqueda.
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true;
        //se llama cuando el texto de búsqueda cambia
    }
}