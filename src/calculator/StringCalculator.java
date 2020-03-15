package calculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	int add(String text) {
		if (blank(text)) {
			return 0;
		}
		
	return sum(makeInt(split(text)));
		/**if (text.contains(",")) {
			int sum = 0;
			String[] num_arr = text.split(",|:");
			for(String i: num_arr) {
				sum = sum + Integer.parseInt(i);
			}
			return sum;
		}
		
		Pattern p = Pattern.compile("^//(.)\n(.*)");
		Matcher m = p.matcher(text);
		
		if(m.find()) {
			String[] num_arr = m.group(2).split(m.group(1));
		}
		
		return Integer.parseInt(text);**/
	}
	
	
	private boolean blank(String text) {
		return (text == null || text.isBlank());
	}
	
	private String[] split(String text) {
		Pattern p = Pattern.compile("^//(.)\n(.*)");
		Matcher m = p.matcher(text);
		//String[] num_arr;
		
		if(m.find()) {
			return m.group(2).split(m.group(1));
		}
		/**if(m.find()) {
			num_arr = m.group(2).split(m.group(1));
		}
		else {
			num_arr = text.split(",|:");
		}
		return num_arr;**/
		
		return text.split(",|:");
	}
	
	private int[] makeInt(String[] splitText) {
		int[] num = new int[splitText.length];
		int checkNum;
		for(int i = 0; i < splitText.length; i++) {
			checkNum = Integer.parseInt(splitText[i]);
			num[i] = Negative(checkNum);
		}
		return num;
	}
	
	private int Negative(Integer num) {
		if (num < 0) {
			throw new RuntimeException();
		}
		return num;
	}
	
	private int sum (int[] num) {
		int total = 0;
		for(int i: num) {
			total += i;
		}
		return total;
	}
}
