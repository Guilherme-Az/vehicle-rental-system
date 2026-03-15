package agency;

public class Bike extends Vehicle{
    private static int _price = 30;
    private static int _maxtime = 15;

    public Bike(int id, String brand, String model, int year, boolean available){
        super(id, brand, model, year, available);
    }

    public int getPrice(){
        return _price;
    }

    public int getMaxTime(){
        return _maxtime;
    }
}
