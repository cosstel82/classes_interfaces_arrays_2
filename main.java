package classes_interfaces_arrays_2;

public class main {

	public static void main(String[] args) {
		char[] array_of_chars = {'c','a','p','a','c'};  //the simple array of chars
		char[] array_of_chars_alphanumeric = {'c','a','p','%','a','c'}; //array of chars with rubbish inside
		
		
		System.out.println(check(array_of_chars));//case a
		System.out.println(check(array_of_chars_alphanumeric));//case b

		
	}
	
	public static boolean check(char[] chr){
		char[] alphanumeric_fixed=new char[chr.length]; // in order to filter out the rubbish we copy the original array
		int j=0; // j is our counter for the numer of cells in the new array
		
		//before operating with the array i have to check if it has only alphanumeric symbols
		for(int i=0;i<chr.length;i++){
		if (((chr[i]>=48) && (chr[i]<=57)) || ((chr[i]>=65) && (chr[i]<=90)) || ((chr[i]>=97) && (chr[i]<=122))){//<<<pseudocode: between A & Z or between 0 & 9 or between a & z
			//checks the ASCII table if the values are alphanumeric (upper & lowercase letters + numbers)
			
			j++;//j is incremented if the value is alphanumeric in order to copy it to the new array in a new position
			alphanumeric_fixed[j-1]=chr[i];	//the process of copying itself, j starts at 1 so we have to normalise it
		}
		}
		char[] temp = alphanumeric_fixed; //once the tinkering with rubbish is done we need to allocate new memory to the now smaller array
		alphanumeric_fixed = new char[j]; //while we still have j saved as a variable we use it to determine the size of the new array
		for(int i=0;i<j;i++)alphanumeric_fixed[i]=temp[i]; //the process of copying from one array to another char by char
		
		System.out.println("The new array has become: ");
		for(int i=0;i<alphanumeric_fixed.length;i++)System.out.print(alphanumeric_fixed[i]);// the new array finalised
		
		
		int half = alphanumeric_fixed.length/2; //save the middle point of the array, doesn't matter if its odd or even
		int length = alphanumeric_fixed.length; //the total length of the array

		for(int i=0;i<half;i++)
			if (!(alphanumeric_fixed[i]==alphanumeric_fixed[length-i-1])) //checks if the first+i and last-i are not the same and moves to the center
				return false; //if the are different, the whole function will exit because they cannot be palindromes anymore
		return true; //if all went well in the previous if statement, the word is a palindrome.
		}
}
