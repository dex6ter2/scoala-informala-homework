package tema4;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Animal> listOfAnimalProducts = new ArrayList<Animal>();
    static List<Vegetable> listOfVegetablesProducts = new ArrayList<Vegetable>();//TODO create a list that includes this and the other as a reference
    public static void main(String[] args) {
        mainProducts();
        listingMenu();
    }

    private static void listingMenu(){
        String userSelection;
        System.out.println("1. Create product and add it to stock");
        System.out.println("2. Sell product");
        System.out.println("3. Display daily sales report");
        System.out.println("4. Exist");
        System.out.println("Please type the number for your desired selection");
        userSelection = createVariableString("int");
        switch (userSelection){
            case "1" :
                System.out.println("1. Create product and add it to stock");
                createNewProductMenu();//TODO addToSTock
                break;
            case "2" :
                System.out.println("2. Sell product");
                displayTheProducts();
                addStock();//TODO sell function
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
    public static void addStock(){ //TODO ask the client to place the quantity, verify if the quantity is ok and remove from stock
        int selection;
        selection = Integer.parseInt(createVariableString("intPositive"));
        if (selection <= listOfAnimalProducts.size()+listOfVegetablesProducts.size()){
            if (selection <= listOfAnimalProducts.size()){
                System.out.println(listOfAnimalProducts.get(selection-1).getId());
                System.out.println(listOfAnimalProducts.get(selection-1).getStock());
            }else {
                System.out.println("vegies");
            }
        }else{
            System.out.println("The selection provided was not valid!");
        }

    }
    private static void mainProducts(){
        Animal milk = new Animal();
        milk.setId("milk");
        milk.setStock(300);
        milk.setWeight(300);
        listOfAnimalProducts.add(milk);
    }

    private static void displayTheProducts(){
        int i = 1;
        for (LocalStore x : listOfAnimalProducts){
            System.out.println(i+". " + x.getId() + " stock: " + x.getStock());
            i++;
        }
        for (LocalStore x : listOfVegetablesProducts){
            System.out.println(i+". " + x.getId()+ " stock: " + x.getStock());
            i++;
        }

    }

    private static void createNewProductMenu(){
        System.out.println("Product type (1 - animal; 2 - vegetable; 3 - return to previous menu; 4 - exit)");
        switch (createVariableString("int")){
            case "1" :
                createNewProduct("1");
                createNewProductMenu();
                break;
            case "2" :
                createNewProduct("2");
                createNewProductMenu();
                break;
            case "3" :
                listingMenu();
                break;
            case "4" : break;
            default: {
                System.out.println("Invalid Selection");
                createNewProductMenu();
            }
        }
    }

    private static boolean checkDate(String a){
        try {
            LocalDate.parse(a);
            return true;
        }
        catch (DateTimeException e){
            return false;
        }
    }

    private static void createNewProduct(String selection){

        if (selection == "1"){
            Animal animalx = new Animal();
            System.out.println("Please provide the name of the animal product");
            animalx.setId(createVariableString("A"));
            System.out.println("Please provide the storage temperature in Celsius");
            animalx.setStorageTemperature(Float.parseFloat(createVariableString("float")));
            System.out.println("Please provide the quantity for the product");
            animalx.setStock(Integer.parseInt(createVariableString("intPositive")));
            System.out.println("Please provide the weight of the product");
            animalx.setWeight(Float.parseFloat(createVariableString("float")));
            System.out.println("Please provide the price per product");
            animalx.setPrice(Float.parseFloat(createVariableString("float")));
            System.out.println("Please provide the expiry date using the format YYYY-MM-DD");
            animalx.setValidityDate(createVariableString("date"));
            listOfAnimalProducts.add(animalx);

        }else{
            Vegetable animalx = new Vegetable();
            System.out.println("Please provide the name of the vegetable product");
            animalx.setId(createVariableString("A"));
            System.out.println("Please provide the list of vitamins for the product");
            animalx.setListOfVitamin(createVariableString("a"));
            System.out.println("Please provide the quantity for the product");
            animalx.setStock(Integer.parseInt(createVariableString("intPositive")));
            System.out.println("Please provide the weight of the product");
            animalx.setWeight(Float.parseFloat(createVariableString("float")));
            System.out.println("Please provide the price per product");
            animalx.setPrice(Float.parseFloat(createVariableString("float")));
            System.out.println("Please provide the expiry date using the format YYYY-MM-DD");
            animalx.setValidityDate(createVariableString("date"));
            listOfVegetablesProducts.add(animalx);
            for (Vegetable x : listOfVegetablesProducts){
                System.out.println(x.getId() + x.getListOfVitamin());
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
                        System.out.println("Invalid natural number provided, please try again");
                    }
                    break;
                }
                case "float" :{
                    if (checkIfNumber(collection,"float")) {
                        i = false;
                    } else {
                        System.out.println("Invalid real number provided, please try again");
                    }break;
                }
                case "intPositive" : {
                    if (checkIfNumber(collection,"int")) {
                        if (Integer.parseInt(collection) >= 0 ){
                            i = false;
                        } else {
                            System.out.println("Invalid natural positive number, please try again");
                        }

                    } else {
                        System.out.println("Invalid natural number provided, please try again");
                    }
                    break;
                }
                case "date" : {
                    if (checkDate(collection)){
                        if (LocalDate.parse(collection).isAfter(LocalDate.now())){
                            i = false;
                            break;
                        }else{
                            System.out.println("There might be a mistake we do not sell expired products, please try again");
                        }break;
                    }else {
                        System.out.println("Invalid date format, please try again and use as format YYYY-MM-DD(example: 2025-09-26)");
                    }
                    break;
                }
                default: i = false;
            }

        }

        return collection;
    }

    /**
     *returns the true or false value by comparing if the value hold by the string may be of the specified type (int or float)
     * @param a string holding a value to be compared
     * @param type the type of value that the value of the string has to meet may be "int" or "float"
     * @return true if String a value may be converted to the specified type
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
