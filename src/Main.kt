import  models.Node
import java.text.DecimalFormat

fun main(args: Array<String>) {
    val numberOfWeights = 10
    val inputNeuron = arrayListOf(0.346, 0.324, 0.452, 0.325, 0.864,0.694,0.245,0.548,0.674,0.786)
    var winNeuron: Node? = null
    var alfa=0.5
    var winNeuronNum =0

    var df = DecimalFormat("#.000000")

    val outputNeurons = arrayListOf(
            Node(numberOfWeights),
            Node(numberOfWeights),
            Node(numberOfWeights))

    println("\n")
    println("X = $inputNeuron")
    println("")


    for(t in 1 until 10) {
        var lessDistance = 0.0

        println("Época : $t")
        for (c in 0 until outputNeurons.size){
            print("W")
            print(c+1)
            println(outputNeurons[c].weights)
        }
        println("")

        //OBTAIN THE WINN NEURONE
        for (i in 0 until outputNeurons.size) {
            val distance = outputNeurons[i].getDistante(inputNeuron)

            print("Distancia")
            print(i+1)
            println(": $distance")

            if (lessDistance != 0.0) {
                if (distance < lessDistance) {
                    lessDistance = distance
                    winNeuronNum=i+1
                    winNeuron = outputNeurons[i]
                }
            } else {
                lessDistance = distance
                winNeuronNum=i+1
                winNeuron = outputNeurons[i]
            }
        }

        println("Distancia Menor = $lessDistance")
        println("Neurona vencedora : $winNeuronNum")
        println("")
        println("alfa: $alfa")
        print("peso actual neurona vencedora")
        println(winNeuron!!.weights)

        //UPDATE THE WEIGHTS OF THE WIN NEURON
        for (i in 0 until numberOfWeights) {
            winNeuron.weights[i] = df.format(winNeuron.weights[i] + (alfa * (inputNeuron[i] - winNeuron.weights[i]))).toDouble()
        }
        print("Peso actualizado neurona vencedora")
        println(winNeuron.weights)
        alfa *= df.format(1 / t.toDouble()).toDouble()
        println("")
        println("------------------------------------------")
    }

    println("Neurona vencedora : $winNeuronNum")
}