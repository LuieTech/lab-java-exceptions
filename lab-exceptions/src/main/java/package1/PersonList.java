package package1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public class PersonList {
    private List<Person> personObjects;

    public PersonList(List<Person> personObjects) {
        this.personObjects = personObjects;
    }

    public List<Person> getPersonObjects() {
        return personObjects;
    }

    public void setPersonObjects(List<Person> personObjects) {
        this.personObjects = personObjects;
    }

    public Person findByName(String name){

        if(!Pattern.matches("[a-zA-Z]+ [a-zA-Z]+", name)){
            throw new IllegalArgumentException(("Name parameter must be in format 'firstName lastName"));
        }
        for(Person person : personObjects){
            if(person.getName().equals(name)){
                return person;
            }
        }
        throw new IllegalArgumentException("Person not found");
    }

    public Person clone(Person object) {
        return new Person(generateNewId(), object.getName(), object.getAge(), object.getOccupation());
    }

    private int generateNewId() {
        // Assuming the ID is generated as the max existing ID + 1
        return personObjects.stream().mapToInt(Person::getId).max().orElse(0) + 1;
    }

    public void writePersonToFile(Person person, String fileName) {
        try (FileWriter writer = new FileWriter("src/main/java/package1/person.txt")) {
            writer.write(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
