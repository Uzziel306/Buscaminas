package buscaminas;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Minas {

    /**
     * @param mtx
     * @return 
     */
    
    public static String[] StartMinas(String Archivo)
    {
        int length;
        String[] mtx, res;

        if ((length = read_lenght(Archivo)) > 0)
        {
            mtx = get_map(length, Archivo);
            res = solve(mtx);
            return res;
        }
        return null;
    }
    
    public static String[] solve(String[]mtx)
    {
        int aux = 0;
        char start = '*';
        for (int i = 0; i < mtx.length; i++) {
            for (int j = 0; j < mtx[i].length(); j++) {
                if (mtx[i].charAt(j) != start)
                {
                    if (i != 0 && j != 0)
                        if (mtx[i - 1].charAt(j - 1) == start)
                            aux++; 
                    if (i > 0)
                        if (mtx[i - 1].charAt(j) == start)
                            aux++;
                    if (i > 0  && j < mtx[i].length() - 1)
                        if (mtx[i - 1].charAt(j + 1) == start)
                            aux++;
                    if (j > 0)
                        if (mtx[i].charAt(j - 1) == start)
                            aux++; 
                    if (j < mtx[i].length() - 1)
                        if (mtx[i].charAt(j + 1) == start)
                            aux++;
                    if (i < mtx[i].length() - 1 && j > 0)
                        if (mtx[i + 1].charAt(j - 1) == start)
                            aux++;
                    if (i < mtx[i].length() - 1)
                        if (mtx[i + 1].charAt(j) == start)
                            aux++; 
                    if (i < mtx[i].length() - 1 && j < mtx[i].length() - 1)
                        if (mtx[i + 1].charAt(j + 1) == start)
                             aux++;
                    //System.out.print(aux);
                    char a = (char) (aux + 48);
                    char[] myNameChars = mtx[i].toCharArray();
                    myNameChars[j] = a;
                    mtx[i] = String.valueOf(myNameChars);
                    System.out.print(a);
                    aux = 0;
                }
                else
                    System.out.print("*");
            }
            System.out.print("\n");
        }
        return mtx;
    }
    
    public static int read_lenght(String fileAleer)
    {
        int i = 0, x = 0, y = 0;
        int length = 0, flag = 0;
        java.io.File file = new java.io.File(fileAleer);
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext())
            {
                String num = input.nextLine();
                if (flag == 0)
                {
                    String[]dimensiones = num.split(" ");
                    x = Integer.parseInt(dimensiones[0]);
                    y = Integer.parseInt(dimensiones[1]);
                   
                }
                i++;
                if (flag == 1 && y != num.length())
                    return 0;
                flag = 1;
            }
        } catch (FileNotFoundException e) {
            System.err.format("Archivo no existente...");
        }
        if (i - 1 != x)
            return (0);
        return i;
    }
    
    public static String[] get_map(int length, String fileAleer)
    {
        int i = 0;
        int j = 0;
        String[] mtx = new String[length - 1];
        java.io.File file = new java.io.File(fileAleer);
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
    
}
