package reactive.section6;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Replaying {

    public static void main(String[] args) throws InterruptedException {

        Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS)
                .replay(2, 4, TimeUnit.SECONDS)
                .autoConnect();

        src.subscribe(aLong -> System.out.println("Observer 1: " + aLong));

        Thread.sleep(5000);
        src.subscribe(aLong -> System.out.println("Observer 2: " + aLong));
        Thread.sleep(3000);


    }
}
