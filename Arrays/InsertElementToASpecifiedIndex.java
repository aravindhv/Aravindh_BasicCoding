import java.util.Scanner;

class Node{
	int data;
	Node next;
}

class LinkedList{
	static Node head;
	
	static void insert(int data){
		Node node = new Node();
		node.data = data;
		node.next = null;
		if(head==null)
			head = node;
		else {
			Node temp = head;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	static void insertToPosition(int data, int position){
		int index = 0;
		Node node = head;
		Node n = new Node();
		n.data = data;
		n.next = null;
		
		if(position == 0)
			insert(data);
		else {
			while(node.next!=null){
				if(++index == position){
					Node temp = node.next;
					node.next = n;
					n.next = temp;
				} else {
					node = node.next;
				}
			}
		}
	}
	void printElements(){
		Node node = head;
		while(node!=null){
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}

class InsertElementToASpecifiedIndex{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		LinkedList ls = new LinkedList();
		
		System.out.print("Enter the number of elements to be inserted :");
		int size = scan.nextInt();
		
		System.out.print("Enter the Elements :");
		for(int i=0; i<size; i++)
			ls.insert(scan.nextInt());
		System.out.println();
		System.out.print("Enter the Element to be Inserted :");
		int element = scan.nextInt();
		System.out.print("Enter the Position to be placed :");
		ls.insertToPosition(element, scan.nextInt());
		System.out.println();
		System.out.print("Resultant Array is :");
		ls.printElements();
		System.out.println();
	}
}
