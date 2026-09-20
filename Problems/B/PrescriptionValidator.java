package B;

import java.util.*;

public class PrescriptionValidator {

    public static boolean isValid(String formula) {
        if (formula == null) {
            throw new IllegalArgumentException();
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : formula.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String formula = "(Medication[Dose{Mg}])";
        System.out.println(isValid(formula));
    }
}