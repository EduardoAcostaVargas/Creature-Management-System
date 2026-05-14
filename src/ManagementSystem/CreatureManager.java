package ManagementSystem;

import java.util.List;
import java.util.Scanner;

public class CreatureManager {

    public static void run() {
        List<Creature> creatures = new java.util.ArrayList<>();
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("--- Creature Manager ---");
            System.out.println("1. Add Creature");
            System.out.println("2. Remove Creature");
            System.out.println("3. Display Creatures");
            System.out.println("4. Filter Creatures");
            System.out.println("5. Statistics");
            System.out.println("6. Creatures lore");
            System.out.println("7. Modify Creature");
            System.out.println("8. Exit");
            System.out.print("Choose an option:  ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter creature type(Dragon, Phoenix, Griffin): ");
                    String creatureType = sc.nextLine();
                    System.out.println("Enter creature name: ");
                    String creatureName = sc.nextLine();
                    System.out.println("Enter creature age: ");
                    int creatureAge = sc.nextInt();
                    sc.nextLine();
                    if (creatureType.equalsIgnoreCase("dragon")) {
                        System.out.println("Enter dragon element(Fire, Ice, Lightning, Water, Earth): ");
                        String dragonElement = sc.nextLine();
                        creatures.add(new Dragon(creatureName, dragonElement, creatureAge, creatureType));
                    } else if (creatureType.equalsIgnoreCase("phoenix")) {
                        creatures.add(new Phoenix(creatureName, creatureAge));
                    } else if (creatureType.equalsIgnoreCase("griffin")) {
                        creatures.add(new Griffin(creatureName, creatureAge));
                    } else {
                        System.out.println("Invalid creature type. Creature not added.");
                    }
                    break;
                case 2:
                    System.out.println("Enter creature name to remove: ");
                    String nameToRemove = sc.nextLine().trim();
                    boolean found = false;
                    try {
                        for (Creature creature : creatures) {
                            if (creature.getCreatureName().equalsIgnoreCase(nameToRemove)) {
                                creatures.remove(creature);
                                System.out.println("Creature removed: " + nameToRemove);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            throw new Exception("Creature not found: " + nameToRemove);
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("--- All Creatures ---");
                    for (Creature creature : creatures) {
                        System.out.println(
                                "Name: [" + creature.getCreatureName() + "], Type: [" + creature.getCreatureType() + "]"
                        );
                    }
                    System.out.println("---------------------");
                    break;
                case 4:
                    System.out.println("--- Filter Creatures ---");
                    System.out.println("1. Filter by Type");
                    System.out.println("2. Filter by Age");
                    System.out.println("Choose an option(1-2): ");
                    if (sc.hasNextInt()) {

                        int optionFilter = sc.nextInt();
                        sc.nextLine();

                        switch (optionFilter) {
                            case 1:
                                System.out.println("Enter Creature type: ");
                                String creatureTypeFilter = sc.nextLine();
                                for (Creature creature : creatures) {
                                    if (creature.getCreatureType().equalsIgnoreCase(creatureTypeFilter)) {
                                        System.out.println(
                                                "Name: [" + creature.getCreatureName() + "]"
                                        );
                                    } else {
                                        System.out.println("No creatures of type " + creatureTypeFilter + " found.");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Enter maximum age: ");
                                int ageFilter = sc.nextInt();
                                sc.nextLine();
                                for (Creature creature : creatures) {
                                    if (creature.getAge() <= ageFilter) {
                                        System.out.println(
                                                "Name: [" + creature.getCreatureName() + "], Age: [" + creature.getAge() + "]"
                                        );
                                    }
                                }
                                break;
                            default:
                                System.out.println("Invalid option. Returning to main menu.");
                        }
                    } else {
                        System.out.println("Input must be an integer. Returning to main menu.");
                        sc.nextLine();
                    }
                    break;
                case 5:
                    if (creatures.isEmpty()) {
                        System.out.println("No creatures to display statistics for.");
                        break;
                    } else {
                        System.out.println("--- Statistics ---");
                        System.out.println("Total Creatures: " + creatures.size());

                        int totalAge = 0;
                        for (int i = 0; i < creatures.size(); i++) {
                            totalAge += creatures.get(i).getAge();
                        }
                        System.out.println("Average Age: " + (totalAge / creatures.size()));
                        System.out.println("Creature Types:");
                        int dragonCount = 0;
                        int phoenixCount = 0;
                        int griffinCount = 0;
                        for (int i = 0; i < creatures.size(); i++) {
                            if (creatures.get(i).getCreatureType().equalsIgnoreCase("dragon")) {
                                dragonCount++;
                            } else if (creatures.get(i).getCreatureType().equalsIgnoreCase("phoenix")) {
                                phoenixCount++;
                            } else if (creatures.get(i).getCreatureType().equalsIgnoreCase("griffin")) {
                                griffinCount++;
                            }
                        }
                        System.out.println("Dragons: " + dragonCount);
                        System.out.println("Phoenixes: " + phoenixCount);
                        System.out.println("Griffins: " + griffinCount);
                    }
                    break;
                case 6:
                    System.out.println("Select a creature to view its lore:");
                    System.out.println("1. Dragon");
                    System.out.println("2. Griffin");
                    System.out.println("3. Phoenix");
                    System.out.println("Chose an option(1-3): ");

                    if (sc.hasNextInt()) {

                        int displayChoice = sc.nextInt();
                        sc.nextLine();

                        switch (displayChoice) {
                            case 1:
                                new Dragon("Example Dragon", "Fire", 100, "Dragon").displayInfo();
                                break;
                            case 2:
                                new Griffin("Example Griffin", 50).displayInfo();
                                break;
                            case 3:
                                new Phoenix("Example Phoenix", 100).displayInfo();
                                break;
                            default:
                                System.out.println("Invalid option. Please enter (1-3)");
                                break;
                        }
                    } else {
                        System.out.println("Input must be an integer.");
                        sc.nextLine();
                    }
                    break;
                case 7:
                    System.out.println("Enter creature name to modify: ");
                    String nameToModify = sc.nextLine().trim();
                    System.out.println("What would you like to modify? ");
                    System.out.println("1. Name");
                    System.out.println("2. Age");
                    System.out.println("Choose an option(1-2): ");
                    int modifyOption = sc.nextInt();
                    sc.nextLine();
                    for (Creature creature : creatures) {
                        if (creature.getCreatureName().equalsIgnoreCase(nameToModify)) {
                            switch (modifyOption) {
                                case 1:
                                    System.out.println("Enter new name: ");
                                    String newName = sc.nextLine();
                                    creature.setCreatureName(newName);
                                    System.out.println("Name updated successfully.");
                                    break;
                                case 2:
                                    System.out.println("Enter new age: ");
                                    int newAge = sc.nextInt();
                                    sc.nextLine();
                                    creature.setAge(newAge);
                                    System.out.println("Age updated successfully.");
                                    break;
                                default:
                                    System.out.println("Invalid option. Returning to main menu.");
                            }
                            break;
                        }
                    }
                    break;
                case 8:
                    System.out.println("Exiting Creature Manager. Goodbye!");
                    return;
            }
        }


    }

}
