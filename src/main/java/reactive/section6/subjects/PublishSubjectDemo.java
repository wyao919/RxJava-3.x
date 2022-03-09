package reactive.section6.subjects;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class PublishSubjectDemo {


    //host observable - Starts receiving transmission from when it joins
    public static void main(String[] args) {

        PublishSubject<String> subject = PublishSubject.create();

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
