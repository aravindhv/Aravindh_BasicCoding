import java.util.Scanner;

class Node{
	int data;
	Node next;
}

class LinkedList{
	static Node head;
	
	static void insert(int data){
		Node node =new Node();
		node.data = data;
		node.next = null;
		if(head == null)
			head = node;
		else {
			Node n = head;
			while(n.next != null)
				n = n.next;
			n.next = node;
		}
	}
	static void printElements(){
		Node n = head;
		while(n!=null){
			System.out.print(n.data +" ");
			n = n.next;
		}
	}
	static void removeElement(int data) {
		Node node = head;
		
		while(node.next!=null){
			if(head.data == data){
				Node temp = node;
				head = head.next;
				node = head;
				temp.next = null;
			}
			else if(node.next.data==data){
				Node temp = node.next.next;
				node.next.next = null;
				node.next=temp;
			} else {
				node = node.next;
			}
		}	
	}
}

class RemoveSpecificElement{
	public static void main(String args[]){
		LinkedList ls = new LinkedList();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter number of Elements to be inserted : ");
		int size = scan.nextInt();
		
		System.out.println("Enter the Elements to Add at the Rear End :");
		for(int i =0; i<size; i++){
			ls.insert(scan.nextInt());
		}
		System.out.println();
		ls.printElements();
		System.out.println();
		System.out.print("Enter element to be deleted :");
		ls.removeElement(scan.nextInt());
		
		System.out.println("Present Elements in Array are :");
		ls.printElements();
		System.out.println();
		scan.close();
	}
}
