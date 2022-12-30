package simulation;

public class Main_4673 {

	public static void main(String[] args) {
		boolean[] v = new boolean[10001];
		for (int i = 1; i <= 10000; i++) {
			int temp = check(i);
			//System.out.println(temp);
			if (temp < 10001) {
				v[temp] = true;
			}
		}
		for (int i = 1; i <= 10000; i++) {
			if (!v[i]) {
				System.out.println(i);
			}
		}
	}

	private static int check(int i) {
		int base = i;
		while (i != 0) {
			base = base + (i % 10);
			i = i / 10;
		}
		return base;
	}

}
