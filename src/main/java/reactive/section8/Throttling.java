package reactive.section8;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Throttling {

    public static void main(String[] args) {

        Observable<Object> obs = Observable.create(emitter -> {

            emitter.onNext("A");

            Thread.sleep(200);
            emitter.onNext("B");

            Thread.sleep(100);
            emitter.onNext("C");

            Thread.sleep(400);
            emitter.onNext("D");

            Thread.sleep(300);
            emitter.onNext("E");

            Thread.sleep(800);
            emitter.onNext("F");

            Thread.sleep(900);
            emitter.onNext("X");

            Thread.sleep(600);
            emitter.onNext("Y");

            Thread.sleep(1000);
            emitter.onNext("Z");

        });

        obs
                .throttleWithTimeout(700, TimeUnit.MILLISECONDS)
                .subscribe(
                o -> System.out.println("onNext: " + o),
                Throwable::printStackTrace,
                () -> System.out.println("onComplete")
        );


    }
}
