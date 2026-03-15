package agency;

public class Client{
    private final int _id;
    private final String _name;
    private String _email;
    private int _delay;
    private boolean _hasRental;

    public Client(int id, String name, String email, int delay, boolean hasRental){
        _id = id;
        _name = name;
        _email = email;
        _delay = delay;
        _hasRental = hasRental;
    }

    public int getId(){
        return _id;
    }

    public String getName(){
        return _name;
    }

    public String getEmail(){
        return _email;
    }

    public void setEmail(String email){
        _email = email;
    }

    public int getDelay(){
        return _delay;
    }

    public void setDelay(int delay){
        _delay = delay;
    }

    public boolean getHasRental(){
        return _hasRental;
    }

    public void setHasRental(boolean hasRental){
        _hasRental = hasRental;
    }

    @Override
    public String toString(){
        return "id: " + _id + "; name: " + _name + "; email: " + _email + "; delay time: " + _delay + "; has rental? " + _hasRental;
    }
}