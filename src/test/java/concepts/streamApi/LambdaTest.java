package concepts.streamApi;

import util.Person;
import org.junit.BeforeClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LambdaTest {
    private static List<Person> personsComplete;

    @BeforeClass
    public static void beforeClass() throws Exception {
        personsComplete = new ArrayList<>();
        Person person1 = new Person("Juan", Person.Sex.MALE, "juan@gmail.com", LocalDate.of(1990,10,21));
        Person person2 = new Person("Pedro", Person.Sex.MALE, "pedro@gmail.com", LocalDate.of(1972,5,21));
        Person person3 = new Person("Maria", Person.Sex.FEMALE, "maria@gmail.com", LocalDate.of(1960,5,12));
        Person person4 = new Person("Emiliano", Person.Sex.MALE, "emi@gmail.com", LocalDate.of(1988,9,19));
        Person person5 = new Person("Juana", Person.Sex.FEMALE, "Juana@gmail.com", LocalDate.of(1945,6,12));
        Person person6 = new Person("Ramona", Person.Sex.FEMALE, "ramona@gmail.com", LocalDate.of(1945,8,18));
        personsComplete.add(person1);
        personsComplete.add(person2);
        personsComplete.add(person3);
        personsComplete.add(person4);
        personsComplete.add(person5);
        personsComplete.add(person6);
    }


}
