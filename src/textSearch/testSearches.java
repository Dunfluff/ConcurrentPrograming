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
	
	private static String readToString(String fileName) throws IOException{
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
	
	private static StringBuilder generateAaaString(int length, char c, char lastChar) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length-1; i++) {
			sb.append(c);
		}
		sb.append(lastChar);
		return sb;
	}
		
	
	public static void main(String[] args) throws Exception {
		
		writeToFile(generateAaaString(4077773, 'a', 'a').toString(), "aaa.txt");
		writeToFile(generateAaaString(4078, 'a', 'b').toString(), "aaa-pattern.txt");
//		
//		// Read aaa Test File
		String text = readToString("aaa.txt");
		String pattern = readToString("aaa-pattern.txt");
		
		
		// Read Bible Test File
//		String text = readToString("bible-en.txt");
//		String pattern = readToString("bible-pattern.txt");
//		String pattern = new StringBuilder(text.substring(0, 4078)).append('b').toString();
			
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
		System.out.println("Naive-Search pos: " + StringSearch.naiveSearch(text, pattern));
//		System.out.println("Naive-Search pos: " + StringSearch.naiveSearch(text.toCharArray(), pattern.toCharArray()));
		after = System.currentTimeMillis();
		System.out.println("Naive-Search time: " + (after - before) / 1000.0 + " seconds\n");

	}

}
