package textSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import edu.princeton.cs.algs4.KMP;
import edu.princeton.cs.algs4.RabinKarp;

public class TestSearches {
	
	private static void writeToFile(String s, String fileName) throws IOException {
		BufferedWriter r = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/" + fileName)));
		r.write(s);
		r.close();
	}
	
	private static String readToArray(String fileName) throws IOException{
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("data/" + fileName)));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String word = r.readLine();
			if (word == null) {
				break;
			}
			sb.append(word);
		}
		r.close();
		return sb.toString();
	}
	
	private static StringBuilder generateAaaString() {
		StringBuilder sb = new StringBuilder();
		String character = "a";
		for (int i = 0; i < 1000000; i++) {
			sb.append(character);
		}

		return sb;
	}
		
	
	public static void main(String[] args) throws Exception {
		
		// Read Bible Test Files
		String text = readToArray("aaa.txt");
		String pattern = readToArray("aaa-pattern.txt");
		
		
		// Read Bible Test Files
//		String text = readToArray("bible-en.txt");
//		String pattern = readToArray("bible-pattern.txt");
			
		// Rabin Search
		long before = System.currentTimeMillis();
		RabinKarp rk = new RabinKarp(pattern);
		System.out.println("Rabin-Karp pos: " + rk.search(text));
		long after = System.currentTimeMillis();
		System.out.println("Rabin-Karp time: " + (after - before) / 1000.0 + " seconds\n");

		// KMP Search
		before = System.currentTimeMillis();
		KMP kmp = new KMP(pattern);
		System.out.println("Knuth-Morris-Pratt pos: " + kmp.search(text));
		after = System.currentTimeMillis();
		System.out.println("Knuth-Morris-Pratt time: " + (after - before) / 1000.0 + " seconds\n");

		// Naive Search
		before = System.currentTimeMillis();
//		System.out.println("Naive-Search pos: " + StringSearch.naiveSearch(text, pattern));
		System.out.println("Naive-Search pos: " + StringSearch.naiveSearch(text.toCharArray(), pattern.toCharArray()));
		after = System.currentTimeMillis();
		System.out.println("Naive-Search time: " + (after - before) / 1000.0 + " seconds\n");

	}

}
