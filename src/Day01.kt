fun main() {

    fun summedElfCalories(input: List<String>): List<Int> {
        return input.joinToString("\n")
            .split("\n\n")
            .map { elf ->
                elf.lines().sumOf {  itemCalories ->
                    itemCalories.toIntOrNull() ?: 0
                }
            }
    }

    // Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?
    fun part1(input: List<String>): Int {
        return summedElfCalories(input).max()
    }


    // Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
    fun part2(input: List<String>): Int {
        val elfs = summedElfCalories(input)
        val top3Elfs = elfs.sortedDescending().take(3)
        top3Elfs.forEachIndexed { idx, elfTotalCals ->
            println("Elf #$idx total calories: $elfTotalCals")
        }
        return top3Elfs.sum()
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(listOf("test_input")) == 0)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
