import java.io.File

class Day10 {
    companion object {
        fun q1() {
            var list = File("C:\\Users\\gusta\\Documents\\Egenstudier\\AoC\\2020\\input\\input10.txt")
                .readLines().map { it.toInt() }

            var j1 = 0
            var j2 = 0
            var j3 = 0
            val usedJolts = mutableSetOf<Int>()
            var currentVolt = 0
            var nextVolt = 0
            while (usedJolts.size < list.size) {
                nextVolt = getNext(list, currentVolt)
                when (nextVolt - currentVolt) {
                    1 -> j1++
                    2 -> j2++
                    3 -> j3++
                }
                currentVolt = nextVolt

                usedJolts.add(nextVolt)
            }
            println(j1)
            println(j2)
            println(j3)
            println(j1 * (j3 + 1))
        }

        fun q2() {
            var list = File("C:\\Users\\gusta\\Documents\\Egenstudier\\AoC\\2020\\input\\test2_10.txt")
                .readLines()
            var l = list.map { it.toInt() }.sorted()
            var totNbr = 1L
            var idx = l.size - 2
            println(l)
            while (idx > 2) {
                if (l[idx] - l[idx - 3] == 3) {
                    totNbr *= 4
                    println("Idx: ${l[idx]} ${l[idx] - 1} ${l[idx - 2]} ${l[idx - 3]}")
                } else if (l[idx] - l[idx - 2] == 2) {
                    totNbr *= 2
                    println("Idx: ${l[idx]} ${l[idx] - 1} ${l[idx - 2]}")
                    println(totNbr)
                }
                idx--
            }
            println(totNbr)
        }

        fun q21() {
            var list = File("C:\\Users\\gusta\\Documents\\Egenstudier\\AoC\\2020\\input\\test2_10.txt")
                .readLines()
            var l = list.map { it.toInt() }.sorted()
            var idx = 1


        }

        private fun getNext(list: List<Int>, currentVolt: Int): Int {
            var twoVolt = -1
            var threeVolt = -1
            list.forEach {
                if (it - currentVolt == 1) {
                    return it
                } else if (it - currentVolt == 2) {
                    twoVolt = it
                } else if (it - currentVolt == 3) {
                    threeVolt = it
                }
            }
            if (twoVolt != -1) {
                return twoVolt
            }
            return threeVolt
        }
    }
}

fun main() {
//    Day10.q1()
    Day10.q2()
}
