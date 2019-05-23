explore - will create a copy of the picture

vvvvvvv this will all be done in the picture and picture tester classes vvvvvvv

getPixels2D (in the SimplePicture class) - will create a 2D array of Pixels for a simple picture -- returned in a pixel object -- how to convert this to RGB codes??
		you will be able to get the color codes in int format by using the getRed() getGreen() and getBLue methods from the Pixel class
		OR by using the getColor, which returns a Color object containing the red, green, blue values within the constructor
			you *might* be able to get the whole RBG code in int form by using the getRGB() method in the Color class, 
			but you will have to test to see what format the output is in
	|		
	|	
	|
	V
Create a method to use the pixel array object as the result from getPixels2D to put the RGB codes in their own array
	will we combine the red green blue codes into one int number and put them in a 2D array (you *may* be able to take
	these values and put them straight into the arraylist.
	OR we may be able to use the getRBG() from using color objects but this will require a lot of testing to get the straight RBG code in int format
	
	
	IF we put the RBG values into an array list, you will have to figure out how to make a 2D arraylist OR modify the existing algorithm to search for 
	the greatest values
	
	
	
	
	
Mar 1

Now that I've added the method findRGBPixelsList and added all the tester methods to the Picture class, the method will create an array list
of all the RGB values concatenated into one integer type. This list is then used as a parameter for the findTheMost array (both of these methods
being called in the PictureTester class). This is posing a challenge, because the parameter initially called for a 2D int list. so, I had to go back
and reoptimize the part I to handle an ArrayList instead. This algorithm works fine, but I'm hitting a wall, because adding the array list seems to
have caused the index finder to return the number it is looking for instead of the index for absolutely no reason clear to me. This is the biggest
challenge faced by converting the methods from the findTheMostTester class to the Picture class so far. However, once it is fixed I beileve the program
will run smoothly.

Another thing that may become an issue in the future is the sheer amount of data handled in the form of the pixels array that may slow down the 
performance of the program and cause these issues to be difficult to debug.

For now, I am going to try using a regular for loop instead of the original for-each loop used in the indexFinder method.


--> using a for loop and changing around the variables to return the index worked for the swan.jpg picture and ran without error, but
I got an indexoutofbounds error when testing other pictures. I still think this error is related to the indexFinder method 
BUT if push comes to shove swan.jpg will allpw the program to run without error.

!! The problem described at line 43 will only occur if you feed the program a photo with only white pixels. I am assuming this will
extend to a photo with all black pixels and possibly all one color pixel, but I have yet to test. All photos, however, will create 
output with no errors.!!

8 March 2019
In order to make the codes more readable, i attempted to add zeroes before the codes to create 3 digit codes for each red, green, and blue.
However, this results in an index out of bounds when sorting and the front zeroes get deleted when converting back to integer types.
One way to fix this is by comparing the codes as string types instead of integers. Another solution might be to add the zeroes in the back
of the codes instead of the front.
I am going to try the second solution first.
//
Adding the zeroes at the end fixed the length issue, but did not fix the array out of bounds error.
I will now try combining the second solution with the first possible solution suggested.

17 March 2019
I was able to find a workaround to the error I was having. I took a step back and looked at the entire problem, 
taking note of what my end goal was: to create a thumbnail or photo with the color that appears the most in it.
By coming at the problem from a new angle, I was able to use the code I got at the end to cycle back through
the original rgb codes to find a match. From there, I was able to get the original values for red, green, and blue,
using those values to set the pixels of the photo to the color appearing the most. The setting method was derived
from the zeroBlue method that I worked on during the Picture Lab assignment.



	
	