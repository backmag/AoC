import java.io.File

class Day4 {
    companion object {
        private fun readInput(): MutableList<String> {
            var list = mutableListOf<String>()
            File("C:/Users/gusta/Documents/Egenstudier/AoC/2020/input/input4.txt").forEachLine {
                list.add(it)
            }
            return list
        }

        fun q1() {
            val array = readInput()
            array.forEach {
                println(it)
            }
        }

        fun q2() {
            val array = readInput()
            array.forEach {
                println(it)
            }

        }
    }
}


fun main() {
    Day4.q1()
}