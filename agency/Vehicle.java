package agency;

public abstract class Vehicle{
    private final int _id;
    private final String _brand;
    private final String _model;
    private final int _year;
    private boolean _available;

    public Vehicle(int id, String brand, String model, int year, boolean available){
        _id = id;
        _brand = brand;
        _model = model;
        _year = year;
        _available = available;
    }

    public int getId(){
        return _id;
    }

    public String getBrand(){
        return _brand;
    }

    public String getModel(){
        return _model;
    }

    public int getYear(){
        return _year;
    }

    public boolean getAvailable(){
        return _available;
    }

    public void setAvailable(boolean available){
        _available = available;
    }

    public abstract double getPrice();
    public abstract int getMaxTime();

    @Override
    public String toString(){
        return "id: " + _id + "; brand: " + _brand + "; model: " + _model + "; year: " + _year + "; available: " + _available;
    }
}