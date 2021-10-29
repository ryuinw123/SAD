import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Flow;
import java.util.regex.Pattern;

public class SymbolSubscriber extends StringSubscriber{
    public SymbolSubscriber() {
        super.pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

        super.subscription = (StringSubscription) subscription;

        //ขอ Arraylist กับ subscription
        subscription.request(1);

    }

    @Override
    public void onNext(Object item) {
        try {
            FileWriter myWriter = new FileWriter("Symbol.txt",true);
            ArrayList<String> as = (ArrayList<String>) item;
            for (String s : as){
                myWriter.write(s);
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            subscription.request(1);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
