package solutions;

import java.io.IOException;
import java.util.Scanner;

/*
 * 
 * input 
 * 	4 9 2
	3 5 7
	8 1 5
	
	all the possible magic square generated 
276951438
294753618
438951276
492357816
618753294
672159834
816357492
834159672

output

1
*/

public class MagicSquare {

	public static boolean checkMatrix(int a[]) {
		int r1, r2, r3, c1, c2, c3, d1, d2;
		r1 = a[0] + a[1] + a[2];
		r2 = a[3] + a[4] + a[5];
		r3 = a[6] + a[7] + a[8];
		c1 = a[0] + a[3] + a[6];
		c2 = a[1] + a[4] + a[7];
		c3 = a[2] + a[5] + a[8];
		d1 = a[0] + a[4] + a[8];
		d2 = a[2] + a[4] + a[6];
		if (r1 != 15 | r2 != 15 | r3 != 15 | c1 != 15 | c2 != 15 | c3 != 15 | d1 != 15 | d2 != 15) {
			return false;
		}else {
			return true;
		}

	}

	public static int magicSquare(int ar[], int s[], boolean c[], int idx, int ans) {
		if (idx == 9) {
			
			if (checkMatrix(ar) == true) {
				for (int j = 0; j < 9; j++) {
					System.out.print(ar[j]);
					}
				System.out.println();
				ans = Math.min(ans, costMatrix(ar, s));
			}
		}
		for (int i = 1; i <= 9; i++) {
			if (c[i] == false) {
				ar[idx] = i;
				c[i] = true;
				ans = magicSquare(ar, s, c, idx + 1, ans);
				c[i] = false;
			}

		}
		return ans;
	}

	public static int costMatrix(int[] ar, int[] s) {
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			if (ar[i] > s[i]) {
				sum += (ar[i] - s[i]);
			}else {
				sum += (s[i] - ar[i]);
			}

		}
		//System.out.println(sum);
		return sum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int s[]=new int[9];
		for (int i = 0; i < 9; i++) {
			s[i] = scanner.nextInt();
		}
		boolean[] c = new boolean[10];
		int ar[] = new int[9];
		System.out.println(magicSquare(ar, s, c, 0, Integer.MAX_VALUE));

	}
}
