package data_structures_and_algorithm_analysis.sort_algorithm;

public class Insertionsort {
    public static <AnyType extends Comparable<? super AnyType>> void insertionsort(AnyType [] a)
    {
        int j;// j is the current index of tmp

        for(int p = 1; p < a.length; p++)
        {
            AnyType tmp = a[p];
            for(j = p; j > 0 /* j >= 1 */ && tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

    public static <AnyType extends Comparable<? super AnyType>> void insertionsort(AnyType [] a, int left, int right)
    {
        int j;

        for(int p = left + 1; p < right + 1; p++)
        {
            AnyType tmp = a[p];
            for(j = p; j >= 1 && tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }
}