import java.util.Scanner;

class TowerOfHanoiProblem{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of Disks in Tower \"A\" : ");
		int disks = scan.nextInt();
		moveDisks(disks, 'A', 'B', 'C');
	}
	private static void moveDisks(int disks, char from_tower, char idle_tower, char to_tower){
		if(disks == 1){
			System.out.println("Disk "+ disks + " moved from "+ from_tower + " to "+ to_tower);
			return;
		}
		moveDisks(disks-1, from_tower, to_tower, idle_tower);
		System.out.println("Disk "+ disks + " moved from "+ from_tower + " to "+ to_tower);
		moveDisks(disks-1, idle_tower, from_tower, to_tower);
	}
}
