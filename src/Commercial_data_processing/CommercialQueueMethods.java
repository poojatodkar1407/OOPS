package Commercial_data_processing;

public class CommercialQueueMethods {
	NodeQ front ;
	NodeQ rear ;
	public CommercialQueueMethods()
	{
		this.front = null;
		this.rear = null;
	}
	int length = 0;
	public void enqueue(String str) 
	{
		// TODO Auto-generated method stub		
		NodeQ temp = new NodeQ(str, front, rear);
		if(isEmpty())
		{
			front = temp;
		}
		else
		{
			rear.next = temp;
		}
		rear = temp ; 
		length++ ;
	}
	
	public void dequeue() 
	{
		// TODO Auto-generated method stub		
		NodeQ withdrawl ;
		if(isEmpty())
		{
			System.out.println("No elements in queue !!");
		}
		else
		{
			withdrawl = front ;
			front = withdrawl.next;
		}		
	}	
	public boolean isEmpty()
	{
		return length == 0;
	}
	
	public void show()
	{
		NodeQ temp ;
		temp = front;
		while(temp.next!=null)
		{
			System.out.print(temp.data+" --> ");
			temp = temp.next;
		}
		System.out.println(temp.data);
}
}
