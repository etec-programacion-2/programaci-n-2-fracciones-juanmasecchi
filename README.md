# 2025-fractions

![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)

## Información del Alumno

**Nombre y Apellido:** [Juan Rodriguez]

**Curso:** [3I]

**Fecha de entrega:** [Escribir aquí la fecha de entrega]

---

## Consigna de Trabajo Práctico: Operaciones con Fracciones

### Contexto
Este trabajo está dirigido a estudiantes que están aprendiendo programación orientada a objetos con Kotlin. El objetivo es implementar una clase `Fraccion` que permita realizar operaciones básicas entre fracciones utilizando los conceptos de POO.

### Objetivos
- Implementar la clase `Fraccion` en Kotlin con sus propiedades y constructores.
- Implementar los operadores necesarios para realizar las operaciones de suma, resta, multiplicación y división de fracciones.
- Aplicar buenas prácticas de programación orientada a objetos en Kotlin.
- Manejar casos especiales como fracciones con denominador cero o fracciones negativas.
- Desarrollar una interfaz de línea de comandos (CLI) para probar la funcionalidad.

---

## Etapas del Trabajo
El trabajo se divide en las siguientes etapas. **Al finalizar cada etapa, deberán hacer un push al repositorio con los avances.**

### Etapa 1: Definición de la Clase
**Objetivo:** Crear la estructura básica de la clase Fraccion con sus propiedades y métodos fundamentales.

**Pasos a seguir:**
1. Crear un archivo separado llamado `Fraccion.kt` en el directorio `src/main/kotlin/org/example/`.
2. Definir la clase `Fraccion` con las siguientes propiedades:
   - `numerador` (tipo Int)
   - `denominador` (tipo Int)
3. Implementar el constructor principal que reciba numerador y denominador como parámetros.
4. Implementar las propiedades con getters y setters automáticos de Kotlin:
   ```kotlin
   var numerador: Int = 0
       get() = field
       set(value) { field = value }
   
   var denominador: Int = 1
       get() = field
       set(value) { 
           if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
           field = value 
       }
   ```
5. Implementar el método `toString()` que devuelva la fracción en formato "numerador/denominador".
6. Crear un método `mostrar()` que imprima la fracción en consola.
7. **Validación:** Verificar que el denominador no sea cero en el constructor.
8. **Push al repositorio** con el mensaje "Etapa 1: Definición básica de la clase Fraccion".

### Etapa 2: Suma y Resta de Fracciones
**Objetivo:** Implementar las operaciones de suma y resta entre fracciones usando operadores de Kotlin.

**Pasos a seguir:**
1. **Operador suma:**
   - Crear el operador `operator fun plus(otra: Fraccion): Fraccion`
   - Implementar la fórmula: (a/b) + (c/d) = (a*d + b*c)/(b*d)
   - El operador debe devolver una nueva fracción con el resultado
2. **Operador resta:**
   - Crear el operador `operator fun minus(otra: Fraccion): Fraccion`
   - Implementar la fórmula: (a/b) - (c/d) = (a*d - b*c)/(b*d)
   - El operador debe devolver una nueva fracción con el resultado
3. **Método simplificar:**
   - Crear un método privado `simplificar()` que reduzca la fracción a su forma más simple
   - Usar el algoritmo de Euclides para encontrar el máximo común divisor (MCD)
   - Aplicar la simplificación en los operadores de suma y resta
4. **Validaciones:**
   - Verificar que las fracciones a operar sean válidas (denominador ≠ 0)
   - Manejar casos de fracciones negativas
5. **Push al repositorio** con el mensaje "Etapa 2: Implementación de operadores suma y resta de fracciones".

### Etapa 3: Multiplicación y División de Fracciones
**Objetivo:** Implementar las operaciones de multiplicación y división entre fracciones usando operadores de Kotlin.

**Pasos a seguir:**
1. **Operador multiplicación:**
   - Crear el operador `operator fun times(otra: Fraccion): Fraccion`
   - Implementar la fórmula: (a/b) * (c/d) = (a*c)/(b*d)
   - El operador debe devolver una nueva fracción con el resultado
2. **Operador división:**
   - Crear el operador `operator fun div(otra: Fraccion): Fraccion`
   - Implementar la fórmula: (a/b) / (c/d) = (a*d)/(b*c)
   - El operador debe devolver una nueva fracción con el resultado
3. **Validaciones adicionales:**
   - En división, verificar que el numerador de la segunda fracción no sea cero
   - Manejar el caso de división por cero lanzando una excepción
4. **Aplicar simplificación:**
   - Usar el método `simplificar()` en los resultados de multiplicación y división
5. **Push al repositorio** con el mensaje "Etapa 3: Implementación de operadores multiplicación y división de fracciones".

### Etapa 4: Validaciones
**Objetivo:** Implementar validaciones adicionales y métodos de utilidad para completar la funcionalidad de la clase.

**Pasos a seguir:**
1. **Validaciones de entrada:**
   - Verificar que el denominador nunca sea cero en cualquier operación
   - Manejar fracciones negativas correctamente
   - Validar que los parámetros de entrada sean válidos
2. **Operadores de comparación:**
   - Crear el operador `operator fun compareTo(otra: Fraccion): Int` para comparar fracciones
   - Implementar `operator fun equals(other: Any?): Boolean` para verificar igualdad
3. **Métodos de utilidad:**
   - Crear un método `esMayor(otra: Fraccion): Boolean` que determine si una fracción es mayor que otra
   - Crear un método `esMenor(otra: Fraccion): Boolean` que determine si una fracción es menor que otra
4. **Método para convertir a decimal:**
   - Crear un método `aDecimal(): Double` que convierta la fracción a su representación decimal
5. **Método para crear fracción desde decimal:**
   - Crear un método companion object `fun desdeDecimal(decimal: Double): Fraccion` que convierta un decimal a fracción
6. **Documentación:**
   - Documentar los parámetros y valores de retorno
7. **Push al repositorio** con el mensaje "Etapa 4: Validaciones y métodos de utilidad completados".

### Etapa 5: Interfaz de Línea de Comandos (CLI)
**Objetivo:** Desarrollar una interfaz de línea de comandos simple para probar todas las funcionalidades de la clase Fraccion.

**Pasos a seguir:**
1. **Crear el archivo CLI:**
   - Crear un archivo `CalculadoraFracciones.kt` en el directorio `src/main/kotlin/org/example/`
   - Este archivo contendrá la función `main()` y la lógica del CLI
   - Importar `java.util.Scanner` al inicio del archivo

2. **Estructura del menú principal:**
   ```kotlin
   fun mostrarMenu() {
       println("=== CALCULADORA DE FRACCIONES ===")
       println("1. Sumar fracciones")
       println("2. Restar fracciones")
       println("3. Multiplicar fracciones")
       println("4. Dividir fracciones")
       println("5. Comparar fracciones")
       println("6. Convertir fracción a decimal")
       println("7. Crear fracción desde decimal")
       println("8. Ejemplos predefinidos")
       println("0. Salir")
       println("Ingrese su opción: ")
   }
   ```

3. **Función para leer fracciones:**
   ```kotlin
   fun leerFraccion(scanner: Scanner, mensaje: String): Fraccion {
       println(mensaje)
       print("Numerador: ")
       val numerador = scanner.nextInt()
       print("Denominador: ")
       val denominador = scanner.nextInt()
       return Fraccion(numerador, denominador)
   }
   ```

4. **Implementar cada operación:**
   - **Suma:** Leer dos fracciones y mostrar el resultado usando el operador `+`
   - **Resta:** Leer dos fracciones y mostrar el resultado usando el operador `-`
   - **Multiplicación:** Leer dos fracciones y mostrar el resultado usando el operador `*`
   - **División:** Leer dos fracciones y mostrar el resultado usando el operador `/`
   - **Comparación:** Leer dos fracciones y mostrar cuál es mayor, menor o si son iguales
   - **Conversión a decimal:** Leer una fracción y mostrar su valor decimal
   - **Desde decimal:** Leer un decimal y mostrar la fracción equivalente

5. **Ejemplos predefinidos:**
   Crear una función que muestre ejemplos de todas las operaciones:
   ```kotlin
   fun mostrarEjemplos() {
       println("\n=== EJEMPLOS PREDEFINIDOS ===")
       
       val f1 = Fraccion(1, 2)  // 1/2
       val f2 = Fraccion(1, 3)  // 1/3
       
       println("Fracción 1: $f1")
       println("Fracción 2: $f2")
       println("Suma: $f1 + $f2 = ${f1 + f2}")
       println("Resta: $f1 - $f2 = ${f1 - f2}")
       println("Multiplicación: $f1 * $f2 = ${f1 * f2}")
       println("División: $f1 / $f2 = ${f1 / f2}")
       println("¿$f1 > $f2? ${f1 > f2}")
       println("$f1 en decimal: ${f1.aDecimal()}")
   }
   ```

6. **Manejo de errores:**
   - Usar try-catch para manejar excepciones (denominador cero, entrada inválida)
   - Mostrar mensajes de error claros al usuario
   - Permitir reintentar la operación
   - Usar `scanner.nextLine()` después de `nextInt()` para limpiar el buffer

7. **Bucle principal:**
   ```kotlin
   fun main() {
       val scanner = Scanner(System.`in`)
       var opcion: Int
       
       do {
           mostrarMenu()
           opcion = scanner.nextInt()
           
           when (opcion) {
               1 -> realizarSuma(scanner)
               2 -> realizarResta(scanner)
               3 -> realizarMultiplicacion(scanner)
               4 -> realizarDivision(scanner)
               5 -> realizarComparacion(scanner)
               6 -> convertirADecimal(scanner)
               7 -> crearDesdeDecimal(scanner)
               8 -> mostrarEjemplos()
               0 -> println("¡Hasta luego!")
               else -> println("Opción inválida. Intente de nuevo.")
           }
           
           if (opcion != 0) {
               println("\nPresione Enter para continuar...")
               scanner.nextLine() // Limpiar buffer
               scanner.nextLine() // Esperar Enter
           }
       } while (opcion != 0)
       
       scanner.close()
   }
   ```

8. **Validaciones en el CLI:**
   - Verificar que las entradas sean números válidos
   - Manejar casos de denominador cero
   - Mostrar resultados formateados correctamente
   - Usar try-catch para capturar `InputMismatchException` cuando se ingrese texto en lugar de números

9. **Push final al repositorio** con el mensaje "Etapa 5: CLI implementado con ejemplos y validaciones".

---

## Entrega de Prompts Usados con Inteligencias Artificiales
Es **obligatorio** entregar todos los prompts utilizados con inteligencias artificiales (como ChatGPT, Copilot, etc.) durante el desarrollo del trabajo.

### ¿Cómo entregar los prompts?
1. Crear un archivo llamado `prompts.md` en la raíz del repositorio.
2. Copiar y pegar en ese archivo todos los prompts utilizados, junto con las respuestas obtenidas si las consideran relevantes.
3. Para cada prompt, indicar:
   - Fecha de uso
   - Herramienta utilizada (por ejemplo: ChatGPT, Copilot, etc.)
   - Fragmento de código o explicación generada (si aplica)

#### Ejemplo de formato para `prompts.md`:

```
### Prompt 1
- Fecha: 2024-04-10
- Herramienta: ChatGPT
- Prompt: "¿Cómo implemento la suma de fracciones en Kotlin?"
- Respuesta: "Puedes crear un método en la clase Fraccion que..."
```

---

## Criterios de Evaluación
- **Funcionalidad:** Todos los operadores y métodos implementados funcionan correctamente
- **Estructura:** Código bien organizado y siguiendo convenciones de Kotlin
- **Validaciones:** Manejo adecuado de casos borde y errores
- **Documentación:** Comentarios claros y explicativos
- **CLI:** Interfaz de usuario funcional y amigable
- **Ejemplos:** Casos de prueba incluidos en el CLI
- **Entrega de prompts:** Archivo `prompts.md` completo con todos los prompts utilizados
- **Commits:** Push realizado al finalizar cada etapa con mensajes descriptivos

¡Éxitos y a programar!
