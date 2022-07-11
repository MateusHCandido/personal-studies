package workingWithFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


        /*Basic and unsustainable solution in a real application, due to unnecessarily verbose amount*/
public class UseBasicFileReader {
    public static void main(String[] args){

        String path = "Enter the path of your .txt file here";
        FileReader fr = null;
        BufferedReader br = null;

        try{
            fr = new FileReader(path); //pass the process of reading the file to the object
            br = new BufferedReader(fr);

            String line = br.readLine();

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }catch (IOException error){
            System.out.println("Error:" + error.getMessage());
        }finally {
            try {
                if (br != null){
                    br.close();
                }
                if (fr != null){
                    fr.close();
                }
            }catch (IOException error){
                error.printStackTrace(); //exception check
            }

        }
    }
}
