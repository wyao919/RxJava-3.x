package reactive.section1;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;


//converts cold to hot. Like listening to the radio
public class ConnectableObservable {
    public static void main(String[] args) throws InterruptedException {
        io.reactivex.rxjava3.observables.ConnectableObservable<Long> source
                = Observable.interval(1, TimeUnit.SECONDS)
                .publish();

        source.connect();

        source.subscribe(System.out::println);
        Thread.sleep(10_000);

        source.subscribe(System.out::println);
        Thread.sleep(10_000);

    }
}
