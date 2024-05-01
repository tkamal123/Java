package FoxesAndRabbits;

import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PopulationGenerator extends Simulator{



        private static final double FOX_CREATION_PROBABILITY = 0.02;
        private static final double RABBIT_CREATION_PROBABILITY = 0.08;
        private static final double HAWK_CREATION_PROBABILITY = 0.03;
        
    


  
    
    	public static void populate(Field field, List<Animal> animals) {
            Random rand = Randomizer.getRandom();
            field.clear();
            for (int row = 0; row < field.getDepth(); row++) {
                for (int col = 0; col < field.getWidth(); col++) {
                    if (rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
                        Location location = new Location(row, col);
                        Fox fox = new Fox(true, field, location);
                        animals.add(fox);
                    } 
                    else if (rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                        Location location = new Location(row, col);
                        Rabbit rabbit = new Rabbit(true, field, location);
                        animals.add(rabbit);
                    }
                    else if(rand.nextDouble() <= HAWK_CREATION_PROBABILITY) {
                   	 Location location = new Location(row, col);
                        Hawk Hawk = new Hawk(true, field, location);
                        animals.add(Hawk);
                   	
                   
                  }
                  
                }
            }
        }
    }
    