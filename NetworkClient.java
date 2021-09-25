import java.io.*;    //Import io wildcard
import java.net.*;   //Import Socket
import java.util.Scanner; 
class NetworkClient
{
   public static void main(String[] args) throws IOException
   {
      int PortNumber = 9959;      
      DataInputStream input;      
      DataOutputStream output;  
      Socket MyClient = new Socket("127.0.0.1", PortNumber);      
      Scanner scanner = new Scanner(System.in);  
      
      System.out.println("connected client!");      
      
      output = new DataOutputStream(MyClient.getOutputStream());      
      input = new DataInputStream(MyClient.getInputStream());      
      
      //scan operator form user
      System.out.println("Please enter operator");      
      String operatorString = scanner.nextLine();      
      char operator = operatorString.charAt(0);
      
      //output operator to server
      output.writeChar(operator);
      
      //get input for numbers from server
      int num1 = input.readInt(); 
      int num2 = input.readInt(); 
      
      //do calculations
      int result = calculate(num1,num2,operator);
      
      //Print Result of calculation
      System.out.println("Result is " + result);
      
   }
   
   public static int calculate(int num1, int num2, char sign)
   {
      int result = 0;
      
      switch (sign) {
            case '+':   //addition
                     result = num1 + num2;
                     break;
            case '-':   //subtract
                     result = num1 - num2;
                     break;
            case '/':   //divide
                     result = num1 / num2;
                     break;
            case '*':   //multiply
                     result = num1 * num2;
                     break;
            }//end of switch statement
      return result;
   }
}