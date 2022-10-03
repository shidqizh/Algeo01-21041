package Utility;
 
import java.io.*;
import java.io.FileReader;

import Aplikasi.InterpolasiPolinom;

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
        FileReader file = new FileReader(String.format("test/" + f));
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
        FileReader file = new FileReader(String.format("test/" + f));
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
        FileReader file = new FileReader(String.format("test/" + f));
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

    public static void outputFileDouble(Double d, String nama){
      try {
        FileWriter write = new FileWriter("test/output/"+ "output_"+nama);
        write.write(Double.toString(d));
        write.close();

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
    public static void outputFileString(String f, String nama){
      try {
        FileWriter write = new FileWriter("test/output/"+"output_"+ nama);
        write.write(f);
        write.close();

      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public static void outputFileMatrix(Matrix m, String nama){
      int i,j;
      String el;
      try {
        FileWriter write = new FileWriter("test/output/"+"output_"+ nama);
        for(i=0;i<m.getRow();i++){
          for(j=0;j<m.getCol();j++){
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

    public static void outputFileTafsiranInpol(Matrix m1, Matrix m2, String nama){
      int i;
      String el;
      String s;
      try {
        FileWriter write = new FileWriter("test/output/"+"output_"+ nama);
        for(i=0;i<m1.getRow();i++){
          el = Double.toString(m1.getElmt(i, 0));
          s = Double.toString(m2.getElmt(i, 0));
          write.write("f("+s+") = " + el); 
          write.write("\n");
        }
        write.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public static void outputFileFungsiInpol(Matrix m1, int x, String nama){
      int i;
      String el,eli;
      double in;
      InterpolasiPolinom inpol = new InterpolasiPolinom();
      try {
        FileWriter write = new FileWriter("test/output/"+"output_"+ nama);
        for(i=0;i<m1.getRow();i++){
          in = m1.getElmt(i,x);
          in = inpol.cekOutput(in);
          el = Double.toString(in);
          eli = Integer.toString(i);
          if (i == 0){
            if (m1.getElmt(i+1, x) < 0){
                write.write("f(x) = " + el + " - ");
            } else {
                write.write("f(x) = " + el + " + ");
            }
          } else if (i == x-1) {
            write.write(el + "(x^" + eli + ")");
          } else {
            if (m1.getElmt(i+1, x) < 0){
                write.write(el + "(x^" + eli + ") - ");
            } else {
                write.write(el + "(x^" + eli + ") + ");
            }
          }
        }
        write.write("\n");
        write.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public static void outputFileTafsiranBikubik(Matrix m, String nama, Double x){
      String el;
      String s;
      String t;
      try {
        FileWriter write = new FileWriter("test/output/"+"output_"+ nama);
        el = Double.toString(x);
        s = Double.toString(m.getElmt(4, 0));
        t = Double.toString(m.getElmt(4, 1));
        write.write("f("+s+","+t+") = " + el); 
        write.write("\n");
        write.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}