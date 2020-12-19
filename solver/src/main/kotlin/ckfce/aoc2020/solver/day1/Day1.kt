package ckfce.aoc2020.solver.day1

import ckfce.aoc2020.solver.DaySolver
import java.lang.IllegalStateException

class Day1 : DaySolver {

    internal fun parse(classpathFilename: String): ExpenseReport {
        val t = Day1::class.java.getResource(classpathFilename).readText()
        val el = t.lines().filter { it != "" }.map { it.toInt() }
        return ExpenseReport(el)
    }

    private fun solve(classpathFilename: String): String {
        val expenseReport = parse(classpathFilename)
        return expenseReport.fix().toString()
    }

    override fun example(): String {
        return solve("day1_1_example.txt")
    }

    override fun puzzle(): String {
        return solve("day1_1_puzzle.txt")
    }

    override fun secondExample(): String {
        TODO("Not yet implemented")
    }

    override fun secondPuzzle(): String {
        TODO("Not yet implemented")
    }
}

class ExpenseReport(val expenses: List<Int>) {

    companion object {
        const val TARGET = 2020
    }
    /**
     * Takes an int and a sorted list and returns the integer that would add up to
     * [TARGET] or -1
     */
    private fun check(i: Int, sorted: List<Int>): Int {
        for (c in sorted.indices.reversed()) {
            val r = i + sorted[c]
            if (r == TARGET) return sorted[c]
            if (r < TARGET) return -1
        }
        return -1
    }

    fun fix(): Int {
        val sorted = expenses.sorted()
        for (i in sorted) {
            val c = check(i, sorted)
            if (c != -1) {
                return i * c
            }
        }
        throw IllegalStateException("No solution to $TARGET in expense report")
    }

}
