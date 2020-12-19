package ckfce.aoc2020.solver.day1

import org.junit.Test
import kotlin.test.assertEquals

class Day1Test {

    @Test
    fun testExample() {
        val day1 = Day1()
        assertEquals("514579", day1.example())
    }

    @Test
    fun testPuzzle() {
        val day1 = Day1()
        println(day1.puzzle())
    }
}
