package reactive.section8;

import io.reactivex.rxjava3.core.Observable;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;


public class Buffering {

    //get your emissions in chunks
    public static void main(String[] args) throws InterruptedException {

//        Observable.range(1,30)
//                .buffer(4)
//                .subscribe(System.out::println);
//        System.out.println();
//
//        Observable.range(1,30)
//                .buffer(4, HashSet::new)
//                .subscribe(System.out::println);
//        System.out.println();
//
//
//        //this will skip everything with a 5 in it
//        Observable.range(1,30)
//                .buffer(4,5)
//                .subscribe(System.out::println);
//        System.out.println();

        //intervalbased
//        Observable.interval(500, TimeUnit.MILLISECONDS)
//                .buffer(1, TimeUnit.SECONDS, 2)
//                .subscribe(System.out::println);

        Observable<Long> interval = Observable.interval(500, TimeUnit.MILLISECONDS);
        Observable.interval(1000, TimeUnit.MILLISECONDS)
                        .buffer(interval)
                                .subscribe(System.out::println);

        Thread.sleep(8000);

    }
}
