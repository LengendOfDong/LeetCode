package leetcode.链表的中间结点_876;

/**
 * 单指针法
 * @author dadongge
 * @date 2020/3/23
 */
public class Solution1 {
    public ListNode middleNode(ListNode head){
        ListNode node = head;
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        count = count / 2 ;
        while(count != 0){
            head = head.next;
            count--;
        }
        return head;
    }
}
