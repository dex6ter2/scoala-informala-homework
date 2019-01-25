package tema4;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * the menu of an online store. the user may create new products by providing the information required,
 * may be able to sell by decreasing the stock with an amount provided by user,
 * generates a list with the report for the sold items in a given date
 * has a report with current stock items
 */
public class Main {

    private static List<LocalStore> listOfSoldItems = new ArrayList<LocalStore>();
    private static List<Animal> listOfAnimalProducts = new ArrayList<Animal>();
    private static List<Vegetable> listOfVegetablesProducts = new ArrayList<Vegetable>();

    public static void main(String[] args) {
        mainProducts();
        listingMenu();
    }

    /**
     * main menu based on the input from user it is redirected to different section of the menu
     * if value is not ok will be requested to input the value again.
     */
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
                createNewProductMenu();
                break;
            case "2" :
                System.out.println("The poducts available for selling and the current stock");
                displayTheProducts();
                System.out.println("Please select the product you desire to sell");
                addStock();
                break;
            case "3" :
                System.out.println("Please provide the date for the sell report using the format YYYY-MM-DD");
                returnProductsOfSellList(createVariableString("dateSell"));
                break;
            case "4" :
                break;
                default:{
                    System.out.println("Invalid Selection");
                    listingMenu();
                }
        }
    }

    /**
     * modifies the stock of an object from class Animal of Vegetable. request the value of the stock from user and
     * compares with current stock. If current stock is bigger or equal the stock will be decreased with the amount
     * entered from user, else notify that the amount requested is too big.
     */
    private static void addStock(){
        int selection;
        selection = Integer.parseInt(createVariableString("intPositive"));
        if (selection <= listOfAnimalProducts.size()+listOfVegetablesProducts.size()){
            System.out.println("Please provide the quantity desired to sell");
            int stock = Integer.parseInt(createVariableString("intPositive"));
            if (selection <= listOfAnimalProducts.size()){
                if (stock <= listOfAnimalProducts.get(selection-1).getStock()){
                    addToSellList(listOfAnimalProducts.get(selection-1).getId(),listOfAnimalProducts.get(selection-1).getStock());
                    listOfAnimalProducts.get(selection-1).setStock(listOfAnimalProducts.get(selection-1).getStock()-stock);
                }else{
                    System.out.println("The quantity provided is not available, the current stock for the "
                            + listOfAnimalProducts.get(selection-1).getId()+ " is " + listOfAnimalProducts.get(selection-1).getStock() );
                }
                System.out.println(listOfAnimalProducts.get(selection-1).getId());
                System.out.println(listOfAnimalProducts.get(selection-1).getStock());
            }else {
                selection = selection - listOfAnimalProducts.size();
                if (stock <= listOfVegetablesProducts.get(selection-1).getStock()){
                    addToSellList(listOfVegetablesProducts.get(selection-1).getId(),listOfVegetablesProducts.get(selection-1).getStock());
                    listOfVegetablesProducts.get(selection-1).setStock(listOfVegetablesProducts.get(selection-1).getStock()-stock);
                }else{
                    System.out.println("The quantity provided is not available, the current stock for the "
                            + listOfVegetablesProducts.get(selection-1).getId()+ " is " +listOfVegetablesProducts.get(selection-1).getStock() );
                }
            }
        }else{
            System.out.println("The selection provided was not valid!");
        }
    }

    /**
     * prints out the products from the list listOfSoldItems that have the sellDate attribute as the param
     * @param date holds a LocalDate value
     */
    private static void returnProductsOfSellList(String date){
        int i = 1;
        for(LocalStore obj : listOfSoldItems) {
            if (obj.getSellDate().equals(date)){
                System.out.println( i + ". " + obj.getId() + obj.getStock());
                i++;
            }
        }
        if (i == 1){
            System.out.println("No products were sold in that period");
        }
    }

    /**
     * created and object of class LocalStore with attributes id, stock and sellDate and adds it to the list listOfSoldItems
     * @param id
     * @param stock
     */
    private static void addToSellList(String id, int stock){
        LocalStore sellProduct = new LocalStore();
        sellProduct.setId(id);
        sellProduct.setSellDate(LocalDate.now().toString());
        sellProduct.setStock(stock);
        listOfSoldItems.add(sellProduct);
    }

    /**
     * generates the milk and egg objects with atributes and adds them to the list listOfAnimalProducts
     */
    private static void mainProducts(){
        Animal milk = new Animal();
        milk.setId("milk");
        milk.setStock(300);
        milk.setWeight(300);
        milk.setValidityDate("2019-02-25");
        milk.setPrice(20);
        milk.setStorageTemperature(10);
        Animal egg = new Animal();
        egg.setId("milk");
        egg.setStock(300);
        egg.setWeight(300);
        egg.setValidityDate("2019-02-25");
        egg.setPrice(15);
        egg.setStorageTemperature(15);
        listOfAnimalProducts.add(milk);
        listOfAnimalProducts.add(egg);

    }

    /**
     * diplays all the products from the listOfAnimalProducts and listOfVegetablesProducts
     */
    private static void displayTheProducts(){
        int i = 1;
        for (LocalStore x : listOfAnimalProducts){
            System.out.println(i + ". " + x.getId() + " stock: " + x.getStock());
            i++;
        }
        for (LocalStore x : listOfVegetablesProducts){
            System.out.println(i + ". " + x.getId()+ " stock: " + x.getStock());
            i++;
        }

    }

    /**
     * Menu for the creation of new product
     */
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

    /**
     * verify if the value hold by the string is a valid date
     * @param date value to be checked
     * @return true if value of string holds a valid date if it does not will return false
     */
    private static boolean checkDate(String date){
        try {
            LocalDate.parse(date);
            return true;
        }
        catch (DateTimeException e){
            return false;
        }
    }

    /**
     * creates and object of class Animal or Vegetable and add it to the list of each class based on the value received
     * in param. 1 is for Animal the rest for Vegetable
     * also sets all the attributes for the specific object with the information requested from user
     * @param selection 1 for Animal rest for Vegetable
     */

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

    /**
     * create a string with the input received from user and checks if the string value may be converted into a certain type based on the param
     * for int will check if int
     * for float will check if float
     * for intPositive will check if integer positive
     * date will check if date is valid and bigger then today
     * dateSell will check if valid and is not bigger then today
     * anything else will just return the String
     * if the input received from user does not meet the checks requested by the param a new value will be requested
     * @param a may have any value but for int, float, intPositive, date, dateSell will do checks
     * @return a string value that meets the requirements in the param
     */
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
                case "dateSell" : {
                    if (checkDate(collection)){
                        if (LocalDate.parse(collection).isAfter(LocalDate.now())){
                            System.out.println("There might be a mistake we do not predict the future, please try again");
                        }else{
                            i = false;
                            break;
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
                Integer.parseInt(a);
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
