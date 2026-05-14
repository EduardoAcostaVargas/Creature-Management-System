package UnitTesting;

import ManagementSystem.Creature;
import ManagementSystem.CreatureManager;
import ManagementSystem.Dragon;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class FCMUnitTesting {
    @Test
    public void addCreature() {
        //Arrange
        String input = "Dragon\nSmolder\n150\nFire\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        List<Creature> creatures = new ArrayList<>();


        //Act
        CreatureManager.addCreature(sc, creatures);

        //Assert
        assertEquals(1, creatures.size());
        assertEquals("Smolder", creatures.get(0).getCreatureName());
        assertEquals("Dragon", creatures.get(0).getCreatureType());
    }

    @Test
    public void removeCreature() {
        //Arrange
        String input = "Smolder\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        List<Creature> creatures = new ArrayList<>();
        creatures.add(new Dragon("Smolder", "Fire", 150, "Dragon"));

        //Act
        CreatureManager.removeCreature(sc, creatures);

        //Assert
        assertEquals(0, creatures.size());
    }

    @Test
    public void modifyCreatureName() {
        //Arrange
            String input = "Smolder\n1\nEmber\n";
            Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
            List<Creature> creatures = new ArrayList<>();
            creatures.add(new Dragon("Smolder", "Fire", 150, "Dragon"));

        //Act
        CreatureManager.modifyCreatures(creatures, sc);

        //Assert
        assertEquals(1, creatures.size());
        assertEquals("Ember", creatures.get(0).getCreatureName());
    }

    @Test
    public void modifyCreatureAge() {
        //Arrange
        String input = "Smolder\n2\n200\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        List<Creature> creatures = new ArrayList<>();
        creatures.add(new Dragon("Smolder", "Fire", 150, "Dragon"));
        //Act
        CreatureManager.modifyCreatures(creatures, sc);

        //Assert
        assertEquals(1, creatures.size());
    }

}
