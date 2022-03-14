package LeeCode;

/**
 * @Description : 合并两个有序链表
 * @Author : LeafTalk
 * @Data : 2021/12/13
 */
public class LC21 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
               if( list1 == null){
                   return list2;
               }else if(list2 == null){
                   return list1;
               }else if(list1.val <= list2.val){
                   list1.next = mergeTwoLists(list1.next,list2);
                   return list1;
               }else {
                   list2.next = mergeTwoLists(list1,list2.next);
                   return list2;
               }
    }

    public ListNode mergeTwoLists02(ListNode list1, ListNode list2) {
            ListNode ln = new ListNode(-1);

            ListNode prev = ln;
            while(list1 != null && list2 !=null){
                if(list1.val <= list2.val){
                    prev.next = list1;
                    list1 =list1.next;
                }else{
                    prev.next = list2;
                    list2 =list2.next;
                }
                prev = prev.next;

            }
            prev.next = list1 ==null? list2:list1;
            return ln.next;
    }
}

 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
