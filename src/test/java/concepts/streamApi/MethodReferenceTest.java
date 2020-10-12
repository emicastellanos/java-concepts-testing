package concepts.streamApi;

import concepts.util.Person;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MethodReferenceTest {
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

    @Test
    public void MethodReferences_ReferenceStaticMethodTest() {
        Person[] personsCompleteAsArray = personsComplete.toArray(new Person[personsComplete.size()]);
        Arrays.sort(personsCompleteAsArray, Person::compareByAge);

        Stream.of(personsCompleteAsArray)
                .map(person -> {
                    StringBuilder builder = new StringBuilder();
                    builder.append(person.getName())
                            .append(" - ")
                            .append(person.getBirthday().toString());
                    return builder.toString();
                })
                .forEach(System.out::println);
    }

    @Test
    public void MethodReferences_ReferenceInstanceMethodTest() {
        Person[] personsCompleteAsArray = personsComplete.toArray(new Person[personsComplete.size()]);
        Arrays.sort(personsCompleteAsArray, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        Stream.of(personsCompleteAsArray)
                .map(person -> {
                    StringBuilder builder = new StringBuilder();
                    builder.append(person.getName())
                            .append(" - ")
                            .append(person.getBirthday().toString());
                    return builder.toString();
                })
                .forEach(System.out::println);
    }

}
