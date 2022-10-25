
public class SortingClass {
	// the actual data that has to be sorted
    private int a[];
    
    // the number of elements in the data
    private int n;
 
    // Constructor to initialize the size
    // of the data
    SortingClass(int n)
    {
        a = new int[n];
        this.n = 0;
    }
 
    // The utility function to insert the data
    void dataAppend(int temp)
    {
        a[n] = temp;
        n++;
    }
 
    // The utility function to swap two elements
    private void swap(int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
 
    // To maxHeap a subtree rooted with node i which is
    // an index in a[]. heapN is size of heap
    private void maxHeap(int i, int heapN, int begin)
    {
        int temp = a[begin + i - 1];
        int child;
 
        while (i <= heapN / 2) {
            child = 2 * i;
 
            if (child < heapN
                && a[begin + child - 1] < a[begin + child])
                child++;
 
            if (temp >= a[begin + child - 1])
                break;
 
            a[begin + i - 1] = a[begin + child - 1];
            i = child;
        }
        a[begin + i - 1] = temp;
    }
 
     //Function to build the heap (rearranging the array)
    private void heapify(int begin, int end, int heapN)
    {
        for (int i = (heapN) / 2; i >= 1; i--)
            maxHeap(i, heapN, begin);
    }
 
    // main function to do heapsort
    private void heapSort(int begin, int end)
    {
        int heapN = end - begin;
 
        // Build heap (rearrange array)
        this.heapify(begin, end, heapN);
 
        // One by one extract an element from heap
        for (int i = heapN; i >= 1; i--) {
 
            // Move current root to end
            swap(begin, begin + i);
 
            // call maxHeap() on the reduced heap
            maxHeap(1, i, begin);
        }
    }
 
     void Heapify(int a[], int n, int i)  
	{  
	    int largest = i; // Initialize largest as root  
	    int left = 2 * i + 1; // left child  
	    int right = 2 * i + 2; // right child  
	    // If left child is larger than root  
	    if (left < n && a[left] > a[largest])  
	        largest = left;  
	    // If right child is larger than root  
	    if (right < n && a[right] > a[largest])  
	        largest = right;  
	    // If root is not largest  
	    if (largest != i) {  
	        // swap a[i] with a[largest]  
	        int temp = a[i];  
	        a[i] = a[largest];  
	        a[largest] = temp;  
	          
	        Heapify(a, n, largest);  
	    }  
	}  
	/*Function to implement the heap sort*/  
	 void HeapSort(int a[], int n)  
	{  
	    for (int i = n / 2 - 1; i >= 0; i--)  
	        Heapify(a, n, i);  
	  
	    // One by one extract an element from heap  
	    for (int i = n - 1; i >= 0; i--) {  
	        /* Move current root element to end*/  
	        // swap a[0] with a[i]  
	        int temp = a[0];  
	        a[0] = a[i];  
	        a[i] = temp;  
	          
	        Heapify(a, i, 0);  
	    }  
	}  
	//ShellSort
	 void shell(int a[], int n)  
	{  
	    /* Rearrange the array elements at n/2, n/4, ..., 1 intervals */  
	    for (int interval = n/2; interval > 0; interval /= 2)  
	    {  
	        for (int i = interval; i < n; i += 1)  
	        {  
	            /* store a[i] to the variable temp and make  
	 
	the ith position empty */  
	            int temp = a[i];  
	            int j;        
	            for (j = i; j >= interval && a[j - interval] >   
	temp; j -= interval)  
	                a[j] = a[j - interval];  
	              
	            /* put temp (the original a[i]) in its correct  
	position */  
	            a[j] = temp;  
	        }  
	    }  
	}  
    // function that implements insertion sort
    private void insertionSort(int left, int right)
    {
 
        for (int i = left; i <= right; i++) {
            int key = a[i];
            int j = i;
 
            // Move elements of arr[0..i-1], that are
            // greater than the key, to one position ahead
            // of their current position
            while (j > left && a[j - 1] > key) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = key;
        }
    }
 
    // Function for finding the median of the three elements
    private int findPivot(int a1, int b1, int c1)
    {
        int max = Math.max(Math.max(a[a1], a[b1]), a[c1]);
        int min = Math.min(Math.min(a[a1], a[b1]), a[c1]);
        int median = max ^ min ^ a[a1] ^ a[b1] ^ a[c1];
        if (median == a[a1])
            return a1;
        if (median == a[b1])
            return b1;
        return c1;
    }
 
    // This function takes the last element as pivot, places
    // the pivot element at its correct position in sorted
    // array, and places all smaller (smaller than pivot)
    // to the left of the pivot
    // and greater elements to the right of the pivot
    private int partition(int low, int high)
    {
 
        // pivot
        int pivot = a[high];
 
        // Index of smaller element
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
 
            // If the current element is smaller
            // than or equal to the pivot
            if (a[j] <= pivot) {
 
                // increment index of smaller element
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return (i + 1);
    }
 
    // The main function that implements Introsort
    // low  --> Starting index,
    // high  --> Ending index,
    // depthLimit  --> recursion level
    private void sortDataUtil(int begin, int end, int depthLimit)
    {
        if (end - begin > 16) {
            if (depthLimit == 0) {
 
                // if the recursion limit is
                // occurred call heap sort
                this.heapSort(begin, end);
                return;
            }
 
            depthLimit = depthLimit - 1;
            int pivot = findPivot(begin,
                begin + ((end - begin) / 2) + 1,
                                           end);
            swap(pivot, end);
 
            // p is partitioning index,
            // arr[p] is now at right place
            int p = partition(begin, end);
 
            // Separately sort elements before
            // partition and after partition
            sortDataUtil(begin, p - 1, depthLimit);
            sortDataUtil(p + 1, end, depthLimit);
        }
 
        else {
            // if the data set is small,
            // call insertion sort
            insertionSort(begin, end);
        }
    }
 


	// A utility function to begin the
    // Introsort module
    void introSort()
    {
 
        // Initialise the depthLimit
        // as 2*log(length(data))
        int depthLimit
            = (int)(2 * Math.floor(Math.log(n) /
                                  Math.log(2)));
 
        this.sortDataUtil(0, n - 1, depthLimit);
    }
}
