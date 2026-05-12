package ManagementSystem;

public class Dragon extends Creature implements Ability {
    private final String element;


    public Dragon(String dragonName,String element, int age ,String creatureType) {
        super(dragonName, age, creatureType);
        this.element = element;
    }

    public void displayInfo(){
        System.out.println("--- Creature Information ---");
        String creatureType = "Dragon";
        System.out.println(creatureType);
        System.out.println(
                "A dragon is a mythical creature found in the folklore of cultures throughout the world. \n" +
                "It is roughly serpentine in form, and often possesses features drawn from different animals, \n" +
                "such as wings and claws. In nearly all cultures, it is conceived of as a powerful and awe-inspiring creature."
        );
        System.out.println("--------------------------");
    }


    @Override
    public void basicAbility() {
        switch (element.toLowerCase()) {
            case "fire":
                System.out.println(getCreatureName() + " breathes fire, scorching everything in its path!");
                break;
            case "ice":
                System.out.println(getCreatureName() + " exhales a chilling blast, freezing its foes!");
                break;
            case "lightning":
                System.out.println(getCreatureName() + " unleashes a bolt of lightning, electrifying its enemies!");
                break;
            case "water":
                System.out.println(getCreatureName() + " summons a tidal wave, drenching its opponents!");
                break;
            case "earth":
                System.out.println(getCreatureName() + " causes the ground to tremble, creating a shockwave!");
                break;
            default:
                System.out.println(getCreatureName() + " has an unknown element and cannot use its basic ability.");
        }

    }

    @Override
    public void secondaryAbility() {
        switch (element.toLowerCase()) {
            case "fire":
                System.out.println(getCreatureName() + " creates a fiery shield, protecting itself from attacks!");
                break;
            case "ice":
                System.out.println(getCreatureName() + " forms an icy barrier, reducing incoming damage!");
                break;
            case "lightning":
                System.out.println(getCreatureName() + " generates an electric field, stunning nearby enemies!");
                break;
            case "water":
                System.out.println(getCreatureName() + " creates a water vortex, pulling enemies towards it!");
                break;
            case "earth":
                System.out.println(getCreatureName() + " raises a wall of earth, blocking incoming attacks!");
                break;
            default:
                System.out.println(getCreatureName() + " has an unknown element and cannot use its secondary ability.");
        }

    }

    @Override
    public void ultimateAbility() {
        switch (element.toLowerCase()) {
            case "fire":
                System.out.println(getCreatureName() + " unleashes a devastating inferno, engulfing everything in flames!");
                break;
            case "ice":
                System.out.println(getCreatureName() + " summons a blizzard, freezing the battlefield and immobilizing enemies!");
                break;
            case "lightning":
                System.out.println(getCreatureName() + " calls down a massive lightning strike, obliterating its foes!");
                break;
            case "water":
                System.out.println(getCreatureName() + " creates a colossal tsunami, sweeping away everything in its path!");
                break;
            case "earth":
                System.out.println(getCreatureName() + " causes a massive earthquake, shattering the ground and toppling structures!");
                break;
            default:
                System.out.println(getCreatureName() + " has an unknown element and cannot use its ultimate ability.");
        }

    }
}
