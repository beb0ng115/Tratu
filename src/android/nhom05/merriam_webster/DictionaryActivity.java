package android.nhom05.merriam_webster;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import Until.DataProvider;
import Until.Word;
import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class DictionaryActivity extends Activity {
	private DataProvider data;
	private List<String> listWord;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dictionary);

		data = new DataProvider();
		listWord = data.loadAllWords();

		final ImageView imgLogo = (ImageView) findViewById(R.id.imgVLogo);
		final TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
		final TextView edtMean = (TextView) findViewById(R.id.tvMeans);
		final ImageView imgSound = (ImageView) findViewById(R.id.imgVSound);
		final TextView tvInput = (TextView) findViewById(R.id.auCTVInput);
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(
		//		getApplicationContext(),
		//		android.R.layout.simple_dropdown_item_1line, listWord);
		//final AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.auCTVInput);
		//textView.setAdapter(adapter);

		imgSound.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				imgLogo.setVisibility(View.GONE);
				tvTitle.setVisibility(View.GONE);
				edtMean.setVisibility(View.VISIBLE);

				String word = tvInput.getText().toString();
				int posWord = getCount(word);
				if (posWord != -1) {
					Word wordss = new Word(data.words.get(posWord).words,
							data.words.get(posWord).poss, data.words
									.get(posWord).lengths);

					edtMean.setText(wordss.meaning);
				}
			}
		});

		tvInput.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				imgLogo.setVisibility(View.GONE);
				tvTitle.setVisibility(View.GONE);

				edtMean.setVisibility(View.VISIBLE);
			}
		});
	}

	public int getCount(String word){
		for(int i = 0 ; i < data.words.size(); i ++){
			if(data.words.get(i).words.equals(data))
				return i;
		}
		
		return -1;
	}
	
	String readFile(String fileName) {
		String result = null;
		AssetManager assetManager = getAssets();
		try {
			InputStream im = assetManager.open("EnglishVietnamese.index");
			result = convertStreamToString(im);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	static String convertStreamToString(java.io.InputStream is) {
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}

}
