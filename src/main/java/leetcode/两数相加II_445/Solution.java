package leetcode.两数相加II_445;

import java.util.List;
import java.util.Stack;

/**
 * @author dadongge
 * @date 2020/4/14
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        //只要有一个栈有数据，或者有进位都需要继续进行
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry > 0){
            int sum = carry;
            sum += stack1.isEmpty() ? 0:stack1.pop();
            sum += stack2.isEmpty() ? 0:stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }


    public static void main(String[] args){
        ListNode l11 = new ListNode(7);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        ListNode l14 = new ListNode(3);
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l21.next = l22;
        l22.next = l23;
        Solution solution = new Solution();
        ListNode node = solution.addTwoNumbers(l11, l21);
        System.out.println(node.val);
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}