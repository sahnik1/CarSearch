package Backend;

/**
* <h1>MergeSort Class</h1>
* MergeSort Implementation By
* Various Different Comparison
* Factors Tailored Toward the
* Car Object.
* <p>
*
* @author  Anant Jain, Karanjot Sahni
* @version 1.0
* @since   2019-02-16 
*/
public class MergeSort {
    private static Car[] array;
    
    // Local Enum Type To Tell MergeSort What Parameter to Sort
    enum sorttype { ID, MODEL, YEAR, RECALLS, MAKE, CATEGORY, CITYMPG, HIGHMPG, COMBMPG };
    
    /**
	 * Function to Sort Cars by Number of Recalls
	 * @param Array of Car Objects
	 */
    public static void recallsort(Car[] c){
    	array = new Car[c.length];
        sort(c, 0, c.length - 1, sorttype.RECALLS);
    }
    
    /**
	 * Function to Sort by Vehicle IDs
	 * @param Array of Car Objects
	 */
    public static void idsort(Car[] c){
    	array = new Car[c.length];
        sort(c, 0, c.length - 1, sorttype.ID);
    }
    
    /**
	 * Function to Sort by Vehicle Years
	 * @param Array of Car Objects
	 */
    public static void yearsort(Car[] c){
    	array = new Car[c.length];
        sort(c, 0, c.length - 1, sorttype.YEAR);
    }
    
    /**
	 * Function to Sort by Make of Cars
	 * @param Array of Car Objects
	 */
    public static void makesort(Car[] c){
    	array = new Car[c.length];
        sort(c, 0, c.length - 1, sorttype.MAKE);
    }
    
    /**
	 * Function to Sort by Vehicle Type of Cars
	 * @param Array of Car Objects
	 */
    public static void typesort(Car[] c){
    	array = new Car[c.length];
        sort(c, 0, c.length - 1, sorttype.CATEGORY);
    }
    
    /**
	 * Function to Sort by Models of Cars
	 * @param Array of Car Objects
	 */
    public static void modelsort(Car[] c){
    	array = new Car[c.length];
        sort(c, 0, c.length - 1, sorttype.MODEL);
    }
    
    /**
	 * Function to Sort by City MPG of Cars
	 * @param Array of Car Objects
	 */
    public static void citympgsort(Car[] c){
    	array = new Car[c.length];
        sort(c, 0, c.length - 1, sorttype.CITYMPG);
    }
    
    /**
   	 * Function to Sort by Highway MPG of Cars
   	 * @param Array of Car Objects
   	 */
    public static void highmpgsort(Car[] c){
    	array = new Car[c.length];
        sort(c, 0, c.length - 1, sorttype.HIGHMPG);
    }
    
    /**
   	 * Function to Sort by Combined MPG of Cars
   	 * @param Array of Car Objects
   	 */
    public static void combmpgsort(Car[] c){
    	array = new Car[c.length];
        sort(c, 0, c.length - 1, sorttype.COMBMPG);
    }
    
    /**
   	 * Sort Function Calls MergeSort Recursively
   	 * @param Array of Car Objects
   	 * @param Index of Current Start of Array
   	 * @param Index of Current End of Array
   	 * @param Type of Attribute Being Sorted By
   	 */
    private static void sort( Car[] x, int low, int high, sorttype a) {
		if (high <= low) return;
		int mid = low + (high - low)/2;
		
		sort(x, low, mid, a);
		sort(x, mid + 1, high,a);
		merge(x, low, mid, high, a);
    }
    
    // Merge Function to Join Sorted Sub-Arrays
    /**
   	 * Merge Function to Rejoin Sorted Sub Arrays
   	 * @param Array of Car Objects
   	 * @param Index of Current Start of Array
   	 * @param Index of Current Middle of Array
   	 * @param Index of Current End of Array
   	 * @param Type of Attribute Being Sorted By
   	 */
    public static void merge(Car[] x, int low, int mid, int high, sorttype a) {
    	int i = low;
		int j = mid + 1;
		
		for (int n = low; n <= high; n++) {
			array[n] = x[n];
		}
		
                if (a == sorttype.MODEL){
		for (int n = low; n <= high; n++) {
			if (i > mid)
				x[n] = array[j++];
			else if (j > high)
				x[n] = array[i++];
			else if (lessModel(array[j], array[i]))
				x[n] = array[j++];
			else 
				x[n] = array[i++];
		}
                }
                
                else if (a == sorttype.RECALLS){
		for (int n = low; n <= high; n++) {
			if (i > mid)
				x[n] = array[j++];
			else if (j > high)
				x[n] = array[i++];
			else if (lessRecalls(array[j], array[i]))
				x[n] = array[j++];
			else 
				x[n] = array[i++];
		}
                }
                
                else if (a == sorttype.YEAR){
		for (int n = low; n <= high; n++) {
			if (i > mid)
				x[n] = array[j++];
			else if (j > high)
				x[n] = array[i++];
			else if (lessYear(array[j], array[i]))
				x[n] = array[j++];
			else 
				x[n] = array[i++];
		}
                }
                
                else if (a == sorttype.ID){
		for (int n = low; n <= high; n++) {
			if (i > mid)
				x[n] = array[j++];
			else if (j > high)
				x[n] = array[i++];
			else if (lessID(array[j], array[i]))
				x[n] = array[j++];
			else 
				x[n] = array[i++];
		}
                }
                
                else if (a == sorttype.MAKE){
		for (int n = low; n <= high; n++) {
			if (i > mid)
				x[n] = array[j++];
			else if (j > high)
				x[n] = array[i++];
			else if (lessMake(array[j], array[i]))
				x[n] = array[j++];
			else 
				x[n] = array[i++];
		}
                }
                
                else if (a == sorttype.CITYMPG){
		for (int n = low; n <= high; n++) {
			if (i > mid)
				x[n] = array[j++];
			else if (j > high)
				x[n] = array[i++];
			else if (lessCitympg(array[j], array[i]))
				x[n] = array[j++];
			else 
				x[n] = array[i++];
		}
                }
                
                else if (a == sorttype.HIGHMPG){
		for (int n = low; n <= high; n++) {
			if (i > mid)
				x[n] = array[j++];
			else if (j > high)
				x[n] = array[i++];
			else if (lessHighmpg(array[j], array[i]))
				x[n] = array[j++];
			else 
				x[n] = array[i++];
		}
                }
                
                else if (a == sorttype.COMBMPG){
		for (int n = low; n <= high; n++) {
			if (i > mid)
				x[n] = array[j++];
			else if (j > high)
				x[n] = array[i++];
			else if (lessCombmpg(array[j], array[i]))
				x[n] = array[j++];
			else 
				x[n] = array[i++];
		}
                }
    }
    
    // Function to Compare Cars by Their Number of Recalls
    private static boolean lessRecalls(Car a, Car b){
        return (a.getRecall() < b.getRecall());
    }
    
    // Function to Compare Cars by Their IDs
    private static boolean lessID(Car a, Car b){
        return (a.getID() < b.getID());
    }
    
    // Function to Compare Cars by Their Years
    private static boolean lessYear(Car a, Car b){
        return (a.getYear() < b.getYear());
    }
    
    // Function to Compare Cars by Their Make
    private static boolean lessMake(Car a, Car b){
        return (a.getMake()).compareTo(b.getMake()) < 0;
    }
    
    // Function to Compare Cars by Their Model
    private static boolean lessModel(Car a, Car b){
        return (a.getModel()).compareTo(b.getModel()) < 0;
    }
    
    // Function to Compare Cars by Their City MPG
    private static boolean lessCitympg(Car a, Car b){
        return (a.getCitympg() < b.getCitympg());
    }
    
    // Function to Compare Cars by Their Highway MPG
    private static boolean lessHighmpg(Car a, Car b){
        return (a.getHighmpg() < b.getHighmpg());
    }
    
    // Function to Compare Cars by Their Highway MPG
    private static boolean lessCombmpg(Car a, Car b){
        return (a.getCombmpg() < b.getCombmpg());
    }
    
    /*public static void main(String[] args) {
        Car[] cars = parseCar.readFile("recalls_final.csv");
        recallsort(cars);
        System.out.println(cars[1].getModel());
    }*/
}
