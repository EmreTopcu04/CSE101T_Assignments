import java.util.Scanner;

public class BreadStore_20220808011 {
    public static void main(String[] args) {
        //@Author Emre Topcu @Date 16.10.2022
        //In here I want the tester to put a number of breads so that my code can work.
        //Due to the location we are at right now, please use "," other than "." It would crash.
        Scanner input = new Scanner(System.in);
        System.out.println("****** Bread Store Inventory ******");
        System.out.print("Enter the number of breads we have: ");
        int NumberOfBread = input.nextInt();
        //If it is lower than 0, There should be an error and exit the program.
        if (NumberOfBread < 0) {
            System.out.println("**** ERROR: Number can't be a negative value. ****   Exiting...");
            //Else, the code continues.
        } else {
            System.out.print("Enter the cost of bread: ");
            double CostOfBread = input.nextDouble();
            //If it is lower than 0, There should be an error and exit the program.
            if (CostOfBread < 0) {
                System.out.println("**** ERROR: Number can't be a negative value. ****   Exiting...");
                //Else, the code continues.
            } else {
                System.out.println("****** Customer User Interface ******");
                System.out.print("Welcome to our bread store. We have " + NumberOfBread + " loaves of bread available. How many would you like? ");

                int NumberOfBreadCustomerWants = input.nextInt();
                //If it is equal to 0, There should be an error and exit the program.
                if (NumberOfBreadCustomerWants == 0) {
                    System.out.println("**** ERROR: Number can't be 0 ****   Exiting...");
                    System.out.println(" We now have " + NumberOfBread + " loaves of bread available.");
                    //If it is higher than the bread we have at this moment. There should be an error and exit the program.
                } else if (NumberOfBreadCustomerWants > NumberOfBread) {
                    System.out.println("**** ERROR: Number can't be higher than the number of bread we have at this moment. ****   Exiting...");
                    System.out.println(" We now have " + NumberOfBread + " loaves of bread available.");
                    //If it is lower than 0, There should be an error and exit the program.
                } else if (NumberOfBreadCustomerWants < 0) {
                    System.out.println("**** ERROR: Value can't be negative ****   Exiting...");
                    System.out.println(" We now have " + NumberOfBread + " loaves of bread available.");
                    //Else, the code continues.
                }else{
                        double Cost = NumberOfBreadCustomerWants * CostOfBread;
                        System.out.println("Your cost is " + Cost);
                        System.out.println("Thank you for shopping with us today.");
                        System.out.println("We now have " + (NumberOfBread - NumberOfBreadCustomerWants) + " loaves of bread remaining.");
                    }
                }
            }
        }
    }
