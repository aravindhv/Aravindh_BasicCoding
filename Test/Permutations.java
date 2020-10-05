import java.util.Arrays;

class Permutations
{
	// Utility function to swap two characters in a character array
	private static void swap(char[] arr, int i, int j) {
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}

	// Utility function to reverse a char array between specified indices 
	private static void reverse(char[] arr, int i, int j)
	{
		// do till two end-points intersect
		while (i < j) {
			swap(arr, i++, j--);
		}
	}

	// Iterative function to find permutations of a String in Java
	private static void permutations(String str, int n)
	{
		// sort the string in natural order
		char[] s = str.toCharArray();
		Arrays.sort(s);

		while (true)
		{
			// Print current permutation
			System.out.print(String.valueOf(s) + " ");

			/* Below code will rearrange the string to next lexicographically
			 ordered permutation (if any) or return if we are already at
			 highest possible permutation */

			// Find largest index i such that s[i-1] is less than s[i]
			int i = n - 1;
			while (s[i-1] >= s[i])
			{
				// if i is first index of the string, that means we are 
				// already at last possible permutation 
				// (string is sorted in reverse order)
				if (--i == 0)
					return;
			}

			// find highest index j to the right of index i such that 
			// s[j] > s[i–1] (s[i..n-1] is sorted in reverse order)

			int j = n - 1;
			while (j > i && s[j] <= s[i-1])
				j--;

			// Swap characters at index i-1 with index j
			swap(s, i-1, j);

			// reverse the substring s[i..n-1] and return true
			reverse (s, i, n-1);
		}
	}

	// Iterative program to find permutations of a String in Java
	public static void main(String[] args)
	{
		String s = "ABC";
		permutations(s, s.length());
	}
}
