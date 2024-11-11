import org.dropproject.stdinstdoutjunithelper.StdinStdoutHelper
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@Timeout(1)
class TestProjectEx5v2 {

    @Test
    @Order(1)
    fun testPrimoFalse() {
        assertEquals(ePrimo(1), false)
        assertEquals(ePrimo(4), false)
        assertEquals(ePrimo(36), false)
        assertEquals(ePrimo(52), false)
    }
    @Test
    @Order(2)
    fun testPrimoTrue() {
        assertEquals(ePrimo(7),true)
        assertEquals(ePrimo(2),true)
        assertEquals(ePrimo(37),true)
        assertEquals(ePrimo(137),true)
        assertEquals(ePrimo(3),true)
    }
    @Test
    @Order(3)
    fun testPrimoNegative() {
        assertEquals(ePrimo(-2),false)
        assertEquals(ePrimo(-10),false)
        assertEquals(ePrimo(-64),false)
        assertEquals(ePrimo(-137),false)
    }
    @Test
    @Order(4)
    fun testInput1() {
        val helper = StdinStdoutHelper(false)
            .expectOutput("Introduza um numero")
            .simulateInput("-4")
            .expectOutput("Introduza um numero")
            .simulateInput("11")
            .expectOutput("11 e primo")
            

        helper.start()
        main()
        helper.stop()
    }

    @Test
    @Order(5)
    fun testOK1() {

        val helper = StdinStdoutHelper(false)
            .expectOutput("Introduza um numero")
            .simulateInput("4")
            .expectOutput("Introduza um numero")
            .simulateInput("10")
            .expectOutput("Introduza um numero")
            .simulateInput("5")
            .expectOutput("5 e primo")


        helper.start()
        main()
        helper.stop()
    }

    @Test
    @Order(6)
    fun testOK2() {

        val helper = StdinStdoutHelper(false)
            .expectOutput("Introduza um numero")
            .simulateInput("37")
            .expectOutput("37 e primo")

        helper.start()
        main()
        helper.stop()
    }




}