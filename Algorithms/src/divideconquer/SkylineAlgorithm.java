package divideconquer;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author Bharat
 *
 */
public class SkylineAlgorithm {
	  private ArrayList<Point> points;

	  /**
	   * Main constructor of the application. ArrayList points gets created, which represents the sum of
	   * all edges.
	   */
	  public SkylineAlgorithm() {
	    points = new ArrayList<>();
	  }

	  /** @return points, the ArrayList that includes all points. */
	  public ArrayList<Point> getPoints() {
	    return points;
	  }

	  /**
	   * The main divide and conquer, and also recursive algorithm. It gets an ArrayList full of points
	   * as an argument. If the size of that ArrayList is 1 or 2, the ArrayList is returned as it is, or
	   * with one less point (if the initial size is 2 and one of it's points, is dominated by the other
	   * one). On the other hand, if the ArrayList's size is bigger than 2, the function is called
	   * again, twice, with arguments the corresponding half of the initial ArrayList each time. Once
	   * the flashback has ended, the function produceFinalSkyLine gets called, in order to produce the
	   * final skyline, and return it.
	   *
	   * @param list, the initial list of points
	   * @return leftSkyLine, the combination of first half's and second half's skyline
	   * @see Point
	   */
	  public ArrayList<Point> produceSubSkyLines(ArrayList<Point> list) {

	    // part where function exits flashback
	    int size = list.size();
	    if (size == 1) {
	      return list;
	    } else if (size == 2) {
	      if (list.get(0).dominates(list.get(1))) {
	        list.remove(1);
	      } else {
	        if (list.get(1).dominates(list.get(0))) {
	          list.remove(0);
	        }
	      }
	      return list;
	    }

	    // recursive part of the function
	    ArrayList<Point> leftHalf = new ArrayList<>();
	    ArrayList<Point> rightHalf = new ArrayList<>();
	    for (int i = 0; i < list.size(); i++) {
	      if (i < list.size() / 2) {
	        leftHalf.add(list.get(i));
	      } else {
	        rightHalf.add(list.get(i));
	      }
	    }
	    ArrayList<Point> leftSubSkyLine = produceSubSkyLines(leftHalf);
	    ArrayList<Point> rightSubSkyLine = produceSubSkyLines(rightHalf);

	    // skyline is produced
	    return produceFianlSkyLine(leftSubSkyLine, rightSubSkyLine);
	  }
	  
	  public ArrayList<Point> produceFianlSkyLine(ArrayList<Point> left, ArrayList<Point> right)
	  {
		  //dominated points of arraylist left are removed 
		  for(int i = 0; i < left.size() -1; i++)
		  {
			  if(left.get(i).x == left.get(i).x && left.get(i).y > left.get(i + 1).y)
			  {
				  left.remove(i);
				  i--;
			  }
		  }
		  //minimum y-value is found
		  int min = left.get(0).y;
		  for(int i = 1; i < left.size(); i++)
		  {
			  if(min > left.get(i).y)
			  {
				  min = left.get(i).y;
				  if(min == 1)
				  {
					  i = left.size();
				  }
			  }
		  }
		  //dominated points of ArrayList right are removed
		  for(int i = 0; i < right.size(); i++)
		  {
			  if(right.get(i).y >= min)
			  {
				  right.remove(i);
				  i--;
			  }
		  }
		  
		  //final skyline found and returned 
		  left.addAll(right);
		  return left;
	  }
	  
	  public static class Point
	  {
		  private int x;
		  private int y;
		  
		  /**
		   * The main Constructor of point class to represents the 2 dimension points 
		   * 
		   * @param x the points x-value
		   * @param y the points y-value
		   */
		  public Point(int x, int y)
		  {
			  this.x = x;
			  this.y = y;
		  }
		  
		  public int getX()
		  {
			  return x;
		  }
		  
		  public int getY()
		  {
			  return y;
		  }
		  /**
		   * Based on the skyLine it checks if the point that calls the function dominates the 
		   * argument point
		   * @param p1 the point taht ius compared
		   * @return true if teh point which calls the function dominates p1 false otherwise  
		   */
		  public boolean dominates(Point p1)
		  {
			  return (this.x < p1.x && this.y <= p1.y) || this.x <= p1.x && this.y < p1.y;
		  }
	  }
	  /**
	   * It is used to compare teh 2 dimesion points based on their x-values in order get sorted 
	   * later
	   */
	  class XComparator implements Comparator<Point>
	  {

		@Override
		public int compare(Point a, Point b) {
	
			return Integer.compare(a.x, b.x);
		}
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}