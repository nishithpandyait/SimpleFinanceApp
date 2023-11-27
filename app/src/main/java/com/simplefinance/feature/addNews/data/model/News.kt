package com.simplefinance.feature.addNews.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class News(
    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0


}