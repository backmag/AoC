import java.io.File

class Day8 {
    companion object {
        fun q1() {
            val list = File("C:\\Users\\gusta\\Documents\\Egenstudier\\AoC\\2020\\input\\input8.txt").readLines()
            list.forEachIndexed { idx, s ->
                val r = """(\w+) ([+-]\d+)""".toRegex()
                val (op,v) = r.find(s)!!.destructured
                if (op == "jmp") {
                    var listCopy = list.toMutableList()
                    listCopy[idx] = "nop +0"
                    tryRun(listCopy)
                } else if (op == "nop") {
                    var listCopy = list.toMutableList()
                    listCopy[idx] = "jmp " + v
                    tryRun(listCopy)
                }
            }
        }

        private fun tryRun(list: List<String>) {
            var acc = 0
            var nextLine = 0
            var visitedRows = mutableSetOf<Int>()
            while (true) {
                if (nextLine >= list.size) {
                    println("Loop terminated! Acc value: $acc")
                    break
                }
                val info = processLine(list[nextLine])
                if (nextLine in visitedRows) {
                    break
                }
                visitedRows.add(nextLine)
                nextLine += info[0]
                acc += info[1]
            }
        }

        private fun processLine(line: String): List<Int> { // Returns relativePos, accDiff
            val r = """(\w+) ([+-]\d+)""".toRegex()
            val (op,v) = r.find(line)!!.destructured
            return when (op) {
                "acc" -> listOf(1, v.toInt())
                "jmp" -> listOf(v.toInt(), 0)
                else -> listOf(1,0)
            }
        }

        fun q2() {

        }
    }
}

fun main() {
    Day8.q1()
}