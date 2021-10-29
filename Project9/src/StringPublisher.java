import java.util.ArrayList;
import java.util.concurrent.Flow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPublisher implements Flow.Publisher {

    private ArrayList<Flow.Subscriber> subscribers;//เป็นตัวที่เก็บไว้ว่าตัว Publisher มีอะไร Subscribe บ้าง เพื่อเช็คว่าซ้ำไหม
    private ArrayList<StringSubscription> subscriptions;//เก็บตัว subscriptions ไว้ เมื่อกรองข้อมูลเสร็จแล้วจะส่งข้อมูลให้ subscriptions

    public StringPublisher() {
        subscribers = new ArrayList<>();
        subscriptions = new ArrayList<>();
    }

    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        if (subscribers.contains(subscriber)){
            System.out.println("Already subscribe");
        }
        else {
            subscribers.add(subscriber);
            StringSubscription ss = new StringSubscription((StringSubscriber) subscriber);
            subscriptions.add(ss);
            subscriber.onSubscribe(ss);
            System.out.println("Subscribe complete");
    }
}

    public void submit(String message){


        for (StringSubscription ss : subscriptions){
            Matcher stringMatcher = ss.getPattern().matcher(message);
            if (stringMatcher.find()){
                ss.add(message);
            }
        }


    }
}
