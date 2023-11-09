fun ePrimo(num: Int): Boolean{
    if (num <= 1) {
        return false
    }
    if (num <= 3) {
        return true
    }
    var divisor = 2
    while (divisor * divisor <= num) {
        if (num % divisor == 0) {
            return false
        }
        divisor++
    }

    /* for (i in 2 until num) {
         if (num % i == 0) {
             return false
         }
     }*/

    return true
}
fun main() {
    do{
        println("Introduza um numero")
        var numero = readln().toInt()
        when{
            (ePrimo(numero) == false && numero <= 0) -> println("Numero invalido")
            (ePrimo(numero) == true) -> println("$numero e primo")

        }
    }while(ePrimo(numero) == false)
}