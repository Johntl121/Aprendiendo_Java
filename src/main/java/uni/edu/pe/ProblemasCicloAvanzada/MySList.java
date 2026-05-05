package uni.edu.pe.ProblemasCicloAvanzada;

public class MySList {
    Node head;
    Node tail;

    class Node {
        int data;
        Node next;
        public Node(int data) { this.data = data; this.next = null; }
    }

    // Resto de atributos...

    public MySList merge(MySList other) {
        // 1. Precondición: Ambas deben estar ordenadas [cite: 178]
        if (!this.isSorted() || (other != null && !other.isSorted())) {
            return null;
        }

        MySList mergedList = new MySList();
        Node p1 = this.head;
        Node p2 = (other != null) ? other.head : null;

        while (p1 != null || p2 != null) {
            int valToAdd;

            // Determinar de qué lista tomar el elemento
            if (p1 == null) {
                valToAdd = p2.data;
                p2 = p2.next;
            } else if (p2 == null) {
                valToAdd = p1.data;
                p1 = p1.next;
            } else if (p1.data <= p2.data) {
                valToAdd = p1.data;
                p1 = p1.next;
            } else {
                valToAdd = p2.data;
                p2 = p2.next;
            }

            // Inserción en mergedList evitando duplicados [cite: 181, 182, 183]
            if (mergedList.head == null) {
                mergedList.addLast(valToAdd);
            } else if (mergedList.tail.data != valToAdd) {
                mergedList.addLast(valToAdd);
            }
        }

        return mergedList;
    }

    // Metodo auxiliar (como permite el PDF) [cite: 189]
    private boolean isSorted() {
        if (head == null || head.next == null) return true;
        Node current = head;
        while (current.next != null) {
            if (current.data > current.next.data) return false;
            current = current.next;
        }
        return true;
    }

    private void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = newNode; tail = newNode; }
        else { tail.next = newNode; tail = newNode; }
    }
}
