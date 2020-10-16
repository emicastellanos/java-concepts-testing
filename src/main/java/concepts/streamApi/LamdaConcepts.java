package concepts.streamApi;

import util.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LamdaConcepts {
    static List<Person> roster;

    public static List<Person> getList() {
        return roster;
    }

    public static void printPersons(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                System.out.println(p);
            }
        }
    }


    public static void processPersons(List<Person> roster,
                                      Predicate<Person> tester,
                                      Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void processPersonsWithFunction(List<Person> roster,
                                                  Predicate<Person> tester,
                                                  Consumer<String> block,
                                                  Function<Person, String> mapper) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static <X> void processElementsString(Iterable<X> source,
                                           Predicate<X> tester,
                                           Consumer<String> block,
                                           Function<X, String> mapper) {
        for (X p : source) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static <X, Y> void processElements(Iterable<X> source,
                                           Predicate<X> tester,
                                           Consumer<Y> block,
                                           Function<X, Y> mapper) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static void main(String[] args) {
        roster = new ArrayList<>();
        Person person1 = new Person("Juan", Person.Sex.MALE, "juan@gmail.com", LocalDate.of(1990, 10, 21));
        Person person2 = new Person("Pedro", Person.Sex.MALE, "pedro@gmail.com", LocalDate.of(1972, 5, 21));
        Person person3 = new Person("Maria", Person.Sex.FEMALE, "maria@gmail.com", LocalDate.of(1960, 5, 12));
        Person person4 = new Person("Emiliano", Person.Sex.MALE, "emi@gmail.com", LocalDate.of(1988, 9, 19));
        Person person5 = new Person("Juana", Person.Sex.FEMALE, "Juana@gmail.com", LocalDate.of(1945, 6, 12));
        Person person6 = new Person("Ramona", Person.Sex.FEMALE, "ramona@gmail.com", LocalDate.of(1945, 8, 18));
        roster.add(person1);
        roster.add(person2);
        roster.add(person3);
        roster.add(person4);
        roster.add(person5);
        roster.add(person6);

        LamdaConcepts.processPersons(
                LamdaConcepts.getList(),
                (Person p) -> p.getGender() == Person.Sex.MALE &&
                        p.getAge() >= 18 &&
                        p.getAge() <= 35,
                p -> System.out.println(p.toString() + p.getAge())
        );

        LamdaConcepts.processPersonsWithFunction(
                LamdaConcepts.getList(),
                p -> p.getGender() == Person.Sex.MALE &&
                        p.getAge() >= 18 &&
                        p.getAge() <= 35,
                p -> System.out.println(p),
                p -> p.getEmailAddress()
        );

        LamdaConcepts.processElements(
                LamdaConcepts.getList(),
                person -> person.getGender() == Person.Sex.MALE &&
                        person.getAge() >= 18 &&
                        person.getAge() <= 35,
                data -> System.out.println(data),
                p -> p.getEmailAddress()
        );

        System.out.println("streams");
        LamdaConcepts.getList()
                .stream()
                .filter(person ->  person.getGender() == Person.Sex.MALE &&
                        person.getAge() >= 18 && person.getAge() <= 35)
                .map(person -> person.getEmailAddress())
                .forEach(System.out::println);


    }

}
