package reactive.section6.subjects;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

public class UniCastSubjectDemo {

    public static void main(String[] args) throws InterruptedException {

        //only allows one observer
        UnicastSubject<Long> subject = UnicastSubject.create();

        Observable.interval(500, TimeUnit.MILLISECONDS)
                        .subscribe(subject);

        Thread.sleep(2000);

        subject.subscribe(s -> System.out.println("Subscriber 1: " + s));

        Thread.sleep(2000);

//        subject.onNext("a");
//        subject.onNext("b");
//        subject.onNext("c");

//        subject.subscribe(s -> System.out.println("Subscriber 2: " + s));

//        subject.onNext("d");
//        subject.onNext("e");

        subject.onComplete();
    }

}
