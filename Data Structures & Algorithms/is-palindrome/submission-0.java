class Solution {
   public boolean isPalindrome(String s) {
        LinkedList currentLinkedList = null;
        LinkedList head = null;
        for(int i=0;i<s.length();i++){
            char letter = s.charAt(i);
            if(!Character.isLetterOrDigit(letter)){
                continue;
            }
            letter = Character.toLowerCase(letter);
            LinkedList linkedList = new LinkedList();
            linkedList.letter = letter;

            if(currentLinkedList != null){
                currentLinkedList.next = linkedList;
                linkedList.prev = currentLinkedList;
            } else {
                head = linkedList;
            }
            currentLinkedList = linkedList;
        }

        while(head != null){
            if(head.letter != currentLinkedList.letter){
                return false;
            }
            head = head.next;
            currentLinkedList = currentLinkedList.prev;
        }
        return true;
    }
}

class LinkedList{
    Character letter;
    LinkedList next;
    LinkedList prev;
}
