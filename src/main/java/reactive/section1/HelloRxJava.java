package reactive.section1;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {

    public static void main(String[] args) {

        Observable<String> observable = Observable.just("hello world");
        observable.subscribe(System.out::println);

        Observable<String> source = Observable.create(emitter -> {
           emitter.onNext("Hello");
           emitter.onNext("RxJava");
        });
        source.subscribe(System.out::println);
        source.subscribe(s -> System.out.println("observer 2: " + s));

    }
}
