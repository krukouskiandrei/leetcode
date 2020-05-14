package by.krukouski.hackerrank.trie;

import by.krukouski.hackerrank.model.TrieNode;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Contact {

    private static final String ADD_COMMAND = "add";
    private static final String FIND_COMMAND = "find";

    private final static TrieNode root = new TrieNode("");

    public static int[] contacts(final String[][] queries) {
        List<Integer> result = new LinkedList<>();

        for (String[] query : queries) {
            final String command = query[0];
            final String value = query[1];
            if (ADD_COMMAND.equals(command)) {
                Instant start = Instant.now();
                addContact(value);
                Instant finish = Instant.now();
                System.out.println("Add " + value + " contact: " + Duration.between(start, finish).toNanos());
            } else if (FIND_COMMAND.equals(command)) {
                Instant start = Instant.now();
                int count = findContact(value);
                Instant finish = Instant.now();
                System.out.println("Find " + value + " contact: " + Duration.between(start, finish).toNanos());
                Instant start1 = Instant.now();
                result.add(count);
                Instant finish1 = Instant.now();
                System.out.println("Add count of " + value + " contact: " + Duration.between(start1, finish1).toNanos());
            } else {
                throw new IllegalArgumentException("Wrong query: " + query);
            }
        }

        Instant start = Instant.now();
        int[] res = result.stream().mapToInt(i -> i).toArray();
        Instant finish = Instant.now();
        System.out.println("Create array of counts: " + Duration.between(start, finish).toNanos());
        return res;
    }

    /*private static void addContact(final String contact) {
        //final String[] lettersOfContact = contact.split("");
        TrieNode newNode;
        TrieNode tmpNode = null;
        for (int i = 0; i < contact.length(); i++) {
            String letter = Character.toString(contact.charAt(i));
            if (tmpNode == null) {
                tmpNode = root.getChild(letter);
                if (tmpNode == null) {
                    tmpNode = new TrieNode(contact);
                    root.setChild(tmpNode);
                }
                tmpNode.addWord();
                continue;
            }


            newNode = tmpNode.getChild(letter);
            if (newNode == null) {
                newNode = new TrieNode(letter);
                tmpNode.setChild(newNode);
            }

            tmpNode = newNode;
            tmpNode.addWord();
        }
        if(tmpNode != null) {
            tmpNode.markValue();
        }
    }*/

    private static void addContact(final String contact) {
        final String[] lettersOfContact = contact.split("");
        TrieNode newNode;
        TrieNode tmpNode = null;
        for (String letter : lettersOfContact) {
            if (tmpNode == null) {
                tmpNode = root.getChild(letter);
                if (tmpNode == null) {
                    tmpNode = new TrieNode(letter);
                    root.setChild(tmpNode);
                }
                tmpNode.addWord();
                continue;
            }

            newNode = tmpNode.getChild(letter);
            if (newNode == null) {
                newNode = new TrieNode(letter);
                tmpNode.setChild(newNode);
            }

            tmpNode = newNode;
            tmpNode.addWord();
        }
        if(tmpNode != null) {
            tmpNode.markValue();
        }
    }

    private static int findContact(final String contact) {
        final String[] lettersOfContact = contact.split("");
        TrieNode newNode;
        TrieNode tmpNode = null;
        for (String letter : lettersOfContact) {
            if (tmpNode == null) {
                tmpNode = root.getChild(letter);
                if (tmpNode == null) {
                    return 0;
                }
                continue;
            }

            newNode = tmpNode.getChild(letter);
            if (newNode == null) {
                return 0;
            }
            tmpNode = newNode;
        }

        return tmpNode !=null ? tmpNode.getCountOfWords() : 0;
    }

}
