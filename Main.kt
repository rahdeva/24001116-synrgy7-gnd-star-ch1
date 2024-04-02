import kotlin.text.toIntOrNull as toIntOrNull

fun main() {
    var continueProgram = true

    while (continueProgram) {
        println("Masukkan nilai n untuk ukuran segitiga:")
        val n = readLine()?.toIntOrNull() ?: 0 // Meminta input nilai n dari pengguna

        if (n > 0) {
            println("Pilih pola segitiga:")
            println("1. Pyramid")
            println("2. Inverted Pyramid")
            println("3. Both Side Pyramid")
            println("4. X Pattern")
            println("5. Outline Pyramid with Empty Inside")
            println("6. Keluar")

            val choice = readLine()?.toIntOrNull() ?: 0 // Meminta input pilihan pola dari pengguna

            when (choice) {
                1 -> Segitiga(n).printPyramid() // Panggil metode printPyramid jika pilihan adalah 1
                2 -> Segitiga(n).printInvertedPyramid() // Panggil metode printInvertedPyramid jika pilihan adalah 2
                3 -> Segitiga(n).printBothSidePyramid() // Panggil metode printBothSidePyramid jika pilihan adalah 3
                4 -> Segitiga(n).printXPattern() // Panggil metode printXPattern jika pilihan adalah 4
                5 -> Segitiga(n).printOutlinePyramid() // Panggil metode printOutlinePyramid jika pilihan adalah 5
                6 -> continueProgram = false // Keluar dari program jika pilihan adalah 6
                else -> println("Pilihan tidak valid") // Jika pilihan tidak sesuai
            }
        } else {
            println("Masukkan nilai n yang valid (bilangan bulat positif).")
        }
    }
}

// Kelas untuk merepresentasikan segitiga
// OOP Concept : Abstraction & Private Access Modifier
class Segitiga(private val n: Int) {

    // Fungsi untuk mencetak segitiga pola "Pyramid"
    fun printPyramid() {
        println("Pyramid:")
        for (i in 1..n) {
            for (j in 1..n - i) print(" ")
            for (k in 1..i) print("* ")
            println()
        }
    }

    // Fungsi untuk mencetak segitiga pola "Inverted Pyramid"
    fun printInvertedPyramid() {
        println("Inverted Pyramid:")
        for (i in n downTo 1) {
            for (j in 1 until n - i + 1) print(" ")
            for (k in 1..i) print("* ")
            println()
        }
    }

    // Fungsi untuk mencetak segitiga pola "Both Side Pyramid"
    fun printBothSidePyramid() {
        println("Both Side Pyramid:")
        for (i in 1..n) {
            for (j in 1..n - i) print(" ")
            for (k in 1..(2 * i - 1)) print("*")
            println()
        }
        for (i in n - 1 downTo 1) {
            for (j in 1..n - i) print(" ")
            for (k in 1..(2 * i - 1)) print("*")
            println()
        }
    }

    // Fungsi untuk mencetak segitiga pola "X Pattern"
    fun printXPattern() {
        println("X Pattern:")
        for (i in 1..n) {
            for (j in 1..n) {
                if (j == i || j == n - i + 1) print("*") else print(" ")
            }
            println()
        }
    }

    // Fungsi untuk mencetak segitiga pola "Outline Pyramid with Empty Inside"
    fun printOutlinePyramid() {
        println("Outline Pyramid with Empty Inside:")
        for (i in 1..n) {
            for (j in 1..n - i) print(" ")
            for (k in 1..2 * i - 1) {
                if (k == 1 || k == 2 * i - 1 || i == n) print("*") else print(" ")
            }
            println()
        }
    }
}