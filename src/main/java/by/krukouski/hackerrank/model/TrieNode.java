package by.krukouski.hackerrank.model;

import java.util.*;

public class TrieNode {

    private String data;
    private Map<String, TrieNode> childes;
    private boolean isValue;
    private int countOfWords;

    public TrieNode(final String data) {
        this.data = data;
        countOfWords = 0;
        childes = new HashMap<>();
    }

    public String getData() {
        return data;
    }

    public void setData(final String data) {
        this.data = data;
    }

    public TrieNode getChild(final String data) {
        return childes.get(data);
    }

    public void setChild(final TrieNode child) {
        childes.put(child.getData().substring(0,1), child);
    }

    public boolean isValue() {
        return isValue;
    }

    public void markValue() {
        isValue = true;
    }

    public void unmarkValue() {
        isValue = false;
    }

    public int getCountOfChildes() {
        return childes.size();
    }

    public TrieNode[] getChildes() {
        return childes.values().toArray(TrieNode[]::new);
    }

    public int getCountOfWords() {
        return countOfWords;
    }

    public void addWord() {
        countOfWords++;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", childes=" + childes +
                ", isValue=" + isValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrieNode trieNode = (TrieNode) o;
        return isValue == trieNode.isValue &&
                data.equals(trieNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, isValue);
    }
}
