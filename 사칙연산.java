import java.util.*;
import java.io.*;

public class 사칙연산 {
	static String[] op = {"*", "/", "+", "-"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String expression = br.readLine();
		
		ArrayList<String> list = new ArrayList<>();
		int idx = 0;
		for(int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i) == '+' || expression.charAt(i) == '-'
					|| expression.charAt(i) == '*' || expression.charAt(i) == '/') {
				list.add(expression.substring(idx, i));
				list.add(expression.charAt(i) + "");
				idx = i + 1;
			}
		}
		list.add(expression.substring(idx));
		
		for(int i = 0; i < op.length; i++) {
			for(int j = 0; j < list.size(); j++) {
				if(op[i].equals(list.get(j))) {
					list.set(j - 1, (calc(list.get(j - 1), list.get(j), list.get(j + 1))));
					list.remove(j);
					list.remove(j);
					j--;
				}
			}
		}
		System.out.println("Answer: " + Long.parseLong(list.get(0)));
	}
	
	private static String calc(String num1, String operator, String num2) {
		Long n1 = Long.parseLong(num1);
		Long n2 = Long.parseLong(num2);
		
		switch(operator){
		case "*":
			return String.valueOf(n1 * n2);
			
		case "/":
			return String.valueOf(n1 / n2);
			
		case "+":
			return String.valueOf(n1 + n2);
			
		case "-":
			return String.valueOf(n1 - n2);
		}
		
		return "";
	}
}
