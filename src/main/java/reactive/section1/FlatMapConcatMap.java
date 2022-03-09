package reactive.section1;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class FlatMapConcatMap {

    public static void main(String[] args) {
        List<String> list = List.of("hello", "reactive", "programming");

        Observable.fromIterable(list)
                .concatMap(s -> Observable.fromArray(s.split(",")))
                .subscribe(System.out::println);

        Observable.fromIterable(list)
                .flatMap(s -> Observable.fromArray(s.split(",")))
                .subscribe(System.out::println);

        Observable.fromIterable(list)
                .map(String::toUpperCase)
                .subscribe(System.out::println);

    }

}
