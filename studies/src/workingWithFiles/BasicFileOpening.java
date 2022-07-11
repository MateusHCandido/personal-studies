package workingWithFiles;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BasicFileOpening {

    public static void main(String [] args){

        File file = new File("Enter the path of your .txt file here");
        Scanner scanner = null;

        try{
            scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }catch (IOException error){
            System.out.println("Error 01: " + error.getMessage());
        }finally {
            if(scanner != null) {
                scanner.close();
            }
        }
    }
}

