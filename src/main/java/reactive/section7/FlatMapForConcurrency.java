package reactive.section7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.time.LocalTime;

public class FlatMapForConcurrency {

    public static void main(String[] args) throws InterruptedException {

        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .flatMap(s -> Observable.just(s)
                        .subscribeOn(Schedulers.computation())
                        .map(s1 -> compute(s1))
                ).subscribe(System.out::println);

        Thread.sleep(6000);
    }

    public static String compute(String s) {

        return s + " printed by: " + Thread.currentThread().getName() + " at: " + LocalTime.now();

    }

}
