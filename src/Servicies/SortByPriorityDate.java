package Servicies;

import Tasks.Tasks;

import java.util.Comparator;

public class SortByPriorityDate implements Comparator<Tasks> {
    public int compare ( Tasks a, Tasks b)
    {
        Boolean priority1 = a.isPriority();
        Boolean priority2 = b.isPriority();

        if (priority1 == true) return -1;
        if (priority2 == true) return 1;

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
