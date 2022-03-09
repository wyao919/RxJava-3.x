package reactive.section1;

import Pojo.Employee;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.internal.observers.EmptyCompletableObserver;

import java.util.Comparator;
import java.util.List;

public class OperatorsInAction {

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

        obs
                .filter(employee -> employee.getRating() > 4)
                .sorted(Comparator.comparingDouble(Employee::getRating))
                .map(Employee::getName)
                .take(4)
                .subscribe(System.out::println);
        System.out.println();


        List<Integer> expenses = List.of(200,500,300,340,129,234,999,1030,3400,890,996,789);

        //using scan will give you all things summed
        System.out.println("Using scan");
        Observable.fromIterable(expenses)
                .scan(Integer::sum)
                .subscribe(System.out::println);
        System.out.println();

        //reduce will just give you one
        System.out.println("Using Reduce");
        Observable.fromIterable(expenses)
                .reduce(Integer::sum)
                .subscribe(System.out::println);





    }


}
