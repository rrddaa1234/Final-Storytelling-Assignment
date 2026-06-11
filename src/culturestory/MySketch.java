/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culturestory;
import processing.core.PApplet;
import processing.core.PImage;
import java.awt.event.KeyEvent;
/**
 *
 * @author 342889045
 */
public class MySketch extends PApplet {
    // variables that set up the drawing function
    private Person person;
    private Person coin1;
    private Person snake;
    int stage = 0;
    String userInput = "";
    private PImage bg;
    private PImage bg2;
    private PImage main;
    private PImage dial1;
    private PImage dial2;
    private PImage dial3;
    private PImage dial4;
    private PImage dial5;
    private Person cat;
    private boolean appearance = true;
    private Person farmer;
    
        int count = 0;
    private int counter =0;

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
        coin1 = new Person(this,800,200,"images/gold.png");
        cat = new Person(this,760,160,"images/Cat.png");
        snake = new Person(this,0,350,"images/Snake.png");
        dial1 = loadImage("images/Dialog1.png");
        dial2 = loadImage("images/Dialog2.png");
        dial3 = loadImage("images/Dialog3.png");
        dial4 = loadImage("images/Dialog4.png");
        dial5 = loadImage("images/Dialog5.png");
        bg2 = loadImage("images/field.png");
        farmer = new Person(this,700,400,"images/farmer.png");
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

            //Draws / prints out images
            image(bg,0,0);
            person.draw();
            
            // Writes users name on the dragon
            this.text(name,person.x +1 , person.y);

            //MOVEMENT
            if (keyPressed){
                // LEFT
                if(keyCode== LEFT){
                    person.moveTo(-3,0);
                 //RIGHT
                } else if(keyCode == RIGHT){
                    person.moveTo(3,0);
                    //DOWN
                } else if(keyCode == DOWN){
                    person.moveTo(0,3);
                    //UP
                }else if(keyCode == UP){
                    person.moveTo(0,-3);
                } 
            }
            // BARRIER SO USER CANNOT LEAVE THE SCREEN
            if(person.x < 0){
                person.x = 0;
            }
            if(person.x> 940){
                person.x = 940;
            }
            if(person.y < 0){
                person.y =0;
            }
            if(person.y >440){
                person.y=440;
            }
            
            
            //COIN MODES ON SCREEN
            
        if (appearance == true){
            coin1.draw();
        }           
            //COIN MODES OFF SCREEN
            if (appearance == false) {  
                if (counter==0){
                image(dial1,50,390);
                text("'ENTER' to continue", 800,380);
                } else if (counter ==1){
                    cat.draw();
                    image(dial2,50,390);
                    text("'Space' to continue", 800,380);
                        if (keyCode == KeyEvent.VK_SPACE){
                            System.out.println("Marker");                            
                            counter =2;
            }
                } else if (counter ==2) {
                person.x = 10;
                person.y = 400;
                stage =2;
                System.out.print("second mark");
    
            }


            //} when user presses either, the counter increases
                if (keyCode == ENTER){
                    counter =1;
                }

    }
                
            // COLLISION CHANGES THE MODE OF THE COIN
        if (person.isCollidingWith(coin1)) {
            appearance = false;

    }
    }
        else if (stage == 2){
            //setting character to a new spot and creating background
            // in scene 2 the dragon flys over a farm town to water their crops.
            image(bg2,0,0);
            person.draw();
            System.out.println("Third marker");
            if (counter != 1){
               if (person.x < 100){
                    image(dial3,50,90);
                    text("'ENTER' to continue", 800,80);
                    farmer.draw();
                    if (keyCode == ENTER){
                        counter = 1;
            }            
               }
            }
            // AFTER DIALOGUE
            if(counter == 1){
                farmer.draw();
                 //MOVEMENT
            if (keyPressed){
                // LEFT
                if(keyCode== LEFT){
                    person.moveTo(-4,0);
                    //RIGHT
                    }else if(keyCode == RIGHT){
                    person.moveTo(4,0);
                    //DOWN
                    }else if(keyCode == SHIFT && person.isCollidingWith(farmer)){
                    image(dial4,50,90);
                    text("'RELEASE' shift to continue", 750,80);
            }
            }
            
                //BARRIER
            if(person.x < 0){
                person.x = 0;
            }
            if(person.x> 940){
                person.x = 940;
            }
            
            
            
            

        }
        //Continue to the next stage of Dragon completing the race
        if (person.x == 930){
            counter = 0;
            person.x = 0;
            person.y = 240;
            stage = 3;
       
        
    
        }
    }
        else if(stage ==3){
            // Goes back into river
            image(bg,0,0);
            person.draw();
            if (counter != 1){
               if (person.x < 100){
                    image(dial5,50,390);
                    text("'ENTER' to start the race", 750,380);
                    cat.x=25;
                    cat.y=100;
                    cat.draw();
                    if (keyCode == ENTER){
                        counter = 1;
                    }
                    }        
            }
            if (counter == 1){
                snake.draw();
                snake.x += 3;
                cat.draw();
                cat.x -= 5;
                //MOVEMENT
            if (keyPressed){
                // LEFT
                if(keyCode== LEFT){
                    person.moveTo(-4,0);
                    //RIGHT
                }else if(keyCode == RIGHT){
                    person.moveTo(4,0);

                }
                //BARRIER
            if(person.x < 0){
                person.x = 0;
            }
            if(person.x> 940){
                person.x = 940;
            }
            }
            }
            if (person.x > 930){
                text("CONGRATULATIONS ON WINNING THE CULTURE GAME!!!",300,200);
            }
            
            
            
            
            
            
            
            

        }
    }    
public void keyPressed(){
    if (stage == 0){
        if (keyCode == ENTER){
            stage = 1; // enter next stage, starts to draw character
            
            //Allowing users input to be their name and allowing them to erase.
        } else if(key != CODED){
            userInput += key;
            
        if (keyCode == BACKSPACE) {

        if (userInput.length() > 0) {

            userInput = userInput.substring(0, userInput.length() - 2);

        }

      }
        }
        
    }
}   

}

