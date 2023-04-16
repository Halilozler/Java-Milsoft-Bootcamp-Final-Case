package Homework.draw;

import java.io.Console;

public class Test {
    public static void main(String[] args) {
        /*
         Test
            drawer = new
            Function f1=new Poinomial(-6,5,1)
            drawer.draw(f1)
            Function f2=new Sinusoidal(10,2,Math.PI/6)
            drawer.draw(f2)
        */
        Drawer drawer = new Drawer();
        Function f1 = new Polynomial(new double[]{-6,5,4});
        drawer.draw(f1,10,40,5);
        Function f2 = new Sinusoidal(10,2,Math.PI/6);
        //drawer.draw(f2, 4,6,3);
    }
}
