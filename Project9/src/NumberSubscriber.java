import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Flow;

public class NumberSubscriber extends StringSubscriber{
    public NumberSubscriber() {
        super.want = "Number";
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

        super.subscription = (StringSubscription) subscription;

        //ขอ Arraylist จาก Subscription
        subscription.request(1);

    }

    @Override
    public void onNext(Object item) {
        //เขียนไฟล์ Number.txt จาก ArrayList<String> item
        try {
            FileWriter myWriter = new FileWriter("Number.txt",true);
            ArrayList<String> as = (ArrayList<String>) item;
            for (String s : as){
                myWriter.write(s);
                myWriter.write("\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            //ขอ Arraylist จาก Subscription
            subscription.request(1);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
