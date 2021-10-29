import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Flow;
import java.util.regex.Pattern;

public class AlphabetSubscriber extends StringSubscriber{


    public AlphabetSubscriber() {
        super.pattern = Pattern.compile("[a-z]",Pattern.CASE_INSENSITIVE);
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

        super.subscription = (StringSubscription) subscription;


        //ขอ Arraylist กับ subscription
        subscription.request(1);

    }

    @Override
    public void onNext(Object item) {
        //เขียนไฟล์จาก String
        try {
            FileWriter myWriter = new FileWriter("Alphabet.txt",true);
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
