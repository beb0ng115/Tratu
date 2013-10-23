package android.nhom05.merriam_webster;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
 
public class MainActivity extends TabActivity {
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        TabHost tabHost = getTabHost();       
 
     // Constructor Dictionary Spec
        TabSpec dictionarySpec = tabHost.newTabSpec("Dictionary");
        int idDictionaryDrawable = R.drawable.btn_dictionary;
        dictionarySpec.setIndicator("Dictionary",getResources().getDrawable(idDictionaryDrawable));
        Intent dictionaryIntent = new Intent(this, DictionaryActivity.class);
        dictionarySpec.setContent(dictionaryIntent);
        
     // Constructor Recent Spec
        TabSpec recentSpec = tabHost.newTabSpec("Recent");
        int idRecentDrawable = R.drawable.btn_recent;
        recentSpec.setIndicator("Recent",getResources().getDrawable(idRecentDrawable));
        Intent recentIntent = new Intent(this, RecentActivity.class);
        recentSpec.setContent(recentIntent);
        
     // Constructor Favorites Spec
        TabSpec favoritesSpec = tabHost.newTabSpec("Favorites");
        int idFavoritesDrawable = R.drawable.btn_favorites;
        favoritesSpec.setIndicator("Favorites", getResources().getDrawable(idFavoritesDrawable));
        Intent favoritesIntent = new Intent(this, FavoritesActivity.class);
        favoritesSpec.setContent(favoritesIntent);
        
     // Constructor DailySpec
        TabSpec dailySpec = tabHost.newTabSpec("Daily");
        int idDailyDrawable = R.drawable.btn_daily;
        dailySpec.setIndicator("Daily", getResources().getDrawable(idDailyDrawable));
        Intent dailyIntent = new Intent(this, DailyActivity.class);
        dailySpec.setContent(dailyIntent);
        
        // Constructor MoreSpec
        TabSpec moreSpec = tabHost.newTabSpec("More");
        int idMoreDrawable = R.drawable.btn_more;
        moreSpec.setIndicator("More", getResources().getDrawable(idMoreDrawable));
        Intent moreIntent = new Intent(this, MoreActivity.class);
        moreSpec.setContent(moreIntent);
        
        
        //Thêm các TabSpec trên vào TabHost
        tabHost.addTab(dictionarySpec); //add Dictionary Tab
        tabHost.addTab(recentSpec); //add Recent tab
        tabHost.addTab(favoritesSpec); //add Favorites tab
        tabHost.addTab(dailySpec); //add Daily tab
        tabHost.addTab(moreSpec); //add More Tab
    }
}
