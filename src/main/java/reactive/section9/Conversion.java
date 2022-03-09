package reactive.section9;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Conversion {

    public static void main(String[] args) throws InterruptedException {

        //Observable to Flowable
        Observable.range(1, 10000)
                .toFlowable(BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.io())
                .subscribe(integer -> System.out.println(integer + " " + Thread.currentThread().getName()));


        //Flowable to Observable
        Flowable.range(1, 10000)
                .toObservable()
                .observeOn(Schedulers.io())
                .subscribe(integer -> System.out.println(integer + " " + Thread.currentThread().getName()));

        Thread.sleep(5000);
    }
}
