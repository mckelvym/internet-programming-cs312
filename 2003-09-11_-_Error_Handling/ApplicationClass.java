// Markus McKelvy
// Internet Programming 9:30TR
// September 15, 2003

//write java application that uses nested loops and displays a message that looks like:
// use different colors
public class ApplicationClass
{
   public static void main(String[] arg)
   {
     int i;
	   int j;
	for(i = 1; i <= 3; i++)
	{
   		System.out.println("Hello World! - Loop " + i);
    		for(j = 1; j <= i; j++)
    		{
			System.out.println("Hello");
    		}
    	}
    }
}
