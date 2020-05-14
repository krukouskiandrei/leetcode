package by.krukouski.hackerrank;

import by.krukouski.hackerrank.binarytree.TreeMetrics;
import by.krukouski.hackerrank.heap.RunningMedian;
import by.krukouski.hackerrank.stacks.BalancedBrackets;
import by.krukouski.hackerrank.trie.Contact;
import by.krukouski.leetcode.binarytree.Codec;
import by.krukouski.leetcode.binarytree.TreeNode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

import static by.krukouski.hackerrank.trie.Contact.contacts;

public class Runner {



    public static void main(String[] args) throws IOException {
        /*String nodes = "[3,2,5,1,null,4,6,null,null,null,null,null,null,null,7]";

        Codec codec = new Codec();

        TreeNode root = codec.deserialize(nodes);
        int heightOfTree = TreeMetrics.height(root);
        System.out.println(heightOfTree);*/

        //String bracketsLine = "{[()]}";
        //String bracketsLine = "[{{()}{()}}[]]";
        /*String bracketsLine = "{[(])}";
        System.out.println(BalancedBrackets.isBalanced(bracketsLine));*/

        /*String[][] queries = {
                {"add", "hack"},
                {"add", "hackerrank"},
                {"add", "hacksdferrank"},
                {"find", "hac"},
                {"find", "hackerr"}
        };

        int[] result = Contact.contacts(queries);

        for (int i : result) {
            System.out.println(i);
        }*/

        /*List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        int[] result = list.stream().mapToInt(i -> i).toArray();
        for (int i : result) {
            System.out.println(i);
        }*/

        /*File file = new File("A:\\ideaProjects\\leetcode\\src\\main\\resources\\input.txt");
        Scanner scanner = new Scanner(file);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("A:\\ideaProjects\\leetcode\\src\\main\\resources\\output.txt"));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        Instant start = Instant.now();
        int[] result = contacts(queries);
        Instant finish = Instant.now();
        System.out.println(Duration.between(start, finish).toNanos());

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();*/

        File file = new File("A:\\ideaProjects\\leetcode\\src\\main\\resources\\inputMedian.txt");
        Scanner scanner = new Scanner(file);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("A:\\ideaProjects\\leetcode\\src\\main\\resources\\outputMedian.txt"));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = RunningMedian.runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

    }

}
