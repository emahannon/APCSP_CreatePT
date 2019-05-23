import java.util.*;

/**
 * @author student
 * @version 17 March 2019
 */
public class PictureTester
{
  
  /**
   * Method for findTheMostProject at the bottom of the Picture class.
   */
  public static void testFindTheMost()
  {
	  Picture swan = new Picture("temple.jpg");
	  ArrayList<Integer> px = swan.findRBGPixelsList();
	  	swan.explore();
	  	swan.findTheMost(px);
	    swan.explore();
  }
  
  
  public static void main(String[] args)
  {
	  
	 testFindTheMost();	  
  }
}
