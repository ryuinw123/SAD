import java.util.ArrayList;
import java.util.concurrent.Flow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPublisher implements Flow.Publisher {

    private ArrayList<Flow.Subscriber> subscribers;
    private ArrayList<StringSubscription> subscriptions;

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
        Pattern symbolPattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern alphabetPattern = Pattern.compile("[a-z]",Pattern.CASE_INSENSITIVE);
        Pattern numericPattern = Pattern.compile("[0-9]+");

        Matcher symbolMatcher = symbolPattern.matcher(message);
        Matcher alphabetMatcher = alphabetPattern.matcher(message);
        Matcher numericMatcher = numericPattern.matcher(message);

        boolean s = symbolMatcher.find();
        boolean a = alphabetMatcher.find();
        boolean n = numericMatcher.find();



        if (s){
            System.out.println("Has symbol");
            for (StringSubscription ss : subscriptions){
                if (ss.getWant() == "Symbol"){
                    ss.add(message);
                }
            }
        }

        if (a) {
            System.out.println("Has alphabet");
            for (StringSubscription ss : subscriptions){
                if (ss.getWant() == "Alphabet"){
                    ss.add(message);
                }
            }
        }

        if (n) {
            System.out.println("Has numeric");
            for (StringSubscription ss : subscriptions){
                if (ss.getWant() == "Number"){
                    ss.add(message);
                }
            }
        }


    }
}
