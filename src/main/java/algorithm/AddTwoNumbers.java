/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package algorithm;

/**
 * TODO
 * 给定两个非空链表示2个非负整数，位数按照逆序方式存储，每个节点只存储单个数字。
 * 将两数相加返回一个新的链表
 * 输入：2-》4-》3 + 5-》6-》4
 * 输出：7-》0-》8
 * 原因：342+465=807
 * 考虑：列表长度不等和不同的进位的情况
 * @author wqc
 * @version V1.0
 * @since 2019-07-16 14:32
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.nextNode= new Node(4);
        node1.nextNode.nextNode = new Node(5);

        Node node2 = new Node(5);
        node2.nextNode = new Node(6);
        node2.nextNode.nextNode = new Node(4);
        Node node3 = addTwoNumbers(node1,node2);
        while(node3 != null){
            System.out.println(node3.data+"---");
            node3=node3.nextNode;
        }

    }

    public static Node addTwoNumbers(Node node1, Node node2){
        Node result = new Node(0);
        Node p=node1;
        Node q=node2;
        Node curr = result;
        int carry = 0;
        while (p !=null ||q!=null){
            int x = (p != null)?p.data:0;
            int y = (q !=null)?q.data:0;
            int sum = carry + x + y;
            carry = sum/10;
            curr.nextNode = new Node(sum%10);
            curr = curr.nextNode;
            if(p != null)
                p = p.nextNode;

            if(q != null)
                q = q.nextNode;
        }

        //判断最后一位是否进位
        if(carry > 0)
            curr.nextNode = new Node(carry);
        return result.nextNode;
    }

}
