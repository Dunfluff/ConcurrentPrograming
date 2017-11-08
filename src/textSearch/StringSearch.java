package textSearch;

public abstract class StringSearch {
	private static int comparisons = 0;

	private StringSearch() {}
	
	public static int naiveSearch(char[] text, char[] pattern) {
		for (int i = 0; i <= text.length - pattern.length; i++) {
			int j;
			for (j = 0; j < pattern.length; j++) {
				comparisons++;
				if (text[i + j] != pattern[j]) break;
			}
			if (j == pattern.length) return i;
		}
		return -1;
	}
	
	public static int naiveSearch(String text, String pattern) {
		for (int i = 0; i <= (text.length() - pattern.length()); i++) {
			int j;
			for (j = 0; j < pattern.length(); j++) {
				if (text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if (j == pattern.length())
				return i;
		}
		return text.length();
	}
	
	public static void main(String[] args) {
		char[] text = {'a', 'a', 'a'};
		char[] pattern = {'a', 'b'};
		System.out.println("N: " + text.length);
		System.out.println("M:" + pattern.length);
		System.out.println("Position: " + naiveSearch(text, pattern));
		System.out.println("Comparisions: " + comparisons);
	}

}
