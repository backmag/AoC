import java.io.File

class Day4 {
    companion object {

        fun q1() {
            var list = mutableListOf<List<String>>()
            var currentPairs = mutableListOf<String>()
            File("C:/Users/gusta/Documents/Egenstudier/AoC/2020/input/input4.txt").forEachLine {
                if (it != "") {
                    it.split(" ").forEach {
                        currentPairs.add(it)
                    }
                } else {
                    list.add(currentPairs)
                    currentPairs = mutableListOf<String>()
                }
            }
            val ctr = list.count {processId(it)}

            println("Found $ctr valid ids!")
        }

        private fun processId(list: List<String>): Boolean {
            var keyList = mutableListOf<String>()
            list.map {
                keyList.add(it.split(":")[0])
            }

            return ("byr" in keyList && "iyr" in keyList &&
                    "eyr" in keyList &&
                    "hgt" in keyList && "hcl" in keyList &&
                    "ecl" in keyList && "pid" in keyList)
        }

        fun q2() {
            var list = mutableListOf<List<String>>()
            var currentPairs = mutableListOf<String>()
            File("C:/Users/gusta/Documents/Egenstudier/AoC/2020/input/input4.txt").forEachLine {
                if (it != "") {
                    it.split(" ").forEach {
                        currentPairs.add(it)
                    }
                } else {
                    list.add(currentPairs)
                    currentPairs = mutableListOf()
                }
            }
            val ctr = list.count { processIdTwo(it) }
            println("Found $ctr valid ids!")
        }

        fun processIdTwo(list: List<String>): Boolean {
            var keyList = mutableMapOf<String, String>()
            val fields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

            list.forEach {
                keyList.put(
                    it.split(":")[0],
                    it.split(":")[1]
                )
            }
            if (!("byr" in keyList.keys && "iyr" in keyList.keys &&
                        "eyr" in keyList.keys &&
                        "hgt" in keyList.keys && "hcl" in keyList.keys &&
                        "ecl" in keyList.keys && "pid" in keyList.keys)
            ) {
                return false
            }
            fields.forEach {
                when (it) {
                    "byr" -> if (keyList["byr"]?.toInt() !in (1920..2002)) {
                        return false
                    }
                    "iyr" -> if (keyList["iyr"]?.toInt() !in (2010..2020)) {
                        return false
                    }
                    "eyr" -> if (keyList["eyr"]?.toInt() !in (2020..2030)) {
                        return false
                    }
                    "hgt" -> if (keyList["hgt"]?.endsWith("cm") == true) {
                        val cmhgt = keyList["hgt"]?.filter { it.isDigit() }?.toInt() ?: 0
                        if (cmhgt !in (150..193)) {
                            return false
                        }
                    } else if (keyList["hgt"]?.endsWith("in") == true) {
                        val inhgt = keyList["hgt"]?.filter { it.isDigit() }?.toInt() ?: 0
                        if (inhgt !in (59..76)) {
                            return false
                        }
                    } else {
                        return false
                    }
                    "hcl" -> if (!"^#[A-z0-9]{6}$".toRegex().containsMatchIn(keyList["hcl"].toString())) {
                        return false
                    }
                    "ecl" -> if (keyList["ecl"] !in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")) {
                        return false
                    }
                    "pid" -> if (keyList["pid"]?.length != 9 || keyList["pid"]?.count {
                            it.isDigit()
                        } != 9) {
                        return false
                    }
                }
            }
            return true
        }
    }
}


fun main() {
    Day4.q1()
}