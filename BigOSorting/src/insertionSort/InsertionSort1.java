package insertionSort;

public class InsertionSort1 {
	 public void insertionSort(int[] theArray){
		 	             
		 	            for (int i = 1; i < theArray.length; i++){
			                  int j = i;
			                  int toInsert = theArray[i];
			                  while ((j > 0) && (theArray[j-1] > toInsert)){
		 	                      theArray[j] = theArray[j-1];
			                      j--; 
			                  }
			                  theArray[j] = toInsert;
			                   
			               
			            }
			        }
}
