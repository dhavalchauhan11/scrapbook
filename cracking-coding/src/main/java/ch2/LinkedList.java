package ch2;

public class LinkedList{

	private Node head;

	public static void main(String args[]){
		LinkedList list = new LinkedList();
		list.addNodeToTail(2);
		list.addNodeToTail(3);
		list.addNodeToTail(3);
		list.addNodeToTail(4);
		list.addNodeToTail(5);
		list.print();

		System.out.println();
//		list.deleteNode(4);
		list.deleteNode2(3);
		list.print();

		System.out.println();
		list.insertAfter(4, 14);
		list.print();

        System.out.println();
        list.insertBefore(2, 10);
        list.print();

        System.out.println();
        list.insertBefore(3,100);
        list.print();
    }

	public void print(){
		Node n = head;
		while(n.next!=null){
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.print(n.data);
	}

	public void addNodeToTail(int d){
		Node newNode = new Node(d);

		if(head == null){
			head = newNode;
		} else {
			Node current = head;

			// Iterate till the end of the list
			while(current.next != null){
				current = current.next;
			}

			// reached end of the list
			current.next = newNode;
		}
	}

	public void deleteNode(int d){
		// empty list
		if(head == null){
			throw new RuntimeException("Empty list - nothing to delete");
		}

		// delete head and return
		if(head.data == d){
			head = head.next;
			return;
		}

		// maintain two pointers - current and previous
		// Iterate through the list to find match to delete and make it current
		// to delete - swap the references
		Node current = head;
		Node previous = null;

		// iterate until either end is reached of match is found
		while(current.next!=null && current.data != d){
	        // swap the pointers to move on...
			previous = current;
			current = current.next;
		}

		if(current == null)
			throw new RuntimeException("No match found to delete");

		// finally - delete
		previous.next = current.next;
	}

	public void deleteNode2(int d){
		// empty list
		if(head == null){
			throw new RuntimeException("Empty list - nothing to delete");
		}

		// delete head and return
		if(head.data == d){
			head = head.next;
			return;
		}

		Node current = head.next;
		Node previous = head;

		while(current.next != null){
			if(current.data == d){
				previous.next = current.next;
				return;
			} else {
				previous = current;
				current = current.next;
			}
		}
	}

	public void insertAfter(int key, int d){
		Node newNode = new Node(d);
		// empty list
		if(head == null){
			head = newNode;
		}

		Node current = head;
		while(current.next != null){
			if(current.data == key){
				newNode.next = current.next;
				current.next = newNode;
				return;
			} else {
				current = current.next;
			}
		}
	}

	public void insertBefore(int key,int d){
		Node newNode = new Node(d);
		// empty list
        if(head == null){
            head = newNode;
            return;
        }

        // if data matches with the head itself
        if(head.data == key){
            newNode.next = head;
            head = newNode;
            return;
        }

        Node previous = head;
        Node current = head.next;
        while(current.next != null){
            if(current.data == key){
                previous.next = newNode;
                newNode.next = current;
                return;
            } else {
                previous = current;
                current = current.next;

            }
        }
	}


	private class Node{
		int data;
		Node next=null;

		public Node(int d)
		{
			this.data = d;
		}
	}
}
