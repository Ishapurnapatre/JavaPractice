package basics;
import java.util.*;

// Linear & Binary Search

public class BasicSearch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int array[] = {1,2,3,4,5,6,7,8,9,10};
//		array = new int[9];
		
		System.out.print("Element to Search: ");
		int input = sc.nextInt();
		
		// Linear Search
//		System.out.print("Array: ");
		for(int i = 0; i< array.length; i++) {
//			System.out.print(array[i]+" ");
			if(input == array[i]) {
				System.out.println("Element present at index: "+(i));
			}
			else {
				continue;
			}
		}
		
		// Binary Search....compare with midpoint......sorted array is necessary
		
		int left = 0;    // index starts with zero
		int right = array.length-1;    // 10-1
				
		for(int j=0; j<array.length; j++) {
			
			int mid = left + (right - left)/2;
			
			if(input == array[mid]) {
				System.out.println("Element at index: "+mid);
				break;
			}
			if(input < array[mid]) {
				right = mid;				
			}
			if(input > array[mid]) {
				left = mid;				
			}
		}
		
		// HashSet.....no duplicates allowed.....only one null element allowed.....can't directly get index..needs to be converted in array or list
		
		Set<Integer> set = new HashSet<>(Arrays.asList(Arrays.stream(array).boxed().toArray(Integer[]::new)));
//		set.add(1);
		
		if (set.contains(input)) {
            System.out.println("Element present in the HashSet.");
		}
		
		sc.close();
	}

}

// Minified Solution: package Search;import java.util.*;public class Main {public static void main(String[] args) {Scanner sc=new Scanner(System.in);int[] array={1,2,3,4,5,6,7,8,9,10};System.out.print("Element to Search: ");int input=sc.nextInt();for(int i=0;i<array.length;i++){if(input==array[i]){System.out.println("Element present at index: "+i);}}int left=0,right=array.length-1;for(int j=0;j<array.length;j++){int mid=left+(right-left)/2;if(input==array[mid]){System.out.print("Element at index: "+mid);break;}if(input<array[mid]){right=mid;}else{left=mid;}}}}

