
public class RemoveDuplicateChar {

	public static void main(String[] args) {

		String original = "lolkeshl";
		String newString = "";
		
		boolean breakflag = false;
		
		for(int i=0;i<original.length();i++) {
			int count =0 ;
			breakflag = false;
			char chI =original.charAt(i);
			for(int j=0;j<original.length();j++) {
				char chJ =original.charAt(j);
				if(j<i && chI == chJ) {
					breakflag = true;
					break;
				}
				if(chI ==chJ) {
					count ++;
				}
			}
		
			if(!breakflag) {
				System.out.println( chI +"= "+count);
				newString = newString+chI;
			}
		}
		System.out.println(newString);
		
		StringBuilder sb = new StringBuilder();
		original.chars().distinct().forEach(c->sb.append((char)c));

	}
}
