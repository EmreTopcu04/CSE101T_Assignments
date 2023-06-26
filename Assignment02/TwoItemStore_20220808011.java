import java.util.Scanner;
public class TwoItemStore_20220808011 {
    public static void main(String[] args) {
        //@Emre Topcu @10/26/2022
        Scanner input = new Scanner(System.in);
        int total_request_of_1 = 0;
        int total_request_of_2 = 0;
        System.out.println("****** Store Inventory ******");
        System.out.print("Enter the name of product 1: ");
        String name_of_product_1 = input.nextLine();
        System.out.print("Enter the number of " + name_of_product_1.substring(0, 1).toUpperCase()
                + name_of_product_1.substring(1).toLowerCase() + " we have: ");
        int number_of_product_1_we_have = input.nextInt();
        if (number_of_product_1_we_have < 0) {
            System.out.println("ERROR: Value can not be negative. Exiting.");
        } else {
            System.out.print("Enter the cost of " + name_of_product_1.substring(0, 1).toUpperCase() +
                    name_of_product_1.substring(1).toLowerCase() + ": ");
            float price_of_product_1 = input.nextFloat();

            if (price_of_product_1 < 0) {
                System.out.println("ERROR: Value can not be negative. Exiting.");
            } else {
                System.out.print("Enter the name of product 2: ");
                input.nextLine();
                String name_of_product_2 = input.nextLine();
                System.out.print("Enter the number of " + name_of_product_2.substring(0, 1).toUpperCase()
                        + name_of_product_2.substring(1).toLowerCase() + " we have: ");
                int number_of_product_2_we_have = input.nextInt();
                if (number_of_product_2_we_have < 0) {
                    System.out.println("ERROR: Value can not be negative. Exiting.");
                } else {
                    System.out.print("Enter the cost of " + name_of_product_2.substring(0, 1).toUpperCase() +
                            name_of_product_2.substring(1).toLowerCase() + ": ");
                    float price_of_product_2 = input.nextFloat();
                    if (price_of_product_2 < 0) {
                        System.out.println("ERROR: Value can not be negative. Exiting.");
                    } else {
                        System.out.println("****** Customer User Interface ******");
                        System.out.println("Welcome to our store. We have the following. Please enter what you would like :");
                        System.out.println("1 - " + name_of_product_1.substring(0, 1).toUpperCase() +
                                name_of_product_1.substring(1).toLowerCase());
                        System.out.println("2 - " + name_of_product_2.substring(0, 1).toUpperCase() +
                                name_of_product_2.substring(1).toLowerCase());
                        System.out.println("0 - to checkout");
                        int user_request = input.nextInt();
                        while (user_request != 0) {
                            if (user_request == 1) {
                                System.out.print("How many " + name_of_product_1.substring(0, 1).toUpperCase() +
                                        name_of_product_1.substring(1).toLowerCase() + " you would like? ");
                                int user_request_of_product_1 = input.nextInt();
                                if (user_request_of_product_1 <= 0) {
                                    System.out.println("ERROR: Invalid request amount");
                                } else if (user_request_of_product_1 > number_of_product_1_we_have) {
                                    System.out.println("ERROR: We do not have that many remaining.");
                                } else {
                                     number_of_product_1_we_have = number_of_product_1_we_have - user_request_of_product_1;
                                    total_request_of_1 = user_request_of_product_1 + total_request_of_1;
                                }
                                 } else if (user_request == 2) {
                                System.out.print("How many " + name_of_product_2.substring(0, 1).toUpperCase() +
                                        name_of_product_2.substring(1).toLowerCase() + " you would like? ");
                                int user_request_of_product_2 = input.nextInt();
                                if (user_request_of_product_2 <= 0) {
                                    System.out.println("ERROR: Invalid request amount");
                                } else if (user_request_of_product_2 > number_of_product_2_we_have) {
                                    System.out.println("ERROR: We do not have that many remaining.");
                                } else {
                                    number_of_product_2_we_have = number_of_product_2_we_have - user_request_of_product_2;
                                    total_request_of_2 = user_request_of_product_2 + total_request_of_2;
                                }
                            } else {
                                System.out.println("ERROR: Invalid menu option.");
                            }
                            System.out.println("****** Customer User Interface ******");
                            System.out.println("Welcome to our store. We have the following. Please enter what you would like :");
                            System.out.println("1 - " + name_of_product_1.substring(0, 1).toUpperCase() +
                                    name_of_product_1.substring(1).toLowerCase());
                            System.out.println("2 - " + name_of_product_2.substring(0, 1).toUpperCase() +
                                    name_of_product_2.substring(1).toLowerCase());
                            System.out.println("0 - to checkout");
                            user_request = input.nextInt();
                        }

                        System.out.println("****** Customer Total ******");
                        System.out.println(name_of_product_1.substring(0, 1).toUpperCase() +
                                name_of_product_1.substring(1).toLowerCase() + " - " + total_request_of_1 + " X " + price_of_product_1 + " = "+ total_request_of_1*price_of_product_1);
                        System.out.println(name_of_product_2.substring(0, 1).toUpperCase() +
                                name_of_product_2.substring(1).toLowerCase() + " - " + total_request_of_2 + " X " + price_of_product_2 + " = "+ total_request_of_2*price_of_product_2);
                        System.out.println("----------------------------");
                        System.out.println("Total due - "+ ((total_request_of_2*price_of_product_2) + (total_request_of_1*price_of_product_1)));
                        System.out.println();
                        System.out.println("****** Final Report ******");
                        System.out.println("We now have the remaining amounts of our products: ");
                        System.out.println(name_of_product_1.substring(0, 1).toUpperCase() +
                                name_of_product_1.substring(1).toLowerCase() + " - " + number_of_product_1_we_have) ;
                        System.out.println(name_of_product_2.substring(0, 1).toUpperCase() +
                                        name_of_product_2.substring(1).toLowerCase() + " - " +number_of_product_2_we_have);
                    }
                }
            }
        }
    }
}

