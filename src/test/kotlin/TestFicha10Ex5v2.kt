import org.junit.Test
import kotlin.test.assertEquals


class TestProjectEx5v2 {

    @Test(timeout = 500)
    fun testPrimoFalse() {
        assertEquals(ePrimo(1), false)
        assertEquals(ePrimo(4), false)
        assertEquals(ePrimo(36), false)
        assertEquals(ePrimo(52), false)
    }
    @Test(timeout = 500)
    fun testPrimoTrue() {
        assertEquals(ePrimo(7),true)
        assertEquals(ePrimo(2),true)
        assertEquals(ePrimo(37),true)
        assertEquals(ePrimo(137),true)
        assertEquals(ePrimo(3),true)
    }
    @Test(timeout = 500)
    fun testPrimoNegative() {
        assertEquals(ePrimo(-2),false)
        assertEquals(ePrimo(-10),false)
        assertEquals(ePrimo(-64),false)
        assertEquals(ePrimo(-137),false)
    }
    @Test(timeout = 500)
    fun testInput1() {
        val helper = StdinStdoutHelper(false)
            .expectOuput("Introduza um numero")
            .simulateInput("-5")
            .expectOuput("Numero invalido")
            .expectOuput("Introduza um numero")
            .simulateInput("11")
            .expectOuput("11 e primo")

        helper.start()
        main()
        helper.stop()
    }

    @Test(timeout = 500)
    fun testOK1() {

        val helper = StdinStdoutHelper(false)
            .expectOuput("Introduza um numero")
            .simulateInput("4")
            .expectOuput("Introduza um numero")
            .simulateInput("10")
            .expectOuput("Introduza um numero")
            .simulateInput("5")
            .expectOuput("5 e primo")


        helper.start()
        main()
        helper.stop()
    }

    @Test(timeout = 500)
    fun testOK2() {

        val helper = StdinStdoutHelper(false)
            .expectOuput("Introduza um numero")
            .simulateInput("37")
            .expectOuput("37 e primo")

        helper.start()
        main()
        helper.stop()
    }




}