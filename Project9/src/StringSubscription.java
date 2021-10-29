import java.util.ArrayList;
import java.util.concurrent.Flow;
import java.util.regex.Pattern;

public class StringSubscription implements Flow.Subscription {

    private final StringSubscriber subscriber;
    private boolean completed;
    private ArrayList<String> stringStream;
    private boolean isRequest;
    private Pattern pattern;

    public StringSubscription(StringSubscriber subscriber) {
        this.subscriber = subscriber;
        this.stringStream = new ArrayList<>();
        this.pattern = subscriber.getPattern();
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
                isRequest = false;
            }
        }

        if (n!=0 && stringStream.size() == 0){
            isRequest = true;
        }

    }

    @Override
    public void cancel() {
        completed = true;
    }

    //รับค่าจาก String Publisher ใส่ค่าให้ Arraylist Subscription
    public void add(String message){
        stringStream.add(message);
        //เช็คว่าเคยมี Request ค้างไว้หรือเปล่า ถ้ามีให้ส่งค่าไปที่ Subscriber
        if (isRequest) {
            this.request(1);
        }
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
}
