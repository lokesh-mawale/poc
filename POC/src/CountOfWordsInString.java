import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOfWordsInString {

	public static void main(String[] args) {
		String string= "ppnpnl";


		boolean breakFlag  = false;

		for(int i=0; i<string.length();i++) {
			breakFlag  = false;
			char ch1 = string.charAt(i);
			int count =0;

			for(int j=0;j<string.length();j++) {
				if(j<i && ch1 == string.charAt(j)) {
					breakFlag = true;
					break;
				}
				if(ch1 ==  string.charAt(j)) {
					count++;
				}
			}
			if(!breakFlag) {
				System.out.println(ch1+" "+count);
			}
		}

	}

}
