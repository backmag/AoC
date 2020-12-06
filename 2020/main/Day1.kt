import java.io.File

class Day1 {
    companion object {

        fun q1() {
            val list = mutableListOf<Int>()
            File("C:/Users/gusta/Documents/Egenstudier/AoC/2020/input/input1.txt").forEachLine {
                list.add(it.toInt())
            }
            list.forEach {
                if ((2020 - it) in list) {
                    println(it * (2020 - it))
                    return
                }
            }
        }

        fun q2() {
            val list = mutableListOf<Int>()
            File("C:/Users/gusta/Documents/Egenstudier/AoC/2020/input/input1.txt").forEachLine {
                list.add(it.toInt())
            }
            for (i in 0 until list.size) {
                for (j in i until list.size) {
                    if (2020 - list[i] - list[j] in list) {
                        println(list[i] * list[j] * (2020 - list[i] - list[j]))
                        return
                    }
                }
            }
        }
    }
}

fun main() {
    Day1.q1()
    Day1.q2()
}