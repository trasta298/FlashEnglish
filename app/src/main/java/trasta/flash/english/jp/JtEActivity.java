package trasta.flash.english.jp;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.text.method.*;
import java.util.*;
import android.net.*;
import android.content.*;

public class JtEActivity extends Activity{

	
	private int num = 0;
	private int op = 0;
	private int direction = 0;
	private Random rnd = new Random();
	private Words words = new Words();

	
	private CountDownTimer cdt = new CountDownTimer(2000,1000){
			// カウントダウン処理
			public void onTick(long millisUntilFinished){
			}
			// カウントが0になった時の処理
			public void onFinish(){
				countdown();
				TextView text = (TextView) findViewById(R.id.maintext);
				if(direction == 0){
					if(op == 1){
						op = 0;
						num ++;
						if(num == words.getLength()) num = 0;
					}else{
						op = 1;
					}
					text.setText(words.getWord(num,op));
				}else if(direction == 1){
					if(op == 1){
						op = 0;
					}else{
						op = 1;
						num --;
						if(num < 0) num = words.getLength()-1;
					}
					text.setText(words.getWord(num,op));
				}
			}
		};

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jte);
		countdown();
		TextView text = (TextView) findViewById(R.id.maintext);
		text.setText(words.getWord(num,op));

		((ToggleButton)findViewById(R.id.onoffbutton)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// トグルON
				if (isChecked) {
					countdown();
				} else {
					stopcountdown(); // タイマーをストップ
				}
			}
		});
	}
	
	public void dbefore(View view){
		TextView text = (TextView) findViewById(R.id.maintext);
		if(op == 1){
			op = 0;
		}else{
			op = 1;
			num --;
			if(num < 0) num = words.getLength()-1;
		}
		text.setText(words.getWord(num,op));
	}

	public void dafter(View view){
		TextView text = (TextView) findViewById(R.id.maintext);
		if(op == 1){
			op = 0;
			num ++;
			if(num == words.getLength()) num = 0;
		}else{
			op = 1;
		}
		text.setText(words.getWord(num,op));
	}

	public void after(View view){
		direction = 0;
	}

	public void before(View view){
		direction = 1;
	}

	public void dictionary(View view){
		Uri uri = Uri.parse("http://ejje.weblio.jp/content/"+words.getWord(num,1));
		Intent i = new Intent(Intent.ACTION_VIEW,uri);
		startActivity(i);
	}

	public void countdown(){
		cdt.cancel();
		cdt.start();
	}

	public void stopcountdown(){
		cdt.cancel();
	}

	public void tomain(View view){
		finish();
	}
}
