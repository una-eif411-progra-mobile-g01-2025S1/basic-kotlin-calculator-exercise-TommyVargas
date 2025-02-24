package org.example


fun main() {
    val calculadora = Calculadora()

    //------------------------------Tommy Vargas Naranjo------------------------------
    //Casos basicos
    println("Suma de 5 y 3: ${calculadora.add(5.0, 3.0)}")
    println("Resta de 5 y 3: ${calculadora.subtract(5.0, 3.0)}")
    println("Multiplicación de 5 y 3: ${calculadora.multiply(5.0, 3.0)}")
    println("División de 10 y 2: ${calculadora.divide(10.0, 2.0)}")

    //Division entre cero
    println("División de 10 y 2: ${calculadora.divide(10.0, 0.0)}")
}
