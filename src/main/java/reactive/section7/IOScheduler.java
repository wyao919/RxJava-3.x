package reactive.section7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class IOScheduler {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.io());

        src.subscribe(s -> IoOperation());
        src.subscribe(s -> IoOperation());
        src.subscribe(s -> IoOperation());
        src.subscribe(s -> IoOperation());
        src.subscribe(s -> IoOperation());

        Thread.sleep(50000);

    }

    public static void IoOperation() throws InterruptedException {

        Thread.sleep(1000);
        System.out.println("Computation done by: " + Thread.currentThread().getName());
    }
}
