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

   
    
    public static void main(String[] args)
    {
        int length;
        String[] mtx;
        String[] res;
        Minas min = new Minas();
        res = min.StartMinas("ejemplo1.txt");
        
//        System.out.println();
//        System.out.println();
        System.out.println(Arrays.toString(res));
    }
    
}
