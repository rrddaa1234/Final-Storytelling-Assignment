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
    //images be declared
    private PImage bg;
    private PImage bg2;
    private PImage main;
    private PImage dial1;
    private PImage dial2;
    private PImage dial3;
    private PImage dial4;
    private PImage dial5;
    private PImage flag;
    private PImage credit;
    private Person cat;
    private boolean appearance = true;
    private Person farmer;
    
// counter variable is set to 0
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
        flag = loadImage("images/Flag.png");
        credit = loadImage("images/Credit.png");
        farmer = new Person(this,700,400,"images/farmer.png");
    }
    public void draw(){
        //change to image later
        image(main,0,0);
        
        if (stage == 0){
            //SET UP FOR THE CHARACTERS NAME
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
                    //Says dialogue and enter to go to next dialogue.
                image(dial1,50,390);
                text("'ENTER' to continue", 800,380);
                } else if (counter ==1){
                    //COIN BECOME THE CAT and says dialogue
                    cat.draw();
                    image(dial2,50,390);
                    text("'Space' to continue", 800,380);
                        if (keyCode == KeyEvent.VK_SPACE){                          
                            counter =2;
            }
                } else if (counter ==2) {
                person.x = 10;
                person.y = 400;
                stage =2;

    
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
            // Writes users name on the dragon
            this.text(name,person.x +1 , person.y);
// Dialogue 
            if (counter != 1){

                    image(dial3,50,90);
                    //ENTER to continue.
                    text("'ENTER' to continue", 800,80);
                    farmer.draw();
                    if (keyCode == ENTER){
                        counter = 1;
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
            image(flag,880,10);
            // Writes users name on the dragon
            this.text(name,person.x +1 , person.y);
            // WHEN COUNTER ISNT 1, this is before the race dialogue
            if (counter != 1){
               if (person.x < 100){
                   //
                    image(dial5,50,390);
                    text("'ENTER' to start the race", 750,380);
                    //DRAWS CAT
                    cat.x=25;
                    cat.y=100;
                    cat.draw();
                    if (keyCode == ENTER){
                        counter = 1;
                    }
                    }        
            }// draws the snake and give a movement speed of 3. Has the cat wash away from the screen.
            if (counter == 1){
                snake.draw();
                snake.x += 3;
                cat.draw();
                cat.x -= 4;
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
                //text
                text("CONGRATULATIONS " + name + " on beating my culture game!!!",300,200);
                text("'ENTER' to see credit page", 340,250);
                counter = 0;
                snake.draw();
                // Enter to move onto the 
                if (keyCode == ENTER){
                    stage = 4;
                }
                //Coding if the SNAKE DEFEATS THE DRAGON
            } else if (snake.x>930 && person.x<snake.x){
                //text
                text("You LOST, redo the race by pressing 'ENTER'",300,200);
                counter = 0;
                //enter to restart the race segment
                if (keyCode == ENTER){
                    counter = 1;
                    person.x = 0;
                    snake.x = 0;
                }
            }

        }
        //HOME CREDIT SCREEN
        else if (stage==4){
            image(credit,0,0);
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

