import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Flow;
import java.util.function.Consumer;

public class NumberSubscriber extends StringSubscriber{
    public NumberSubscriber() {
        super.want = "Number";
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

        super.subscription = (StringSubscription) subscription;


        try {
            FileWriter myWriter = new FileWriter("Number.txt");
            myWriter.write("");
            myWriter.close();
            System.out.println("New file");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        subscription.request(1);

    }

    @Override
    public void onNext(Object item) {
        try {
            FileWriter myWriter = new FileWriter("Number.txt",true);
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
