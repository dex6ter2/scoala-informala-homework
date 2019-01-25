package tema4;

class Animal extends LocalStore {
    private float storageTemperature;

    void setStorageTemperature(float _storageTemperature){
        this.storageTemperature = _storageTemperature;
    }

    float getStorageTemperature(){
        return this.storageTemperature;
    }
}
