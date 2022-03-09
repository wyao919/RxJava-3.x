package reactive.section6.subjects;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class BehaviorSubjectDemo {

    public static void main(String[] args) {

        //subscriber 2 will show the last thing that was transmitted before it starts
        BehaviorSubject<Object> subject = BehaviorSubject.create();

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
