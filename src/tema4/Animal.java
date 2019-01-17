package tema4;

class Animal extends LocalStore {
    private float storageTemperature;

    void setStorageTemperature(float _storageTemperature){
        storageTemperature = _storageTemperature;
    }

    float getStorageTemperature(){
        return storageTemperature;
    }
}
