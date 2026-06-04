/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culturestory;
import processing.core.PApplet;
import java.awt.event.KeyEvent;
import processing.core.PImage;
/**
 *
 * @author 342889045
 */
public class MySketch extends PApplet {
    // variables that set up the drawing function
    private Person person;
    int stage = 0;
    String userInput = "";
    private PImage bg;
    private PImage main;
    public void settings(){
        size(1000, 500);
    }
    //setup textsize and background, can change later on
    public void setup() {
        bg = loadImage("images/water.jpg");
        main = loadImage("images/Mainmenu.png");
        textSize(20);
        //Import image and instantiate person
        person = new Person(this,50,50,"images/drag.png");
    }
    public void draw(){
        //change to image later
        image(main,0,0);
        
        if (stage == 0){
            fill(0);
            text("Enter your Name and press 'ENTER' to start", 330,280);
            text(userInput, 423 , 320);

            //movement code
        } 
                    String name = userInput;
        if (stage == 1){
            image(bg,0,0);
            person.draw();
            // Writes users name on the dragon
            this.text(name,person.x +3 , person.y);

            
            if (keyPressed){
                if(keyCode== LEFT){
                    person.moveTo(-3,0);
                 
                } else if(keyCode == RIGHT){
                    person.moveTo(3,0);
            } else if(keyCode == DOWN){
                person.moveTo(0,3);
                
            }else if(keyCode == UP){
                person.moveTo(0,-3);
            } 
            
               
        }
    }
    
    }
public void keyPressed(){
    if (stage == 0){
        if (keyCode == ENTER){
            stage = 1; // enter next stage, starts to draw character
        } else if(key != CODED){
            userInput += key;
        }
        
    }
}   


}
