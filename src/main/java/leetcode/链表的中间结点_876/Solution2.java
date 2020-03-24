package leetcode.链表的中间结点_876;

/**
 * 数组
 * @author dadongge
 * @date 2020/3/23
 */
public class Solution2 {
    public ListNode middleNode(ListNode head){
        ListNode[] A = new ListNode[101];
        int count = 0;
        while(head != null){
            A[++count] = head;
            head = head.next;
        }
        return A[count / 2 + 1];
    }
}
