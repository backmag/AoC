import java.io.File
import java.math.BigInteger

class Day9 {
    companion object {
        fun q1() {
            val list = File("C:\\Users\\gusta\\Documents\\Egenstudier\\AoC\\2020\\input\\input9.txt")
                .readLines().map {it.toBigInteger()}
            var valid = true
            var startIdx = 0
            while (valid) {
                val s = list.slice(startIdx..(startIdx + 25))
                valid = validSlice(s)
                startIdx += 1
            }
            println(list[startIdx + 24])

        }

        private fun validSlice(list: List<BigInteger>): Boolean {
            val preamble = list.slice(0..(list.size - 1))
            val entry = list.last()
            for (i in 0 until preamble.size) {
                for (j in 1 until preamble.size) {
                    if (preamble[i] + preamble[j] == entry) {
                        return true
                    }
                }
            }
            return false
        }

        fun q2() {
            var list = File("C:\\Users\\gusta\\Documents\\Egenstudier\\AoC\\2020\\input\\input9.txt")
                .readLines().map {it.toBigInteger()}
            val toFind = (1639024365).toBigInteger()
            val toFindIdx = 653
            list = list.slice(0..toFindIdx)
            var startIdx = 0
            var found = false
            while (!found) {
                found = tryFind(startIdx, list, toFind)
                startIdx++
            }

        }
        private fun tryFind(start: Int, list: List<BigInteger>, toFind: BigInteger): Boolean {
            var rangeSize = 2
            var end = start + rangeSize - 1
            while (end < list.size) {
                var sublist = list.slice(start..end)
                var sum = (0).toBigInteger()
                sublist.forEach { sum += it }
                if (sum == toFind) {
                    var min = sublist.minBy { it.toInt()} ?: BigInteger.ZERO
                    var max = sublist.maxBy {it.toInt()} ?: BigInteger.ZERO
                    println(min + max)
                    return true
                }
                end += 1
            }
            return false
        }
    }
}

fun main() {
    Day9.q1()
    Day9.q2()
}