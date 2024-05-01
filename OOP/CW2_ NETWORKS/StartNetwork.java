package OOP2.Network;

public class StartNetwork
{

	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		
		MessagePost message = new MessagePost("White Rabbit", "Oh dear, oh dear, I shall be late!");
		PhotoPost photo = new PhotoPost("Alice Wonderland", "RabbitHole.jpg" ,"Down the rabbit hole :)");
		
		EventPost eventpost = new EventPost("Lunch:","Joon");
		message.addComment( "Your watch is exactly two days slow." );
	
		photo.like();
		
		NewsFeed news = new NewsFeed();
		news.addPost( message );
		news.addPost( photo );
		news.addPost(eventpost) ;
		news.show();

	}
	
	
}
