import com.sun.deploy.util.ArrayUtil;

import java.util.*;

class Pizza {
    // Main method to run and test the solution with input
    public static void main(String[] args) {
        // Create an instance of the Pizza class
        Pizza pizza = new Pizza();
//        String[] topping = {"Cheese", "Mushrooms"}; // Pass the type of Toppings we need
//        float price = pizza.getPizzaPrice("Small", topping, "Thin Crust"); // get the total price
//        System.out.println("Total Price " + price); // Print the price
//        String s= 21+"abc"+ 49 +14;
//        String s1= 21+ 49+"abc"+ 14+56;
//        System.out.println(s1) ;
        int[] nums = {1,1,2,  3, 4, 5};
        int[] nums2 = {6, 7, 8, 9, 10};
        System.out.println(pizza.firstUniqChar(nums));

    }

    //Concatenate two array
    public int[] addArray(int[] arr1, int[] arr2) {
        int array1Size = arr1.length;
        int array2Size = arr2.length;
        int[] result = new int[array2Size + array1Size];

        for (int i = 0; i < result.length; i++) {
            if (i < array1Size) {
                result[i] = arr1[i];
            } else {
                result[i] = arr2[i - array1Size];
            }
        }


        return result;
    }

    public int firstUniqChar(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0; i<num.length; i ++) {
            map.put(num[i],map.getOrDefault(num[i], 0) + 1);
        }

        for (int i =0; i<num.length; i ++) {
            if (map.get(num[i]) == 1) {
                return num[i];
            }


        }
        return -1;
    }



    //Method to calculate total Pizza Price with provided Pizza size, toppings and base type
    public float getPizzaPrice(String size, String[] topping, String base) {
        //Put the Base size and their related price to pizza size map
        Map<String, Double> pizzaSizes = new HashMap<>();
        pizzaSizes.put("Small", 0.75);
        pizzaSizes.put("Medium", 1.0);

        //Put the Base type and their related price to pizza size map
        Map<String, Double> pizzaBases = new HashMap<>();
        pizzaBases.put("Thin Crust", 8.0);

        //Return the Pizza Price
        return (float) ((pizzaBases.get(base) + getToppingPrice(topping)) * pizzaSizes.get(size));
    }


    //This method is to get total toppings price where we provide our all toppings to get price calculated
    public float getToppingPrice(String[] toppings) {
        //Put Toppings and price to the topping map;
        Map<String, Double> pizzaToppings = new HashMap<>();
        pizzaToppings.put("Cheese", 2.0);
        pizzaToppings.put("Mushrooms", 2.0);

        //initialise the topping price
        double toppingPrice = 0;


        //if we have only one topping then, we get the price of that topping without iterating the for loop
        if (toppings.length > 1) {
            for (int i = 0; i < pizzaToppings.size(); i++) {
                toppingPrice += pizzaToppings.get(toppings[i]);
            }
        } else {
            toppingPrice = pizzaToppings.get(toppings[0]);
        }


        return (float) toppingPrice;
    }

}

class PizzaWithEnum {

    enum SizeMultiplier {
        SMALL(0.75),
        MEDIUM(1.0);

        public final double sizeMultiplier; // The value associated with each plan


        SizeMultiplier(double sizeMultiplier) {
            this.sizeMultiplier = sizeMultiplier;
        }

    }

    enum Crust {
        THIN_CRUST(8.0),
        REGULAR(10),
        CHEESY_CRUST(12);;

        public final double price; // The value associated with each plan


        Crust(double price) {
            this.price = price;
        }

    }

//    public float getPizzaPrice(String size, String[] topping, String base) {
//
//        //Return the Pizza Price
//        return (float) ((SizeMultiplier. + getToppingPrice(topping)) * pizzaSizes.get(size));
//    }


    //This method is to get total toppings price where we provide our all toppings to get price calculated
    public float getToppingPriceUsingEnum(String[] toppings) {
        //Put Toppings and price to the topping map;
        Map<String, Double> pizzaToppings = new HashMap<>();
        pizzaToppings.put("Cheese", 2.0);
        pizzaToppings.put("Mushrooms", 2.0);

        //initialise the topping price
        double toppingPrice = 0;


        //if we have only one topping then, we get the price of that topping without iterating the for loop
        if (toppings.length > 1) {
            for (int i = 0; i < pizzaToppings.size(); i++) {
                toppingPrice += pizzaToppings.get(toppings[i]);
            }
        } else {
            toppingPrice = pizzaToppings.get(toppings[0]);
        }


        return (float) toppingPrice;
    }

    // Main method to run and test the solution with input
    public static void main(String[] args) {
        // Create an instance of the Pizza class
        Pizza pizza = new Pizza();
        String[] topping = {"Cheese", "Mushrooms"}; // Pass the type of Toppings we need
        float price = pizza.getPizzaPrice("Small", topping, "Thin Crust"); // get the total price
        System.out.println("Total Price " + price); // Print the price


    }


}



//        int waitTime = 0;
//        int finishTime = 0;
//        int numOfCustomers = customers.length;
//
//        for (int[] customer : customers) {
//            finishTime = Math.max(customer[0], finishTime) + customer[1];
//            waitTime += finishTime - customer[0];
//        }
//
//        return (double) waitTime / numOfCustomers;

//
//    public enum Price {
//        SMALL(0.75);
//
//
//        private double price;
//
//        Price(double price) {
//            this.price = price;
//        }
//
//        public  double getPrice() {
//            return price;
//        }









