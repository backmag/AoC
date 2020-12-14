import java.io.File
import java.math.BigInteger
import kotlin.math.ceil
import kotlin.math.roundToInt

class Day13 {
    companion object {
        var est = 0
        fun q1() {
            var list = File("C:\\Users\\gusta\\Documents\\Egenstudier\\AoC\\2020\\input\\input13.txt")
                .readLines()
            est = list[0].toInt()
            val ids = list[1].split(",")
            var buses = mutableListOf<Int>()
            ids.forEach {
                if (it != "x") {
                    buses.add(it.toInt())
                }
            }
            val (bestId, bestTime) = findClosest(buses)
            val waitTime = bestTime!! - est
            println("The best bus to take is $bestId")
            println("Answer: ${waitTime * bestId!!}")
        }

        fun findClosest(buses: List<Int>): Array<Int?> {
            var times = mutableListOf<Int>()
            buses.forEach {
                times.add(ceil((est / it.toDouble())).toInt() * it)
            }
            val bestTime = times.min()
            val bestIdx = times.indexOf(bestTime)
            return arrayOf(buses[bestIdx], bestTime)
        }

        fun q2() {
            var list = File("C:\\Users\\gusta\\Documents\\Egenstudier\\AoC\\2020\\input\\input13.txt")
                .readLines()
            val pattern = list[1].split(",")
//            val pattern = "1789,37,47,1889".split(",")
            var largestValue = 0
            val map = mutableMapOf<Int, Int>()
            pattern.forEachIndexed { i, v ->
                if (v != "x") {
                    map.put(v.toInt(), i)
                    if (v.toInt() > largestValue) {
                        largestValue = v.toInt()
                    }
                }
            }
            var valid = false
            var ctr = 284290980.toBigInteger()
            var printctr = 0
            while (!valid) {
                if (printctr == 10000000) {
                    println(ctr)
                    printctr = 0
                }
                valid = validatePattern(map, ctr)
                if (!valid) {
                    ctr += 298798939.toBigInteger()
                }
                printctr++
            }
            println("First valid at: ${ctr}")
        }

        fun q2v2() {
            var list = File("C:\\Users\\gusta\\Documents\\Egenstudier\\AoC\\2020\\input\\input13.txt")
                .readLines()
            val pattern = list[1].split(",")
//            val pattern = "1789,37,47,1889".split(",")
            var largestValue = 0
            val map = mutableMapOf<Int, Int>()
            pattern.forEachIndexed { i, v ->
                if (v != "x") {
                    map.put(v.toInt(), i)
                    if (v.toInt() > largestValue) {
                        largestValue = v.toInt()
                    }
                }
            }
            var valid = false
            var ctr = BigInteger.ZERO
            var prevctr = BigInteger.ZERO
            while (!valid) {
                if ((ctr + map[457]!!.toBigInteger()) % 457.toBigInteger() == BigInteger.ZERO &&
                    (ctr + map[431]!!.toBigInteger()) % 431.toBigInteger() == BigInteger.ZERO &&
                    (ctr + map[41]!!.toBigInteger()) % 41.toBigInteger() == BigInteger.ZERO &&
                        ctr % 37.toBigInteger() == BigInteger.ZERO) {
                    println("Ctr:${ctr}, difference: ${ctr - prevctr}")
                    prevctr = ctr
                }
                if (ctr > 100000000000.toBigInteger()) {
                    valid = true
                }
                ctr += BigInteger.ONE
            }
            println("First valid at: ${ctr}")
        }

        fun validatePattern(map: Map<Int, Int>, value: BigInteger): Boolean {
            map.forEach {
                if ((value + it.value.toBigInteger()) % it.key.toBigInteger() != BigInteger.ZERO) {
                    return false
                }
            }
            return true
        }
    }
}

fun main() {
//    Day13.q1()
    Day13.q2()
//    Day13.q2v2()
}

