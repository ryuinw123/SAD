import java.util.concurrent.Flow;

public abstract class StringSubscriber implements Flow.Subscriber {

    protected String want;
    protected StringSubscription subscription;

    @Override
    public abstract void onSubscribe(Flow.Subscription subscription);

    @Override
    public abstract void onNext(Object item);

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Finish");
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }
}
