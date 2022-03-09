package reactive.section6.subjects;

import io.reactivex.rxjava3.subjects.AsyncSubject;

public class AsyncSubjectDemo {
    public static void main(String[] args) {


        //only gives last emission and will only work if onComplete is called
        AsyncSubject<Object> subject = AsyncSubject.create();

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
