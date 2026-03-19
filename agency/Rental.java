package agency;

public class Rental{
    private final int _id;
    private final Client _client;
    private final Vehicle _vehicle;
    private int _time;
    private double _price;

    public Rental(int id, Vehicle vehicle, Client client, int time, double price){
        _id = id;
        _vehicle = vehicle;
        _client = client;
        _time = time;
        _price = price;
    }

    public int getId(){
        return _id;
    }

    public Vehicle getVehicle(){
        return _vehicle;
    }

    public Client getClient(){
        return _client;
    }

    public int getTime(){
        return _time;
    }

    public void setTime(int time){
        _time = time;
    }

    public double getPrice(){
        return _price;
    }

    public void setPrice(double price){
        _price = price;
    }

    @Override
    public String toString(){
        return "id: " + _id + "; client id: " + _client.getId() + "; vehicle id: " + _vehicle.getId() + "; days remaining: " + _time;
    }
}