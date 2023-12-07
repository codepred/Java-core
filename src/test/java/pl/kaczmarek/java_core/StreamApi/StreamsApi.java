package pl.kaczmarek.java_core.StreamApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


// Stream - kolejne elementy są wyliczane wraz z kolejnymi operacjami.
// Operacje pośrednie - zwraca stream
// Operacje terminalne - zwraca tablice lub kolekcje
public class StreamsApi {

    // Nie modyfikuje elementów kolekcji
    List<Employee> employees = new ArrayList<>();

    @BeforeEach()
    public void  setUp(){
        List<String> list = new ArrayList<>();
        Employee employee = new Employee("Gabrysia","Kowalewska",100, list);
        Employee employee1 = new Employee("Jacek","Kaczmarek",200,List.of("Java","Hibernate"));
        Employee employee2 = new Employee("Mateusz","Stawski",300,List.of("Java","Hibernate"));
        Employee employee3 = new Employee("Kacper","Karman",400,List.of("Java","Hibernate"));

        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }

    @Test
    public void getAllElements(){
        employees
                .forEach(System.out::println);
        employees.stream()
                .forEach(employee -> System.out.println(employee));
    }

    @Test
    public void getAllLastNames(){
        employees.stream()
                .forEach(employee -> System.out.println(employee.getLastName()));
    }

    @Test
    public void mapOperation(){
        employees.stream()
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .forEach(System.out::println);
        employees.stream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    @Test
    public void flatMapOperation(){
        List<List<String>> allSkills = employees.stream()
                .map(Employee::getSkills)
                .collect(Collectors.toList());

        System.out.println(allSkills);

        List<String> allSkillsList = employees.stream()
                .map(Employee::getSkills)
                .flatMap(list -> list.stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(allSkillsList);
    }

    // przeszukuje całą tablicę
    @Test
    public void filter(){
        employees.stream()
                .filter(employee -> employee.getLastName().startsWith("K"))
                .forEach(System.out::println);
    }

    @Test
    public void sorted(){
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge).reversed())
                .forEach(System.out::println);
    }

    @Test
    public void limit(){
        employees.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void skip(){
        employees.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void count(){
        long count = employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("G"))
                .count();
        System.out.println(count);
    }

    @Test
    public void min(){
        Optional<Employee> min = employees.stream()
                .min(Comparator.comparing(Employee::getAge));
        System.out.println(min.get());
    }

    @Test
    public void max(){
        Optional<Employee> max = employees.stream()
                .max(Comparator.comparing(Employee::getAge));
        System.out.println(max.get());
    }

    @Test
    public void findAnyAndFirst(){
        Optional<Employee> findAny = employees.stream()
                .filter(employee -> employee.getLastName().startsWith("K")).findAny();

        Optional<Employee> findFirst = employees.stream()
                .filter(employee -> employee.getLastName().startsWith("K")).findFirst();
        System.out.println(findAny.get());
        System.out.println(findFirst.get());
    }

    @Test
    public void matchOperations(){
        boolean nameStartsG = employees.stream()
                .allMatch(employee -> employee.getFirstName().startsWith("G"));
        System.out.println(nameStartsG);
        boolean contains = employees.stream()
                .allMatch(employee -> employee.getFirstName().contains("a"));
        System.out.println(contains);
        boolean noneMatch = employees.stream()
                .noneMatch(employee -> employee.getFirstName().contains("a"));
        System.out.println(noneMatch);
        boolean anyMatch = employees.stream()
                .anyMatch(employee -> employee.getFirstName().contains("a"));
        System.out.println(anyMatch);
    }

    @Test
    public void reduce(){
        Integer integer = employees.stream()
                .map(employee -> employee.getAge())
                .reduce((age1, age2) -> age1 + age2)
                .get();
        System.out.println(integer);
        Integer integer2 = employees.stream()
                .map(Employee::getAge)
                .reduce(Integer::sum)
                .get();
        System.out.println(integer2);

        Integer integer3 = employees.stream()
                .map(Employee::getAge)
                .reduce(0, Integer::sum);
        System.out.println(integer3);

        Integer integer4 = employees.stream()
                .reduce(0, (age, employees) -> age + employees.getAge(), Integer::sum);

        System.out.println(integer4);

        String names = employees.stream()
                .map(Employee::getFirstName)
                .reduce((name, name2) -> name + ", " + name2)
                .get();

        System.out.println(names);
    }

    // Nie przeszukuje dalej elementów gdy natrafi na granicę
    @Test
    public void takeWhileOperation(){
        employees.stream()
                .sorted(Comparator.comparing(employee -> employee.getAge()))
                .takeWhile(employee -> employee.getAge() < 250)
                .forEach(System.out::println);
    }

    // przeszukuje dalej elementy od konca gdy natrafi na wieksze
    @Test
    public void dropWhileOperation(){
        employees.stream()
                .sorted(Comparator.comparing(employee -> employee.getAge()))
                .dropWhile(employee -> employee.getAge() < 250)
                .forEach(System.out::println);
    }

    @Test
    public void forEachOrdered(){
        String string = "Ala to młoda kobieta";

        // stream jednowątkowy
        string.chars().forEach(s -> System.out.print((char)(s)));
        System.out.println("");
        // stream wielowątkowy
        string.chars().parallel().forEachOrdered(s -> System.out.print((char)(s)));
    }

    // Modyfikuje elementy oryginalnej kolekcji
    // Służy do debugowania
    @Test
    public void peekOperation(){
        List<Employee> collect = employees.stream()
                .peek(employee -> employee.setFirstName("GABA"))
                .peek(employee -> employee.setLastName("ZABA"))
                .collect(Collectors.toList());

        System.out.println(collect);
    }

}
