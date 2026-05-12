package ManagementSystem;

public abstract class Creature {
    private String creatureName;
    private int age;
    private final String creatureType;

    public Creature(String creatureName, int age, String creatureType) {
       this.creatureName = creatureName;
       this.age = age;
         this.creatureType = creatureType;
    }

    public void displayInfo(){
        System.out.println("--- Creature Information ---");
        System.out.println(creatureType);
        System.out.println("--------------------------");
    }


    public String getCreatureName() {
        return creatureName;
    }

    public void setCreatureName(String creatureName) {
        this.creatureName = creatureName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCreatureType() {
        return creatureType;
    }
    public void setCreatureType(String creatureType) {}
}
