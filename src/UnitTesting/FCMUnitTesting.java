package UnitTesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FCMUnitTesting {
    @Test
    public void addCreature() {
        //Arrange
        String nameToAdd = "Smolder";
        String creatureType = "Dragon";
        String creatureElement = "Fire";
        int age = 25;


        //Act
        addCreature();

        //Assert
    }

    @Test
    public void removeCreature() {
        //Arrange
        String nameToRemove = "Smolder";

        //Act

        //Assert
    }

    @Test
    public void modifyCreatureName() {
        //Arrange
        String previousName = "Smolder";
        String newName = "Spyro";
        //Act

        //Assert
    }

    @Test
    public void modifyCreatureAge() {
        //Arrange
        int previousAge = 150;
        int newAge = 250;
        //Act

        //Assert
    }

}
