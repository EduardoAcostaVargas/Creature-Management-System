package ManagementSystem;

import java.io.Serializable;

public class Griffin extends Creature implements Ability {

    public Griffin(String griffinName, int age) {
        super(griffinName, age, "Griffin");

    }

    @Override
    public void basicAbility() {
        System.out.println(" swoops down with incredible speed, striking its target with razor-sharp claws!");
    }

    @Override
    public void secondaryAbility() {
            System.out.println(" takes to the skies, evading attacks and gaining a strategic advantage!");
    }

    @Override
    public void ultimateAbility() {
        System.out.println(" unleashes a powerful roar, stunning nearby enemies and boosting its own strength!");
    }

    @Override
    public void displayInfo() {
        System.out.println("--- Creature Information ---");
        System.out.println("Griffin");
        System.out.println(
                "A griffin is a legendary creature with the body of a lion and the head and wings of an eagle. \n" +
                "Griffins are known for their strength, courage, and loyalty. They are often depicted as guardians of treasure and sacred places."
        );
        System.out.println("--------------------------");
    }
}
