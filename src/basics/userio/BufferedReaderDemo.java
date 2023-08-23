package basics.userio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Read Input in the following format
 * 4
 * 12 34 10
 * 22 56 89 40
 * 23 67
 * 23 45 17
 * */
public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int q=Integer.parseInt(br.readLine());
		while(q-->0) {
			String[] strArr=br.readLine().split(" ");
			for(String s: strArr) {
				int val=Integer.parseInt(s);
				System.out.print(val+" ");
			}
			System.out.println();
		}
		
		/* Array input line by line
		 * 

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int q=Integer.parseInt(br.readLine());
		while(q-->0) {
		    int n=Integer.parseInt(br.readLine());
			String[] strArr=br.readLine().split(" ");
			int[] arr=new int[n];
			for(int i=0; i<n; i++) {
				arr[i]=Integer.parseInt(strArr[i]);
			}
			System.out.println(res);
		}
		
		*/
	}

}
