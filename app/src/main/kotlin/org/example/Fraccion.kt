package org.example

class Fraccion(numerador: Int, denominador: Int) {

    var numerador: Int = numerador
        get() = field
        set(value) {
            field = value
            // No llamar a simplificar aquí
        }

    var denominador: Int = denominador
        get() = field
        set(value) {
            if (value == 0) {
                throw IllegalArgumentException("El denominador no puede ser cero")
            }
            field = value
            // No llamar a simplificar aquí
        }

    init {
        if (denominador == 0) {
            throw IllegalArgumentException("El denominador no puede ser cero")
        }
        simplificar()
    }

    private fun mcd(a: Int, b: Int): Int {
        return if (b == 0) kotlin.math.abs(a) else mcd(b, a % b)
    }

    private fun simplificar(): Fraccion {
        if (numerador == 0) {
            denominador = 1
            return this
        }

        val divisor = mcd(numerador, denominador)
        numerador /= divisor
        denominador /= divisor

        // Manejo de signos
        if (denominador < 0) {
            numerador = -numerador
            denominador = -denominador
        }

        return this
    }

    override fun toString(): String = "$numerador/$denominador"

    fun mostrar() = println(this.toString())

    fun aDecimal(): Double = numerador.toDouble() / denominador

    fun esMayor(otra: Fraccion): Boolean = this > otra

    fun esMenor(otra: Fraccion): Boolean = this < otra

    companion object {
        fun desdeDecimal(decimal: Double): Fraccion {
            val precision = 1_000_000
            val numerador = (decimal * precision).toInt()
            val denominador = precision
            return Fraccion(numerador, denominador)
        }
    }

    // --- Operadores ---
    operator fun plus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.denominador + otra.numerador * this.denominador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun minus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.denominador - otra.numerador * this.denominador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun times(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun div(otra: Fraccion): Fraccion {
        if (otra.numerador == 0) {
            throw IllegalArgumentException("No se puede dividir por una fracción con numerador cero")
        }
        val nuevoNumerador = this.numerador * otra.denominador
        val nuevoDenominador = this.denominador * otra.numerador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    // --- Comparación ---
    operator fun compareTo(otra: Fraccion): Int {
        val diferencia = this.numerador * otra.denominador - otra.numerador * this.denominador
        return diferencia.compareTo(0)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraccion) return false
        return this.numerador == other.numerador && this.denominador == other.denominador
    }

    override fun hashCode(): Int {
        return 31 * numerador + denominador
    }
}
