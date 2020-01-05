package data_structures_and_algorithm_analysis.sort_algorithm;

public class Shellsort {
    public static <AnyType extends Comparable<? super AnyType>> void shellsort(AnyType [] a)
    {
        int j;

        for(int gap = a.length / 2; gap > 0; gap /= 2)
            for(int i = gap; i < a.length; i++) 
            {
                AnyType tmp = a[i];

                for(j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap)
                    a[j] = a[j - gap];
                a[j] = tmp;
            }
    }

    public static <AnyType extends Comparable<? super AnyType>> void betterShellsort(AnyType [] a)
    {
        int j;
        int k = (int)Math.round(Math.log(a.length)/Math.log(2) - 0.5);

        //gap: 1, 3, 7, ..., 2^k - 1
        for(int gap = (int)(Math.pow(2, k) - 1); gap > 0; gap = ((gap + 1) / 2 - 1))
            for(int i = gap; i < a.length; i++) 
            {
                AnyType tmp = a[i];

                for(j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap)
                    a[j] = a[j - gap];
                a[j] = tmp;
            }
    }
}