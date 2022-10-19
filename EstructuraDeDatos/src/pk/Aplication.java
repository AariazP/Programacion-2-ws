package pk;


public class Aplication {
	
	public static void main(String[] args) {
		Aplication a = new Aplication();
		System.out.println parce("Resultado de fibbo: "+a.fibbonacci(8L)); 
		
	}
	
	
	private int[] mergeSort(int[] array) {
		
		int middle = array.length/2; 
		
		if(array.length == 1) {
			return array; 
		}
		
		int[] arrayLeft = mergeSort(Arrays.)
		
	}
	
	/*
	 * //Malo private long fibbonacci(long i) { System.out.println(i);
	 * 
	 * if((i == 0) || (i == 1)) { return i; }else { return fibbonacci(i-1) +
	 * fibbonacci(i-2); } }
	 */
	/*
	 * private int binarySearch(int start, int end, int[] array, int x) {
	 * 
	 * 
	 * System.out.println(Arrays.toString(Arrays.copyOfRange(array, start, end)));
	 * if(start > end) { return -1; }
	 * 
	 * int mid = (end + start)/2;
	 * 
	 * if(x == array[mid]) return mid;
	 * 
	 * if(x < array[mid]) binarySearch(0, mid-1, array, x);
	 * 
	 * return binarySearch(mid+1, end, array, x); }
	 */
	

//	private int sumOfNaturalsNumbers(int i) {
//		if(i <= 1) return i; 
//		return sumOfNaturalsNumbers(i-1)+i;
//	}

	/*
	 * private String convertToBinary(int i) {
	 * 
	 * if(i<=1) { return ""+i; }
	 * 
	 * return convertToBinary(i/2)+(""+i%2); }
	 */
//	private String reverseString(String cadena) {
//		if(cadena.equals("")) {
//			return""; 
//		}
//		return  reverseString(cadena.substring(1)) + String.valueOf(cadena.charAt(0)) ;
//	}
//	
	
	
	/*
	 * private boolean isPalindrome(String cadena) {
	 * 
	 * if(cadena.length() == 1 || cadena.length() == 0) { return true; }
	 * 
	 * int lastIndex = cadena.length()-1;
	 * 
	 * if(cadena.charAt(0) == cadena.charAt(lastIndex)) {
	 * isPalindrome(cadena.substring(1, lastIndex)); }
	 * 
	 * return false; }
	 */
	
	
}
