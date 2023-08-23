package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BeautifulStr {
	public static int countSetBits(int x) {
		int cnt = 0;
		while (x > 0) {
			int rmsb = x & (-x);
			x = x ^ rmsb;
			cnt++;
		}
		return cnt;
	}

	public static long noOfPairs(String box[]) {
		int n = box.length;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int[] freq = new int[26];
			for (char ch : box[i].toCharArray()) {
				freq[ch - 'a']++;
			}
			for (int j = 0; j < 26; j++) {
				if (freq[j] % 2 == 1) {
					arr[i] = arr[i] | (1 << j);
				}
			}
		}
		Map<Integer, Integer> map = new HashMap<>();
		long ans = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (Map.Entry<Integer, Integer> itr : map.entrySet()) {
				if (countSetBits(arr[i] ^ itr.getKey()) <= 1) {
					ans += itr.getValue();
				}
			}
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		int q = fr.readInteger();
		String[] box=new String[q];
		for(int i=0; i<q; i++) {
			box[i]=fr.readString();
		}
		long ans=noOfPairs(box);
		System.out.println(ans);
	}

	static class FastReader {
		private BufferedReader br;

		public FastReader() {
			this.br = new BufferedReader(new InputStreamReader(System.in));
		}

		public int readInteger() throws NumberFormatException, IOException {
			return Integer.parseInt(this.br.readLine());
		}

		public long readLong() throws NumberFormatException, IOException {
			return Long.parseLong(this.br.readLine());
		}

		public double readDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(this.br.readLine());
		}

		public char readCharacter() throws IOException {
			String s = this.br.readLine();
			if (s.length() > 1) {
				throw new IOException("Invalid Character!");
			}
			return s.charAt(0);
		}

		public String readString() throws IOException {
			return this.br.readLine();
		}

		public int[] readArray(int n) throws IOException {
			String[] strArr = this.br.readLine().split(" ");
			if (strArr.length != n) {
				throw new IOException("Invalid array size!");
			}
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(strArr[i]);
			}
			return arr;
		}

		public String[] readStringArray() throws IOException {
			return this.br.readLine().split(" ");
		}
	}
}