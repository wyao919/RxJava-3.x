package reactive.section7;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOn {
    public static void main(String[] args) throws InterruptedException {

       Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.computation())
                .map(s -> s.toUpperCase())
//                .subscribeOn(Schedulers.newThread())
                .filter(s -> s.startsWith("P"))
                .subscribe(s -> print(s));

       Thread.sleep(6000);

    }

    public static void print(String s)  {

        System.out.println(s+ " printed by: " + Thread.currentThread().getName());
    }
}
