package tema4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Animal> listOfAnimalProducts = new ArrayList<Animal>();
    public static void main(String[] args) {
        listingMenu();
    }

    private static void listingMenu(){
        String userSelection;
        System.out.println("1. Create product and add it to stock");
        System.out.println("2. Sell product");
        System.out.println("3. Display daily sales report");
        System.out.println("4. Exist");
        userSelection = createVariableString("int");
        switch (userSelection){
            case "1" :
                System.out.println("1. Create product and add it to stock");
                createNewProduct();//TODO addToSTock
                break;
            case "2" :
                System.out.println("2. Sell product");//TODO sell function
                break;
            case "3" :
                System.out.println("3. Display daily sales report");//TODO report
                break;
            case "4" :
                break;
                default:{
                    System.out.println("Invalid Selection");
                    listingMenu();
                }
        }
    }

    private static void createNewProduct(){
        System.out.println("Product type (1 - animal; 2 - vegetable; 3 - return to previous menu; 4 - exit)");
        switch (createVariableString("int")){
            case "1" :
                System.out.println("animal");
                Animal animal1 = new Animal();
                System.out.println("Please provide the name of the animal product");
                animal1.setId(createVariableString("A"));
                System.out.println("Please provide the storage temperature in Celsius");
                animal1.setStorageTemperature(Float.parseFloat(createVariableString("float")));
                System.out.println("Please provide the quantity of the animal product");
                animal1.setStock(Integer.parseInt(createVariableString("int")));
                listOfAnimalProducts.add(animal1);
                for (Animal x : listOfAnimalProducts){
                    System.out.println(x.getStock());
                    System.out.println(x.getId());
                    System.out.println(x.getStorageTemperature());
                }
                createNewProduct();//TODO add the weight validityDate and price also create method to validate the date
                break;
            case "2" :
                System.out.println("vegetable");//TODO vegetable class
                break;
            case "3" :
                listingMenu();
                break;
            case "4" : break;
            default: {
                System.out.println("Invalid Selection");
                createNewProduct();
            }
        }
    }


    private static String createVariableString(String a) {
        String collection = "0";
        boolean i = true;
        Scanner readNumber = new Scanner(System.in);
        while (i) {
            collection = readNumber.nextLine();
            switch (a){
                case "int" :{
                    if (checkIfNumber(collection,"int")) {
                        i = false;
                    } else {
                        System.out.println("Invalid selection provided, please try again");
                    }
                }
                case "float" :{
                    if (checkIfNumber(collection,"float")) {
                        i = false;
                    } else {
                        System.out.println("Invalid selection provided, please try again");
                    }
                }
                default: i = false;
            }

        }

        return collection;
    }

    /**
     * returns true if the string received holds an float value, otherwise returns false
     * @param a the string to be evaluated
     * @return true or false
     */
    /**
     *
     * @param a
     * @param type
     * @return
     */
    private static boolean checkIfNumber(String a, String type){
        if (type == "int"){
            try{
                Float.parseFloat(a);
                return true;
            }
            catch (NumberFormatException ex){
                return false;
            }
        }else {
            try{
                Float.parseFloat(a);
                return true;
            }
            catch (NumberFormatException ex){
                return false;
            }
        }

    }
}
