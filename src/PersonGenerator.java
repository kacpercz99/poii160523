import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class PersonGenerator {
    private final List<String> maleNameList = List.of("Jan", "Michal", "Henryk", "Piotr");
    private final List<String> femaleNameList = List.of("Anna", "Maria", "Iwona", "Natalia");
    private final List<String> surnameList = List.of("Szewc", "Malina", "Nowak", "Kania");
    private final Supplier<Integer> randAge = () -> new Random().nextInt(100);
    private final Supplier<String> randMaleName = () -> maleNameList.get(new Random().nextInt(maleNameList.size() - 1));
    private final Supplier<String> randFemaleName = () -> femaleNameList.get(new Random().nextInt(femaleNameList.size() - 1));
    private final Supplier<String> randSurname = () -> surnameList.get(new Random().nextInt(surnameList.size() - 1));
    private final Supplier<Person> randPerson = () -> {
        String sex = new Random().nextBoolean() ? "male" : "female";
        return sex.equals("male") ? new Person(randMaleName.get(), randSurname.get(), randAge.get(), sex) :
                new Person(randFemaleName.get(), randSurname.get(), randAge.get(), sex);
    };
    private final Supplier<List<Person>> randPersons = () -> {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            personList.add(randPerson.get());
        }
        return personList;
    };

    public Person generatePerson(String sex) {
        if (sex.equalsIgnoreCase("male")) {
            return new Person(randMaleName.get(), randSurname.get(), randAge.get(), sex);
        } else {
            return new Person(randFemaleName.get(), randSurname.get(), randAge.get(), sex);
        }
    }

    public List<Person> generateRandomPeople() {
        return randPersons.get();
    }
}
