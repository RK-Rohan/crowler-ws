package it.stasbranger.crowlerws.ws.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHTML {

	static public String[] getValue(String text, String regularExpression){
		String[] res = new String[10];
		Pattern p = Pattern.compile(regularExpression, Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
		Matcher m = p.matcher(text);
		if (m.find()) {
			for(int i = 1; i <= m.groupCount(); i++){
			res[i] = m.group(i);
			}
			return res;
		}else{
			return res;
		}
	}
}	