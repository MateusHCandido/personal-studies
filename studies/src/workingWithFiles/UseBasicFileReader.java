package workingWithFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


        /*Basic and unsustainable solution in a real application, due to unnecessarily verbose amount*/
public class UseBasicFileReader {
    public static void main(String[] args){

        String path = "C:\\Users\\Matheus Henrique\\OneDrive\\Área de Trabalho\\MATEUS\\estudos-pessoais\\" +
                "personal-workspace\\out\\production\\personal-workspace\\workingWithFiles\\teste.txt";


        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }catch (IOException error){
            System.out.println("Error:" + error.getMessage());
        }
    }
}
