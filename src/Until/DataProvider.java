package Until;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.StringTokenizer;

import android.os.Environment;

public class DataProvider {

	public  File wfile;
	public List<WordIndex> words;
	
	public DataProvider(){
		wfile = new File(System.getProperty("user.dir").concat(
				Environment.getExternalStorageDirectory().getAbsolutePath()
						+ "/EnglishVietnamese.index"));
		words = new ArrayList<WordIndex>();
		words = loadAllIndexWords();
	}
	
	
	public String readFile(File file)
	{
	   String content = null;
	  // File file = new File(filename); //for ex foo.txt
	   try {
	       FileReader reader = new FileReader(file);
	       char[] chars = new char[(int) file.length()];
	       reader.read(chars);
	       content = new String(chars);
	       reader.close();
	   } catch (IOException e) {
	       e.printStackTrace();
	   }
	   return content;
	}
	
	public List<String> loadAllWords()
	{
		List<String> strs = new ArrayList<String>();
		for(int i = 0 ; i < words.size(); i ++){
			strs.add(words.get(i).words);
		}	
		return strs;
	}
	
	
	public int getCount(String word){
		
		for(int i = 0 ; i < words.size(); i ++)
		{
			if(words.get(i).words.equals(word)){
				return i;
			}
		}
		return -1;
	}
	
	public List<WordIndex> loadAllIndexWords()
	{
		List<WordIndex> listWords = new ArrayList<WordIndex>();
		try {
			
			/*
			StringBuilder builder = new StringBuilder();
			FileInputStream instream = new FileInputStream(wfile);
			byte[] buff = new byte[102400];
			while (instream.read(buff) != -1) {
				String in = new String(buff);
				builder.append(in);
			}

			
			String data = builder.toString();
			String content = null;
			FileReader reader = new FileReader(wfile);
		    char[] chars = new char[(int) wfile.length()];
		    reader.read(chars);
		    content = new String(chars);
		    reader.close();
			*/
			
			String data = readFile(wfile);
			StringTokenizer token = new StringTokenizer(data, "\n");
			while (token.hasMoreTokens()) {
				String line = token.nextToken();
				String elements[] = line.split("\t");
				if (elements.length == 3) {
					WordIndex index = new WordIndex();
					index.words = elements[0];
					index.poss = elements[1];
					index.lengths = elements[2];
				}
			}
			return listWords;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
