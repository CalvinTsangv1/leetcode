/*
 * 26. Remove Duplicates from Sorted Array
 * 
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * 
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).


/* Thought:
 * 
 * Set Smaller Number and Reference previous one, can know previous one whether is deplicated
 * 
 * Pseudo code:
 * 
 * MEMORY_NUMBER = Smaller Number
 * 
 * FOR LOOP Length of Array:
 *  IF no same as previous one:
 *      Memorized current number
 *      INSERT TO Array and add position of array
 * 
 * Time Complexity:
 * O(n)
 * Space Complexity:
 * O(1)
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int position = 0;
        int previousOne = Integer.MIN_VALUE;
        
        for(int i=0; i< nums.length;i++) {
            if(previousOne != nums[i]){
                previousOne = nums[i];
                nums[position++] = nums[i];
            }
        }
        return position;
    }
}