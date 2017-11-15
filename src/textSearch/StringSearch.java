package textSearch;

public class StringSearch {
	private long comparisons = 0;

	public StringSearch() {

	}

	public int naiveSearch(char[] text, char[] pattern) {
		for (int i = 0; i <= text.length - pattern.length; i++) {
			int j;
			for (j = 0; j < pattern.length; j++) {
				comparisons++;
				if (text[i + j] != pattern[j])
					break;
			}
			if (j == pattern.length)
				return i;
		}
		return text.length;
	}

	public int naiveSearch(String text, String pattern) {
		comparisons = 0;
		for (int i = 0; i <= (text.length() - pattern.length()); i++) {
			int j;
			for (j = 0; j < pattern.length(); j++) {
				comparisons++;
				if (text.charAt(i + j) != pattern.charAt(j))
					break;
			}
			if (j == pattern.length())
				return i;
		}
		System.out.println("Comparisons: " + comparisons);
		return -1;
	}

	public int rk(String text, String pattern) {
		long pHash = hash(pattern);
		long tHash = hash(text.substring(0, pattern.length()));
		int q = 13;
		int m = pattern.length();
		int RM = 1;
		boolean ok;
		for (int z = 1; z <= m - 1; z++)
			RM = (256 * RM) % q;
		if (pHash == tHash) {
			if (tHash == pHash) {
				// compare actual characters to be sure
				ok = true;
				int k, j;
				for (k = 0, j = 0; k < pattern.length() && ok; k++, j++) {
					if (text.charAt(k) != pattern.charAt(j)) {
						ok = false;
						break;
					}
				}
				if (ok) {
					System.out.println("Comparisons: " + comparisons);
					return 0;
				}

			}
		}
		comparisons = 0;
		for (int i = pattern.length(); i <= text.length() - pattern.length(); i++) {
			comparisons++;
			tHash = (tHash + q - RM * text.charAt(i - m) % q) % q;
			tHash = (tHash * 256 + text.charAt(i)) % q;
			if (tHash == pHash) {
				// compare actual characters to be sure
				ok = true;
				int k, j;
				for (k = i - (pattern.length() - 1), j = 0; j < pattern.length() && ok; k++, j++) {
					if (text.charAt(k) != pattern.charAt(j)) {
						ok = false;
						break;
					}
				}
				
				if (ok) {
					System.out.println("Comparisons: " + comparisons);
					return i-(pattern.length() - 1);
				}
			}
		}
		System.out.println("Comparisons: " + comparisons);
		return -1;
	}

	private long hash(String s) {
		long h = 0;
		for (int j = 0; j < s.length(); j++)
			h = (256 * h + s.charAt(j)) % 13;
		return h;
	}
}
