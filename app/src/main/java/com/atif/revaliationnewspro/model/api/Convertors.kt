package com.atif.revaliationnewspro.model.api

import androidx.room.TypeConverter


class Convertors  {

    @TypeConverter
    fun SourcetoString(value :Source) : String{
        return value.name
    }
    @TypeConverter
    fun StringtoSource(value :String) : Source{
        return Source(name = value, id = null)
    }
}