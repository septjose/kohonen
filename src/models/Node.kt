package models
import java.text.DecimalFormat

class Node(numweights : Int ){

    val weights : ArrayList<Double> = ArrayList()
    private var df = DecimalFormat("#.00000")

    init {
        for(i in 0 until numweights){
            weights.add(df.format(Math.random()).toDouble())

        }
    }

    fun getDistante(inputVector : ArrayList<Double>) : Double
    {
        var distance = 0.0
        for(i in 0 until weights.size){
            distance+=Math.pow(inputVector[i]-weights[i], 2.0)
        }
        return df.format(distance).toDouble()
    }
}