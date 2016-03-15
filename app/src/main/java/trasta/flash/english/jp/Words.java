package trasta.flash.english.jp;
import java.util.*;

public class Words{

	private ArrayList<String[]> words = new ArrayList<String[]>();

	Words(){
		String[] word= {"憎む、嫌う","hate"};
		this.words.add(word.clone());
		word[0] = "前";
		word[1] = "before";
		this.words.add(word.clone());
		word[0] = "上";
		word[1] = "top";
		this.words.add(word.clone());
		word[0] = "下";
		word[1] = "under";
		this.words.add(word.clone());
	}

	public ArrayList getWords(){
		return this.words;
	}

	public int getLength(){
		return this.words.size();
	}

	public String getWord(int a,int b){
		return this.words.get(a)[b];
	}

}
