class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');

        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) stack.pop();
            else stack.push(c);
        }
        return stack.isEmpty();
    }
}
