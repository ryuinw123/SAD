import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        try {
            File myObj = new File("Alphabet.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            File myObj2 = new File("Number.txt");
            if (myObj2.createNewFile()) {
                System.out.println("File created: " + myObj2.getName());
            } else {
                System.out.println("File already exists.");
            }
            File myObj3 = new File("Symbol.txt");
            if (myObj3.createNewFile()) {
                System.out.println("File created: " + myObj3.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        StringPublisher publisher = new StringPublisher();
        NumberSubscriber a = new NumberSubscriber();
        AlphabetSubscriber b = new AlphabetSubscriber();
        SymbolSubscriber c = new SymbolSubscriber();

        publisher.subscribe(a);
        publisher.subscribe(b);
        publisher.subscribe(c);

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter word enter cancel to cancel Program");//อยากให้หยุดโปรแกรมให้พิมพ์ว่า cancel

        String username = myObj.nextLine();
        while (!username.equals("cancel")){
            publisher.submit(username);
            username = myObj.nextLine();
        }

    }
}
