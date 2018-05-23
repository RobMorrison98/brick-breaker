import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class coursework
{	
	GameArena a = new GameArena(800,800);		//add game arena and define size
	Ball b = new Ball(350,780,10,"White");		//add first ball
	Ball b2 = new Ball(350, 780, 10, "White");	//add second ball
	Rectangle right = new Rectangle(700,0,200,1600,"lightGray");	//add panel to the right
	Rectangle[] brick = new Rectangle[20];				//add bricks
	Line line = new Line(350, 780, 350, 750, 3, "White");		//add line

		
	public coursework()
	{
		a.addBall(b); 			//add first ball to game arena
		a.addBall(b2);			//add second ball to game arena
		a.addRectangle(right);		//add rectangle on the right to game arena
		a.addLine(line);		//add line to game arena
		bricks();			//run bricks
		ball();				//run ball
		a.update();			//update game arena
	}
	public static void main(String[] arguments)
	{
		coursework game = new coursework();	//run coursework
	}

	public void ball()
	{

	double xspeed = 5;	//first ball horizontal speed
	double x2speed = 6;	//second ball horizontal speed
	double yspeed = 2;	//first ball vertical speed
	double y2speed = 3;	//second ball vertical speed

	while(true)
		{
			double x = b.getXPosition();	//defines x as horizontal position of ball one
			double y = b.getYPosition();	//defines x as vertical position of ball one

			double x2 = b2.getXPosition();	//defines x as horizontal position of ball two
			double y2 = b2.getYPosition();	//defines x as vertical position of ball two
	
			x = x + xspeed;			//getting co ordinates for x
			y = y + yspeed;			//getting co ordinates for y

			x2 = x2 + x2speed;		//getting co ordinates for x2
			y2 = y2 + y2speed;		//getting co ordinates for
	
			if(x>= 600 || x <= 0)		//sets it so the ball goes in the opposite direction when hitting the boundries
			{
				xspeed = -xspeed;
			}

			if(x2>=600 || x2 <= 0)		//sets it so the ball goes in the opposite direction when hitting the boundries
			{
				x2speed = -x2speed;
			}
		
			if(y>= 800 || y <= 0)		//sets it so the ball goes in the opposite direction when hitting the boundries
			{
				yspeed = -yspeed;
			}

			if(y2>=800 || y2 <=0)		//sets it so the ball goes in the opposite direction when hitting the boundries
			{
				y2speed = -y2speed;
			}
	
			b.setXPosition(x);	//sets the horizontal position of ball one
			b.setYPosition(y);	//sets the vertical position of ball one

			b2.setXPosition(x2);	//sets the horizontal position of ball two
			b2.setYPosition(y2);	//sets the vertical position of ball two

			a.update();
		}

	}

	public void bricks()
	{
	int index = 0;	//brick number
	
	for (int r=0; r<2; r++){		//rows
		for(int c=0; c<10; c++){	//colums
			brick[index] = new Rectangle(30+60*c,30+60*r, 50, 20, "white");	//defines location and colour of bricks
			a.addRectangle(brick[index]);	//adds the brick that is currently being made
			index++; //adds one to index so that when it runs through it will stop at the correct number of bricks
			}
		}
	}
}
