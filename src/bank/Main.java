package bank;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, Exception {
    ATM Add=new ATM(1114,123456);
    System.out.println(Add.AtmLogin(1114, 123456));
    Add.AccInfo();
    }
}
