import java.io.File

class Day6 {
    companion object {

        private fun readLineSep(): MutableList<List<String>> {
            val list = mutableListOf<List<String>>()
            var entry = mutableListOf<String>()
            File("C:/Users/gusta/Documents/Egenstudier/AoC/2020/input/input6.txt").forEachLine { line ->
                if (line != "") {
                    entry.add(line)
                } else {
                    list.add(entry)
                    entry = mutableListOf<String>()
                }
            }
            list.add(entry)
            return list
        }

        fun q1() {
            val input = readLineSep()
            val sol = input.map {
                it.map { it.toSet() }
                    .reduce { a, b -> a.union(b) }
                    .size
            }.sum()
            println(sol)
        }

        fun q2() {
            val input = readLineSep()
            val sol = input.map {
                it.map { it.toSet() }
                    .reduce { a, b -> a.intersect(b) }
                    .size
            }.sum()
            println(sol)
        }
    }
}

fun main() {
    Day6.q1()
    Day6.q2()
}