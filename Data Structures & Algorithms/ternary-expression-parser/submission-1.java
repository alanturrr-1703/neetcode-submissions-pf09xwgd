
class Solution {
    public String parseTernary(String expression) {

        Stack<String> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; ) {

            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                int j = i;
                while (j >= 0 && Character.isDigit(expression.charAt(j))) {
                    j--;
                }

                stack.push(expression.substring(j + 1, i + 1));
                i = j;
            }
            else if (c == 'T' || c == 'F') {

                if (!stack.isEmpty() && stack.peek().equals("?")) {

                    stack.pop(); // ?
                    String trueVal = stack.pop();
                    stack.pop(); // :
                    String falseVal = stack.pop();

                    stack.push(c == 'T' ? trueVal : falseVal);

                } else {
                    stack.push(String.valueOf(c));
                }

                i--;
            }
            else {
                stack.push(String.valueOf(c));
                i--;
            }
        }

        return stack.peek();
    }
}