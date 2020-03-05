package leetcode.两数相加_2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overnum = 0;
        return getNode(l1,l2,overnum);
    }

    private ListNode getNode(ListNode l1,ListNode l2,int overnum){
        int sum = l1.val + l2.val + overnum;
        overnum = 0;
        if(sum >= 10){
            overnum = sum/10;
            sum = sum%10;
        }
        l1 = l1.next;
        l2 = l2.next;
        ListNode node = new ListNode(sum);
        if( l1 == null){
            if(l2 != null){
                node.next = l2;
                while(overnum != 0){
                    l2.val = l2.val + overnum;
                    overnum = 0;
                    if(l2.val >= 10){
                        overnum = l2.val/10;
                        l2.val = l2.val%10;
                    }
                    if(l2.next == null){
                        if(overnum != 0){
                            l2.next = new ListNode(overnum);
                            overnum = 0;
                        }
                    }else{
                        l2 = l2.next;
                    }
                }
            }else{
                if(overnum != 0){
                    node.next = new ListNode(overnum);
                }else{
                    node.next = null;
                }
            }
        }else if(l2 == null){
            if(l1 != null){
                node.next = l1;
                while(overnum != 0){
                    l1.val = l1.val + overnum;
                    overnum = 0;
                    if(l1.val >= 10){
                        overnum = l1.val/10;
                        l1.val = l1.val%10;
                    }
                    if(l1.next == null){
                        if(overnum != 0){
                            l1.next = new ListNode(overnum);
                            overnum = 0;
                        }
                    }else{
                        l1 = l1.next;
                    }
                }
            }else{
                if(overnum != 0){
                    node.next = new ListNode(overnum);
                }else{
                    node.next = null;
                }
            }
        }else{
            node.next = getNode(l1,l2,overnum);
        }
        return node;
    }
}