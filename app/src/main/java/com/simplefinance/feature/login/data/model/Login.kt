package com.simplefinance.feature.login.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login")
data class Login( @ColumnInfo(name = "name")val name: String) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}