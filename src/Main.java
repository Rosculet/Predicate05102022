import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Ex. 1
        Predicate<String> predicate = x -> (x.charAt(0) == 'J' || x.charAt(0) == 'N' && x.charAt(x.length() - 1) == 'A');

        // Ex. 2
        Node[] array = new Node[]{new Node(1, 4), new Node(3, 6), new Node(2, 8)};
        coverNodes(array);
    }

    public static List coverNodes(Node[] array) {
        LinkedList<Node> nodeLinkedList = new LinkedList<>(List.of(array));
        int index = 0;

        for (Node node : nodeLinkedList) {
            for (Node node1 : nodeLinkedList) {
                if (node.getX() < node1.getX()
                        && node.getY() > node1.getY()) {
                    nodeLinkedList.remove(node1);
                    index++;
                }
                if (node.getX() > node1.getX()
                        && node.getY() < node1.getY()) {
                    nodeLinkedList.remove(node);
                    index++;
                }
            }
        }
        System.out.println("deleted " + index + " elements ");
        nodeLinkedList.forEach(System.out::println);
        return nodeLinkedList;
    }
}
