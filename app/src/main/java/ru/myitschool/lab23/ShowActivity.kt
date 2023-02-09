package ru.myitschool.lab23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import ru.myitschool.lab23.databinding.ActivityShowBinding

data class Student(val name: String)

class ShowActivity : AppCompatActivity() {

    private lateinit var students: List<Student>
    private lateinit var bindingShow: ActivityShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingShow = ActivityShowBinding.inflate(layoutInflater)
        setContentView(bindingShow.root)

        val fileString = application.assets.open("test.json").bufferedReader().use { it.readText() }
        val gson = GsonBuilder().create()
        students = gson.fromJson(fileString, Array<Student>::class.java).toList()
        Log.d("RRR", students.size.toString())
        bindingShow.generatedList.layoutManager = LinearLayoutManager(this)
        bindingShow.generatedList.adapter = MyAdapter(students)

    }
}