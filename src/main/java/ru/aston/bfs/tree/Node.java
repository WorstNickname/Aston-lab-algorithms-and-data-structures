package ru.aston.bfs.tree;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

@ToString
@Getter
public class Node<T> {

    private T value;
    private List<Node<T>> children;

    public Node(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(T value) {
        Node<T> node = new Node<>(value);
        children.add(node);
    }

    public static <T> Optional<Node<T>> breadthFirstSearch(T value, Node<T> startingNode) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(startingNode);

        while (!queue.isEmpty()) {
            var visitedNode = queue.remove();
            if (visitedNode.getValue().equals(value)) {
                return Optional.of(visitedNode);
            } else {
                queue.addAll(visitedNode.getChildren());
            }
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        var root = new Node<Integer>(10);
        root.addChild(15);
        root.addChild(10);
        System.out.println(root);
    }

}
