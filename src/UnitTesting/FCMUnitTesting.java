package UnitTesting;

import ManagementSystem.Creature;
import ManagementSystem.CreatureManager;
import ManagementSystem.CreatureService;
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
        // Arrange
        CreatureService service = new CreatureService();

        // Act
        service.addCreature("Dragon", "Smolder", 150, "Fire");

        // Assert
        assertEquals(1, service.getCreatures().size());
        assertEquals("Smolder", service.getCreatures().get(0).getCreatureName());
        assertEquals("Dragon", service.getCreatures().get(0).getCreatureType());
    }

    @Test
    public void removeCreature() {
        // Arrange
        CreatureService service = new CreatureService();
        service.addCreature("Dragon", "Smolder", 150, "Fire");

        // Act
        service.removeCreature("Smolder");

        // Assert
        assertEquals(0, service.getCreatures().size());
    }

    @Test
    public void modifyCreatureName() {
        // Arrange
        CreatureService service = new CreatureService();
        service.addCreature("Dragon", "Smolder", 150, "Fire");

        // Act
        service.modifyCreature("Smolder", "Ember");

        // Assert
        assertEquals("Ember", service.getCreatures().get(0).getCreatureName());
    }

    @Test
    public void modifyCreatureAge() {
        // Arrange
        CreatureService service = new CreatureService();
        service.addCreature("Dragon", "Smolder", 150, "Fire");

        // Act
        service.modifyCreatureAge("Smolder", 200);

        // Assert
        assertEquals(200, service.getCreatures().get(0).getAge());
    }

}
