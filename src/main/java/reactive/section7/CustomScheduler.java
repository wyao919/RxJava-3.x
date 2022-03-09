package reactive.section7;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomScheduler {



    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(20);

        @NonNull
        Scheduler scheduler = Schedulers.from(executor);

        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(scheduler)
                .doFinally(executor::shutdown);

        src.subscribe(s -> compute());
        src.subscribe(s -> compute());
        src.subscribe(s -> compute());
        src.subscribe(s -> compute());
        src.subscribe(s -> compute());
        src.subscribe(s -> compute());
        src.subscribe(s -> compute());
        src.subscribe(s -> compute());


        Thread.sleep(50000);
    }

    public static void compute() throws InterruptedException {

        Thread.sleep(1000);
        System.out.println("Computation done by: " + Thread.currentThread().getName());
    }
}
