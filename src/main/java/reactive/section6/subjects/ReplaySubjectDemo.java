package reactive.section6.subjects;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.ReplaySubject;


public class ReplaySubjectDemo {


    //this is a cold observable. Second subscriber can rewind
    public static void main(String[] args) {
        @NonNull ReplaySubject<Object> subject = ReplaySubject.create();

        subject.subscribe(s -> System.out.println("Subscriber 1: " + s));

        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");

        subject.subscribe(s -> System.out.println("Subscriber 2: " + s));

        subject.onNext("d");
        subject.onNext("e");

        subject.onComplete();
    }
}
