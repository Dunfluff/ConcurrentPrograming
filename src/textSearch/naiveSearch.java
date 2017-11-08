package textSearch;

import java.math.BigInteger;
import java.util.Random;

public class naiveSearch {
	public naiveSearch() {

	}

	public int Search(String s, String pattern) {
		for (int i = 0; i <= (s.length() - pattern.length()); i++) {
			int j;
			for (j = 0; j < pattern.length(); j++) {
				if (s.charAt(i+j) != pattern.charAt(j)) {
					break;
				}
			}
			 if (j == pattern.length()) return i;
		}
		return s.length();
	}
}
