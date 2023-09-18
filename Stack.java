public class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.setNext(top);
        top = newNode;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return top.getValue();
    }

    public int size() {
        int count = 0;
        Node current = top;
    
        while (current != null) {
            count++;
            current = current.getNext();
        }
    
        return count;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int poppedValue = top.getValue();
        top = top.getNext();
        return poppedValue;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printH() {
        Stack tempStack = new Stack();
        Node current = top;
    
        while (current != null) {
            tempStack.push(current.getValue());
            current = current.getNext();
        }
    
        System.out.print("Stack: ");
        while (!tempStack.isEmpty()) {
            System.out.print(tempStack.pop() + " ");
        }
        System.out.println();
    }

}





