/*
 * 167. Move Zeroes
 * 
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 */


/* Thought:
 * 
 * Save Array Length first, and get non-zero value into new Array
 * After that, fill in zero to new Array
 * 
 * Pseudo code:
 * 
 * FOR LOOP Length of Array:
 *  IF NON-ZERO:
 *      INSERT TO NEW ARRAY
 *      COUNTER

 * FOR LOOP COUNTER TO end of Array Length:
 *  INSERT ZERO TO NEW ARRAY
 * 
 * Time Complexity:
 * O(n)
 * Space Complexity:
 * O(1)
 */

 class Solution {
    public void moveZeros(int[] nums) {
        int count = 0;
        int length = nums.length;
        for(int i=0; i < length; i++) {
            if(nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }

        for(int j=count; j < length; j++) {
            nums[j] = 0;
        }
    }
 }