package de.ChrisGold.ChrisUtil;

import java.util.*;

/**
 * @author Christian Goldapp
 */
public class ArrayUtil {

    public static int[] unbox(Integer[] boxed) {
        int[] unboxed = new int[boxed.length];
        for (int i = 0; i < boxed.length; i++) {
            unboxed[i] = boxed[i];
        }
        return unboxed;
    }

    public static boolean[] unbox(Boolean[] boxed) {
        boolean[] unboxed = new boolean[boxed.length];
        for (int i = 0; i < boxed.length; i++) {
            unboxed[i] = boxed[i];
        }
        return unboxed;
    }

    public static long[] unbox(Long[] boxed) {
        long[] unboxed = new long[boxed.length];
        for (int i = 0; i < boxed.length; i++) {
            unboxed[i] = boxed[i];
        }
        return unboxed;
    }

    public static double[] unbox(Double[] boxed) {
        double[] unboxed = new double[boxed.length];
        for (int i = 0; i < boxed.length; i++) {
            unboxed[i] = boxed[i];
        }
        return unboxed;
    }

    public static float[] unbox(Float[] boxed) {
        float[] unboxed = new float[boxed.length];
        for (int i = 0; i < boxed.length; i++) {
            unboxed[i] = boxed[i];
        }
        return unboxed;
    }

    public static char[] unbox(Character[] boxed) {
        char[] unboxed = new char[boxed.length];
        for (int i = 0; i < boxed.length; i++) {
            unboxed[i] = boxed[i];
        }
        return unboxed;
    }

    public static short[] unbox(Short[] boxed) {
        short[] unboxed = new short[boxed.length];
        for (int i = 0; i < boxed.length; i++) {
            unboxed[i] = boxed[i];
        }
        return unboxed;
    }

    public static byte[] unbox(Byte[] boxed) {
        byte[] unboxed = new byte[boxed.length];
        for (int i = 0; i < boxed.length; i++) {
            unboxed[i] = boxed[i];
        }
        return unboxed;
    }

    public static Integer[] box(int[] unboxed) {
        Integer[] boxed = new Integer[unboxed.length];
        for (int i = 0; i < boxed.length; i++) {
            boxed[i] = unboxed[i];
        }
        return boxed;
    }

    public static Long[] box(long[] unboxed) {
        Long[] boxed = new Long[unboxed.length];
        for (int i = 0; i < boxed.length; i++) {
            boxed[i] = unboxed[i];
        }
        return boxed;
    }

    public static Double[] box(double[] unboxed) {
        Double[] boxed = new Double[unboxed.length];
        for (int i = 0; i < boxed.length; i++) {
            boxed[i] = unboxed[i];
        }
        return boxed;
    }

    public static Float[] box(float[] unboxed) {
        Float[] boxed = new Float[unboxed.length];
        for (int i = 0; i < boxed.length; i++) {
            boxed[i] = unboxed[i];
        }
        return boxed;
    }

    public static Character[] box(char[] unboxed) {
        Character[] boxed = new Character[unboxed.length];
        for (int i = 0; i < boxed.length; i++) {
            boxed[i] = unboxed[i];
        }
        return boxed;
    }

    public static Byte[] box(byte[] unboxed) {
        Byte[] boxed = new Byte[unboxed.length];
        for (int i = 0; i < boxed.length; i++) {
            boxed[i] = unboxed[i];
        }
        return boxed;
    }

    public static Short[] box(short[] unboxed) {
        Short[] boxed = new Short[unboxed.length];
        for (int i = 0; i < boxed.length; i++) {
            boxed[i] = unboxed[i];
        }
        return boxed;
    }

    public static String toString(Object[] input){
        return java.util.Arrays.toString(input);
    }

    public static String toString(Object[] input, String start, String delimiter, String end){
        StringBuilder buffer = new StringBuilder();
        buffer.append(start);
        if(input.length==0) return buffer.append(end).toString();
        buffer.append(input[0].toString());
        if(input.length==1) return buffer.append(end).toString();
        for (int i = 1; i < input.length; i++) {
            buffer.append(delimiter);
            buffer.append(input[i].toString());
        }
        buffer.append(end);
        return buffer.toString();
    }

    public static List<String> permute(String input) {
        List<Character[]> charsList = new ArrayList<>();
        permute(charsList, input.length(), box(input.toCharArray()));
        List<String> strings = new ArrayList<>(charsList.size());
        for (Character[] objects : charsList) {
            char[] chars = unbox(objects);
            strings.add(new String(chars));
        }
        return strings;
    }

    public static <E> List<E[]> permute(E[] arr) {
        List<E[]> permutations = new ArrayList<>();
        permute(permutations, arr.length, arr);
        return permutations;
    }

    private static <E> void permute(List<E[]> list, int n, E[] arr) {
        if (n == 1) list.add(Arrays.copyOf(arr, arr.length));
        else {
            for (int i = 0; i < n - 1; i++) {
                permute(list, n - 1, arr);
                if (n % 2 == 0) swap(arr, i, n - 1);
                else swap(arr, 0, n - 1);
            }
            permute(list, n - 1, arr);
        }
    }

    private static <E> void swap(E[] arr, int pos1, int pos2) {
        E o = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = o;
    }
}
