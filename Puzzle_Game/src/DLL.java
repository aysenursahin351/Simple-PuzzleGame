
public class DLL {
	public static Node head=null;;
    static void sortedInsert(int number, String data) 
    { 
    	Node current=head; 
             if (head == null) {
                Node newNode = new Node(); 
                newNode.setNumber(number,data);  
                newNode.setPrev(null);newNode.setNext(null);
                head = newNode;  
               } 
            else if (current.getNumber() <=number)  	
            {  
            	current=head;
				Node newNode = new Node(); 
                newNode.setNumber(number,data);  
                newNode.setPrev(null);newNode.setNext(null);	
            	newNode.setNext(head);
                head = newNode; 
            } 
            else 
            { 
                current = head;
                while ((current.getNext() != null &&  
                        current.getNext().getNumber() >number))  
                    current = current.getNext(); 
                  Node newNode = new Node(); 
                newNode.setNumber(number,data);  
                newNode.setPrev(null);newNode.setNext(null);
                newNode.setNext(current.getNext());
                if (current.getNext() != null)  
                    newNode.getNext().setPrev(newNode); 
  
                current.setNext(newNode);
                newNode.setPrev(current);
              
            } 
            
    } 
    static void sortedInsert2(int number, String data) ///Alfabetik sıralıyor.
    { 
            Node current=head; 
            if (head == null) {
            	Node newNode = new Node(); 
                newNode.setNumber(number,data);  
                newNode.setPrev(null);newNode.setNext(null);
                head = newNode;
            	
            }
            else if ( head.getData().compareToIgnoreCase(data) <= 0) {
            	current=head;
            	Node newNode = new Node(); 
                newNode.setNumber(number,data);  
                newNode.setPrev(null);newNode.setNext(null);
            	 newNode.setNext(head);
                 head = newNode; 
			}          
            else 
            { 
            	current=head; 
                while (current.getNext() != null &&  
                		current.getNext().getData().compareToIgnoreCase(data) > 0)  
                    current = current.getNext(); 
                  Node newNode = new Node(); 
                newNode.setNumber(number,data);  
                newNode.setPrev(null);newNode.setNext(null);
                newNode.setNext(current.getNext());
                if (current.getNext() != null)  
                    newNode.getNext().setPrev(newNode); 
                current.setNext(newNode);
                newNode.setPrev(current);              
            } 
            
    } 
  
      static void printList(Node Head) 
    { int y=15;Game game3=new Game();
            while (head != null)  
            {       game3.cn.getTextWindow().setCursorPosition(60, y);
                    System.out.println(+head.getNumber() +" "+head.getData()); 
                    head = head.getNext(); y++;
            } 
  
    } 
  

}
