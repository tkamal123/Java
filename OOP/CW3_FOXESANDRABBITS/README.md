Introduce a new class PopulationGenerator:
Create a new class, PopulationGenerator, and move the populate method from Simulator.java into this new class.
Ensure that only PopulationGenerator is coupled to the concrete animal classes (Fox and Rabbit), making it easier to find places where changes are necessary when extending the application.
Modify Simulator.java to call the PopulationGenerator.
Introduce New Animals:
Define a new type of animal as a subclass of Animal, considering its impact on existing animal types.
Experiment with configuration settings (e.g., breeding age/probability, litter size, max age) to re-establish equilibrium in the ecosystem.
Modify the populate method to include the new animal.
Double check the giveBirth method to ensure the new animal gives birth correctly.
Define a new color for the new animal class in the constructor of the Simulator class.
Define a new Superclass:
Introduce a new Abstract Class (e.g., Predator) to reduce code duplication within other animals.
Implement methods like hunt to replace specific behaviors (e.g., findFood in Fox).
Optionally, create a superclass Prey if Predators are not restricted to only eating Rabbits.
For apex predators, handle multiple inheritance or use interfaces instead of an abstract class.
