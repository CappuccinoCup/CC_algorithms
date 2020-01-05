package data_structures_and_algorithm_analysis.sort_algorithm;

public class CommonFunc{
    /**
     * Swap two elements in an array
     * @param a an array
     * @param i the index of an element
     * @param j the index of the other element
     */
    public static <AnyType extends Comparable<? super AnyType>> void swapReference(AnyType[] a, int i, int j)
    {
        AnyType tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * random integer generator
     * @param size the number of integers returned 
     * @return an array containing size number of integers (>= 0 && <= 1000)
     */
    public static Integer[] randomInteger(int size) 
    {
        Integer[] a = new Integer[size];
        int idx = 0;

        for(int i = 0;i < size; i++) 
        {
            a[idx++] = (int)Math.round(Math.random() * 1000);
        }

        return a;
    }

    /**
     * random lowercase letter String generator
     * @param size the number of Strings returned
     * @param maxLen the maximal length of Strings
     * @param fixedLen is the Strings' length fixed
     * @return an array containing size number of lowercase letter Strings (char: >= 97 && <= 122)
     */
    public static String[] randomString(int size, int maxLen, boolean fixedLen)
    {
        String[] str = new String[size];
        int idx = 0;

        for(int i = 0; i < size; i++)
        {
            int thisLen = fixedLen ? maxLen : (int)Math.round(Math.random() * maxLen);
            String s = new String();

            for(int j = 0; j < thisLen; j++)
                s += (char)(int)(Math.round(Math.random() * 25) + 97);// 97 ~ 122

            str[idx++] = s;
        }

        return str;
    }
}