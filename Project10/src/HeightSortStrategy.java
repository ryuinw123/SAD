
import java.util.Comparator;
import java.util.List;

public class HeightSortStrategy implements SortStrategy {
    public void customSort(List<Person> people) {
        people.sort(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {return o1.getHeight().compareTo(o2.getHeight());}
        });
    }

    // YOU MAY ADD UP TO 5 LINES OF CODE BELOW THIS COMMENT !! A LINE OF CODE MAY CONTAIN UP TO ONE SEMI-COLON !!

}
