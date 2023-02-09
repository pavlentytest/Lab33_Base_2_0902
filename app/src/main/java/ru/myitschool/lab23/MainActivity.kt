package ru.myitschool.lab23

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.myitschool.lab23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.content.getRundomNums.setOnClickListener{getRandomValues()}
    }

    private fun getRandomValues() {
        val sizeText = binding.content.sizeParam.text.toString()
        val shapeText = binding.content.shapeParam.text.toString()
        val rateText = binding.content.rateParam.text.toString()

        val n = if(sizeText == "") 0 else sizeText.toInt()
        val k = if(shapeText == "") 0 else shapeText.toInt()
        val r = if(rateText == "") 0.0 else rateText.toDouble()

        val calcArray = DoubleArray(n)
        repeat(n) {

            calcArray[it] = calcErlang(k, r)
            Log.d("RRR",calcArray[it].toString())
        }
        /*
        val intent = Intent(context, Activity2)

         */
    }

    private fun calcErlang(kk: Int, rr: Double): Double {
        var total = 0.0
        repeat(kk) {
            val randm = Math.random()
            total += Math.log(randm)
        }
        return -total/rr
    }

}