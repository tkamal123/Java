package OOP2.Network;



public class EventPost extends Post{
	private String EventType;
	 public EventPost(String author, String EventType)
	    {
	       super(author);
	       this.EventType=EventType;
	    }
	 public String getEventType() {
		    return EventType;
		  }
	 @Override
	 public void display()
	    {
		 System.out.println(EventType);
		 super.display();
	
	        
	    }
	 

}
