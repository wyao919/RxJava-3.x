package reactive.section9;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;


public class BackPressure {

    public static void main(String[] args) {

        Flowable.range(1,100000)
                .map(integer -> {
                    System.out.println("Produced item is: " + integer+ " " +Thread.currentThread().getName());
                    return integer;
                })
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<Integer>() {

                    Subscription s;
                    AtomicInteger count = new AtomicInteger(0);

                    @Override
                    public void onSubscribe(Subscription s) {

                        this.s = s;
                        System.out.println("Asking for 20 items");
                        s.request(20);

                    }

                    @Override
                    public void onNext(Integer integer) {

                        System.out.println("Subscriber Consumed : " + integer);
                        if(count.getAndIncrement() % 20 ==0) {
                            System.out.println("Asking for next 20");
                            s.request(20);
                        }
                        sleep(100);

                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Everything completed");
                    }
                });

        sleep(10000000);

    }

    private static void sleep(int i) {

        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
