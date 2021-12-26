
public class SingleLinkedList {
	Node head;
	
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	int counth=0;
	int countb=0;
	
	public void sortedInsert(String data) 
    {   
         Node current; ///head boşsa buraya giriyor hem de eğer data headden küçükse headi newnode yapıyoruz yani listenin başına ekleniyor.
         if (head == null || head.getData().compareToIgnoreCase(data) >= 0) 
            { 
             Node new_node = new Node(data); 
             new_node.setNext(head);
             head = new_node; 
         } 
         else { 
            current = head; 
            while (current.getNext()!= null && 
               current.getNext().getData().compareToIgnoreCase(data) <0) {
               current = current.getNext(); }
               Node new_node = new Node(data); 
               new_node.setNext(current.getNext());
               current.setNext(new_node); 
         } 
     } 
		public  void printList() 
     { 
         Node temp = head; 
         while (temp != null) 
         { 
            System.out.println(temp.getData()+" "); 
            temp = temp.getNext(); 
         } 
     } 
		public int size() {
			Node temp=head;int count=0;
			while (temp != null) 
				{  
				temp = temp.getNext(); count++;
				}
			return count; 
  }

		public  void printList2() 
        { int y=8;
          int x=25;
        	Game game2=new Game();
            Node temp = head; 
            while (temp != null) 
            { game2.cn.getTextWindow().setCursorPosition(x, y);

               System.out.println(temp.getData()+" "); 

               y++;
               if(y==19) {
            	   y=8;
            	   x=41;
               }
               temp = temp.getNext(); 
            } 
        }
		public static int y=8;
        
		public void Search3(String data) {
            
			int y=8;
			int x=26;
			boolean flag=false;
			Game game2=new Game();
                if (head==null) {

                }
                else {
                    Node temp=head;
                    do {
                        if (temp.getData().equals((String)data)) {
                            flag=true;
                            break;
                            }
                            temp=temp.getNext();
                            y++;
                            if(y == 19) {
                            	y=8;
                            	x=41;
                            }
                    } while (temp.getNext() != null);
                    game2.cn.getTextWindow().setCursorPosition(x+1, y);
                    System.out.print("x");
                   //System.out.println(y);

                }


            }
		

}
