package package1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class PersonListTest {

    private  List<Person> personList;
    private PersonList persons;

    @BeforeEach
    void setUp() {
        personList = new ArrayList<>();
        personList.add(new Person(1, "John Doe", 30, "Engineer" ));
        personList.add(new Person(2, "Jane Smith", 25, "Doctor"));
        persons = new PersonList(personList);

    }

    @Test
    public void testFindByNameReturnsCorrectPerson() {
        Person person = persons.findByName("Jane Smith");
        assertNotNull(person);
        assertEquals("Jane Smith", person.getName());
    }

    @Test
    public void testFindByNameThrowsExceptionForImproperlyFormattedName() {

        assertThrows(IllegalArgumentException.class, () -> persons.findByName("JohnDoe"));
    }

    @Test
    public void testCloneCreatesNewPersonWithNewId() {
        Person original = personList.get(0);
        Person cloned = persons.clone(original);

        assertNotNull(cloned);
        assertNotEquals(original.getId(), cloned.getId());
        assertEquals(original.getName(), cloned.getName());
        assertEquals(original.getAge(), cloned.getAge());
        assertEquals(original.getOccupation(), cloned.getOccupation());

        System.out.println(original);
        System.out.println(cloned);

    }
}