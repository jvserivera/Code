package Code;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		int[] test = {1, 3, 1, 4};
		for (int i : fix34(test)) {System.out.println(i);}

	}




	/*
	 * Consider the leftmost and righmost appearances of some value in an array.
	 *  We'll say that the "span" is the number of elements between the two inclusive.
	 *  A single value has a span of 1. 
	 *  Returns the largest span found in the given array. (Efficiency is not a priority.)
	 */


	public int maxSpan(int[] nums) {
		if(nums.length ==0) return 0;
		int maxSpan =1;
		for(int i =0;i<nums.length;i++){
			for(int j =i;j<nums.length;j++) {
				if(nums[i] == nums[j] && j-i+1> maxSpan) {
					maxSpan = j-i+1;
				}
			}
		}
		return maxSpan;
	}


	/*
	 * 
		Return an array that contains exactly the same numbers as the given array,
 		but rearranged so that every 3 is immediately followed by a 4.
		Do not move the 3's, but every other number may move.
   		The array contains the same number of 3's and 4's,
    	every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.
	 */


	public static int[] fix34(int[] nums) {
		ArrayList<Integer> lostNumbers = new ArrayList<Integer>();
		int extra4 =-1;
		for(int i =0;i< nums.length-1;i++) {
			if (nums[i] == 3 && nums[i+1] != 4) {
				lostNumbers.add(nums[i+1]);
				nums[i+1] = 4;
				extra4++;
			}
		}
		for (int i =0;i<nums.length-1;i++) {
			
			if (nums[i] != 3 && nums[i+1] == 4 && extra4>-1) {
				nums[i+1] = lostNumbers.get(extra4);
			}
		}
		return nums;
	}
}





