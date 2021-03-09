package com.example.wizardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.wizardapp.database.AppDatabase
import com.example.wizardapp.database.User

open class MainActivity : AppCompatActivity() {

    protected lateinit var db: AppDatabase
    protected lateinit var currentUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = AppDatabase.getAppDatabase(this)!!

        if(db.userDao().countUsers() == 0) {
            currentUser = User()
            currentUser.uid = 1
            currentUser.address1 = ""
            currentUser.address2 = ""
            currentUser.birthday = ""
            currentUser.name = ""
            db.userDao().insert(currentUser)
        } else {
            currentUser = db.userDao().user!!
        }


        Log.d("CHECK", "On Create")
    }

    override fun onStart() {
        super.onStart()
        Log.d("CHECK", "On Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CHECK", "On Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CHECK", "On Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CHECK", "On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CHECK", "On Destroy")
    }

    fun startWizard(view: View) {
        val intent = Intent(this, NameCollector::class.java).apply {  }
        startActivity(intent)
    }
}