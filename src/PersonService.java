import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PersonService {
    private Consumer<Person> printPerson = person -> {
        if (person.sex.equals("male"))
            System.out.printf("Pan %s %s lat: %d\n", person.imie, person.nazwisko, person.wiek);
        else
            System.out.printf("Pani %s %s\n", person.imie, person.nazwisko);
    };

    private Consumer<List<Person>> printPersons = persons -> {
        persons.forEach(person -> printPerson.accept(person));
    };

    public void printPeople() {
        PersonGenerator pg = new PersonGenerator();
        printPersons.accept(pg.generateRandomPeople());
    }

    public void printPeopleSortedBy(Function<Person, String> mappingFunction) {
        List<Person> persons = new PersonGenerator().generateRandomPeople();
        List<String> strings = new ArrayList<>(persons.stream().map(mappingFunction).toList());
        strings.sort(String::compareToIgnoreCase);
        System.out.println(strings);
    }
}
