public class Person {
    String imie;
    String nazwisko;
    int wiek;
    String sex;

    public Person(String imie, String nazwisko, int wiek, String sex) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.sex = sex;
    }


    @Override
    public String toString() {
        return "Person{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                ", sex='" + sex + '\'' +
                '}';
    }
}
