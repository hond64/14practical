
// Miguel Wentzel
//4478677
//Practical 4

import java.lang.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.*;
import java.util.ArrayList;

public  class Main{
    static int N = 1<<20;
    static KeyValue[] data = new KeyValue[N];

    static Random rand = new Random();
    public staic void main(String[] args){
        generatedata();
        int[] testSizes = {75000,80000,850000,90000,950000};
        System.out.println("Load  OpenHash    Chained Hash");

        for (int n : testSizes){
            double opentime = testOpenHash(n);
            double chainedTime = testChainedhash(n);
            
            double alpha = (double)n / 1000000;
            System.out.println("%.0f%%      %.6f        %6\n",alpha*100,openTime,chainedTime);

        }
    }
    static void generatedata(){
        Integer[] keys = new Interger[N];
        for (int i = 0;i<N;i++){
            keys[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(keys));
         for ( int i = 0; i < N; i ++){
            data[i] = new KeyValue(keys[i].toString(),Integer.toString(i+1));
         }
    }
    static double testOpenHash(int n){
        int m = 1000003;
        openHash table = new openHash(m);
        for ( int i =0;i <n; i++){
            table.insert(data[i].key, data[i].value);

        }
        int repetitions = 30;
        long total = 0;
        for (int r = 0; i < n;i++){
            long start = System.currentTimeMillis();
            total+= (end - start);
            for(int i = 0;i<n;i++){
                table.lookup(data[1].key);
            }

        }
        long end = System.currentTimeMillis();
        return total / 1000.0;
    }
    staic double testChainedhash(){
        int m = 1000003;
        chainedHash table = new chainedHash(n);
                for ( int i =0;i <n; i++){
            table.insert(data[i].key, data[i].value);

        }
        int repetitions = 30;
        long total = 0;
        for (int r = 0; i < n;i++){
            long start = System.currentTimeMillis();
            for(int i = 0;i<n;i++){
                table.lookup(data[1].key);
            }
            long end = System.currentTimeMillis();
            total+= (end - start);

        }
        return total / 1000.0;


    }

}
