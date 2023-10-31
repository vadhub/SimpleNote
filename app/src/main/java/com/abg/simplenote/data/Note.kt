package com.abg.simplenote.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity annotation to specify the table's name
@Entity(tableName = "notes")
data class Note(
    //PrimaryKey annotation to declare primary key with auto increment value
    //ColumnInfo annotation to specify the column's name
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "label") var label: String = "",
    @ColumnInfo(name = "date") var date: String = "",
    @ColumnInfo(name = "time") var time: String = "",
    @ColumnInfo(name = "body") var body: String = ""
)