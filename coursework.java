import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class coursework implements MouseMotionListener
{	int mouseX;
	int mouseY;
	GameArena a = new GameArena(800,800);
	Ball b = new Ball(350,780,10,"White");
	Rectangle right = new Rectangle(700,0,200,1600,"lightGray");
	Rectangle[] brick = new Rectangle[20];
	Line line = new Line(350, 780, mouseX, mouseY, 3, "White");

		
	public coursework()
	{
		a.addBall(b);
		a.addRectangle(right);
		a.addLine(line);
		bricks();
		ball();
		a.update();
	}
	public static void main(String[] arguments)
	{
		coursework game = new coursework();
		addMouseListener(this);		
		addMouseMotionListener(this);
	}

	public void ball()
	{

	double xspeed = 5;	//x is across
	double yspeed = 2;	//y is up + down

	while(true)
		{
			double x = b.getXPosition();
			double y = b.getYPosition();
	
			x = x + xspeed;
			y = y + yspeed;
	
			if(x>= 600 || x <= 0)
			{
				xspeed = -xspeed;
			}
		
			if(y>= 800 || y <= 0)
			{
				yspeed = -yspeed;
			}
	
			b.setXPosition(x);
			b.setYPosition(y);
			a.update();
		}

	}

	public void bricks()
	{
	int index = 0;	//brick number
	
	for (int r=0; r<2; r++){
		for(int c=0; c<10; c++){
			brick[index] = new Rectangle(30+60*c,30+60*r, 50, 20, "white");
			a.addRectangle(brick[index]);
			index++;
			}
		}
	}
	public void updateSize(MouseEvent e){
		mouseX = e.getX();
		mouseY = e.getY();
		line.setEnd(mouseX, mouseY);
	}
	public void mouseMoved(MouseEvent e)
	{
		
		updateSize(e);
	}
	public void mouseDragged(MouseEvent e){}
}
