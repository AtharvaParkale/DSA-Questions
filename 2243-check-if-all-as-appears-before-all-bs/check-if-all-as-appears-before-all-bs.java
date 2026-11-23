class Solution {
    public boolean checkString(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i =0;i<s.length();i++){
            Character curr = s.charAt(i);

            if(curr=='a'){
                if(stack.isEmpty() || stack.peek()=='a'){
                    stack.push(curr);
                }
                else if(stack.peek()=='b'){
                    return false;
                }
            }
            else{
                stack.push(curr);
            }
        }

        return true;
    }
}