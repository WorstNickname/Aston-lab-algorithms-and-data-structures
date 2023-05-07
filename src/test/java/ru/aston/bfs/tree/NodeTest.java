package ru.aston.bfs.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NodeTest {

    @Test
    void targetNodeExists() {
        var root = new Node<Integer>(10);
        var target = 22;
        root.addChild(15);
        root.addChild(22);

        var mayBeNode = Node.breadthFirstSearch(target, root);

        assertThat(mayBeNode).isPresent();
        assertThat(mayBeNode.get().getValue()).isEqualTo(target);
    }

    @Test
    void targetNodeDoesNotExist() {
        var root = new Node<Integer>(10);
        var target = 1337;
        root.addChild(15);
        root.addChild(22);

        var mayBeNode = Node.breadthFirstSearch(target, root);

        assertThat(mayBeNode).isEmpty();
    }
}