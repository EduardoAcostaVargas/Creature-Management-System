package ManagementSystem;


import java.util.List;
import java.util.Scanner;

public class CreatureManager {

    public static void run() {
        CreatureService service = new CreatureService();
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
                    addCreature(sc, service);
                    break;
                case 2:
                    removeCreature(sc, service);
                    break;
                case 3:
                    displayAllCreatures(service);
                    break;
                case 4:
                    filterCreatures(sc, service);
                    break;
                case 5:
                    displayStatistics(service);
                    break;
                case 6:
                    creaturesLore(sc);
                    break;
                case 7:
                    modifyCreatures(service, sc);
                    break;
                case 8:
                    System.out.println("Exiting Creature Manager. Goodbye!");
                    return;
            }
        }


    }

    public static void modifyCreatures(CreatureService service, Scanner sc) {
        if (service.getCreatures().isEmpty()) {
            System.out.println("No creatures to modify at this time. Add at least one creature first.");
            return;
        }else {
            System.out.println("Enter creature name to modify: ");
            String nameToModify = sc.nextLine().trim();
            System.out.println("What would you like to modify? ");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("Choose an option(1-2): ");
            int modifyOption = sc.nextInt();
            sc.nextLine();
            switch (modifyOption) {
                case 1:
                    System.out.println("Enter new name: ");
                    String newName = sc.nextLine();
                    if(service.modifyCreature(nameToModify, newName)) {
                        System.out.println("Successfully modified creature!");
                    } else {
                        System.out.println("No creature found with the name: " + nameToModify);
                    }
                    break;
                case 2:
                    System.out.println("Enter new age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();
                    if(service.modifyCreatureAge(nameToModify, newAge)) {
                        System.out.println("Age successfully modified!");
                    } else {
                        System.out.println("No creature found with the name: " + nameToModify);
                    }
                    break;
                default:
                    System.out.println("Invalid option. Returning to main menu.");
            }
        }
    }

    public static void creaturesLore(Scanner sc) {
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
    }

    public static void displayStatistics(CreatureService service) {
        if (service.getCreatures().isEmpty()) {
            System.out.println("No creatures to display statistics for. Add at least one creature first.");
            return;
        } else {
            System.out.println("--- Creature Statistics ---");
            System.out.println("Total Creatures: " + service.getCreatures().size());
            System.out.println("Average Age: " + String.format("%.2f", service.getAverageAge()));
            System.out.println("Count by Type:");
            service.getCountByType().forEach((type, count) -> {
                System.out.println(" - " + type.substring(0, 1).toUpperCase() + type.substring(1) + ": " + count);
            });
        }
    }

    public static void filterCreatures(Scanner sc, CreatureService service) {
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
                    List<Creature> result = service.filterByType(creatureTypeFilter);
                    if (result.isEmpty()) {
                        System.out.println("No creatures found of type: " + creatureTypeFilter);
                    } else {
                        for (Creature creature : result) {
                            System.out.println("Name: [" + creature.getCreatureName() + "]" + "Type: [" + creature.getCreatureType() + "]");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter maximum age: ");
                    int ageFilter = sc.nextInt();
                    sc.nextLine();
                    for (Creature creature : service.filterByMaxAge(ageFilter)) {
                        System.out.println("Name: [" + creature.getCreatureName() + "]" + "Age: [" + creature.getAge()+ "]");
                    }
                    break;
                default:
                    System.out.println("Invalid option. Returning to main menu.");
            }
        } else {
            System.out.println("Input must be an integer. Returning to main menu.");
            sc.nextLine();
        }
    }

    public static void displayAllCreatures(CreatureService service) {
        System.out.println("--- All Creatures ---");
        for (Creature creature : service.getCreatures()) {
            System.out.println(
                    "Name: [" + creature.getCreatureName() + "], Type: [" + creature.getCreatureType() + "]"
            );
        }
        System.out.println("---------------------");
    }

    public static void removeCreature(Scanner sc, CreatureService service) {
        System.out.println("Enter creature name to remove: ");
        String nameToRemove = sc.nextLine().trim();
        if (service.removeCreature(nameToRemove)) {
            System.out.println("Successfully removed the creature: " + nameToRemove);
        }else {
            System.out.println("No creature found with the name: " + nameToRemove);
        }
    }

    public static void addCreature(Scanner sc,CreatureService service) {
        System.out.println("Enter creature type(Dragon, Phoenix, Griffin): ");
        String creatureType = sc.nextLine();
        System.out.println("Enter creature name: ");
        String creatureName = sc.nextLine();
        System.out.println("Enter creature age: ");
        int age = sc.nextInt();
        sc.nextLine();
        if (creatureType.equalsIgnoreCase("dragon")) {
            System.out.println("Enter dragon element(Fire, Ice, Lightning, Water, Earth): ");
            String dragonElement = sc.nextLine();
            if (!service.addCreature(creatureType, creatureName, age, dragonElement)) {
                System.out.println("Invalid creature type. Creature not added.");
            }
        } else {
            if (!service.addCreature(creatureType, creatureName, age, null)) {
                System.out.println("Invalid creature type. Creature not added.");
            }
        }
    }

}
