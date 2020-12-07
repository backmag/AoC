import java.io.File

class Day7 {
    companion object {
        private fun readLineSep(): MutableList<List<String>> {
            val list = mutableListOf<List<String>>()
            var entry = mutableListOf<String>()
            File("C:/Users/gusta/Documents/Egenstudier/AoC/2020/input/input6.txt").forEachLine { line ->
                if (line != "") {
                    entry.add(line)
                } else {
                    list.add(entry)
                    entry = mutableListOf<String>()
                }
            }
            list.add(entry)
            return list
        }

        fun q1() {
            val list = File("""C:\Users\gusta\Documents\Egenstudier\AoC\2020\input\input7.txt""")
                .readLines()
            val bagMap = mutableMapOf<String, List<String>>()
            list.forEach { str ->
                val entry = str.split("contain", ",").map { it.replace(".", "").trim() }
                bagMap[entry[0]] = entry.subList(1, entry.size)
                //println("${entry[0]} + ${bagMap[entry[0]]}")
            }
            var bagsToFind = mutableListOf("shiny gold")
            var newBagsToFind = mutableListOf<String>()
            var allOccuringBags = mutableSetOf<String>()
            while (bagsToFind.isNotEmpty()) {
                bagsToFind.forEach { bag ->
                    bagMap.forEach { mapEntry ->
                        mapEntry.value.forEach { mapList ->
                            if (mapList != "no other bags") {
                                val (nbr, entryBag) = """(\d) (\w+ \w+)""".toRegex().find(mapList)!!.destructured
                                if (bag == entryBag) {
                                    var newFind = mapEntry.key.split(" ")[0] + " " + mapEntry.key.split(" ")[1]
                                    newBagsToFind.add(newFind)
                                }
                            }
                        }
                    }
                }
                bagsToFind.map { allOccuringBags.add(it) }
                bagsToFind = mutableListOf<String>()
                newBagsToFind.map {
                    if (it != "no other bags") {
                        bagsToFind.add(it)
                    }
                }
                newBagsToFind = mutableListOf<String>()
            }
            println(allOccuringBags.size - 1)
        }

        fun q2() {
            val list = File("""C:\Users\gusta\Documents\Egenstudier\AoC\2020\input\test7.txt""")
                .readLines()
            val bagMap = mutableMapOf<String, List<String>>()
            list.forEach { str ->
                val entry = str.split("contain", ",").map { it.replace(".", "").trim() }
                bagMap[entry[0]] = entry.subList(1, entry.size)
            }
            var totalnbr = 0
            var bagsToFind = mutableListOf("1 shiny gold")
            var newBagsToFind = mutableListOf<String>()
            var allOccuringBags = mutableSetOf<String>()
            while (bagsToFind.isNotEmpty()) {
                bagsToFind.forEach { bag ->
                    bagMap.forEach { mapEntry ->
                        var key = mapEntry.key.split(" ")[0] + " " + mapEntry.key.split(" ")[1]
                        if (key == bag) {
                            println(mapEntry.value)
                        }
                        mapEntry.value.forEach { mapList ->
                            if (mapList != "no other bags") {
                                val (nbr, entryBag) = """(\d) (\w+ \w+)""".toRegex().find(mapList)!!.destructured
                                if (bag == entryBag) {
                                    var newFind = mapEntry.key.split(" ")[0] + " " + mapEntry.key.split(" ")[1]
                                    newBagsToFind.add(newFind)
                                }
                            }
                        }
                    }
                }
                bagsToFind.map { allOccuringBags.add(it) }
                bagsToFind = mutableListOf<String>()
                newBagsToFind.map {
                    if (it != "no other bags") {
                        bagsToFind.add(it)
                    }
                }
                newBagsToFind = mutableListOf<String>()
            }
            println(allOccuringBags.size - 1)
        }
    }
}

fun main() {
    //Day7.q1()
    Day7.q2()
}