package tema4;

public class LocalStore {
    private int stock;
    private String id;
    private float weight;
    private String validityDate;
    private float price;

    void setStock(int _stock){
        stock = _stock;
    }
    void setId(String _id){
        id = _id;
    }
    void setWeight(float weight){
        this.weight = weight;
    }

    void setValidityDate(String validityDate){
        this.validityDate = validityDate;
    }

    void setPrice(float price){
        this.price = price;
    }

    int getStock(){
        return stock;
    }

    String getId(){
        return id;
    }

    float getWeight(){
        return weight;
    }

    String getValidityDate(){
        return validityDate;
    }

    float getPrice(){
        return price;
    }
}
