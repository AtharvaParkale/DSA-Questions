class Solution {
    fun solve(s:String, p:String):Boolean{
        if(p.length == 0){
            return s.length == 0
        }

        var first_char_matched = false

        if(s.length>0 && ( p[0] ==s[0] || p[0] =='.')){
            first_char_matched = true
        }

        if(p.length >= 2 && p[1] == '*'){
            val  not_take:Boolean = solve(s,p.substring(2))
            val take: Boolean = first_char_matched && solve(s.substring(1),p)

            return not_take || take
        }

        return first_char_matched && solve(s.substring(1),p.substring(1));
    }

    fun isMatch(s: String, p: String): Boolean {
        return solve(s,p)
    }
}