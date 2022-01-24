package com.example.kazinsta

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kazinsta.databinding.ActivityHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import kotlin.reflect.full.declaredMemberProperties


const val TAG = "Home"

class Home: AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var dogAdapter: DogAdapter

    private lateinit var btnMulRandImg : Button
    private lateinit var etNumber: EditText
    private lateinit var spinner: Spinner
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var breed: String
    private  var breedList = mutableListOf<String>()
    private lateinit var btnAllImgByBreed : Button
    private lateinit var btnMulRandImgByBreed : Button
    private var list = MutableLiveData<List<String>>()
    private var httpHelper =  HttpHelper()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        initializeButtons()
        spinner = findViewById(R.id.spBreeds)

        lifecycleScope.launchWhenCreated {
            val response = httpHelper.getListOfAllBreeds()

            if (response != null) {
                println(response)
                val fields = response::class.declaredMemberProperties

                for (i in fields) {
                    breedList.add(i.name)
                    Log.d("Fields ===", i.name)
                }

                adapter = ArrayAdapter<String>(
                    this@Home,
                    R.layout.support_simple_spinner_dropdown_item,
                    breedList
                )
                spinner.adapter = adapter

            }
            closeKeyboard()
        }


        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                breed = adapterView?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                breed = "akita"
            }

        }


        btnMulRandImg.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                var number = etNumber.text.toString()
                if(number.isEmpty()){
                    number = "5"
                }

                val response = httpHelper.getMultipleRandomDogImage(number.toInt())

                if (response != null) {
                    list.postValue(response as List<String>?)
                }
            }
            closeKeyboard()
        }

        btnAllImgByBreed.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                if(breed.isEmpty()){
                    println("EMPTY BREED")
                    breed = "hound"
                }

                val response = httpHelper.getAllDogImageByBreed(breed)

                if (response != null) {
                    list.postValue(response as List<String>?)
                }
            }
            closeKeyboard()
        }

        btnMulRandImgByBreed.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
//                breed = etBreed.text.toString()
                var number = etNumber.text.toString()
                if(breed.isEmpty()){
                    breed = "akita"
                }
                if(number.isEmpty()){
                    number = "5"
                }

                val response = httpHelper.getMultipleRandomDogImageByBreed(breed,number.toInt())

                if (response != null) {
                    list.postValue(response as List<String>?)
                }
            }
            closeKeyboard()
        }

        list.observe(this,{
            if (it.isNotEmpty()){
                dogAdapter.dogs = it as MutableList<String>
                dogAdapter.notifyDataSetChanged()
            }
        })
    }

    fun closeKeyboard(){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
    }


    private fun setupRecyclerView() = binding.rvDog.apply {
        dogAdapter = DogAdapter(this@Home)
        adapter = dogAdapter
        layoutManager = GridLayoutManager(this@Home,2)
    }


    private fun initializeButtons(){
        btnMulRandImg = findViewById(R.id.btnMulRandImg)
        btnAllImgByBreed = findViewById(R.id.btnAllImgByBreed)
        btnMulRandImgByBreed = findViewById(R.id.btnMulRandImgByBreed)
        etNumber = findViewById(R.id.etNumber)
    }

}