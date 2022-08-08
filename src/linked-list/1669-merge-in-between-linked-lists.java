/*
 * 1669. Merge In Between Linked Lists
 * 
 * Example 1:
 * Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * Output: [0,1,2,1000000,1000001,1000002,5]
 * Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.
 * 
 * Example 2:
 * Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
 * Explanation: The blue edges and nodes in the above figure indicate the result.
 * 
 */


/* Thought:
 * ----------------
 * memorize start node out of remove range in list1
 * memorize end node out of remove range in list1
 * 
 * Pseudo code:
 * 
 * LOOP list1 TO THE END or list2 TO THE END
 * 
 * IF COUNTER == a:
 *  MEMORIZE START NODE
 * IF COUNT UNTIL SMALLER THAN b+1
 *  MEMORIZE END NODE
 * IF LIST UNTIL TO THE END && FIND END NODE:
 *  MERGE List1 TO List2
 * 
 * 
 * Time Complexity:
 * O(n)
 * Space Complexity:
 * O(1)
 */

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode header = list1;
        ListNode secondHeader = list2;
        ListNode startNode = null;
        int count = 1;
        while(count <= b+1 || list2 != null) {
            if(count == a) {
                startNode = list1;
            }
            if(count <= b+1) {
                list1 = list1.next;
            }
            if(list2.next == null && count > b+1) {
                list2.next = list1;
                startNode.next = secondHeader;
                break;
            } else if(list2.next != null) {
                list2 = list2.next;
            }
            count++;
        }
        return header;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}