import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu and student
 * @version 17 March 2019
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
	
	/// ALL CONSTRUCTORS BELONG TO BARBARA ERICSON //////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width, height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  

  ///EVERYTHING BELOW THIS IS ORIGINAL CODE//////

  /**
   * Finds the index of an int number in an arraylist.
   * Used in the findTheMost method.
   * @param arr
   * @param number
   * @return
   */
  public static int indexFinder(ArrayList<Integer> arr, int number) 
  { 
      // checks if array is Null 
      if (arr == null) return -1; 
      
      // traverse in the array 
    	  for (int i = 0; i < arr.size(); i++)
      {
    		  	if (i == number) return i;
      }
 
      return -1; 
  } 
  
  
    /**
     * Finds the top three pixels that appear the most frequently in a jpg picture
     * and print out the numerical results to the user.
     * Uses the indexFinder and findRGBThumbnail methods.
     * @param pixels
     */
  	public void findTheMost (ArrayList<Integer> pixels)
	{
	
		//initialization of variables
		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<Integer> type = new ArrayList<Integer>();
		ArrayList<Integer> oneDuplicates = new ArrayList<Integer>();
		ArrayList<Integer> twoDuplicates = new ArrayList<Integer>();
		ArrayList<Integer> threeDuplicates = new ArrayList<Integer>();
		int indexFound = 0;
		
		int max = 0;
		int countGreatest = 0;
		int maxIndex = -1;
		
		int oneGreatest = 0;
		int twoGreatest = 0;
		int threeGreatest = 0;
		
		int oneCount = -1;
		int twoCount = -1;
		int threeCount = -1;
		
		
		//Part I
		//pixels go into count and type slots
		//this may only have to be one for loop if we get the RBG values in an arraylist format

		System.out.println("Finding the most...");
		System.out.println("Please wait a moment.");
		System.out.println("Note: if you would like to get the color from a specific area of the photo, use a cropped version.");
		System.out.println();
		
		for (int i = 0; i < pixels.size(); i++)
	      {
		    	  //check if a number from the type array is in the pixels array
		    	  indexFound = indexFinder(type, pixels.get(i));
		    	  
		    	  //if the index is not found, add it to the zeroed elements in the array
		    	  if(indexFound == -1)
		    	  {
		    		  //System.out.println("INDEX NOT FOUND");
		    		  type.add(pixels.get(i));
		    		  count.add(1);
		      }
		    	  
		    	  
		    	  //if the index is found, add one to the count array slot of the same index
		    	  if( indexFound != -1)
		    	  {
		    		  int add = count.get(indexFound) +1;
		    		  count.set(indexFound, add);
		    	  }
		    	  
	      }
	    
	    
	    //PART II
	    //to print out the top three numbers that appear the most, 
	    //we will have to go through and find the greatest number in count
	    //get its index
	    //replace it with zero in the count array
	    //and then find the type with the corresponding index
	    //you will then have three different variables to set each type found to
	    //this will be repeated three times
	    
	    int threeWhile = 0;
	    while (threeWhile < 3) //confirmed will iterate only three times
	    {
		    //cycles through count array to find number that appears the most
		    for (int i = 0; i < count.size(); i++)
		    {
		    		if (count.get(i) > max)
		    		{
		    			max = count.get(i); //gets the max from the count array
		    			maxIndex = i;  //gets the index from the count array
		    		}
		    		
		    }
		    
		    //cycles through count array to find ANY DUPLICATES OF THE MAX
		    //puts duplicates into their corresponding duplicate arrays
		    //and replaces any of those duplicates with a 0 in the count array
		    for (int i = 0; i < count.size(); i++)
		    {
		    		if (count.get(i) == max)
		    		{	
		    			if(threeWhile == 0)
		    		    {
		    		    		oneDuplicates.add(type.get(i));
		    		    		count.set(i, 0);
		    		    }
		    		    	if(threeWhile == 1)
		    		    	{
		    		    		twoDuplicates.add(type.get(i));
		    		    		count.set(i, 0);
		    		    	}	
		    		    	if(threeWhile == 2)
		    		    	{
		    		    		threeDuplicates.add(type.get(i));
		    		    		count.set(i, 0);
		    		    	}
		    		}
		    }
		    
		    //replaces the max with 0 in the count array
		    count.set(maxIndex, 0);
		    //sets countGreatest to the maximum count value
		    countGreatest = max;  
		    //sets the max to the maximum count vaule's corresponding type value
		    max = type.get(maxIndex);

		    //sets the max and countGreatest to the corresponding level
		    if(threeWhile == 0)
		    {
		    		oneGreatest = max;
		    		oneCount = countGreatest;
		    }
		    	if(threeWhile == 1)
		    	{
		    		twoGreatest = max;
		    		twoCount = countGreatest;
		    	}
		    	if(threeWhile == 2)
		    	{
		    		threeGreatest = max;
		    		threeCount = countGreatest;
		    	}
		    
		    	//reset values and iterate
		    	max = 0;
			maxIndex = -1;
		    threeWhile++;
	    }
	    
	    //output
	    System.out.println("The top items that appear the most are: ");
	    
	    System.out.println();
	    System.out.println("One Greatest: " + oneGreatest);
	    System.out.println(oneDuplicates + " appearing " + oneCount + " times.");
	    
	    System.out.println();
	    System.out.println("Two Greatest: " + twoGreatest);
	    System.out.println(twoDuplicates + " appearing " + twoCount + " times.");
	    
	    System.out.println();
	    System.out.println("Three Greatest: " + threeGreatest);
	    System.out.println(threeDuplicates + " appearing " + threeCount + " times.");
	    
	   
	    /*
	     * functions to cycle through each ArrayList
	    System.out.println("TYPE");
	    for(int obj:type)  
	        System.out.println(obj);  
	    
	    System.out.println("COUNT");
	    for(int index:count)  
	        System.out.println(index); 
	     */ 
	    
	    
	    //asks the user if the would like to use the thumbnail function of the program after initial output
		System.out.println();
		System.out.println("Would you like a thumbnail of the color that appears the most number of times?");
		System.out.println();
		  
		Scanner reader = new Scanner(System.in);
		System.out.print("Press 1 for yes and 0 for no: ");
		int yn = reader.nextInt(); 
		  
		 if(yn == 0)
		 {
			 reader.close();
		  	System.out.println("You may now exit the program.");
		 }
		 if(yn != 1)
		 {
			 System.out.println("You have offered incorrect input, please try again.");
			 System.out.println("Press 1 for yes and any other key for no: ");
			  
			 yn = reader.nextInt(); 
			 reader.close();
		 }
		  
		 if (yn != 1) System.out.println("You may now exit the program.");
		 if (yn == 1) findRBGThumbnail(oneGreatest);
		  
	}
  
  	
  	/**
  	 * Gets the pixels from the photo 
  	 * and puts them into an array.
  	 * @return pixels
  	 */
  	public ArrayList<Integer> findRBGPixelsList ()
  	{
  		Pixel[][] pixelsGot = this.getPixels2D();
  		
  		ArrayList<Integer> pixels = new ArrayList<Integer>(); 
  		
  		int red = -1;
  		int green = -1;
  		int blue = -1;
  		int pixelGot = -1;
  		String concat = "";
  		
  		String redString;
  		String blueString;
  		String greenString;
  		
  		int width = getWidth();
  		int height = getHeight();
  		
  		
  		for (int row = 0; row < height; row++)
  		{
  			for (int col = 0; col < width; col++)
  			{
   				red = pixelsGot[row][col].getRed();
   				blue = pixelsGot[row][col].getBlue();
   				green = pixelsGot[row][col].getGreen();
   				
   				//convert the color codes from integer to string
   				redString = Integer.toString(red);
   				blueString = Integer.toString(blue);
   				greenString = Integer.toString(green);
   				
   				//concatenate the red green and blue values together
   				//and then convert them back to int
   				concat = redString + blueString + greenString;
   				pixelGot = Integer.parseInt(concat);
   				
   				//set the new rbg pixel value to a new slot in the pixels arraylist
   				pixels.add(pixelGot);
  			}
   		      
  		}
  		
  		//at the end, this will return the pixels variable
  		return pixels;
  	}
  	
  	/**
  	 * Finds the seperate red green and blue codes to match
  	 * the greatest appearing rgb integer code. Then converts
  	 * the photo to a thumbnail of the color that appears
  	 * the most frequently in the photo.
  	 * Uses the convertToThumbnail method.
  	 * Used by the findTheMostMethod.
  	 * @param oneGreatest
  	 */
  	public void findRBGThumbnail (int oneGreatest)
  	{
  		Pixel[][] pixelsGot = this.getPixels2D(); 
  		
  		int red = -1;
  		int green = -1;
  		int blue = -1;
  		int pixelGot = -1;
  		String concat = "";
  		
  		String redString;
  		String blueString;
  		String greenString;
  		
  		int width = getWidth();
  		int height = getHeight();
  		
  		int redMatch = -1;
  		int blueMatch = -1;
  		int greenMatch = -1;
  		
  		
  		for (int row = 0; row < height; row++)
  		{
  			for (int col = 0; col < width; col++)
  			{
  				
   				red = pixelsGot[row][col].getRed();
   				blue = pixelsGot[row][col].getBlue();
   				green = pixelsGot[row][col].getGreen();
   				
   				//convert the color codes from integer to string
   				redString = Integer.toString(red);
   				blueString = Integer.toString(blue);
   				greenString = Integer.toString(green);
   				
   				//concatenate the red green and blue values together
   				//and then convert them back to int
   				concat = redString + blueString + greenString;
   				pixelGot = Integer.parseInt(concat);
   				
   				//compares the pixel that appears the most amount of times
   				//to the concatenated version of the pixel, looking for a 
   				//match from the original array
   				if(pixelGot == oneGreatest)
   				{
   					redMatch = red;
   					blueMatch = blue;
   					greenMatch = green;
   				}
 
  			}
   		      
  		}
  		
  		//at the end, this will CREATE THE THUMBNAIL
  		convertToThumbnail(redMatch, blueMatch, greenMatch);	
  	}
  
  	
    /**
     * Method to create thumbnail modeled after the zeroBlue method.
     * Used by the findRGBThumbnail method.
     * @param red, blue, green
     */
  	public void convertToThumbnail(int red, int blue, int green)
    {
  	  Pixel[][] pixels = this.getPixels2D();
  	    for (Pixel[] rowArray : pixels)
  	    {
  	      for (Pixel pixelObj : rowArray)
  	      {
  	        pixelObj.setRed(red);
  	        pixelObj.setBlue(blue);
  	        pixelObj.setGreen(green);
  	      }
  	    }
    }

  
  
  
} // this } is the end of class Picture, put all new methods before this
