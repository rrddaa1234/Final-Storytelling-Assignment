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
    /**
    @param p, x, y, imagePath
    * @ return the image path and set x and y
    * 
    */
    //Instantiation of people / characters with their image.
    public Person(PApplet p, int x, int y, String imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
    }
    public void Name(String name){
        // adds name
        this.namep = name;
    }
    //d is the rate of increase
    public void moveTo(int dx, int dy){
        // addes the rate of change to the x and y
        x += dx;
        y += dy;

    }
    public void draw(){
        //draws the image/person onto the screen
        app.image(image,x,y);

    }
    public boolean isCollidingWith(Person other) {
        //Checking and comparing the x and y from both sides to confirm collision.
        boolean isLeftOfOtherRight = x < other.x + other.image.width;
        boolean isRightOfOtherLeft = x + other.image.width > other.x ;
        boolean isAboveOtherBottom = y < other.y + other.image.height;
        boolean isBelowOtherTop = y + image.height > other.y;
        
        // return statement
        return isLeftOfOtherRight && isRightOfOtherLeft && isAboveOtherBottom && isBelowOtherTop;
    }
}
