class Solution {
    fun minWindow(s: String, t: String): String {

        if (s.length < t.length) return ""

        val freq = IntArray(128)

        for (c in t) {
            freq[c.code]++
        }

        var start = 0
        var minStart = 0
        var minLen = Int.MAX_VALUE
        var count = t.length

        for (end in s.indices) {

            // include current character
            if (freq[s[end].code] > 0) {
                count--
            }
            freq[s[end].code]--

            // when all characters matched
            while (count == 0) {

                if (end - start + 1 < minLen) {
                    minLen = end - start + 1
                    minStart = start
                }

                // shrink window
                freq[s[start].code]++
                if (freq[s[start].code] > 0) {
                    count++
                }
                start++
            }
        }

        return if (minLen == Int.MAX_VALUE) ""
        else s.substring(minStart, minStart + minLen)
    }
}