public abstract class GameSuperclass
{
	// Attributes
	public String gameName;
	//Constructor 
	public GameSuperclass(String gameName)
	{
		//current object in a constructor 
		this.gameName =gameName;
		
	}
	
	abstract public void printGameIntro();
	abstract public boolean processInput(int value);
}
