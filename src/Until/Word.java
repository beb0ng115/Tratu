package Until;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import android.os.Environment;


public class Word {

	public String words;
	private String hashLength;
	private String hashPos;
	public String meaning;
	private List<String> autoListWords;
	
	private int length;
	private int post;
	
	
	public Word(String word, String lengths, String poss){
	
		this.words = word;
		this.hashLength = lengths;
		this.hashLength = poss;
		try {
			this.meaning = Meaning.LoadMean(word, lengths, poss);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
//	public Word loadWord(String words){
		//Word wordss = new Word();
		
		
		//re//turn wordss;
	//}
	
	
	
	
	public void LoadWord() {
/*
		try {
			StringBuilder builder = new StringBuilder();
			FileInputStream instream = new FileInputStream(wfile);
			byte[] buff = new byte[1024];
			while (instream.read(buff) != -1) {
				builder.append(new String(buff));
			}

			String data = builder.toString();
			StringTokenizer token = new StringTokenizer(data, "\n");
			while (token.hasMoreTokens()) {
				String line = token.nextToken();
				String elements[] = line.split("\t");
				if (elements.length == 3) {
					wordtest temp = new wordtest();
					temp.setWord(elements[0]);
					temp.setOfset(Integer.valueOf(elements[1]));

				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	}
	
	
	
	
}
