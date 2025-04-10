import java.util.Scanner;
import java.io.*;

public class HWFractionsV1
{
    public static Scanner console = new Scanner(System.in);

    public static void main(String[] args)
    {
        while (true)
        {
            System.out.print("Filename: ");
            String fileName =  console.nextLine();

            if (fileName.equalsIgnoreCase("quit"))
            {
                System.out.println("All done!");
                break;
            }

            try (Scanner fileScanner = new Scanner(new File(fileName)))
            {
                String[] fractions = new String[1000];
                int[] counts = new int[1000];
                int index = 0;
                
                while (fileScanner.hasNextLine())
                {
                    String fraction = fileScanner.nextLine();
                    boolean isValid = false; 


                    for (int i = 0; i < index; i++)
                    {
                        if (areEquivalent(fractions[i], fraction))
                        {
                            counts[i]++;
                            isValid = true;
                            break;
                        }
                    }

                    if (!isValid)
                    {
                        fractions[index] = fraction;
                        counts[index] = 1;
                        index++;
                    }
                }

                for (int i = 0; i < index; i++)
                {
                    System.out.printf("%s has a count of %d\n", fractions[i], counts[i]);
                }
            }

            catch(FileNotFoundException e)
            {
                System.out.println("Error reading file " + e.getMessage());
            }
        }

        console.close();
    }

    // This method was heavily supported by ChatGPT, initializaiton and rearrangement was created by me, and the 
    //rest was with the help of ChatGPT.
    public static boolean areEquivalent(String fraction1, String fraction2)
    {
        String[] parts1 = fraction1.split("/");
        String[] parts2 = fraction2.split("/");

        int a = Integer.parseInt(parts1[0]);
        int b = Integer.parseInt(parts1[1]);
        int c = Integer.parseInt(parts2[0]);
        int d = Integer.parseInt(parts2[1]);

        return a * d == b * c;
    }
}