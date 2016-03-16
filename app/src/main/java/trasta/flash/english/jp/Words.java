package trasta.flash.english.jp;
import java.util.*;
import java.io.*;
import android.app.*;
import android.os.*;
import android.widget.*;

public class Words{

	private ArrayList<String[]> words = new ArrayList<String[]>();
	private boolean isfile = true;

	Words(Activity activity){
		String[] word;
		String sdPath = Environment.getExternalStorageDirectory().getPath();
		// 読み込むファイル名
		String fileName = "/FlashEnglish/words.txt";
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sdPath + fileName), "utf-8"));
			String str;
			while((str = reader.readLine()) != null){
				if(str.indexOf("_")==-1) continue;
				String[] temp = str.split("_",0);
				this.words.add(temp);
			}
			reader.close();
		}catch(FileNotFoundException e){
			try{
				String str = "";
				File dir = new File(sdPath+"/FlashEnglish");
				dir.mkdirs();
				dir = new File(sdPath+"/FlashEnglish/words.txt");
				dir.createNewFile();
				isfile = false;
				Toast.makeText(activity, "/FlashEnglish/words.txtに 日本語_English という形式で書き込んでください", Toast.LENGTH_LONG).show();
			}catch( IOException err){
			}
		}catch(IOException e){
		}
	}

	public ArrayList<String[]> getWords(){
		return this.words;
	}

	public int getLength(){
		return this.words.size();
	}

	public String getWord(int a,int b){
		if(!isfile || getLength() == 0) return "日本語_English";
		return this.words.get(a)[b];
	}

}
