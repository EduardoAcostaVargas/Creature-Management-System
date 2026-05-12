package ManagementSystem;

public class Phoenix extends Creature implements Ability {
    private final String creatureType = "Phoenix";

    public Phoenix(String phoenixName, int age) {
        super(phoenixName, age, "Phoenix");
    }

    @Override
    public void basicAbility() {
        System.out.println(getCreatureName() + " unleashes a powerful firestorm, engulfing its enemies in flames!");
    }

    @Override
    public void secondaryAbility() {
        System.out.println(getCreatureName() + " creates a fiery shield, protecting itself from attacks!");
    }

    @Override
    public void ultimateAbility() {
        System.out.println(getCreatureName() +" bursts into flames and is reborn from its ashes!");
    }

    @Override
    public void displayInfo() {
        System.out.println("--- Creature Information ---");
        System.out.println(creatureType);
        System.out.println(
                "A phoenix is a mythical bird that is said to cyclically regenerate or be reborn. \n" +
                "Associated with the sun, a phoenix obtains new life by arising from the ashes of its predecessor. \n" +
                "According to some sources, the phoenix dies in a show of flames and combustion, " +
                "although there are other versions of the myth."
        );
        System.out.println("--------------------------");
    }
}
