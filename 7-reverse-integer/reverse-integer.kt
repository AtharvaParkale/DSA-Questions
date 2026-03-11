class Solution {
    fun reverse(x: Int): Int {

        var num = x
        var ans = 0

        while (num != 0) {

            val digit = num % 10
            num /= 10

            // overflow check
            if (ans > Int.MAX_VALUE / 10 || ans < Int.MIN_VALUE / 10) return 0

            ans = ans * 10 + digit
        }

        return ans
    }
}