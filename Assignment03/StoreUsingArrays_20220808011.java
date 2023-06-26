import java.util.Scanner;
//@Author: Emre Topcu @Date: 12/01/2022
public class StoreUsingArrays_20220808011 {
    public static void main(String[] args) {

        String[] test = {"bread", "cola", "sniCKers", "AYRAN"};
        double[] number = {.75, 2.5, 2.25, 1};
        int[] quantity = {10, 15, 12, 30};
        storeRun(test, quantity, number);

    }

    //1. Method
    public static int menu(String[] item, double[] price, Scanner input) {
        int i = 0;
        capitalizeArray(item);
        while (i < item.length) {
            System.out.println(i + 1 + " - for " + item[i] + " (" + price[i] + ")");
            i++;
        }
        System.out.println("0 - to checkout");

        System.out.println("Please enter what you would like: ");
        return input.nextInt();
    }

    //2. Method
    public static String returnedAmounts(double amount) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        int g = 0;
        int h = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        String text = "";
        while (amount >= 0.0099999) {
            if (amount >= 199.9999999) {
                a++;
                amount -= 200;
            } else if (amount >= 99.999999) {
                b++;
                amount -= 100;
            } else if (amount >= 49.9999999) {
                c++;
                amount -= 50;
            } else if (amount >= 19.9999999) {
                d++;
                amount -= 20;
            } else if (amount >= 9.99999) {
                e++;
                amount -= 10;
            } else if (amount >= 4.99999) {
                f++;
                amount -= 5;
            } else if (amount >= 0.99999) {
                g++;
                amount -= 1;
            } else if (amount >= 0.499999) {
                h++;
                amount -= 0.5;
            } else if (amount >= 0.2499999) {
                i++;
                amount -= 0.25;
            } else if (amount >= 0.099999999) {
                j++;
                amount -= 0.10;
            } else if (amount > 0.049999999) {
                k++;
                amount -= 0.05;
            } else {
                l++;
                amount -= 0.01;

            }

        }
        if (a > 0)
            text = (a + " - " + "200\n");
        if (b > 0)
            text += (b + " - " + "100\n");
        if (c > 0)
            text += (c + " - " + "50\n");
        if (d > 0)
            text += (d + " - " + "20\n");
        if (e > 0)
            text += (e + " - " + "10\n");
        if (f > 0)
            text += (f + " - " + "5\n");
        if (g > 0)
            text += (g + " - " + "1\n");
        if (h > 0)
            text += (h + " - " + "0.50\n");
        if (i > 0)
            text += (i + " - " + "0.25\n");
        if (j > 0)
            text += (j + " - " + "0.10\n");
        if (k > 0)
            text += (k + " - " + "0.05\n");
        if (l > 0) {
            text += (l + " - " + "0.01\n");
        }
        return text;
    }

    //3. Method
    public static void storeRun(String[] item, int[] quantity, double[] price) {

        double a; int b; int c; int i = 0; int[] array = new int[item.length]; double counter = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to our store. We have the following. ");
        b = menu(item,price,input);
        while (b != 0){
            if (b < 0) {
                System.out.println("Invalid Choice");
            }else if (b > item.length){
                System.out.println("Invalid Choice");
            }else{
                System.out.println("How many "+capitalizeString(item[b-1])+" would you like? ");
                c = input.nextInt();
                if (c < 0){
                    System.out.println("Invalid Choice");
                }else if (c > quantity[b-1]){
                    System.out.println("Invalid Choice");
                }else{
                    quantity[b-1] -= c;
                    array[b-1] += c;
                }
            }
        b = menu(item,price,input);
        }

        System.out.println("****** Customer Total *****");
        while (i < array.length){
            if(array[i] == 0){
                //I intentionally left here empty body because I want to see nothing if the costumer didn't pick that item.
            }else {
                System.out.println(capitalizeString(item[i]) + " - " + array[i] + " * " + price[i] + " = " + price[i] * array[i]);
                counter += price[i] * array[i];

            }
            i++;
        }
          System.out.println("------------------------------");
          System.out.println("Total due - "+counter);
          System.out.println("Please enter amount given");
          a = input.nextDouble();
          while (a < counter){
              System.out.println("Not enough payment given");
              System.out.println("Please enter amount given");
              a = input.nextDouble();
          }
          System.out.println("Thank you for your business. Your change given is:");
          System.out.println(returnedAmounts(a-counter));
    }



   //4. Method
   public static String capitalizeString(String text){
   text = text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
   return text;
}  //5. Method
   public static void capitalizeArray(String[] user_input){
      int a = 0;
      while (a < user_input.length){
        user_input[a] = capitalizeString(user_input[a]);
         a++;
      }

   }


}
