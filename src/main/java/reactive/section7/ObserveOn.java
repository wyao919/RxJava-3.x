package reactive.section7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObserveOn {

    public static void main(String[] args) throws InterruptedException {

        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.computation())
                .map(s -> s.toUpperCase())
                .doOnNext(s -> System.out.println(Thread.currentThread().getName()))
                .observeOn(Schedulers.newThread())
                .filter(s -> s.startsWith("P"))
                .observeOn(Schedulers.io())
                .subscribe(s -> print(s));

        Thread.sleep(6000);

    }

    public static void print(String s)  {

        System.out.println(s+ " printed by: " + Thread.currentThread().getName());
    }

}
