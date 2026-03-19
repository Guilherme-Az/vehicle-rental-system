package agency;

public class Car extends Vehicle{
    private static double _price = 50;
    private static int _maxtime = 30;

    public Car(int id, String brand, String model, int year, boolean available){
        super(id, brand, model, year, available);
    }

    public double getPrice(){
        return _price;
    }

    public int getMaxTime(){
        return _maxtime;
    }
}