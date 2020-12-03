import java.io.File

class Day3 {
    companion object {
        fun q1() {
            var trees = 0
            var posX = 0
            File("C:/Users/gusta/Documents/Egenstudier/AoC/2020/input/input3.txt").forEachLine { line ->
                if (line[posX].toString() == "#") {
                    trees++
                }
                posX += 3
                if (posX >= line.length) {
                    posX -= line.length
                }
            }
            println("Answer q1: $trees")
        }

        fun q2() {
            var ans = checkSlope(1, 1)
            ans *= checkSlope(3, 1)
            ans *= checkSlope(5, 1)
            ans *= checkSlope(7, 1)
            ans *= checkSlope(1, 2)
            println("Multiplied trees: $ans")


        }

        fun checkSlope(right: Int, down: Int): Int {
            var trees = 0
            var posX = 0
            val skip = down == 2
            var skipNext = false
            File("C:/Users/gusta/Documents/Egenstudier/AoC/2020/input/input3.txt").forEachLine { line ->
                if (!skipNext) {
                    if (skip) {
                        skipNext = true
                    }
                    if (line[posX].toString() == "#") {
                        trees++
                    }
                    posX += right
                    if (posX >= line.length) {
                        posX -= line.length
                    }
                } else {
                    skipNext = false
                }
            }
            return trees
        }
    }
}

fun main() {
    Day3.q1()
    Day3.q2()
}