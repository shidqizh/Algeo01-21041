package Utility;
 
import java.io.*;
import java.io.File; 
import java.io.FileReader;
import java.util.Scanner; 
import java.io.IOException;
import java.io.BufferedReader;

import Matrix.*;

public class IO {
  public static Double split(String f) {
    if (f.split("/").length == 1) {
      return Double.parseDouble(f);
    } else {
      return Double.parseDouble(f.split("/")[0]) / Double.parseDouble(f.split("/")[1]);
    }
  }
    public static int findrow(String f){
      int row = 0;
      try{
        FileReader file = new FileReader(String.format("https://github.com/shidqizh/Algeo01-21041/tree/main/test/1.txt"));
        BufferedReader bReader = new BufferedReader(file);
        while(bReader.readLine() != null){
          row++;
        }
        file.close();
      } 
      catch(IOException e){
        e.printStackTrace();
      }
      return row;
    }
    public static int findcol(String f){
      int col = 0;
      try{
        FileReader file = new FileReader(String.format("https://github.com/shidqizh/Algeo01-21041/tree/main/test/1.txt"));
        BufferedReader bReader = new BufferedReader(file);
        String line = bReader.readLine();
        String[] lines = line.split(" ");
        col = lines.length;
        file.close();
      } 
      catch(IOException e){
        e.printStackTrace();
      }
      return col;

    }
    public static Matrix fileToMatrix(String f){
      Matrix nm = new Matrix(findrow(f), findcol(f));
      try{
        FileReader file = new FileReader(String.format("https://github.com/shidqizh/Algeo01-21041/tree/main/test/1.txt"));
        BufferedReader bReader = new BufferedReader(file);
        String line;
        int count = 0;
        while((line = bReader.readLine()) != null){
          String[] lines = line.split(" ");
          for(int i = 0; i < lines.length; i++){
            double temp = split(lines[i]);
            nm.setElmt(temp,count, i);
          }
          count++;
        }
        file.close();
      }
      catch(IOException e){
        e.printStackTrace();
      }
      
      return nm;
    }
    public static void inputFile(String f){
      fileToMatrix(f);
    }

    
    public void outputFileString(String f, String nama){
      try {
        FileWriter write = new FileWriter(nama+".txt");
        write.write(f);
        write.close();

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    public void outputFileMatrix(Matrix m, String nama){
      int i,j;
      String el;
      try {
        FileWriter write = new FileWriter(nama+".txt");
        for(i=0;i<m.getCol();i++){
          for(j=0;j<m.getRow();j++){
            el = Double.toString(m.getElmt(i, j));
            write.write(el+" ");
          }
          write.write("\n");
        }
        write.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

    }

}

