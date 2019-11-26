package com.example.tetris.models

import com.example.tetris.helpers.array2dOfByte

class Frame(private val  with:Int){
    val data:ArrayList<ByteArray> = ArrayList()

    fun addRow(byteStr:String):Frame{
        val row = ByteArray(byteStr.length)

        for (index in byteStr.indices){
            row[index] = "${byteStr[index]}".toByte()
        }
        data.add(row)
        return this
    }

    fun as2dToByteArray():Array<ByteArray>{
        val bytes = array2dOfByte(data.size,with)
        return data.toArray(bytes)
    }
}