package reactive.section1;

import Pojo.Employee;
import io.reactivex.rxjava3.core.Observable;

public class GroupingObservables {

    public static void main(String[] args) {

        Observable<Employee> obs = Observable.just(
                new Employee(101, "Alexa", 60000, 4.0),
                new Employee(123, "Dhwanit", 94000, 4.7),
                new Employee(236, "Mike", 65000, 4.0),
                new Employee(155, "Ela", 85000, 4.4),
                new Employee(443, "George", 50000, 3.6),
                new Employee(127, "Shreeja", 85000, 4.5),
                new Employee(509, "Daniel", 60000, 4.0),
                new Employee(344, "Lucy", 94000, 4.7),
                new Employee(509, "Harry", 75000, 4.3),
                new Employee(344, "Emma", 55000, 3.8)
        );

        obs.groupBy(Employee::getRating)
                .flatMapSingle(e -> e.toMultimap(key -> e.getKey(), Employee::getName))
                .subscribe(System.out::println);

        obs.groupBy(Employee::getRating)
                .flatMapSingle(e -> e.toList())
                .subscribe(System.out::println);
    }
}
