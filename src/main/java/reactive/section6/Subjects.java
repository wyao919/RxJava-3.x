package reactive.section6;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

//subjects are not thread safe
public class Subjects {

    public static void main(String[] args) throws InterruptedException {

        Observable<Integer> src1 = Observable.just(5, 10, 15, 20)
                .subscribeOn(Schedulers.computation());
        Observable<Integer> src2 = Observable.just(50, 100, 150, 200)
                .subscribeOn(Schedulers.computation());

//        src1.subscribe(integer -> System.out.println(integer));
//        src2.subscribe(integer -> System.out.println(integer));

        Subject<Object> subject = PublishSubject.create();
        PublishSubject<Object> objectPublishSubject = PublishSubject.create();

        subject.subscribe(o -> System.out.println(o));
        subject.subscribe(o -> System.out.println("The element is: " + o));

        src1.subscribe(subject);
        src2.subscribe(subject);

        Thread.sleep(9000);



//        src1.mergeWith(src2).subscribe(System.out::println);
    }
}
