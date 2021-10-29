import java.util.concurrent.Flow;
import java.util.regex.Pattern;

public abstract class StringSubscriber implements Flow.Subscriber {

    protected StringSubscription subscription;
    protected Pattern pattern;

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

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
}
