public class BinarySearch<T extends Comparable<? super T> >{
	public int find(T[] sortedArray, T item){
		int firstIndex = 0;
		int lastIndex = sortedArray.length - 1;
		int index = -1;
		boolean found = false;
		while(lastIndex >= firstIndex && !found){
			int middleIndex = (firstIndex + lastIndex) / 2;
			if(sortedArray[middleIndex].equals(item)){
				found = true;
				index = middleIndex;
			}
			else{
				if(sortedArray[middleIndex].compareTo(item) == 1)
					lastIndex = middleIndex - 1;
				else
					firstIndex = middleIndex + 1;
			}
		}

		return index;
	}

	public void testMethod(String returned, String expectedReturn){
	    /* 
	     * A simple test function that takes a function returns 
	     * and compares it to what the function is to return
	     */
	    if(returned.equals(expectedReturn)){
	      System.out.println(" OK function returned: " + returned + " expected: " + expectedReturn);
	    }
	    else{
	      System.out.println(" X function returned: " + returned + " expected: " + expectedReturn);
	    }    
	}

	public static void main(String[] args){
		BinarySearch<Integer> tester = new BinarySearch<Integer>();
		Integer[] array = new Integer[10];

		//porpulating array
		for(int i = 0; i < 20; i++){
			if(i % 2 == 0)
				array[i/2] = new Integer(i);
		}

		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		}

		tester.testMethod(Integer.toString(tester.find(array, new Integer(8))), "4");
		tester.testMethod(Integer.toString(tester.find(array, new Integer(6))), "3");
		tester.testMethod(Integer.toString(tester.find(array, new Integer(18))), "9");


	}
}