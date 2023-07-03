class DoubleLL{
	 class Node{
		int data;
		Node next;
		Node prev;
		public Node(int data){
			this.data=data;
			this.next=null;
			this.prev=null;
		}
	}
	public static Node head;
	public static Node tail;
	public static int size;
//*************ADD DATA AT FIRST****************	
	public void addFirst(int data){
		Node newNode=new Node(data);
		size++;
		if(head==null){
			head=tail=newNode;
			return;
		}
		newNode.next=head;
		head.prev=newNode;
		head=newNode;
	}
//*************REMOVE FROM FIRST****************
	public int removeFirst(){
		if(head==null){
			System.out.println("DLL is empty");
			return Integer.MAX_VALUE;
		}
		if(size==1){
			int s=head.data;
			head=head.next;
			size--;
			return s;
		}
		int s=head.data;
		head=head.next;
		head.prev=null;
		size--;
		return s;
	}
//*********REVERSE A DOBLE LINK LIST*************
		public void reverse(){
			Node prev=null;
			Node curr=tail=head;
			Node next;
			while(curr!=null){
				next=curr.next;
				curr.next=prev;
				curr.prev=next;
				prev=curr;
				curr=next;
			}
			head=prev;
		}
//*************DISPLAY THE LINKLIST***************
	public void display(){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data+"\t");
			temp=temp.next;
		}
		System.out.println();
	}
//**************MAIN METHORD******************
	public static void main(String[] args){
		DoubleLL dll=new DoubleLL();
		dll.addFirst(5);
		dll.addFirst(4);
		dll.addFirst(3);
		dll.addFirst(2);
		dll.addFirst(1);
		System.out.println("The entered linklist is:: ");
		dll.display();
		dll.reverse();
		System.out.println("The reversed linklist is:: ");
		dll.display();
		/*dll.removeFirst();
		System.out.println("After deleating from first:: ");
		dll.display();*/
	}
}