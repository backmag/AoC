import java.io.File

class Day2 {
    companion object {

        fun q1() {
            val list = File("""C:\Users\gusta\Documents\Egenstudier\AoC\2020\input\input2.txt""")
                .readLines()
            println(list.map { str ->
                val (lower, upper, v, pw) = """(\d+)-(\d+) (\w): (\w+)""".toRegex().find(str)!!.destructured
                pw.count { it == v.single() } in (lower.toInt()..upper.toInt())
            }.count { it })
        }

        fun q2() {
            val list = File("""C:\Users\gusta\Documents\Egenstudier\AoC\2020\input\input2.txt""")
                .readLines()
            println(list.map { str ->
                val (first, second, v, pw) = """(\d+)-(\d+) (\w): (\w+)""".toRegex().find(str)!!.destructured
                (pw[first.toInt() - 1] == v.single()) xor (pw[second.toInt() - 1] == v.single())
            }.count { it })
        }
    }
}


fun main() {
    Day2.q1()
    Day2.q2()
}