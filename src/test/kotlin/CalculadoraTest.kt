package org.example

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Verifica todas las operaciones básicas y algunos casos borde.
 */
class CalculadoraTest {

    private lateinit var calculadora: Calculadora

    @BeforeEach
    fun setUp() {
        // Inicializa el objeto Calculadora antes de cada prueba
        calculadora = Calculadora()
    }

    // -----------------------------------Suma-----------------------------------
    @Test
    @DisplayName("Suma de números positivos")
    fun testAdditionPositiveNumbers() {
        val a = 5.0
        val b = 3.0

        val resultado = calculadora.add(a, b)

        assertEquals(8.0, resultado, 0.0001, "La suma de 5.0 y 3.0 debe ser 8.0")
    }

    @Test
    @DisplayName("Suma de números negativos")
    fun testAdditionNegativeNumbers() {
        val a = -4.0
        val b = -6.0

        val resultado = calculadora.add(a, b)

        assertEquals(-10.0, resultado, 0.0001, "La suma de -4.0 y -6.0 debe ser -10.0")
    }

    @Test
    @DisplayName("Suma con cero")
    fun testAdditionWithZero() {
        val a = 5.0
        val b = 0.0

        val resultado = calculadora.add(a, b)

        assertEquals(5.0, resultado, 0.0001, "La suma de 5.0 y 0.0 debe ser 5.0")
    }

    // -----------------------------------Resta-----------------------------------
    @Test
    @DisplayName("Resta de números positivos")
    fun testSubtractionPositiveNumbers() {
        val a = 10.0
        val b = 4.0

        val resultado = calculadora.subtract(a, b)

        assertEquals(6.0, resultado, 0.0001, "La resta de 10.0 y 4.0 debe ser 6.0")
    }

    @Test
    @DisplayName("Resta de números negativos")
    fun testSubtractionNegativeNumbers() {
        val a = -5.0
        val b = -3.0

        val resultado = calculadora.subtract(a, b)

        assertEquals(-2.0, resultado, 0.0001, "La resta de -5.0 y -3.0 debe ser -2.0")
    }

    @Test
    @DisplayName("Resta con cero")
    fun testSubtractionWithZero() {
        val a = 5.0
        val b = 0.0

        val resultado = calculadora.subtract(a, b)

        assertEquals(5.0, resultado, 0.0001, "La resta de 5.0 y 0.0 debe ser 5.0")
    }

    // -----------------------------------Multi-----------------------------------
    @Test
    @DisplayName("Multiplicación de números positivos")
    fun testMultiplicationPositiveNumbers() {
        val a = 4.0
        val b = 3.0

        val resultado = calculadora.multiply(a, b)

        assertEquals(12.0, resultado, 0.0001, "4.0 * 3.0 debe ser 12.0")
    }

    @Test
    @DisplayName("Multiplicación de números negativos")
    fun testMultiplicationNegativeNumbers() {
        val a = -2.0
        val b = 3.0

        val resultado = calculadora.multiply(a, b)

        assertEquals(-6.0, resultado, 0.0001, "-2.0 * 3.0 debe ser -6.0")
    }

    @Test
    @DisplayName("Multiplicación por cero")
    fun testMultiplicationWithZero() {
        val a = 5.0
        val b = 0.0

        val resultado = calculadora.multiply(a, b)

        assertEquals(0.0, resultado, 0.0001, "Cualquier número multiplicado por 0.0 debe dar 0.0")
    }

    // -----------------------------------División-----------------------------------
    @Test
    @DisplayName("División de números positivos")
    fun testDivisionPositiveNumbers() {
        val a = 10.0
        val b = 2.0

        val resultado = calculadora.divide(a, b)

        assertEquals(5.0, resultado, 0.0001, "10.0 / 2.0 debe ser 5.0")
    }

    @Test
    @DisplayName("División de números negativos")
    fun testDivisionNegativeNumbers() {
        val a = -10.0
        val b = 2.0

        val resultado = calculadora.divide(a, b)

        assertEquals(-5.0, resultado, 0.0001, "-10.0 / 2.0 debe ser -5.0")
    }

    @Test
    @DisplayName("División entre cero lanza excepción")
    fun testDivisionByZero() {
        assertThrows(ArithmeticException::class.java) {
            calculadora.divide(10.0, 0.0)
        }
    }

    // -----------------------------------Edge Cases (grandes, pequeños, etc.)-----------------------------------
    @Test
    @DisplayName("Suma de 1.0e308 + 1.0e308 produce infinito")
    fun testAdditionLargeValues() {
        val a = 1.0e308
        val b = 1.0e308
        val resultado = calculadora.add(a, b)

        assertTrue(
            resultado.isInfinite(),
            "La suma de 1.0e308 con 1.0e308 debería desbordar y dar infinito"
        )
    }


    @Test
    @DisplayName("División con valores muy pequeños")
    fun testDivisionSmallValues() {
        val a = 1.0e-308 // número muy pequeño
        val b = 1.0e-308

        val resultado = calculadora.divide(a, b)

        assertEquals(1.0, resultado, 1e-15, "Si a y b son iguales, la división debe dar 1.0 (aprox).")
    }
}


