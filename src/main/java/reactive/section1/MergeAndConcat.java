package reactive.section1;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class MergeAndConcat {

    public static void main(String[] args) throws InterruptedException {
//        Observable<String> src1 = Observable.just("Ella", "Alexa", "Lily");
//        Observable<String> src2 = Observable.just("Priya", "Chloe");

        Observable<String> src1 = Observable.interval(1, TimeUnit.SECONDS).map(number -> "src1: " + number);
        Observable<String> src2 = Observable.interval(1, TimeUnit.SECONDS).map(number -> "src2: " + number);

        System.out.println("Using Merge");
//        Observable.concat(src1, src2)
//                .subscribe(System.out::println);

        src1.concatWith(src2).subscribe(System.out::println);


        Thread.sleep(20000);


//        System.out.println("\nUsing Concat");
//        Observable.concat(src1, src2)
//                .subscribe(System.out::println);
    }

}
