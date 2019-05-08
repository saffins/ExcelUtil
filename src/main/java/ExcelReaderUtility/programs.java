package ExcelReaderUtility;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class programs {

	public static void main(String... args) {

		int[] arr = { 9, 7, 5, 5, 6, 1, 2 };

		int temp;
		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] < arr[j]) {

					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;

				}

			}

		}

		// String s = "�!�%^&#@# hi hello 5465";
		// removeJunk(s);
		// reverseInt(12345);
		int[] arr1 = { -20, 1, 1, 2, 2, 4, -90, 5, 6, 7, 8, 9, 7, 10 };

		// findMissingNum(arr1);

		int[] arr2 = { -1, -1 };
		String[] str = { "java", "ron", "avnet", "takeshi", "avnet", "ron" };
		String s = "adfdgxvbxcvbfgdhdfvzxxc";
		// mallAndLarge(arr2);

		//swapString();
		
		//System.out.println(multiplyNumbers(3));
		
		System.out.println(factorialRec(0));
	}
	
	public static void factorial(int num){
		
		
	 int fact = 1;
	 
	 
	 for(int i = 4;i>0;i--){
		 
		 fact *=i;
		 
		 
	 }
	 
	 System.out.println("factorial " + fact);
		
	}
	
	
	public static int factorialRec(int num){
		
		 if(num==1){
			 return 1;
			
		}else{
			
			return (num*factorialRec(num-1));
			
		}
		
	}
	
	
	
	public static void armStrong(int num){
		
		int org = num;
		int div = 0;
		int add = 0;
		int fin;
		while(num!=0){
			
			div = num%10;
			
			add = add   +( div*div*div);
			
			 
			
			num/=10;
			
		}
		
		if(add==org){
			
			System.out.println("its armstrong");
			
		}else{
			
			System.out.println("its not");
		}
		
		
	}
	
	public static void palindromeNumber(int num){
		
		
		int rev = 0;
		int s = num;
		while(num!=0){
			
			rev = rev*10+num%10;
			num/=10;
			
		}
		
	 
		if(rev==s){
			
			System.out.println("number is palindrome");
			
		}else{
			
			System.out.println("its not");
		}
		
		
	}

	public static long multiplyNumbers(int num) {
		if (num >= 1)
			return num * multiplyNumbers(num - 1);
		else
			return 1;
	}

	public static void swapString() {

		String s1 = "helllo";
		String s2 = "world";

		s1 = s1 + s2;

		s2 = s1.substring(0, (s1.length() - 1) - (s2.length() - 1));
		/*
		 * s1 = s1.substring((s2.length()-1) - (s1.length()-1));
		 * System.out.println(s1);
		 */
		System.out.println(s2.length());
		s1 = s1.substring(s2.length());

		System.out.println("after swapp...");

		System.out.println("s1 value " + s1);
		System.out.println("s2 value " + s2);

	}

	public static void smallAndLarge(int[] arr) {

		int large = arr[0];
		int small = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > large) {

				large = arr[i];

			} else if (arr[i] < small) {

				small = arr[i];

			}

		}

		System.out.println("large " + large);
		System.out.println("small " + small);

	}

	public static void swapValues() {

		int x = 1;
		int y = 2;

		x = x + y;
		y = x - y;
		x = x - y;

		System.out.println("x " + x);
		System.out.println("y " + y);

	}

	public static boolean palindrome(String str) {

		String rev = "";
		int length = str.length();

		for (int i = length - 1; i >= 0; i--) {

			rev += str.charAt(i);

		}

		System.out.println(rev);
		if (str.equals(rev)) {

			return true;

		}

		return false;
	}

	public static void removeJunk(String s) {

		s = s.replaceAll("[^a-zA-Z0-9]", "");

		System.out.println(s);

	}

	public static void reverseInt(int i) {
		System.out.println("using string buffer " + new StringBuffer(String.valueOf(i)).reverse());

		int rev = 0;

		while (i != 0) {
			rev = rev * 10 + i % 10;

			i = i / 10;
			// System.out.println(i);

		}

		System.out.println("using algo " + rev);

	}

	public static void findMissingNum(int[] arr) {

		int sum = 0;

		int jtotal = 0;

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];

		}

		System.out.println(sum);

		for (int j = -1; j <= 10; j++) {

			jtotal += j;

		}

		System.out.println("jtotal " + jtotal);

		System.out.println("missing number from array is " + (jtotal - sum));

	}

	public static void findDuplicates(int[] arr) {

		// 1. compare each element
		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] == (arr[j])) {

					System.out.println("using forloop worst solution : duplicate is " + arr[i]);

				}

			}

		}

		// using hashset it stores unique values

		Set<Integer> set = new HashSet<>();
		for (int name : arr) {

			if (set.add(name) == false) {

				System.out.println(name + " was found duplicate using hashset");

			}

		}

		// using hashmap
		Map<Integer, Integer> map = new HashMap<>();

		for (Integer name : arr) {

			Integer count = map.get(name);

			if (count == null) {

				map.put(name, 1);
			} else {
				map.put(name, ++count);
			}

		}

		Set<Entry<Integer, Integer>> entry = map.entrySet();

		for (Entry<Integer, Integer> entr : entry) {

			if (entr.getValue() > 1) {

				System.out.println(entr.getKey() + " is duplicate using hashmap");

			}

		}

	}

	public static void findOccurings(String str) {

		char[] strArray = str.toCharArray();

		System.out.println(strArray);

		Map<Character, Integer> charMap = new HashMap<>();

		for (char c : strArray) {

			Integer count = charMap.get(c);

			if (count == null) {

				charMap.put(c, 1);

			} else {

				charMap.put(c, ++count);

			}

		}

		System.out.println(charMap);

	}
}
