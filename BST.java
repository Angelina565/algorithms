package lesson6;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        int height;

        public Node(Key key, Value value, int size, int height) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = height;
        }
    }

        private Node root = null;

        public boolean isEmpty () {
            return root == null;
        }

        public int size () {
            return size(root);
        }

        private int size (Node node) {
            if (node == null) {
                return 0;
            } else {
                return node.size;
            }
        }

        public Value get (Key key) {
            return get(key, root);
        }

        private Value get (Key key, Node node) {
            if (key == null) {
                throw new IllegalArgumentException("не может быть ключа со значением null");
            }
            if (node == null) {
                return null;
            }

            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                return node.value;
            } else if (cmp < 0 ) {
                return get(key, node.left);
            } else {
                return get(key, node.right);
            }
        }

        public boolean contains (Key key) {
            return get(key) != null;
        }

        public void put (Key key, Value value) {
            if (key == null) {
                throw new IllegalArgumentException("не может быть ключа со значением null");
            }
            root = put(root, key, value);
        }

        private Node put (Node node, Key key, Value value) {
            if (node == null) {
                return new Node(key, value, 1, 0   );
            }
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                node.value = value;
            } else if (cmp < 0) {
                node.left = put(node.left, key, value);
            } else {
                node.right = put(node.right, key, value);
            }

            node.size = size(node.left) + size(node.right) + 1;
            node.height = 1 + Math.max(height(node.right), height(node.left));
            return node;
        }

        private Node min (Node node) {
            if (node == null) {
                return node;
            } else {
                return min(node.left);
            }
        }

        private Node max (Node node) {
            if (node == null) {
                return node;
            } else {
                return max(node.right);
            }
        }

        private Node deleteMin (Node node) {
            if (node.left == null) {
                return node.right;
            } else {
                node.left = deleteMin(node.left);
            }
            return node;
        }

        public void deleteMin () {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            root = deleteMin(root);
        }

    private Node deleteMax (Node node) {
        if (node.right == null) {
            return node.left;
        } else {
            node.right = deleteMax(node.right);
        }
        return node;
    }

    public void deleteMax () {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMax(root);
    }

    private Node delete (Node node, Key key) {
            if (node == null) {
                return null;
            }
            int cmp = key.compareTo(node.key);
            if (cmp < 0 ) {
                node.left = delete(node.left, key);
            } else if (cmp >0) {
                node.right = delete(node.right, key);
            } else {
                if (node.left == node) {
                    return node.right;
                }
                if (node.right == null) {
                    return node.left;
                }
                Node tmp = node;
                node = max(node.left);
                node.left = deleteMax(tmp.left);
                node.right = tmp.right;
                tmp = null;
            }
            node.size = size(node.left) + size(node.right) + 1;
            node.height = 1 + Math.max(height(node.right), height(node.left));
            return node;
    }

    public void delete (Key key) {
            root = delete(root, key);
    }

    private int height (Node node) {
            if (node == null) {
                return -1;
            } else {
                return node.height;
            }
    }

    public int height () {
            return height(root);
    }

    private boolean isBalanced (Node node) {
            if (node == null) {
                return true;
            }
            if (Math.abs(height(node.left)-height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
                return true;
            }
            return false;

    }
    public boolean isBalanced () {
        return isBalanced(root);
    }

}
