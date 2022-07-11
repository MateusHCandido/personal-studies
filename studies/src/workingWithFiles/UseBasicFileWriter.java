package workingWithFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UseBasicFileWriter {
    public static void main(String[] args){
        String[] lines = new String[]{"Adicionando mais linhas...", "Lendo linha 8", "Lendo linha 9",
                "Lendo linha 10", "Acabaram as linhas de novo..."};


        String path = "C:\\Users\\Matheus Henrique\\OneDrive\\Área de Trabalho\\MATEUS\\estudos-pessoais\\" +
                "personal-workspace\\out\\production\\personal-workspace\\workingWithFiles\\teste.txt";
        // Create File IF NOT EXISTS
        /*If you don't want to recreate the file, just update it,
        just pass the "true" parameter along with the path, in FileWriter*/
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){
            for(String line: lines){
                bw.write(line);
                bw.newLine();//line break;
            }
        }catch (IOException error){
            error.printStackTrace();
        }

    }
}
