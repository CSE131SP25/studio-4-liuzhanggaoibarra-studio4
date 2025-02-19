package studio4;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		
		String shapeType = in.next();
		int redComponent = in.nextInt();
		int greenComponent = in.nextInt();
		int blueComponent = in.nextInt();
		Boolean filledShape = in.nextBoolean();
		
		
		
		Color shapeColor = new Color (redComponent, greenComponent, blueComponent);
		
		if (shapeType.equals("rectangle")) {
			double parameterOne = in.nextDouble();
			double parameterTwo = in.nextDouble();
			double parameterThree = in.nextDouble();
			double parameterFour = in.nextDouble();
			if (filledShape == true) {
				StdDraw.setPenColor(shapeColor);
				StdDraw.filledRectangle(parameterOne, parameterTwo, parameterThree, parameterFour);
				
			} else {
				StdDraw.setPenColor(shapeColor);
				StdDraw.rectangle(parameterOne, parameterTwo, parameterThree, parameterFour);
				
			}
		} else if (shapeType.equals("triangle")) {
			double parameterOne = in.nextDouble();
			double parameterTwo = in.nextDouble();
			double parameterThree = in.nextDouble();
			double parameterFour = in.nextDouble();
			double parameterFive = in.nextDouble();
			double parameterSix = in.nextDouble();
			double[]x= {parameterOne, parameterThree, parameterFive};
			double[]y= {parameterTwo, parameterFour, parameterSix};
			if (filledShape == true) {
				StdDraw.setPenColor(shapeColor);
				StdDraw.filledPolygon(x, y);
				
			} else {
				StdDraw.setPenColor(shapeColor);
				StdDraw.polygon(x, y);
			}
		} else if (shapeType.equals("ellipse")) {
			double parameterOne = in.nextDouble();
			double parameterTwo = in.nextDouble();
			double parameterThree = in.nextDouble();
			double parameterFour = in.nextDouble();
			if (filledShape == true) {
				StdDraw.setPenColor(shapeColor);
				StdDraw.filledEllipse(parameterOne, parameterTwo, parameterThree, parameterFour);
				
			} else {
				StdDraw.setPenColor(shapeColor);
				StdDraw.ellipse(parameterOne, parameterTwo, parameterThree, parameterFour);
			}
		}
	}
}