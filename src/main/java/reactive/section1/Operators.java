package reactive.section1;

import io.reactivex.rxjava3.core.Observable;

public class Operators {

    public static void main(String[] args) {

        Observable.just(60,57,89,90,34,100,40)
                .filter(integer -> integer > 75)
                .sorted()
                .subscribe(System.out::println);
    }
}
