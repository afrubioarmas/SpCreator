package com.company;

import java.util.Scanner;

public class ScannerOps {

    static private Scanner in = new Scanner(System.in);

    public static String read(){
        String input="";


        input = in.next();


        return input;
    }

    public static void close(){
        in.close();
    }
}
