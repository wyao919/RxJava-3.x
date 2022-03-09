package reactive.section7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewThreadScheduler {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.io());

        src.subscribe(s -> newThreadScheduler());
        Thread.sleep(6000);
        src.subscribe(s -> newThreadScheduler());
        src.subscribe(s -> newThreadScheduler());
        src.subscribe(s -> newThreadScheduler());
        src.subscribe(s -> newThreadScheduler());

        Thread.sleep(50000);
    }

    public static void newThreadScheduler() throws InterruptedException {

        Thread.sleep(1000);
        System.out.println("Computation done by: " + Thread.currentThread().getName());
    }
}
