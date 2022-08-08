/*
 * 2130. Maximum Twin Sum of a Linked List
 * 
 * Example 1:
 * Input: head = [5,4,2,1]
 * Output: 6
 * Explanation:
 * Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
 * There are no other nodes with twins in the linked list.
 * Thus, the maximum twin sum of the linked list is 6.
 * 
 * Example 2:
 * Input: head = [4,2,2,3]
 * Output: 7
 * Explanation:
 * The nodes with twins present in this linked list are:
 * - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
 * - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
 * Thus, the maximum twin sum of the linked list is max(7, 4) = 7. 
 * 
 */

/* Thought:
 * ----------------
 * look at the pattern in node
 * 
 * size = 6
 * Twin: (size - node position - 1)
 * Position:
 * 0 -> 6-0-1=5, 5 (pair of node position)
 * 1 -> 6-1-1=4, 4
 * 2 -> 6-2-1=3, 3
 * 3 -> 6-3-1=2, 2
 * 4 -> 6-4-1=1, 1
 * 5 -> 6-5-1=0, 0
 * 
 * Result:
 * when position number is increasing, pair of node position number is decreasing, so that can cut at a half for different approach.
 * first part is to add list
 * second part is to take node from list
 * 
 * Time Complexity:
 * O(n)
 * Space Complexity:
 * O(1)
 */

class Solution {
    public int pairSum(ListNode head) {
        int length = lenList(head);
        int startPoint = length/2;
        ListNode currentNode = head;
        int maxSum = 0;
        int[] sums = new int[startPoint];
        int i=0;
        while (currentNode != null) {
            if(i < startPoint) {
                sums[i] = currentNode.val;
                currentNode = currentNode.next;
            } else {
                maxSum = Math.max(sums[length-i-1]+currentNode.val,maxSum);
                currentNode = currentNode.next;
            }
            i+=1;
        }
        return maxSum;
    }
    
    public int lenList(ListNode head) {
        if(head != null) {
            return 1+lenList(head.next);
        }
        return 0;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}