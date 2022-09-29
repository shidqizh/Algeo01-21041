package Utility;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner; 
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;

import Matrix.*;

public class IO {
    public void inputFile(String S){
        int array[] = new int[144];
        try {
            File myObj = new File("%s.txt", S); //NAMA PATHNAME NYA GA SESUAI TAR BENERIN
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              for(int i=0;i<144;i++){
                if()
              }
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        }
    
    public String fileToString(){
        String ns = "mwmek";
        try {
            String content = Files.readString(Paths.get(path));
            System.out.println(content);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    


}

