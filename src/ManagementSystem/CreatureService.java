package ManagementSystem;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CreatureService {
    private List<Creature> creatures = new ArrayList<>();

    public List<Creature> getCreatures() {
        return Collections.unmodifiableList(creatures);
    }

    public boolean addCreature(String type, String creatureName, int age, String element){
        if(type.equalsIgnoreCase("Dragon")){
            creatures.add(new Dragon(creatureName, element, age, type));
        } else if (type.equalsIgnoreCase("Phoenix")) {
            creatures.add(new Phoenix(creatureName, age));
        }else if (type.equalsIgnoreCase("Griffin")) {
            creatures.add(new Griffin(creatureName, age));
        } else {
            return false;
        }
        System.out.println("Successfully added " + type + ": " + creatureName);
        return true;
    }

    public boolean removeCreature(String creatureName){
        return creatures.removeIf(creature -> creature.getCreatureName().equalsIgnoreCase(creatureName));
    }

    public List<Creature> filterByType(String type){
        return creatures.stream()
                .filter(c -> c.getCreatureType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    public List<Creature> filterByMaxAge(int maxAge){
        return creatures.stream()
                .filter(c -> c.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    public Map<String, Long> getCountByType(){
        return creatures.stream()
                .collect(Collectors.groupingBy(
                        c -> c.getCreatureType().toLowerCase(),
                        Collectors.counting()
                ));
    }

    public double getAverageAge(){
        if(creatures.isEmpty()) return 0;
        return creatures.stream()
                .mapToInt(Creature::getAge)
                .average()
                .orElse(0);
    }

    public boolean modifyCreature(String creatureName, String creatureNewName){
        for(Creature creature : creatures){
            if(creature.getCreatureName().equalsIgnoreCase(creatureName)){
                creature.setCreatureName(creatureNewName);
                return true;
            }
        }
        return false;
    }

    public boolean modifyCreatureAge(String creatureName, int newAge){
        for(Creature creature : creatures){
            if (creature.getCreatureName().equalsIgnoreCase(creatureName)){
                creature.setAge(newAge);
                return true;
            }
        }
        return false;
    }

}




