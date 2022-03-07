package reactive.section1;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import jdk.jshell.SourceCodeAnalysis;

public class ObservableVariants {

    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alex", "Justin", "Jack");

        //for maybe
        Observable<String> sourceEmpty =
                Observable.empty();

        source.first("Name")
                .subscribe(System.out::println);

        Single<String> singleSource = Single.just("Alex");
        singleSource.subscribe(System.out::println);

        //Maybe may or may not exist

        source.firstElement().subscribe(System.out::println);
        sourceEmpty.firstElement()
                .subscribe(System.out::println,
                        Throwable::printStackTrace,
                        () -> System.out.println("completed"));

        //Completable has no emissions

        Completable completable = Completable.complete();
        completable.subscribe(() -> System.out.println("Completable done"),
                Throwable::printStackTrace);

        Completable.fromRunnable(
                () -> System.out.println("Something executing"))
                .subscribe(() -> System.out.println("Executed successfully"));


    }
}
