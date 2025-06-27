package org.example

// Clase Fracción
class Fraccion(numerador: Int, denominador: Int) {

    var numerador: Int = numerador
        get() = field
        set(value) {
            field = value
        }

    var denominador: Int = denominador
        get() = field
        set(value) {
            if (value == 0) {
                throw IllegalArgumentException("El denominador no puede ser cero")
            }
            field = value
        }

    init {
        if (denominador == 0) {
            throw IllegalArgumentException("El denominador no puede ser cero")
        }
    }

    override fun toString(): String {
        return "$numerador/$denominador"
    }

    fun mostrar() {
        println(this.toString())
    }
}

// Algoritmo de Euclides para MCD
private fun mcd(a: Int, b: Int): Int {
    var num1 = kotlin.math.abs(a)
    var num2 = kotlin.math.abs(b)
    while (num2 != 0) {
        val temp = num2
        num2 = num1 % num2
        num1 = temp
    }
    return num1
}

// Método de extensión para simplificar
fun Fraccion.simplificar(): Fraccion {
    val divisor = mcd(this.numerador, this.denominador)
    var num = this.numerador / divisor
    var den = this.denominador / divisor
    if (den < 0) {
        num *= -1
        den *= -1
    }
    return Fraccion(num, den)
}

// Suma
operator fun Fraccion.plus(otra: Fraccion): Fraccion {
    val nuevoNumerador = this.numerador * otra.denominador + otra.numerador * this.denominador
    val nuevoDenominador = this.denominador * otra.denominador
    return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
}

// Resta
operator fun Fraccion.minus(otra: Fraccion): Fraccion {
    val nuevoNumerador = this.numerador * otra.denominador - otra.numerador * this.denominador
    val nuevoDenominador = this.denominador * otra.denominador
    return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
}
