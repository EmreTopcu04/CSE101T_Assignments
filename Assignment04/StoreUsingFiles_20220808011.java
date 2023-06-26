
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
//@Author: Emre Topcu @Date 12/22/2022
public class StoreUsingFiles_20220808011 {
public static void main(String[]args) throws IOException {
    String base_Filename = args[0];
    FileWriter Error_logs = new FileWriter(base_Filename + "_log.txt");
    FileWriter receipt = new FileWriter(base_Filename + "_Receipt.txt");
    int number_of_products = countProducts(base_Filename + "_ProductInfo.txt");
    String[] item_id = new String[number_of_products];
    String[] item_name = new String[number_of_products];
    int[] quantity = new int[number_of_products];
    double[] price = new double[number_of_products];
    getProductInfo(item_id, item_name, quantity, price, base_Filename + "_ProductInfo.txt");
    File order = new File(base_Filename + "_Order.txt");
    String[] item_name_order = new String[0];
    String[] item_id_order = new String[0];
    int[] quantity_order = new int[0];
    Scanner input = new Scanner(order);
    int quantity_order_counter = 0;
    int item_id_order_counter = 0;
    int counter = 0;
    receipt.write("********** Customer Receipt *********\n");
    while (input.hasNext()) {
        if (counter == 0) {
            String temp = input.next();
            item_id_order = Arrays.copyOf(item_id_order, item_id_order.length + 1);
            item_id_order[item_id_order_counter] = temp;
            counter++;
            item_id_order_counter++;
        } else if (counter == 1) {
            int temp = input.nextInt();
            quantity_order = Arrays.copyOf(quantity_order, quantity_order.length + 1);
            quantity_order[quantity_order_counter] = temp;
            counter = 0;
            quantity_order_counter++;
        }

    }
    String[] bool = new String[item_id_order.length];
    boolean temp = true;
    for (int i = 0; i < item_id_order.length; i++) {
        for (int j = 0; j < item_id.length; j++) {
            if (item_id_order[i].equals(item_id[j])) {
            temp = true;
            break;
            }else {
                temp = false;
            }

        }
    bool[i] = String.valueOf(temp);
    }
    double returnVal = 0;
    int[]true_order = new int[0];
    int clock = 0;
    int clock_2 = 0;
    for (int i = 0; i < item_id_order.length; i++) {
       if (Objects.equals(bool[i], "true")){
           String val = item_id_order[i];
           int vall = 0;
           for (int j = 0; j < item_name.length; j++){
               if (val.equals(item_id[j])) {
               vall = j;
               item_name_order = Arrays.copyOf(item_name_order,item_name_order.length+1);
               item_name_order[clock_2] = item_name[j];
               clock_2++;
               }
           }



           if (quantity_order[i] < 0){
            Error_logs.write("ERROR: Invalid amount requested ("+quantity_order[i]+")\n");
        }else if (quantity_order[i] > quantity[vall]){
            Error_logs.write("ERROR: "+item_name_order[clock_2-1]+" - "+quantity_order[i]+" requested but only "+ quantity[vall]+" remaining.\n");
        }else{
             true_order = Arrays.copyOf(true_order,true_order.length);
               quantity[vall] -= quantity_order[i];
               receipt.write(item_name_order[clock_2-1]+" ("+item_id[vall]+")"+" - "+ quantity_order[i]+" * "+ price[vall]+" = " +(price[vall]*quantity_order[i])+"\n");
               returnVal += price[vall]*quantity_order[i];
           }

       }else{
           Error_logs.write("ERROR: Product "+ item_id_order[i]+ " not found.\n");
       }
    }
    writeProductInfo(item_id,item_name,quantity,price,base_Filename+"_ProductInfoAfterOrder.txt");
    receipt.write("------------------------------------\n");
    receipt.write("Total due - "+returnVal);
    receipt.close();
    Error_logs.close();
}
   public static int countProducts(String file_name) throws FileNotFoundException {
       int counter = 0;
       File f = new File(file_name);
       Scanner input = new Scanner(f);
       while (input.hasNextLine()){
           input.nextLine();
           counter++;
       }
   return counter;
   }
   public static void getProductInfo(String[] item_id,String[] item_name, int[] quantity,double[] price,String filename) throws FileNotFoundException {
   File file = new File(filename);
   Scanner input = new Scanner(file);
       int item_id_counter = 0;
       int item_name_counter = 0;
       int item_quantity_counter = 0;
       int item_price_counter = 0;

   int counter = 0;
   while (input.hasNext()){
   if (counter == 0){
      String item = input.next();
      item_id[item_id_counter] = item;
      item_id_counter++;
      counter++;
   }else if(counter == 1){
       String item = input.next();
       item_name[item_name_counter] = item;
       item_name_counter++;
       counter++;
   }else if (counter == 2){
       int item = input.nextInt();
       quantity[item_quantity_counter] = item;
       item_quantity_counter++;
       counter++;
   }else if (counter == 3){
       double item = input.nextDouble();
       price[item_price_counter] = item;
       item_price_counter++;
       counter = 0;
   }

      }
   }
public static void writeProductInfo(String[] itemID, String[] itemName, int[] quantity, double[] price,String filename) throws IOException {
    FileWriter File = new FileWriter(filename);
    for (int i = 0; i < itemName.length; i++){
        File.write(itemID[i]+" "+itemName[i]+" "+quantity[i]+" "+price[i]+"\n" );
    }
File.close();
   }
}
