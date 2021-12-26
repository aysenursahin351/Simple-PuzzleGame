



public class MultiLinkedList {

	private RowNode head;

	public MultiLinkedList() {

		head = null;
	}

		public void addRow(String dataToAdd) {
			if (head == null) {
				RowNode newnode = new RowNode(dataToAdd);
				head = newnode;
		}
			else {
				RowNode temp = head;
			while (temp.getDown() != null) {
				temp = temp.getDown();
			}
			RowNode newnode = new RowNode(dataToAdd);
			temp.setDown(newnode);

		}
	}

		public void addElement(String row, String element) {

			if (head == null)
				System.out.println("Add a row before element");
			else {
				RowNode temp = head;

				while (temp != null) {

					if (row.equals(temp.getRowCode())) {
						Node temp2 = temp.getRight();

						if (temp2 == null) {
							Node newnode = new Node(element);
							temp.setRight(newnode);
						} else {
							while (temp2.getNext() != null) {
								temp2 = temp2.getNext();
							}
							Node newnode = new Node(element);
							temp2.setNext(newnode);
						}
					}

					temp = temp.getDown();

				}
			}

		}
		
		public void display() {
	        if(head== null)
	            System.out.println("List is empty");
	        else {
	            RowNode temp=head;
	            while(temp!=null) {
	                System.out.print(temp.getRowCode()+ "-->");
	                Node temp2 = temp.getRight();
	                while (temp2!=null) {
	                    System.out.print(temp2.getData()+" ");
	                    temp2=temp2.getNext();
	                }
	                temp=temp.getDown();
	                System.out.println();
	            }
	        }
	    }
		
		public int sizeRow() {
			int count=0;
			if(head==null)
				System.out.println("list is empty");
			else {
				RowNode temp=head;
				while( temp!=null) {
					count++;
					temp=temp.getDown();
				}
			}
			return count;
		}

		
		public int sizeCell(String row) {
            int count=0;
            if(head==null)
                System.out.println("list is empty");
            else {
                RowNode temp=head;
                while( temp!=null) {
                    if(temp.getRowCode().equalsIgnoreCase(row)) {
                        Node temp2=temp.getRight();
                        while (temp2!=null) {
                            count++;
                            temp2=temp2.getNext();
                        }
                        return count;
                    }
                    else
                        temp=temp.getDown();

                }
            }
            return count;
        }

		
		
		public RowNode getHead() {
			return head;
		}

		public void setHead(RowNode head) {
			this.head = head;
		}
		public void delete(String delete) {
            if(head == null) {
                System.out.println("Linked list is empty");
            }
            else {
                RowNode temp = head;
                Node temp2;
                Node prev_temp2;
                while(temp != null) {
                    if(temp.getRight() == null) {
                        temp = temp.getDown();
                        continue;
                    }
                    else {
                        temp2 = temp.getRight();
                        if(temp2.getData().equals(delete)) {
                            temp.setRight(temp2.getNext());
                            return;
                        }
                        else {
                            prev_temp2 = temp2;
                            temp2 = temp2.getNext();
                            while(temp2 != null) {
                                if(temp2.getData().equals(delete)) {
                                    prev_temp2.setNext(temp2.getNext());
                                    return;
                                }
                                else {
                                    prev_temp2 = temp2;
                                    temp2 = temp2.getNext();
                                }
                            }
                            temp = temp.getDown();
                        }
                    }}}

        }

		
}
