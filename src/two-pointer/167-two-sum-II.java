/*
 * 167. Two Sum II - Input Array Is Sorted
 * 
 * Example 1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * 
 * Example 2:
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * 
 * Example 3:
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 */


/* Thought:
 * ----------------
 * 1. Array = 1,2,3,4,5,6,7 , target = 13
 *  smaller = 1
 *  larger = 7
 *  total = 7 + 1 = 8
 *  result: not larger than target 13, left pointer move to right (number will get increased as sorted array situation) until larger than target
 * 
 * 2. Array = 1,2,3,4,5,6,7, target = 3
 *  smaller = 1
 *  larger = 7
 *  total = 7 + 1 = 8
 *  result: larger than target 3, right pointer move to left (number will get decreased as sorted array situation) until smaller than target
 * 
 * Pseudo code:
 * 
 * SUM = left hand side number (SMALLER NUMBER) + right hand side number (LARGER NUMBER)
 * 
 * IF SUM > target:
 *  MAKE Number Smaller
 * ELSE IF SUM < target:
 *  MAKE Number Larger
 * ELSE SUM = target:
 *  IS RIGHT ANSWER
 * 
 * Time Complexity:
 * O(n)
 * Space Complexity:
 * O(1)
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        //handle specific case when numbers array is empty or null.
        if(numbers == null || numbers.length == 0)
            return null;

        //init two pointer in start and end position.
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        while(leftPointer < rightPointer) {
            int twoSum = numbers[leftPointer] + numbers[rightPointer];

            if(twoSum > target) {
                rightPointer--;
            } else if (twoSum < target) {
                leftPointer++;
            } else {
                return new int[] {leftPointer+1, rightPointer+1};
            }
        }
        return null;
    }
}