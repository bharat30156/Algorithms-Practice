package divideconquer;

/**
 * 
 * @author Bharat
 *
 */
/* Foa a set of points in a coordinates system (1000 maximum), closetPair class calculates the two*/
public class ClosetPair {
	
	  /** Number of points */
	  int numberPoints = 0;
	  /** Input data, maximum 10000. */
	  private Location[] array;
	  /** Minimum point coordinate. */
	  Location point1 = null;
	  /** Minimum point coordinate. */
	  Location point2 = null;
	  /** Minimum point length. */
	  private static double minNum = Double.MAX_VALUE;
	  private static int secondCount = 0;

	  public static void setMinNum(double minNum) 
	  {
	    ClosetPair.minNum = minNum;
	  }

	  public static void setSecondCount(int secondCount) 
	  {
	    ClosetPair.secondCount = secondCount;
	  }
	  
	  // constructor
	  ClosetPair(int points)
	  {
		  numberPoints = points;
		  array = new Location[numberPoints];
	  }
	  
	  /** Location class is an auxillary type to keep points coordinates*/
	  public static class Location
	  {
		  double x = 0;
		  double y = 0;
		  
		  /**
		   * @param xpar (IN Parameter) x Coordinates <br>
		   * @param ypar (IN Parameter) y Coordinates <br>
		   */
		  Location(final double xpar, final double ypar) 
		  {
			  this.x = xpar;
			  this.y = ypar;
		  }
	  }
	  
	  public Location[] createLocation(int numberValues)
	  {
		  return new Location[numberValues];
	  }
	  
	  public Location buildLocation(double x, double y)
	  {
		  return new Location(x, y);
	  }
	  
	  /**
	   * xPartition function arrange x - axis 
	   * 
	   * @param a (IN Parameter) array of points <br>
	   * @param first (IN Parameter) first point <br>
	   * @param last (IN Parameter) last Point <br>
	   * @return pivot index
	   */
	  
	  public int xPartition(final Location[] a, final int first, final int last)
	  {
		  Location pivot = a[last];
		  int i = first - 1;
		  Location temp; // Temporaily store value for position taranformation
		  for(int j = first; j <= last - 1; j++)
		  {
			  if(a[j].x <= pivot.x)
			  {
				  i++;
				  temp = a[i];
				  a[i] = a[j];
				  a[j] =  temp;
			  }
		  }
		  i++;
		  temp = a[i];
		  a[i] = a[last];
		  a[last] = temp;
		  return i;
	  }
	  /**
	   * yPartition function arrange y - axis 
	   * 
	   * @paramm a (IN Paremeter ) array of points <br>
	   * @param first (IN Parameter) first point <br>
	   * @param last (IN Parameter) last point <br>
	   * @return pivot index
	   */
	  
	  public int yPartition (final Location[] a, final int first, final int last)
	  {
		  Location pivot = a[last];
		  int i = first - 1;
		  Location temp;
		  for(int j = first; j <= last - 1; j++)
		  {
			  if(a[j].y <= pivot.y)
			  {
				  i++;
				  temp = a[i];
				  a[i] = a[j];
				  a[j] = temp;
			  }
		  }
		  i++;
		  temp = a[i];
		  a[i] = a[last];
		  a[last] = temp;
		  return i;
	  }
	  
	  /**
	   * xOuickSort function // xaxis Quick Sorting 
	   * 
	   * @param a (In Parameter) array of points <br>
	   * @param first (In Parameter) first point <br>
	   * @param last (In Parameter) last [oint <br> 
	   */
	  
	  public void xQuickSort(final Location[] a, final int first, final int last)
	  {
		  if( first < last)
		  {
			  int q = xPartition(a, first, last);
			  xQuickSort(a, first, q - 1); // Left
			  xQuickSort(a, q + 1, last); // right
		  }
	  }
	  
	  /**
	   * yQuickSort function // yaxis Quick Sorting 
	   * 
	   * @param a (IN Parameter) array of points <br>
	   * @param first (In parameter) first points <br>
	   * @param last (IN Parameter) last point <br>
	   */
	  public void yQuickSort(final Location[] a, final int first, final int last)
	  {
		  if(first < last)
		  {
			  int q = yPartition(a, first, last);
			  yQuickSort(a, first, q - 1);
			  yQuickSort(a, q + 1, last);
		  }
	  }
	  
	  /**
	   * Closet pair function find Closet pair
	   * 
	   * @param a (In Parameter) array stored before divide <br>
	   * @param indexNum (IN Parameter) number cooordinates divideArray <br>
	   * @return minmum distance <br> 
	   */
	  public double closestPair(final Location[] a, final int indexNum)
	  {
		  Location[] divideArray = new Location[indexNum];
		  System.arraycopy(a, 0, divideArray, 0, indexNum); //copy previous array
		  int divideX = indexNum / 2; // Intermediate value for divide 
		  Location [] leftArray = new Location[divideX]; // divide - left array
		  
		  
		  //divdie-right array
		  Location[] rightArray = new Location[indexNum - divideX];
		  if(indexNum <= 3) // if the number of coordinates is 3 or less
		  {
			  return bruteForce(divideArray);
		  }
		  
		  // divide lest array
		  System.arraycopy(divideArray, 0, leftArray, 0, divideX);
		  //divide right array
		  System.arraycopy(divideArray, divideX, rightArray, 0, indexNum - divideX);
		  
		  double minLeftArea = 0; // Minimum length of left Array
		  double minRightArea = 0; // Minimum Length of right arrat
		  double minValue = 0; // Minimum length
		  
		  minLeftArea = closestPair(leftArray, divideX); // recursive closest pair
		  minRightArea = closestPair(rightArray, indexNum - divideX);
		  // windoe Size (= minimum length)
		  minValue = Math.min(minLeftArea, minRightArea);
		  
		  //create window. Set the size for creating a window 
		  // and creating a new array for the coordinates in the window 
		  for(int i = 0; i < indexNum; i++)
		  {
			  double xGap = Math.abs(divideArray[divideX].x - divideArray[i].x);
			  if(xGap < minValue)
			  {
				  ClosetPair.setSecondCount(secondCount  + 1); // size of array
			  }
			  else
			  {
				  if( divideArray[i].x > divideArray[divideX].x)
				  {
					  break;
				  }
			  }
		  }
		  
		  // new Array for coordinates in window 
		  Location[] firstWindow = new Location[secondCount];
		  int k = 0;
		  for(int i = 0; i < indexNum; i++)
		  {
			  double xGap = Math.abs(divideArray[divideX].x - divideArray[i].x);
			  if(xGap < minValue)
			  {
				  firstWindow[k] = divideArray[i];
				  k++;
			  }
			  else
			  {
				  if(divideArray[i].x > divideArray[divideX].x)
				  {
					  break;
				  }
			  }
		  }
		  yQuickSort(firstWindow, 0, secondCount - 1); // Sort by y Coordinates
		  
		  //Coordinate in Window
		  double length = 0;
		  //size comparrision within Window
		  for(int i = 0; i < secondCount - 1; i++)
		  {
			  for(int j = (i + 1); j < secondCount; j++)
			  {
				  double xGap = Math.abs(firstWindow[i].x - firstWindow[j].x);
				  double yGap = Math.abs(firstWindow[i].y - firstWindow[j].y);
				  if(yGap < minValue)
				  {
					  length = Math.sqrt(Math.pow(xGap, 2) + Math.pow(yGap, 2));
					  
					  //if measured distance is less thyan current min distance 
					  if(length < minValue)
					  {
						  //change minimum distance to current distance 
						  minValue = length;
						  //Conditional for registering final coordinate 
						  if(length < minNum)
						  {
							  ClosetPair.setMinNum(length);
							  point1 = firstWindow[i];
							  point2 = firstWindow[j];
						  }
					  }
				  }
				  else
				  {
					 break;
				  }
			  }
		}
		ClosetPair.setSecondCount(0);
			  return minValue;
	}
	  
	/**
	 * bruteForce function : When the number of coordinates is less than 3 
	 * 
	 *   @param ArrayParam (In Parameter) array stored before divide <br>
	 *   @return <br>
	 */
	  
	  public double bruteForce(final Location[] arrayParam)
	  {
		  double minValue = Double.MAX_VALUE;
		  double length = 0;
		  double xGap = 0;
		  double yGap = 0;
		  double result = 0;
		  
		  if(arrayParam.length == 2)
		  {
			  //Difference between x coordinates 
			  xGap = (arrayParam[0].x = arrayParam[1].x);
			  //Differnce Between y coordinates 
			  yGap = (arrayParam[0].y = arrayParam[1].y);
			  
			  //distance between coordinates 
			  length = Math.sqrt(Math.pow(xGap, 2) + Math.pow(yGap, 2));
			  
			  //conditional statement for registering final Coordinates 
			  if(length < minNum)
			  {
				  ClosetPair.setMinNum(length);
			  }
			  point1 = arrayParam[0];
			  point2 = arrayParam[1];
			  result = length;
		  }
		  
		  if(arrayParam.length == 3)
		  {
			  for(int i = 0; i < arrayParam.length - 1; i++)
			  {
				  for(int j = (i + 1); j < arrayParam.length; j++)
				  {
					  //Differnce between x Coordinates 
					  xGap = (arrayParam[i].x - arrayParam[j].x);
					  //differnce between y Coordinates 
					  yGap = (arrayParam[i].y - arrayParam[j].y);
					  //distance between coordinates
					  length = Math.sqrt(Math.pow(xGap, 2) + Math.pow(yGap, 2));
					  //If measured distance is less than current min distance 
					  if(length < minValue)
					  {
						  //Change minimum distance to current distance 
						  minValue = length;
						  if(length < minNum)
						  {
							  //Registering final coordinates 
							  ClosetPair.setMinNum(length);
							  point1 = arrayParam[i];
							  point2 = arrayParam[j];
						  }
					  }
				  }
			  }
			  result = minValue;
		  }
		  return result;
	  }
	  
	  /**
	   * main function executes class 
	   * 
	   * @param args (IN Parameter) <br>
	   * @throws IOException if an input or output exception ocurred 
	   */
	  
	  public static void main(final String[] args)
	  {
		  // Input data consists of one x-coordinate and one y-coordinate

		    ClosetPair cp = new ClosetPair(12);
		    cp.array[0] = cp.buildLocation(2, 3);
		    cp.array[1] = cp.buildLocation(2, 16);
		    cp.array[2] = cp.buildLocation(3, 9);
		    cp.array[3] = cp.buildLocation(6, 3);
		    cp.array[4] = cp.buildLocation(7, 7);
		    cp.array[5] = cp.buildLocation(19, 4);
		    cp.array[6] = cp.buildLocation(10, 11);
		    cp.array[7] = cp.buildLocation(15, 2);
		    cp.array[8] = cp.buildLocation(15, 19);
		    cp.array[9] = cp.buildLocation(16, 11);
		    cp.array[10] = cp.buildLocation(17, 13);
		    cp.array[11] = cp.buildLocation(9, 12);
		    
		    System.out.println("Input Data");
		    System.out.println("Number of points : " + cp.array.length);
		    for(int i = 0; i < cp.array.length; i++)
		    {
		    	System.out.println("x : " + cp.array[i].x + ", y: " + cp.array[i].y);
		    }
		    cp.xQuickSort(cp.array, 0, cp.array.length - 1);
		    
		    double result;
		    
		    result = cp.closestPair(cp.array, cp.array.length);
		    
		    System.out.println("Output Data");
		    System.out.println("(" + cp.point2.x + ", " + cp.point1.y + ")");
		    System.out.println("(" + cp.point2.x + ", " + cp.point2.y + ")");
		    System.out.println("Minimum Distance : " + result);
	  }
	  
	  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
}


