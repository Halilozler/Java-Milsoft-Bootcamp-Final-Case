package Homework.draw;

import java.io.Console;

public class Drawer {
    public void draw(Function f, double x1, double x2, int n){
        double dx = (x1 - x2) / n;
        for (int x = (int)x1; x < x2; x += dx){
            double y = f.evaluate(x);
            System.out.println("x: " + x + " y: " + y);
        }
    }
}
