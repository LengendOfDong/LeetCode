package leetcode.链表的中间结点_876;

/**
 * 双指针法
 * @author dadongge
 * @date 2020/3/23
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;
        while(node2 != null && node2.next != null){
            node2 = node2.next.next;
            node1 = node1.next;
        }
        return node1;
    }
}
