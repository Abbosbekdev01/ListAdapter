package uz.abbosbek.listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.abbosbek.listadapter.adapters.PersonAdapter
import uz.abbosbek.listadapter.databinding.ActivityMainBinding
import uz.abbosbek.listadapter.models.Person

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var list: ArrayList<Person>
    private lateinit var personAdapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        personAdapter = PersonAdapter()
        binding.rv.adapter = personAdapter
        loadData()
        personAdapter.submitList(list)

    }

    private fun loadData(){
        list = ArrayList()
        for(i in 0 until 10){
            list.add(Person("Asadbek", 17))
            list.add(Person("Biloldin", 23))
            list.add(Person("Murodiljon", 22))
        }
    }
}