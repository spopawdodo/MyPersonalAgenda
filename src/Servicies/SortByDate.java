package Servicies;

import Tasks.Tasks;

import java.util.Comparator;
import java.util.Date;

public class SortByDate implements Comparator<Tasks> {
    public int compare ( Tasks a, Tasks b)
    {
        String date1[] = a.getDeadLine().getDate().split("[.]");
        String date2[] = b.getDeadLine().getDate().split("[.]");
        for ( int i = date1.length - 1; i >= 0 ; i--)
        {
            if (date1[i].compareTo(date2[i]) != 0){
                return date1[i].compareTo(date2[i]);
            }
        }
        return 0;
    }
}
