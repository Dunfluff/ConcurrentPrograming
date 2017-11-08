package textSearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import edu.princeton.cs.algs4.KMP;
import edu.princeton.cs.algs4.RabinKarp;

public class testSearches {
	public static String read(String fileName) throws IOException{
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("data/" + fileName)));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String word = r.readLine();
			if (word == null) {
				break;
			}
			sb.append(word);
		}
		return sb.toString();
	}
		
	
	public static void main(String[] args) throws Exception {
			

			
			//Read Words
			String s = read("bible-en.txt");
			String pattern = read("pattern1.txt");
			
			//Naive Bible
			long before = System.currentTimeMillis();
	        naiveSearch ns = new naiveSearch();
			ns.Search(s, pattern);
			long after = System.currentTimeMillis();
			System.out.println((after-before) / 1000.0);
			//Rabin Bible
			before = System.currentTimeMillis();
			RabinKarp rk = new RabinKarp(pattern);
			rk.search(s);
			after = System.currentTimeMillis();
			System.out.println((after-before) / 1000.0);
			//KMP Bible
			before = System.currentTimeMillis();
			KMP kmp = new KMP(pattern);
			kmp.search(s);
			after = System.currentTimeMillis();
			System.out.println((after-before) / 1000.0);


	}

}
