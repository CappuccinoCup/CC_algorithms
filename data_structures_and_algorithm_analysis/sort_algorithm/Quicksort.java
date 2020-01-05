package data_structures_and_algorithm_analysis.sort_algorithm;

public class Quicksort{
    private final static int CUTOFF = 10;
    /**
     * Return median of left, center, and right
     * Order these and hide the pivot
     */
    private static <AnyType extends Comparable<? super AnyType>> AnyType median3(AnyType[] a, int left, int right)
    {
        int center = (left + right) / 2;
        if(a[center].compareTo(a[left]) < 0)
            CommonFunc.swapReference(a, left, center);
        if(a[right].compareTo(a[left]) < 0)
            CommonFunc.swapReference(a, left, right);
        if(a[right].compareTo(a[center]) < 0)
            CommonFunc.swapReference(a, center, right);
        
        // Place pivot at position right - 1
        CommonFunc.swapReference(a, center, right - 1);
        return a[right - 1];
    }

    /**
     * QuickSort algorithm
     * @param a an array of Comparable items
     */
    public static <AnyType extends Comparable<? super AnyType>> void quicksort(AnyType[] a)
    {
        quicksort(a, 0, a.length - 1);
    } 

    /**
     * Internal quicksort
     * Uses median-of-three partitioning and a cutoff of 10
     * @param a an array of Comparable items
     * @param left the left-most index of the subarray
     * @param right the right-most index of the subarray
     */
    private static <AnyType extends Comparable<? super AnyType>> void quicksort(AnyType[] a, int left, int right)
    {
        if(left + CUTOFF <= right)
        {
            AnyType pivot = median3(a, left, right);

            // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; )
            {
                while(a[++i].compareTo(pivot) < 0);
                while(a[--j].compareTo(pivot) > 0);
                if(i < j)
                    CommonFunc.swapReference(a, i, j);
                else
                    break;
            }

            CommonFunc.swapReference(a, i, right - 1);

            quicksort(a, left, i - 1);
            quicksort(a, i + 1, right);
        }
        else    // Do an insertion sort on the subarray
            Insertionsort.insertionsort(a, left, right);
    }

    /**
     * Quick select algorithm
     * @param a an array of Comparable items
     * @return the kth smallest item in a
     */
    public static <AnyType extends Comparable<? super AnyType>> AnyType quickSelect(AnyType[] a, int k)
    {
        if(k < 1 || k > a.length)
        {
            System.out.println("Please input an appropriate k");
            return null;
        }
        else
        {
            quickSelect(a, 0, a.length - 1, k);
            return a[k - 1];
        }
    }

    /**
     * Internal selection method that makes recursive calls
     * Uses median-of-three partitioning and a cutoff of 10
     * Places the kth smallest item in a[k - 1]
     * @param a an array of Comparable items
     * @param left the left-most index of the subarray
     * @param right the right-most index of the subarray
     * @param k the desired index (1 is minimum) in the entire array
     */
    private static <AnyType extends Comparable<? super AnyType>> void quickSelect(AnyType[] a, int left, int right, int k)
    {
        if(left + CUTOFF <= right)
        {
            AnyType pivot = median3(a, left, right);

            // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; )
            {
                while(a[++i].compareTo(pivot) < 0);
                while(a[--j].compareTo(pivot) > 0);
                if(i < j)
                    CommonFunc.swapReference(a, i, j);
                else 
                    break;
            }

            CommonFunc.swapReference(a, i, right - 1);

            // if k = i + 1, the a[i] is the kth smallest item
            if(k <= i)
                quickSelect(a, left, i - 1, k);
            else if(k > i + 1)
                quickSelect(a, i + 1, right, k);
        }
        else    // Do an insertion sort on the subarray
            Insertionsort.insertionsort(a, left, right);
    }
}