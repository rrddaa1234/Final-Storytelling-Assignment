/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culturestory;
import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author 342889045
 */
public class Person {
    // declaring the variables for position x and y
    public int x;
    public int y;

    // name never changes
    private static final String name = "Dragon";
    //set up for drawing and image
    private PImage image;
    private PApplet app;
    //Special stamina bar
    private double stamina = 30.0;
    private String namep;
    
    public Person(PApplet p, int x, int y, String imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
    }
    public void Name(String name){
        this.namep = name;
        
    }
    
    public void moveTo(int dx, int dy){
        x += dx;
        y += dy;

        stamina -= .2;
        System.out.print(stamina + "   ");
        System.out.flush();
    }
    public void draw(){
        app.image(image,x,y);


        //staminap = doubleParce
        //text(stamina, 50,50);
    }
}
