package reactive.section6;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class AddingEmissionsWithSubject {

    public static void main(String[] args) {
        PublishSubject<String> subject = PublishSubject.create();

        Subject<String> serialized = subject.toSerialized();


        serialized.subscribe(System.out::println);
        serialized.subscribe(s -> System.out.println("Observer2: " +s));

        serialized.onNext("Hello");
        serialized.onNext("BasicsStrong");
        serialized.onComplete();
        serialized.onNext("BasicsStrong");


    }
}
