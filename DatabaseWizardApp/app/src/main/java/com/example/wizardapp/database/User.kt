package com.example.wizardapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User {
    @PrimaryKey
    var uid = 0
    var name: String? = null
    var address1: String? = null
    var address2: String? = null
    var birthday: String? = null
}