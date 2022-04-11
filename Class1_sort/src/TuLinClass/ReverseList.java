package TuLinClass;

public class ReverseList {
    static class  ListNode{
        int val;
        ListNode next;
        public  ListNode(int val, ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public  static  ListNode interate(ListNode head){
        ListNode prev=null,next;
        ListNode curr=head;
        while (curr!=null){
            next=curr.next;//记下他的下一节点，因为会断开这个next
            curr.next=prev;//反转
            prev=curr;//当前节点变成前继结点
            curr=next;//后继节点变成当前结点
        }
        return prev;
    }
    public static ListNode recursion(ListNode head){//从后往前找,递归
        if(head==null||head.next==null){//链表为空，无需反转；已经找到最后一个
            //返回前一个，既不为空的最后一个结点
            return head;
        }//1-2-3-4-5这样一个链表
        ListNode new_head= recursion(head.next);//先找到最后一个元素,5
        head.next.next=head;//5指向4，head=4,head.next.next=new_head.next
        head.next=null;//4指向空
        return new_head;
    }

    public static void main(String[] args) {
        ListNode node5=new ListNode(5,null);
        ListNode node4=new ListNode(4,node5);
        ListNode node3=new ListNode(3,node4);
        ListNode node2=new ListNode(2,node3);
        ListNode node1=new ListNode(1,node2);

        ListNode prev = recursion(node1);
        System.out.println(prev);

    }

}
