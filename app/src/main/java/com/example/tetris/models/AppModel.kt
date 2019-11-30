package com.example.tetris.models

import android.graphics.Point
import com.example.tetris.models.FieldConstants.FieldConstants
import com.example.tetris.helpers.array2dOfByte
import com.example.tetris.storage.AppPreference

class AppModel {

    var score:Int = 0

    private var preference:AppPreference? = null

    var currentBlock: Block? = null

    var currentState: String = Statuses.AWAITING_START.name

    private var field: Array<ByteArray> = array2dOfByte(
        FieldConstants.ROW_COUNT.value,
        FieldConstants.COLUMN_COUNT.value
    )
    enum class Statuses{
        AWAITING_START, ACTIVE,INACTIVE,OVER
    }
    enum class Motion{
        LEFT,RIGTH,DOWN,ROTATE
    }

    fun setPreferences(preference: AppPreference?){
        this.preference

    }

    fun getCellStatus(row:Int,column:Int):Byte?{
        return field[row][column]
    }

    private  fun setCellStatus(row:Int,column: Int,status:Byte?){
        if(status != null ){
            field[row][column] = status
        }

    }
}