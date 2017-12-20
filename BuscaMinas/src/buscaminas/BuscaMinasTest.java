package buscaminas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class BuscaMinasTest {

    
    @Test
    void test() {
        String[] res;
        Minas min = new Minas();
        res = min.StartMinas("ejemplo.txt");
        String[] t = { "*100", "2210", "1*10", "1110"};
        assertTrue(Arrays.equals(res,t));

    }
    @Test
    void test1() {
        String[] res;
        Minas min = new Minas();
        res = min.StartMinas("ejemplo1.txt");
        String[] t = { "1*", "11"};
        assertTrue(Arrays.equals(res,t));

    }
    @Test
    void test2() {
        String[] res;
        Minas min = new Minas();
        res = min.StartMinas("ejemplo2.txt");
        String[] t = { "01110", "01*10", "01110", "22100", "**100"};
        assertTrue(Arrays.equals(res,t));

    }

    @Test
    void test3() {
        String[] res;
        Minas min = new Minas();
        res = min.StartMinas("ejemplo3.txt");
        String[] t = { "000", "000", "000"};
        assertTrue(Arrays.equals(res,t));

    }
    @Test
    void test4() {
        String[] res;
        Minas min = new Minas();
        res = min.StartMinas("ejemplo4.txt");   
        String[] t = { "******", "******", "******", "******", "******", "******"};
        assertTrue(Arrays.equals(res,t));

    }
    @Test
    void test5() {
        String[] res;
        Minas min = new Minas();
        res = min.StartMinas("ejemplo5.txt");
        String[] t = null;
        assertTrue(Arrays.equals(res,t));

    }
    

}
