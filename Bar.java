// Name: Julius Yee
// USC NetID: 2037-8984-92
// CS 455 PA1
// Fall 2017

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 */

public class Bar
{
	private int xLeft;
	private int yBottom;
	private int barWidth;
	private int height;
	private Color barColor;
	private String barLabel;
	
   /**
    * Constructor
    * Creates a labeled bar.  You give the height of the bar in application
    * units (e.g., population of a particular state), and then a scale for how
    * tall to display it on the screen (parameter scale). 
  
      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
   public Bar(int bottom, int left, int width, int barHeight,
              double scale, Color color, String label) 
   {
	   yBottom = bottom;
	   xLeft = left;
	   barWidth = width;
	   height = (int)(barHeight * scale);
	   barColor = color;
	   barLabel = label;
   }
   
   /**
     * Draw the labeled bar. 
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) 
   {   
	 //Draw the bar labels
	   Font font = g2.getFont();
	   FontRenderContext context = g2.getFontRenderContext();
	   Rectangle2D labelBounds = font.getStringBounds(barLabel, context);
	   int heightOfLabel = (int) labelBounds.getHeight();
	   int widthOfLabel = (int) labelBounds.getWidth();
	   
	   g2.setColor(barColor);
	   g2.drawString(barLabel, (xLeft + (barWidth/2)) - (widthOfLabel/2) , yBottom);
	   
	   //Create rectangle objects to represent a bar
	   Rectangle body = new Rectangle(0, 0, barWidth, height);
	   yBottom = yBottom - height - heightOfLabel;
	   body.translate(xLeft, yBottom);
	   
	   g2.draw(body);
	   g2.fill(body);
	   
   }
}