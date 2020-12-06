import java.io.File

class Day5 {
    companion object {
        fun q1() {
            val seatIds = mutableListOf<Int>()
            File("C:/Users/gusta/Documents/Egenstudier/AoC/2020/input/input5.txt").forEachLine { line ->
                seatIds.add(
                    line.slice(0..6).replace("B", "1")
                        .replace("F", "0")
                        .toInt(2) * 8 +
                            line.slice(7..9).replace("R", "1")
                                .replace("L", "0")
                                .toInt(2)
                )
            }
            println("The largest seat id is ${seatIds.max()}!")
        }

        fun q2() {
            val seatIds = mutableListOf<Int>()
            File("C:/Users/gusta/Documents/Egenstudier/AoC/2020/input/input5.txt").forEachLine { line ->
                seatIds.add(
                    line.slice(0..6).replace("B", "1")
                        .replace("F", "0")
                        .toInt(2) * 8 +
                            line.slice(7..9).replace("R", "1")
                                .replace("L", "0")
                                .toInt(2)
                )
            }
            val mySeatId = (seatIds.min()!!..seatIds.max()!!).first { it !in seatIds }
            println("My seat id is $mySeatId!")
        }
    }
}

fun main() {
    Day5.q1()
    Day5.q2()
}