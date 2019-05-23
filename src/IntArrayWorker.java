

public class IntArrayWorker
{
  /** two dimensional matrix */
  private int[][] matrix = null;
  
  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
  }
  
  /**
   * Method to return the total 
   * @return the total of the values in the array
   */
  public int getTotal()
  {
    int total = 0;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        total = total + matrix[row][col];
      }
    }
    return total;
  }
  
  /**
   * Method to return the total using a nested for-each loop
   * @return the total of the values in the array
   */
  public int getTotalNested()
  {
    int total = 0;
    for (int[] rowArray : matrix) //loops through outer array of rows
    {
      for (int item : rowArray) //loops through the inner array of columns in each row
      {
        total = total + item;
      }
    }
    return total;
  }
  
  /**
   * @param tester integer that the method will look for
   * @return the count number of times a passed integer value
   * is found in the matrix
   */
  public int getCount(int tester)
  {
	  int count = 0;
	  for (int row = 0; row < matrix.length; row++)
	  {
	    for (int col = 0; col < matrix[0].length; col++)
	    {
	    		if(tester == matrix[row][col])
	    			count++;
	     }
	   }
	  return count;
  }
  
  /**
   * @return the largest value in the matrix
   */
  public int getLargest()
  {
	  int largest = 0;
	  for (int row = 0; row < matrix.length; row++)
	  {
	    for (int col = 0; col < matrix[0].length; col++)
	    {
	    		if(largest < matrix[row][col])
	    			largest = matrix[row][col];
	     }
	   }
	  return largest;
	  
  }
  
  /**
   * @param integer that refers to the column to be totaled
   * @return the total of all integers in a specified column
   */
  public int getColTotal(int specCol)
  {
	  int total = 0;
	  for (int row = 0; row < matrix.length; row++)
	  {
	    for (int col = 0; col < matrix[0].length; col++)
	    {
	    		if(specCol == col)
	    			total = total +matrix[row][col];
	     }
	   }
	  return total;
  }
  
  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }
  
  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        System.out.print( matrix[row][col] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }
  
  
  /** 
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; 
           col++)
      {
        if (row < col)
          matrix[row][col] = 1;
        else if (row == col)
          matrix[row][col] = 2;
        else
          matrix[row][col] = 3;
      }
    }
  }
 
}