package trasta.flash.english.jp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
	
	public void JtE(View view){
		Intent intent = new Intent();
		intent.setClassName("trasta.flash.english.jp", "trasta.flash.english.jp.JtEActivity");
		startActivity(intent);
	}
}
