import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        PersonGenerator pg = new PersonGenerator();
//        System.out.println(pg.generatePerson("male"));
//        System.out.println(pg.generatePerson("female"));
//        System.out.println(pg.generateRandomPeople());
        PersonService ps = new PersonService();
        ps.printPeople();
        Function<Person,String> func = person -> person.imie;
        ps.printPeopleSortedBy(func);
    }
}