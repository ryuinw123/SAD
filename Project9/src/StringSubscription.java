import java.util.ArrayList;
import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription {

    private final StringSubscriber subscriber;
    private boolean completed;
    private ArrayList<String> stringStream;
    private String want;

    public StringSubscription(StringSubscriber subscriber) {
        this.subscriber = subscriber;
        this.stringStream = new ArrayList<>();
        this.want = subscriber.getWant();
    }

    //ฟังก์ชั่น request เป็นการส่งค่าจาก Arraylist stringStream ให้ Subscriber
    @Override
    public void request(long n) {
        if (n != 0 && !completed && stringStream.size() != 0) {
            if (n < 0) {
                IllegalArgumentException ex = new IllegalArgumentException();
                subscriber.onError(ex);
            } else {
                ArrayList<String> stream = new ArrayList<String>();
                for (int i = 0; i < n; i++){
                    stream.add(stringStream.remove(0));
                }
                subscriber.onNext(stream);
            }
        }
    }

    @Override
    public void cancel() {
        completed = true;
    }

    //รับค่าจาก String Publisher ใส่ค่าให้ Arraylist Subscription
    public void add(String message){
        stringStream.add(message);
        this.request(1);
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }
}
