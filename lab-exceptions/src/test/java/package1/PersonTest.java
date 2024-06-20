package package1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testSetAge(){
        Person person = new Person(1, "John Doe", 30, "Engineer");
        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-1);
        });
    }


}