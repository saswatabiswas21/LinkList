class CycleLinkList{
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	public static Node head;
	public static Node tail;
	public static boolean isCycle(){
		Node fast=head;
		Node slow=head;
		while(head!=null && head.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
				return true;
		}
		return false;
	}
	public static void remove(){
		Node slow=head;
		Node fast=head;
		boolean check=false;
		while(fast!=null&&fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(slow==fast){
				check=true;
				break;
			}
		}
		if(check==false)
			return;
		slow=head;
		Node prev=null;
		while(slow!=fast){
			prev=fast;
			slow=slow.next;
			fast=fast.next;
		}
		prev.next=null;
	}
	public static void main(String[] args){
		head=new Node(1);
		Node temp=new Node(2);
		head.next=temp;
		head.next.next=new Node(3);
		head.next.next.next=temp;
		System.out.println(isCycle());
		remove();
		System.out.println(isCycle());
	}
}