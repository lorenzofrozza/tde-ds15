public class CircularList <T> {
    private Node<T> head;
    private int size;

    public CircularList(){
        this.head = null;
        this.size = 0;
    }

    //insert
    public void insertEnd(T data){
        Node<T> newNode = new Node<>(data);

        if(head == null){
            head = newNode;
            newNode.setNext(newNode);
        } else {
            Node<T> currentTemp = head;

            while( currentTemp.getNext() != head){
                currentTemp = currentTemp.getNext(); //The node currentTemp appoint to final node
            }

            currentTemp.setNext(newNode);
            newNode.setNext(head);
        }
        size++;
    }

    public void insertBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            newNode.setNext(newNode); // O único nó aponta para si mesmo
        } else {
            newNode.setNext(head);
            Node<T> last = head;
            while (last.getNext() != head) {
                last = last.getNext();
            }
            last.setNext(newNode);
            head = newNode;
        }
        size++;
    }

    public void insertPosition(int position,T data) {
        if(position < 0 || position > size){
            System.out.println("Invalid position");
            return;
        }

        Node<T> newNode = new Node<>(data);

        if (position == 0) {
            if (head == null) {
                head = newNode;
                newNode.setNext(newNode);// There is only one node so it is looking at itself
            } else {
                Node<T> last = head;
                while (last.getNext() != head) {
                    last = last.getNext();
                }
                last.setNext(newNode);
                newNode.setNext(head);
                head = newNode;
            }
        } else {
            Node<T> currentTemp = head;
            for (int i = 0; i < position - 1; i++) { // Navigate until the prev node
                currentTemp = currentTemp.getNext();
            }
            newNode.setNext(currentTemp.getNext());
            currentTemp.setNext(newNode);
        }
        size++;
    }

    //remove
    public void removeBeginning() {
        if (head == null) {
            System.out.println("A lista está vazia, nada para remover.");
            return;
        }
        if (head.getNext() == head) {
            head = null; // Apenas um elemento na lista
        } else {
            Node<T> currentTemp = head;
            while (currentTemp.getNext() != head) {
                currentTemp = currentTemp.getNext();
            }
            head = head.getNext();
            currentTemp.setNext(head); // Último nó aponta para o novo início
        }
        size--;
    }

    public void removeEnd() {
        if (head == null) {
            System.out.println("The list is empty, nothing to remove.");
            return;
        }
        if (head.getNext() == head) {
            head = null;
        } else {
            Node<T> currentTemp = head;
            Node<T> prev = null;
            while (currentTemp.getNext() != head) {
                prev = currentTemp;
                currentTemp = currentTemp.getNext();
            }
            prev.setNext(head); // Penúltimo aponta para o início
        }
        size--;
    }

    public T removePosition(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position");
            return null;
        }

        T removedData;

        if (position == 0) {
            removedData = head.getData();
            if (size == 1) {
                head = null;
            } else {
                Node<T> last = head;
                while (last.getNext() != head) {
                    last = last.getNext();
                }
                last.setNext(head.getNext());
                head = head.getNext();
            }
        } else {
            Node<T> currentTemp = head;
            for (int i = 0; i < position - 1; i++) {
                currentTemp = currentTemp.getNext();
            }
            Node<T> removedNode = currentTemp.getNext();
            removedData = removedNode.getData();
            currentTemp.setNext(removedNode.getNext());
        }

        size--;
        return removedData;
    }

    public T removeByValue(T element) {
        if (head == null) {
            System.out.println("The list is empty, nothing to remove.");
        }

        Node<T> currentTemp = head;
        Node<T> prev = null;

        do {
            if (currentTemp.getData().equals(element)) {
                if (currentTemp == head) {
                    if (size == 1) {
                        head = null;
                    } else {
                        Node<T> last = head;
                        while (last.getNext() != head) {
                            last = last.getNext();
                        }
                        last.setNext(head.getNext());
                        head = head.getNext();
                    }
                } else {

                    prev.setNext(currentTemp.getNext());
                }

                size--;
                return currentTemp.getData();
            }
            prev = currentTemp;
            currentTemp = currentTemp.getNext();
        } while (currentTemp != head);

        System.out.println("Element not found.");
        return null; //
    }

    //search
    public T searchValue(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position.");
            return null;
        }

        Node<T> currentTemp = head;

        for (int i = 0; i < position; i++) {
            currentTemp = currentTemp.getNext(); // Navigate to the desired position
        }

        return currentTemp.getData(); // Return the value of the found node
    }

    public int searchPosition(T value) {
        if (head == null) {
            return -1; // List is empty
        }

        Node<T> currentTemp = head;
        int position = 0;

        do {
            if (currentTemp.getData().equals(value)) {
                return position; // Return the found position
            }
            currentTemp = currentTemp.getNext(); // Move to the next node
            position++;
        } while (currentTemp != head);

        return -1; // Value not found
    }

    //dispay
    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node<T> currentTemp = head;
        do {
            System.out.print(currentTemp.getData() + " ");
            currentTemp = currentTemp.getNext();
        } while (currentTemp != head);
        System.out.println();
    }
}
