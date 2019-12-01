package com.example.tetris.models

import android.graphics.Point
import com.example.tetris.models.FieldConstants.FieldConstants
import com.example.tetris.helpers.array2dOfByte
import com.example.tetris.storage.AppPreference
import com.example.tetris.constants.CellConstants
import java.text.FieldPosition

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

    fun isGameOver():Boolean {
        return currentState == Statuses.OVER.name

    }

    fun isGameActive():Boolean{
        return currentState == Statuses.ACTIVE.name
    }

    fun isGameAwaitingStart():Boolean{
        return currentState == Statuses.AWAITING_START.name
    }

    private fun boostScore(){
        score+=10
        if(score>preference?.getHighScore()as Int){
            preference?.saveHighScore(score)
        }
    }

    private fun generateNextBlock(){
        currentBlock = Block.createBlock()
    }

    private fun validTranslation(position: Point, shape: Array<ByteArray>):Boolean{
         if(position.x<0 || position.y<0){
             return  false
        } else if(position.y + shape.size>FieldConstants.ROW_COUNT.value){
             return false

         }else if(position.x + shape[0].size> FieldConstants.COLUMN_COUNT.value){
             return false
         } else{
             for ( i in 0 until shape.size){
                 for (j in 0 until shape[i].size){
                     val y =position.y +i
                     val x =position.x +j

                     if(CellConstants.EMPTY.value != shape[i][j] && CellConstants.EMPTY.value != field[x][y]){
                            return false
                     }
                 }
             }

         }
        return true
    }

    private fun moveValid(position: Point, frameNumber: Int?):Boolean{
        val shape:Array<ByteArray>? = currentBlock?.getShape(frameNumber as Int)
        return validTranslation(position, shape as Array<ByteArray>)
    }

    fun generateField(action: String){
        if(isGameActive()){
            resetField()
            var frameNumber = currentBlock?.frameNumber
            var coordinate: Point? = Point()
            coordinate?.x = currentBlock?.position?.x
            coordinate?.y = currentBlock?.position?.y

            when(action){
                
            }
        }
    }
}