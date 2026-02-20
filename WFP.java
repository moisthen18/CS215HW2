public class WFP {

    public static int wellFormedParExp(String exp) {
        Ar_Stack<Character> stack = new Ar_Stack<>();
        int matchCount = 0;

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return -1; 
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return -1; 
                }

                matchCount++; 
            }
        }

        if (!stack.isEmpty()) {
            return -1;
        }

        return matchCount; 
    }
}
