package reactive.section1;

import com.sun.security.jgss.GSSUtil;
import io.reactivex.rxjava3.core.Observable;

public class CreatingObserver {

    public static void main(String[] args) {
        Observable<String> source = Observable.just("Orange", "Black", "Red");
        source.subscribe(s -> System.out.println(s),
                Throwable::printStackTrace,
                () -> System.out.println("Completed"));

        System.out.println();

        source.subscribe(s -> System.out.println(s),
                Throwable::printStackTrace);

        source.subscribe(s -> System.out.println(s));
    }



}
