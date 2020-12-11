import java.io.File

class Day11 {
    companion object {
        fun q1() {
            var list = File("C:\\Users\\gusta\\Documents\\Egenstudier\\AoC\\2020\\input\\test11.txt")
                .readLines().toMutableList()
            var equal = false
            var newList = mutableListOf<String>()
            var itr = 0
            for (i in list.indices) {
                println(list[i])
            }
            while (!equal) {
                newList = update(list).map { it.joinToString("") }.toMutableList()
                equal = checkEqual(newList, list)
                list.clear()
                newList.forEach {list.add(it)}
                println("itr: $itr")
                itr++
                for (i in list.indices) {
                    println(list[i])
                }
                if (itr > 2) {
                    break
                }
            }
            println(newList.sumBy { it.count { it == "L".single() } })
        }

        fun checkEqual(newList: List<String>, list: List<String>): Boolean {
            for (i in 0 until list.size) {
                for (j in 0 until list[0].length) {
                    if (newList[i][j] != list[i][j]) {
                        return false
                    }
                }
            }
            println("All equal.")
            return true
        }

        fun update(list: List<String>): List<CharArray> {
            var updatedList = mutableListOf<CharArray>()
            list.forEach { updatedList.add(it.toCharArray()) }
            var cols = list[0].length
            var rows = list.size
            for (col in 0 until cols) {
                for (row in 0 until rows) {
                    val newChar = updateSeat(col, row, updatedList)
                    updatedList[row][col] = newChar
                }
            }
            return updatedList
        }

        fun updateSeat(col: Int, row: Int, list: List<CharArray>): Char {
            if (list[row][col] == ".".single()) {
                return ".".single()
            }
            if (list[row][col] == "L".single() && countAdjacent(col, row, list) == 0) {
                return "#".single()
            } else if (countAdjacent(col, row, list) >= 4) {
                return "L".single()
            }
            return "L".single()
        }

        fun countAdjacent(col: Int, row: Int, list: List<CharArray>): Int {
            if (col == 0) {
                if (row == 0) {
                    println("CORNER 1")
                    return listOf<Char>(list[0][1], list[1][0], list[1][1]).count { it == "#".single() }
                } else if (row == list.size - 1) {
                    println("CORNER 2")
                    return listOf<Char>(
                        list[list.size - 2][1],
                        list[list.size - 2][0],
                        list[list.size - 1][1]
                    ).count { it == "#".single() }
                } else {
                    return listOf<Char>(
                        list[row - 1][col], list[row - 1][col + 1], list[row][col + 1],
                        list[row + 1][col + 1], list[row + 1][col]
                    ).count { it == "#".single() }
                }
            } else if (col == list[0].size - 1) {
                if (row == 0) {
                    println("CORNER 3 ADJ ${listOf<Char>(
                        list[0][list[0].size - 2],
                        list[1][list[0].size - 1],
                        list[1][list[0].size - 2]
                    ).count { it == "#".single() }}")
                    return listOf<Char>(
                        list[0][list[0].size - 2],
                        list[1][list[0].size - 1],
                        list[1][list[0].size - 2]
                    ).count { it == "#".single() }
                } else if (row == list.size - 1) {
                    println("CORNER 4 ADJ ${listOf<Char>(
                        list[list.size - 1][list[0].size - 2],
                        list[list.size - 2][list[0].size - 1],
                        list[list.size - 2][list[0].size - 2]
                    ).count { it == "#".single() }}")
                    return listOf<Char>(
                        list[list.size - 1][list[0].size - 2],
                        list[list.size - 2][list[0].size - 1],
                        list[list.size - 2][list[0].size - 2]
                    ).count { it == "#".single() }
                } else {
                    return listOf<Char>(
                        list[row - 1][col], list[row - 1][col - 1], list[row][col - 1],
                        list[row + 1][col - 1], list[row + 1][col]
                    ).count { it == "#".single() }
                }
            }
            if (row == 0) {
                return listOf<Char>(
                    list[row][col - 1], list[row][col + 1], list[row + 1][col - 1],
                    list[row + 1][col], list[row + 1][col + 1]
                ).count { it == "#".single() }
            } else if (row == list.size - 1) {
                return listOf<Char>(
                    list[row][col - 1], list[row][col + 1], list[row - 1][col - 1],
                    list[row - 1][col], list[row - 1][col + 1]
                ).count { it == "#".single() }
            } else {
                return listOf<Char>(
                    list[row - 1][col - 1], list[row - 1][col], list[row - 1][col + 1],
                    list[row][col - 1], list[row][col + 1],
                    list[row + 1][col - 1], list[row + 1][col], list[row + 1][col + 1]
                ).count { it == "#".single() }

            }
        }

        fun q2() {
            var list = File("C:\\Users\\gusta\\Documents\\Egenstudier\\AoC\\2020\\input\\input9.txt")
                .readLines()
        }
    }
}

fun main() {
    Day11.q1()

}