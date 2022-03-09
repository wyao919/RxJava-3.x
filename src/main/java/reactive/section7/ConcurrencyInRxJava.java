package reactive.section7;

import io.reactivex.rxjava3.core.Observable;

public class ConcurrencyInRxJava {

    public static void main(String[] args) {

        Observable<Object> source1 = Observable.create(emitter -> {

            new Thread(() -> {
                emitter.onNext("Hello");
                emitter.onNext("RxJava");
            }).start();

        });

        Observable<Object> source2 = Observable.create(emitter -> {

                emitter.onNext("Hello");
                emitter.onNext("RxJava");

        });

        System.out.println("Not using thread");
        source2.subscribe(o -> System.out.println("Observer 1 : " + o + " Thread is : " + Thread.currentThread().getName()));
        source2.subscribe(o -> System.out.println("Observer 2 : " + o + " Thread is : " + Thread.currentThread().getName()));

        System.out.println();
        System.out.println("Using Thread");


        source1.subscribe(o -> System.out.println("Observer 1 : " + o + " Thread is : " + Thread.currentThread().getName()));
        source1.subscribe(o -> System.out.println("Observer 2 : " + o + " Thread is : " + Thread.currentThread().getName()));
    }

}
