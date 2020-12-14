import java.io.File
import java.math.BigInteger
import kotlin.reflect.typeOf

class Day14 {
    companion object {
        var map = mutableMapOf<Int, BigInteger>()
        fun q1() {
            var list = File("C:\\Users\\gusta\\Documents\\Egenstudier\\AoC\\2020\\input\\input14.txt")
                .readLines()
            var listIdx = 0
            var nbrs = mutableListOf<String>()
            var mask = ""
            var first = true
            while (listIdx < list.size) {
                if (list[listIdx].startsWith("ma")) {
                    if (first) {
                        mask = list[listIdx]
                        first = false
                    } else {
                        nbrs.forEach { processCommand(it, mask) }
                        mask = list[listIdx]
                        nbrs = mutableListOf<String>()
                    }
                } else {
                    nbrs.add(list[listIdx])
                }
                listIdx++
            }
            nbrs.forEach { processCommand(it, mask) }
            var sum = BigInteger.ZERO
            map.values.forEach { sum += it }
            println("The sum is $sum")

        }

        fun processCommand(c: String, mask: String) {
            var (idxS, vS) = """\w+\[(\d+)\] = (\d+)""".toRegex().find(c)!!.destructured
            var idx = idxS.toInt()
            var v = vS.toInt()
            var res = doBitwise(v, mask)
            map.put(idx, res)
        }

        fun doBitwise(v: Int, mask: String): BigInteger {
            var m = mask.split(" ")[2]
            var vrev = v.toString(2).reversed()
            var ret = ""

            mask.reversed().forEachIndexed { i, b ->
                when (b) {
                    "X".single() -> {
                        if (i > vrev.length - 1) {
                            ret = "0" + ret
                        } else {
                            ret = vrev[i] + ret
                        }
                    }
                    "0".single() -> ret = "0" + ret
                    "1".single() -> ret = "1" + ret
                }
            }
            return ret.toBigInteger(2)
        }

        fun q2() {
            var list = File("C:\\Users\\gusta\\Documents\\Egenstudier\\AoC\\2020\\input\\input14.txt")
                .readLines()
        }
    }
}

fun main() {
    Day14.q1()
//    Day14.q2()
}