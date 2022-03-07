package reactive.section1;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Disposing {

    public static final CompositeDisposable COMPOSITE_DISPOSABLE = new CompositeDisposable();

    public static void main(String[] args) throws InterruptedException {

        Observable<Long> source =
                Observable.interval(1, TimeUnit.SECONDS);

        Disposable d1 = source.subscribe(count -> System.out.println("Observer 1: " + count));
            Thread.sleep(5000);

        Disposable d2 = source.subscribe(count -> System.out.println("Observer 2: " + count));

        COMPOSITE_DISPOSABLE.addAll(d1, d2);
        COMPOSITE_DISPOSABLE.dispose();
        Thread.sleep(10_000);
        }
    }
