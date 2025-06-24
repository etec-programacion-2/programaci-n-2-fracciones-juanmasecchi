package org.example

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
