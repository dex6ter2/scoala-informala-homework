package tema4;

/**
 * parent for Vegetable and Animal class
 * holds attributes used for both classes.
 * attribute sellDate used only for reporting
 */

public class LocalStore {
    private int stock;
    private String id;
    private float weight;
    private String validityDate;
    private float price;
    private String sellDate;

    void setStock(int _stock){
        this.stock = _stock;
    }
    void setId(String _id){
        this.id = _id;
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
    void setSellDate(String sellDate){
        this.sellDate = sellDate;
    }

    int getStock(){
        return this.stock;
    }

    String getId(){
        return this.id;
    }

    float getWeight(){
        return this.weight;
    }

    String getValidityDate(){
        return this.validityDate;
    }

    float getPrice(){
        return this.price;
    }
    String getSellDate(){
        return this.sellDate;
    }
}
