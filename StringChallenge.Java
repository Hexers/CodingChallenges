import java.util.*; 
import java.io.*;

class Main {

  public static String StringChallenge(String[] strArr) 
  {
    // code goes here  
    int num = Integer.parseInt(strArr[0]);
    StringBuilder string1 = new StringBuilder();
    while ((num != 1 ) && (num !=0)) 
    {    
        int remainder = num%2;
        num = num/2;
        string1.append(""+remainder);
    }
    string1.append(num);
    string1 = string1.reverse();
    int count = 0;
    String string2 = string1.toString() ;
    for (int i  =0; i < string2.length(); i++)
    {
      if (string2.charAt(i) != strArr[1].charAt(i))
      {
         count++;
      }
    }
    return ""+count;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine())); 
  }

}
