fun ePrimo(num: Int): Boolean {
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

    return true
}

fun main() {
    do {
        println("Introduza um numero")
        val numero = readln().toInt()
        val ePrimo = ePrimo(numero)
        if (ePrimo) {
            println("$numero e primo")
        }
    } while (ePrimo(numero) == false)
}