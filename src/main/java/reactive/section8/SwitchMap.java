package reactive.section8;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class SwitchMap {

    public static void main(String[] args) throws InterruptedException {

        Observable<String> source = Observable.just("John", "Lily", "Emma", "Reyan", "Darshin")
                .concatMap(s -> Observable.just(s)
                        .delay(ThreadLocalRandom.current().nextInt(1000), TimeUnit.MILLISECONDS));

        Observable.interval(2, TimeUnit.SECONDS)
                .switchMap(aLong -> source.doOnDispose(() -> System.out.println("Disposing and restarting")))
                .subscribe(System.out::println);

        Thread.sleep(10000);

    }
}
