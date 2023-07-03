class LinkList{
//***********NESTED CLASS NODE****************
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
		public static Node head;
		public static Node tail;
		public static int size;
//********ADD A NODE AT FIRST*****************
		public void addFirst(int data){
			Node newNode=new Node(data);//Creating new node
			size++;
			if(head==null){
				head=tail=newNode;
				return;
			}
			newNode.next=head;//Link part
			head=newNode;
		}
//********ADD A NODE AT LAST*****************
		public void addLast(int data){
			Node newNode=new Node(data);
			size++;
			if(head==null){
				head=tail=newNode;
				return;
			}
			tail.next=newNode;
			tail=newNode;
		}
//********ADD A NODE IN MIDDLE*****************
		public void addMiddle(int data,int index){
			if(index==0){
				addFirst(data);
				return;
			}
			Node newNode=new Node(data);
			size++;
			Node temp=head;
			int i=0;
			while(i==index-1){
				temp=temp.next;
				i++;
			}
			newNode.next=temp.next;
			temp.next=newNode;
		}
//********REMOVE FIRST NODE*****************
		public int removeFirst(){
			if(size==0){
				System.out.println("Link List is empty");
				return Integer.MIN_VALUE;
			}
			else if(size==1){
				int val=head.data;
				head=tail=null;
				size=0;
				return val;
			}
			int val=head.data;
			head=head.next;
			size--;
			return val;
		}
//********REMOVE LAST NODE*****************
		public int removeLast(){
			if(size==0){
				System.out.println("Link List is empty");
				return Integer.MIN_VALUE;
			}
			else if(size==1){
				int val=head.data;
				head=tail=null;
				size=0;
				return val;
			}
			Node prev=head;
			for(int i=0;i<size-2;i++){
				prev=prev.next;
			}
			int val=tail.data;
			prev.next=null;
			tail=prev;
			size--;
			return val;
		}
//********ITERATIVE SCARCH IN A LINK LIST*****************
		public int scarch(int key){
			Node temp=head;
			int i=0;
			while(temp!=null){
				if(temp.data==key)
					return i;//IF KEY IS FOUND
				temp=temp.next;
				i++;
			}
			return -1;//IF KEY IS NOT FOUND
		}
//********ITERATIVE SCARCH IN A LINK LIST WITH RECURSION*****************
		public int helper(Node head,int key){
			if(head==null)
				return -1;
			if(head.data==key)
				return 0;
			int indx=helper(head.next,key);
			if(indx==-1)
				return -1;
			return indx+1;
		}
		public int scarchRecurcion(int key){
			return helper(head,key);
		}
//*********REVERSE A LINK LIST*************
		public void reverse(){
			Node prev=null;
			Node curr=tail=head;
			Node next;
			while(curr!=null){
				next=curr.next;
				curr.next=prev;
				prev=curr;
				curr=next;
			}
			head=prev;
		}
//********DELEAT Nth ELEMENT FROM LAST
		public void deleat(int n){
			//FIND SIZE OF LIBKLIST
			int sz=0;
			Node temp=head;
			while(temp!=null){
				temp=temp.next;
				sz++;
			}
			//IF 1st ELEMENT WAT TO DELEAT 
			if(sz==n){
				head=head.next;
				return;
			}
			//OTHER THEN 1st ELEMENT
			int i=1;
			int find=size-n;
			Node prev=head;
			while(i<find){
				prev=prev.next;
				i++;
			}
			prev.next=prev.next.next;
			return;
		}
//********DISPLAY LINKLIST*****************
		public void display(){
			Node temp=head;
			while(temp!=null){
				System.out.print(temp.data+"\t");
				temp=temp.next;
			}
			System.out.println();
		}
//*********MAIN METHORD*********************
	public static void main(String[] args){
			LinkList ll=new LinkList();
			ll.addFirst(2);
			ll.addFirst(1);
			ll.addLast(3);
			ll.addLast(4);
			ll.addMiddle(9,2);
			ll.display();
			System.out.println("After deleat 1st element:: ");
			ll.deleat(3);
			ll.display();
			/*System.out.println("The key is at:: "+ll.scarch(9));
			System.out.println("The key is at:: "+ll.scarchRecurcion(9));*/
			/*ll.reverse();
			System.out.println("Rverse linklist is:: ");
			ll.display();*/
			/*System.out.println("Size of a link list is :: "+ll.size);
			System.out.println("After deleation head");
			ll.removeFirst();
			ll.display();
			System.out.println("Size of a link list is :: "+ll.size);
			System.out.println("After deleation tail");
			ll.removeLast();
			ll.display();
			System.out.println("Size of a link list is :: "+ll.size);*/
	}
}