package chapter12;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Memowrite {
	public static void main(String[] args) {
		
		
		try {
			Writer out = new FileWriter("memo.txt");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
