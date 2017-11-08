package textSearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import edu.princeton.cs.algs4.KMP;
import edu.princeton.cs.algs4.RabinKarp;

public class testSearches {
	public static String[] readToArray(String fileName) throws IOException{
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("data/" + fileName)));
		ArrayList<String> list= new ArrayList<String>();
		while (true) {
			String word = r.readLine();
			if (word == null) {
				break;
			}
			list.add(word);
		}
		return list.toArray(new String[list.size()]);
	}
		
	
	public static void main(String[] args) throws Exception {
			

			
			//Read Words
			String[] s = readToArray("bible-en.txt");
			String[] pattern = readToArray("pattern1.txt");
			
			
			//Rabin Bible
			long before = System.currentTimeMillis();
			RabinKarp rk = new RabinKarp(pattern.toString());
			System.out.println(rk.search(s.toString()));
			long after = System.currentTimeMillis();
			System.out.println("TimeReadWords: " + (after-before) / 1000.0 + " seconds");
			//KMP Bible
			before = System.currentTimeMillis();
			KMP kmp = new KMP(pattern.toString());
			System.out.println(kmp.search(s.toString()));
			after = System.currentTimeMillis();
			System.out.println("TimeReadWords: " + (after-before) / 1000.0 + " seconds");
			//Naive Bible
	        before = System.currentTimeMillis();
	        naiveSearch ns = new naiveSearch();
			System.out.println(ns.Search(s.toString(), pattern.toString()));
			after = System.currentTimeMillis();
			System.out.println("TimeReadWords: " + (after-before) / 1000.0 + " seconds");

	}

}
