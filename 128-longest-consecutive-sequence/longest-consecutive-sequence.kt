class Solution {
    fun longestConsecutive(nums: IntArray): Int {

        val set = nums.toHashSet()
        var maxLen = 0

        for (num in set) {

            // Start only if it's the beginning of sequence
            if (!set.contains(num - 1)) {

                var current = num
                var length = 1

                while (set.contains(current + 1)) {
                    current++
                    length++
                }

                maxLen = maxOf(maxLen, length)
            }
        }

        return maxLen
    }
}