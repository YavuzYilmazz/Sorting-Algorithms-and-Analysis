import java.util.Random;

public class main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
 
        int arr[]=Random10k(); //In this section, you can create the array you want by calling the method you want.
        int arr2[]=new int[arr.length];
        int arr1[]=new int[arr.length];
        System.arraycopy( arr, 0, arr1, 0, arr.length );
        System.arraycopy( arr, 0, arr2, 0, arr.length );
        //all functions are in the end of main class
        
        int length=arr.length;
        SortingClass SortingClass = new SortingClass(arr.length);
        for (int i = 0; i < arr.length; i++) {
        	SortingClass.dataAppend(arr[i]);
        }
        
        
        
        long startTimeHeapsort = System.nanoTime();
        SortingClass.HeapSort(arr1,length);
        double estimatedTimeHeapsort = (double)(System.nanoTime() - startTimeHeapsort)/1000000;
        
        long startTimeShellsort = System. nanoTime();
        SortingClass.shell(arr2, length);
        double estimatedTimeShellsort = (double)(System.nanoTime() - startTimeShellsort)/1000000;
        
        long startTimeIntrosort = System. nanoTime();
        SortingClass.introSort();
        double estimatedTimeIntrosort = (double)(System.nanoTime() - startTimeIntrosort)/1000000;
        
        System.out.println("HeapSort: "+estimatedTimeHeapsort);
        System.out.println("ShellSort: "+estimatedTimeShellsort);
        System.out.println("IntroSort: "+estimatedTimeIntrosort);
	}
	
	@SuppressWarnings("unused")
	private static int[] Equal1k(){
		int arr[]=new int[1000];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=5;
		}
		return arr;
	}
	
	@SuppressWarnings("unused")
	private static int[] Equal10k(){
		int arr[]=new int[10000];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=5;
		}
		return arr;
	}
	
	@SuppressWarnings("unused")
	private static int[] Equal100k(){
		int arr[]=new int[100000];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=5;
		}
		return arr;
	}
	
	@SuppressWarnings("unused")
	private static int[] Random1k(){
		int arr[]=new int[1000];
		Random rand=new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i]=rand.nextInt(arr.length);
		}
		return arr;
	}
	
	@SuppressWarnings("unused")
	private static int[] Random10k(){
		int arr[]=new int[10000];
		Random rand=new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i]=rand.nextInt(arr.length);
		}
		return arr;
	}
	
	@SuppressWarnings("unused")
	private static int[] Random100k(){
		int arr[]=new int[100000];
		Random rand=new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i]=rand.nextInt(arr.length);
		}
		return arr;
	}
	
	@SuppressWarnings("unused")
	private static int[] increasing1k(){
		int arr[]=new int[1000];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i;
		}
		return arr;
	}
	
	@SuppressWarnings("unused")
	private static int[] increasing10k(){
		int arr[]=new int[10000];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i;
		}
		return arr;
	}
	
	@SuppressWarnings("unused")
	private static int[] increasing100k(){
		int arr[]=new int[100000];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i;
		}
		return arr;
	}
	
	@SuppressWarnings("unused")
	private static int[] decreasing1k(){
		int arr[]=new int[1000];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=arr.length-i;
		}
		return arr;
	}
	
	@SuppressWarnings("unused")
	private static int[] decreasing10k(){
		int arr[]=new int[10000];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=arr.length-i;
		}
		return arr;
	}
	
	@SuppressWarnings("unused")
	private static int[] decreasing100k(){
		int arr[]=new int[100000];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=arr.length-i;
		}
		return arr;
	}
	
	
}
