package reactive.section1;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class CreatingObservable {

    public static void main(String[] args) {

        //create
        Observable<Integer> source = Observable.create(emitter -> {

            emitter.onNext(11);
            emitter.onNext(12);
            emitter.onNext(13);
            emitter.onComplete();

        });

       source.subscribe(System.out::println);

        //just
        Observable<Integer> just = Observable.just(1, 2, 3);
        just.subscribe(System.out::println);

        //from Iterable
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Barry");
        listOfStrings.add("Willy");
        listOfStrings.add("Kathy");
        Observable<String> fromIterable = Observable.fromIterable(listOfStrings);
        fromIterable.subscribe(System.out::println);

        //with Range
        Observable<Integer> range = Observable.range(3, 5);
        range.subscribe(System.out::println);

        //defer

        Observable<String> defer = Observable.defer(() -> Observable.fromIterable(listOfStrings));
        defer.subscribe(System.out::println);
        listOfStrings.add("Sean");
        defer.subscribe(System.out::println);

    }

}
