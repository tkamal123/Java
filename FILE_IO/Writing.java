import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writing {

    public static void main(String[] args) {

	try {
	    BufferedWriter writer = new BufferedWriter(new FileWriter("conversation.txt"));
	    writer.write("What took you so long?");
	    writer.write("\nWell, you know, Master, I couldn't find a speeder that I really liked...");
	    writer.write("\nThere he is.");
	    writer.write("\n...with an open cockpit and the right speed capabilities.");
	    writer.write("\nIf you spent as much time practicing your saber techniques as you did your wit,");
	    writer.write("\nyou'd rival Master Yoda as a swordsman.");
	    writer.write("\nI thought I already did.");
	    writer.write("\nOnly in your mind, my very young apprentice");
	    writer.close();

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}