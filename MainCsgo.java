package csgomvc;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCsgo {
    public static MyCompiler mc;
    public static void main(String[] args) {
        choose();
        try(Scanner input = new Scanner(Paths.get("csgomvc/csgo.txt"))) {
            while (input.hasNext()) { 
                String row = input.nextLine();
                String[] dataFields = row.split("\\s+");
                for(int i = 0; i<dataFields.length; i++){
                    if(mc.isComment(dataFields[i])){
                        break;
                    }else {
                        System.out.println( mc.checkType(dataFields[i]));
                    }
                }
            }          
         } 
         catch (InputMismatchException e) {
            System.err.printf("Data format error: %s%n", e);
         }
         catch (NoSuchFileException e) {
            System.err.printf("File not found: %s%n", e);
         }
         catch (IOException e) {
            System.err.printf("Unknown I/O error: %s%n", e);
            e.printStackTrace();
         }
    }

    public static void choose(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("choose Lexical Analysis 4 or 5 : " );
            String in = sc.nextLine();
            
            if(in.equals("4")){
                mc = new MyCompiler4();
                break;
            }else if(in.equals("5")){
                mc = new MyCompiler5();
                break;
            }
        }
        sc.close();
        
    }
}
