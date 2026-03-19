package agency;

public class Truck extends Vehicle{
    private static double _price = 100;
    private static int _maxtime = 7;

    public Truck(int id, String brand, String model, int year, boolean available){
        super(id, brand, model, year, available);
    }

    public double getPrice(){
        return _price;
    }

    public int getMaxTime(){
        return _maxtime;
    }
}