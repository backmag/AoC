import java.io.File

fun q1() {
    var minCount = 0
    var maxCount = 0
    var charToCount: Char?
    var password = ""
    var nbrValid = 0

    File("C:/Users/gusta/Documents/Egenstudier/AoC2020/main/input/input2.txt").forEachLine {line ->
        val split = line.split("-", " ", ":")
        minCount = split[0].toInt()
        maxCount = split[1].toInt()
        charToCount = split[2].single()
        password = split[4]
        val count = password.filter {it == charToCount}.count()
        if (count >= minCount && count <= maxCount) {nbrValid++}
    }
    println("Found $nbrValid valid passwords.")
}

fun q2() {
    var idx1 = 0
    var idx2 = 0
    var charToCount: Char?
    var password = ""
    var nbrValid = 0
    var totalNbr = 0

    File("C:/Users/gusta/Documents/Egenstudier/AoC-2020/2/input/input.txt").forEachLine {line ->
        totalNbr++
        val split = line.split("-", " ", ":")
        idx1 = split[0].toInt()
        idx2 = split[1].toInt()
        charToCount = split[2].single()
        password = split[4]
        if (password[idx1 - 1] == charToCount) {
            if (password[idx2 - 1]  != charToCount) {nbrValid++}
        } else if (password[idx2 - 1] == charToCount) {nbrValid++}
    }
    println("Found $nbrValid valid passwords.")
}


fun main() {
    q1()
    q2()
}