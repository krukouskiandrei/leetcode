package by.krukouski.hackerrank.stacks;

import java.util.*;

public class BalancedBrackets {

    private static final Map<Character, Character> balanceOfBrackets = getBalancedBrackets();

    public static boolean isBalanced(final String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        char[] brackets = s.toCharArray();
        LinkedList<Character> bracketPoll = new LinkedList<>();
        for (char bracket : brackets) {
            Character startBracket = getStartBracket(bracket);
            if (startBracket == null) {
                bracketPoll.add(bracket);
            } else if (startBracket.equals(bracketPoll.peekLast())) {
                bracketPoll.pollLast();
            } else {
                return false;
            }
        }

        return bracketPoll.isEmpty();
    }

    private static Character getStartBracket(final char endBracket) {
        return balanceOfBrackets.get(endBracket);
    }

    private static Map<Character, Character> getBalancedBrackets() {
        final Map<Character, Character> balanceOfBrackets = new HashMap<>();
        balanceOfBrackets.put(')', '(');
        balanceOfBrackets.put(']', '[');
        balanceOfBrackets.put('}', '{');
        return balanceOfBrackets;
    }
}
