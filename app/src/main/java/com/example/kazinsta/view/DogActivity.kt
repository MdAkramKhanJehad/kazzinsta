package com.example.kazinsta.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kazinsta.R
import com.example.kazinsta.data.Message
import com.example.kazinsta.databinding.ActivityHomeBinding
import com.example.kazinsta.utilies.InjectorUtils
import com.example.kazinsta.viewmodel.DogViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DogActivity: AppCompatActivity() {

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        initializeButtons()
        initializeUi()

    }


    private fun initializeUi() {
        val factory = InjectorUtils.provideDogsViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(DogViewModel::class.java)


        spinner = findViewById(R.id.spBreeds)
        lifecycleScope.launchWhenCreated {
            val response = viewModel.getListOfAllBreeds()

            if (response != null) {
                println(response)
                breedList = getFields(response)

                adapter = ArrayAdapter<String>(
                    this@DogActivity,
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

                val response = viewModel.getMultipleRandomDogImage(number.toInt())

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

                val response = viewModel.getAllDogImageByBreed(breed)

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

                val response = viewModel.getMultipleRandomDogImageByBreed(breed,number.toInt())

                if (response != null) {
                    list.postValue(response as List<String>?)
                }
            }
            closeKeyboard()
        }

        list.observe(this, {
            if (it.isNotEmpty()) {
                dogAdapter.dogs = it as MutableList<String>
                dogAdapter.notifyDataSetChanged()
            }
        })
    }


    private fun getFields(response: Message): MutableList<String> {
        val fields = response::class.java.declaredFields
        for (i in fields) {
            breedList.add(i.name)
            Log.d("Fields ===", i.name)
        }

        return breedList
    }


    fun closeKeyboard(){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
    }


    private fun setupRecyclerView() = binding.rvDog.apply {
        dogAdapter = DogAdapter(this@DogActivity)
        adapter = dogAdapter
        layoutManager = GridLayoutManager(this@DogActivity,2)
    }


    private fun initializeButtons(){
        btnMulRandImg = findViewById(R.id.btnMulRandImg)
        btnAllImgByBreed = findViewById(R.id.btnAllImgByBreed)
        btnMulRandImgByBreed = findViewById(R.id.btnMulRandImgByBreed)
        etNumber = findViewById(R.id.etNumber)
    }

}