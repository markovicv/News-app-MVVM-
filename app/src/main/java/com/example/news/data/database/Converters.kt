package com.example.news.data.database

import androidx.room.TypeConverter
import com.example.news.data.model.api_response.Source

class Converters {

    @TypeConverter
    fun fromSource(source:Source):String{
        return source.name
    }

    @TypeConverter
    fun toSource(name:String):Source{
        return Source(name,name)
    }
}