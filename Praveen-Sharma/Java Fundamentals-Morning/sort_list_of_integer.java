package JavaFundamental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class sort_list_of_integer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for(int i=0;i<n;i++){
			arr.add(sc.nextInt());
		}
		
		System.out.println("List Before Sorting");
		for(int val:arr){
			System.out.print(val+" ");
		}
		
		Collections.sort(arr);
		
		
		System.out.println();
		System.out.println("List After Sorting");
		for(int val:arr){
			System.out.print(val+" ");
		}

	}

}
