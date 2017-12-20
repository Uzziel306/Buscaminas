/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Uzziel
 */

public class BuscaMinas {

    /**
     * @param mtx
     * @return 
     */
    
    public static void solve(String[]mtx)
    {
        int aux = 0;
        char start = '*';
        for (int i = 0; i < mtx.length; i++) {
            for (int j = 0; j < mtx[i].length(); j++) {
                if (mtx[i].charAt(j) != start)
                {
                    if (i > 0 && j > 0)
                        if (mtx[i - 1].charAt(j - 1) == start)
                            aux++; 
                    if (i > 0 && j < mtx[i].length())
                        if (mtx[i - 1].charAt(j) == start)
                            aux++;
                    if (i > 0)
                        if (mtx[i - 1].charAt(j + 1) == start)
                            aux++;
                    if (j > 0)
                        if (mtx[i].charAt(j - 1) == start)
                            aux++; 
                    if (j < mtx[i].length())
                        if (mtx[i].charAt(j + 1) == start)
                            aux++;
                    if (i < mtx[i].length() && j > 0)
                        if (mtx[i + 1].charAt(j - 1) == start)
                            aux++;
                    if (i < mtx[i].length())
                        if (mtx[i + 1].charAt(j) == start)
                            aux++; 
                    if (i < mtx[i].length() && j < mtx[i].length())
                        if (mtx[i + 1].charAt(j + 1) == start)
                             aux++;
                    System.out.println(i + " " + j + " = "+ aux);
                    aux = 0;
                }
            }
        }
    }
    
    public static int read_lenght()
    {
        int i = 0;
        java.io.File file = new java.io.File("ejemplo.txt");
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext())
            {
                String num = input.nextLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            System.err.format("Archivo no existente...");
        }
        return i;
    }
    
    public static String[] get_map(int length)
    {
        int i = 0;
        int j = 0;
        String[] mtx = new String[length - 1];
        java.io.File file = new java.io.File("ejemplo.txt");
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()){
                String num = input.nextLine();
                if (i == 1)
                {
                    mtx[j] = num;
                    j++;
                }    
                i = 1;
            }
        } catch (FileNotFoundException e) {
            System.err.format("Archivo no existente...");
        }
        return mtx;
    }
    
    public static void main(String[] args)
    {
        int length;
        String[] mtx;

        length = read_lenght();
        mtx = get_map(length);
        solve(mtx);
        //System.out.println(Arrays.toString(mtx));
        // TODO code application logic here
    }
    
}
