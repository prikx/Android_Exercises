package com.example.threadapp

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*


@RequiresApi(Build.VERSION_CODES.N)
class RandomString {

    private val random = Random()
    var string : String = ""

    init{
        for(i in 1..100) {

            val x = random.nextInt(126)
                if(x > 33)
                string += x.toChar()
        }
    }
}