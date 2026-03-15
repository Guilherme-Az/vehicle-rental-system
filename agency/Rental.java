package agency;

public class Rental{
    private final int _id;
    private final Client _client;
    private final Vehicle _vehicle;
    private int _time;

    public Rental(int id, Vehicle vehicle, Client client, int time){
        _id = id;
        _vehicle = vehicle;
        _client = client;
        _time = time;
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

    public int calcPrice(){
        return _vehicle.getPrice() * _time;
    }

    @Override
    public String toString(){
        return "id: " + _id + "; client id: " + _client.getId() + "; vehicle id: " + _vehicle.getId() + "; days remaining: " + _time;
    }
}