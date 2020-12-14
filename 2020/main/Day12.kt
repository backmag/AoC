import java.io.File
import kotlin.math.abs

class Day12 {
    companion object {
        var x = 0
        var y = 0
        var wX = 10
        var wY = -1
        var dir = 90

        fun q1() {
            var list = File("C:\\Users\\gusta\\Documents\\Egenstudier\\AoC\\2020\\input\\input12.txt")
                .readLines()
            list.forEach {
                executeCommand1(it)
                println("Dir: ($dir)")
            }
            println(Math.abs(x) + Math.abs(y))
        }

        fun executeCommand1(s: String) {
            var (c, v) = "(\\w)(\\d+)".toRegex().find(s)!!.destructured
            var d = v.toInt()
            when (c) {
                "N" -> y -= d
                "E" -> x += d
                "S" -> y += d
                "W" -> x -= d
                "L" -> dir -= d
                "R" -> dir = (dir + d) % 360
                "F" -> goForward(d)
            }
            if (dir < 0) {
                dir += 360
            }
        }

        fun goForward(dist: Int) {
            when (dir) {
                0 -> y -= dist
                90 -> x += dist
                180 -> y += dist
                270 -> x -= dist
            }
        }

        fun q2() {
            x = 0
            y = 0
            var list = File("C:\\Users\\gusta\\Documents\\Egenstudier\\AoC\\2020\\input\\input12.txt")
                .readLines()
            list.forEach {
                executeCommand2(it)
            }
            println(abs(x) + abs(y))
        }

        fun executeCommand2(s: String) {
            var (c, v) = "(\\w)(\\d+)".toRegex().find(s)!!.destructured
            var d = v.toInt()
            when (c) {
                "N" -> wY -= d
                "E" -> wX += d
                "S" -> wY += d
                "W" -> wX -= d
                "L" -> rotateLeft(d)
                "R" -> rotateRight(d)
                "F" -> {
                    x += wX * d
                    y += wY * d
                }
            }
        }

        fun rotateLeft(d: Int) {
            var newY = 0
            var newX = 0
            when (d) {
                90 -> {
                    newY = -wX
                    newX = wY
                }
                180 -> {
                    newY = -wY
                    newX = -wX
                }
                270 -> {
                    newY = wX
                    newX = -wY
                }
            }
            wY = newY
            wX = newX
        }

        fun rotateRight(d: Int) {
            when (d) {
                90 -> rotateLeft(270)
                180 -> rotateLeft(180)
                270 -> rotateLeft(90)
            }
        }
    }

}

fun main() {
    Day12.q1()
    Day12.q2()
}