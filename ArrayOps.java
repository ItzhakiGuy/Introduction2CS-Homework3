/**
* Course: Intro To Computer Science
* Homework: 3
* Task: 2
* Name: Guy Itzhaki
* E-mail: itzhaki1234@gmail.com
*/

// Performs various array operations
public class ArrayOps 
{

	public static void main(String[] args) 
	{
		test_printArr();
		test_maxArr();
	}	
	
	public static void test_printArr()
	{
		int[] a = {2,  1,  9,  7,  0};
		printArr(a); 
	}
	
	public static void test_maxArr()
	{
		int[] a = {2,  1,  9,  7,  0};
		int[] b = {3,  0,  8, 11, -1, 9 ,-2};
		int[] maxArr = maxArr(a,b);
		System.out.print("a = "); printArr(a); 
		System.out.print("b = "); printArr(b); 
		System.out.print("max = "); printArr(maxArr); 
	}	
	
	/** Returns an array whose elements are the maxima of the respective elements of the 
	 *  two given arrays. The size of the returned array is the size of the longer array.
	 *  For example, if the two given arrays are [3,4,1] and [2,6,8,5,1], returns [3,6,8,5,1]. 
	 */
	public static int[] maxArr(int[] a, int[] b) 
	{
		int runmin,runmax=0;
		runmin=(Math.min(a.length, b.length));
		runmax=(Math.max(a.length, b.length));
		int[] newarr=new int[runmax];
		for (int i=0; i<runmin; i++)
			if (a[i]>b[i])
				newarr[i]=a[i];
			else
				newarr[i]=b[i];
		if (a.length>b.length)
		{
			for (int i=runmin; i<runmax; i++)
				newarr[i]=a[i];
		}
		else
			for (int i=runmin; i<runmax; i++) //When the length of a and b equal it won't run
				newarr[i]=b[i];
		return newarr;
	}
	
	/** Prints the given array in one line, with space separators, 
	 *  and then skips to the next line.
	 */
	public static void printArr(int[] arr) 
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
	    }
		System.out.println();
	}
}
