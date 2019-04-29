package Commercial_data_processing;

public class NodeQ {
	public String data;
	public NodeQ next;	
	public NodeQ previous ;
	public NodeQ(String data , NodeQ next ,NodeQ previous) 
	{
		super();
		this.data = data;
		this.next = next;
		this.previous = previous ;
} 
}
