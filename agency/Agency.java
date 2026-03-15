package agency;

import java.util.List;
import java.util.ArrayList;

public class Agency{
    private int _day = 1;
    private int _vehicleId = 0;
    private int _clientId = 0;
    private int _rentalId = 0;
    private List<Vehicle> _vehicles = new ArrayList<>();
    private List<Client> _clients = new ArrayList<>();
    private List<Rental> _rentals = new ArrayList<>();
    private List<Rental> _completedRentals = new ArrayList<>();

    public Agency(int day, List<Vehicle> vehicles, List<Client> clients, List<Rental> rentals, List<Rental> completedRentals){
        _day = day;
        _vehicles = vehicles;
        _clients = clients;
        _rentals = rentals;
        _completedRentals = completedRentals;
    }

    public void addCar(String brand, String model, int year, boolean available){
        Vehicle car = new Car(++_vehicleId, brand, model, year, available);
        _vehicles.add(car);
    }

    public void addBike(String brand, String model, int year, boolean available){
        Vehicle bike = new Bike(++_vehicleId, brand, model, year, available);
        _vehicles.add(bike);
    }

    public void addTruck(String brand, String model, int year, boolean available){
        Vehicle truck = new Truck(++_vehicleId, brand, model, year, available);
        _vehicles.add(truck);
    }

    public void removeVehicle(int id){
        Vehicle v = getVehicleById(id);

        if (v == null){
            System.out.println("\nVeículo inválido");
            return;
        }
        if (!v.getAvailable()){
            System.out.println("\nNão é possível remover um veículo alugado!");
            return;
        }
        _vehicles.remove(v);
    }

    public void listVehicles(){
        if (_vehicles.isEmpty()){
            System.out.println("\nNão há veículos registados!");
            return;
        }
        for (Vehicle v: _vehicles){
            System.out.println(v);
        }
    }

    public void addClient(String name, String email){
        Client client = new Client(++_clientId, name, email, 0, false);
        _clients.add(client);
    }

    public void removeClient(int id){
        Client c = getClientById(id);
        if(c == null){
            System.out.println("\nCliente inválido");
            return;
        }
        _clients.remove(c);
    }

    public void listClients(){
        if (_clients.isEmpty()){
            System.out.println("\nNão há clientes registados!");
            return;
        }
        for (Client c: _clients){
            System.out.println(c);
        }
    }


    public void addRental(Vehicle vehicle, Client client, int time){
        if (client.getDelay() > 0){
            System.out.println("\nO cliente tem a entrega de um veículo em atraso!");
            return;
        }
        if (client.getHasRental()){
            System.out.println("\nO cliente já tem um veículo alugado!");
            return;
        }
        if (!vehicle.getAvailable()){
            System.out.println("\nO veículo não está disponível");
            return;
        }
        if(time > vehicle.getMaxTime()){
            System.out.println("\nTempo maior do que o tempo máximo permitido");
            return;
        }
        Rental rental = new Rental(++_rentalId, vehicle, client, time);
        vehicle.setAvailable(false);
        client.setHasRental(true);
        _rentals.add(rental);
    }

    public void listRentals(){
        if (_rentals.isEmpty()){
            System.out.println("\nNão há alugueres registados!");
            return;
        }
        for (Rental r: _rentals){
            System.out.println(r);
        }
    }

    public void listCompletedRentals(){
        for (Rental r: _completedRentals){
            System.out.println(r);
        }
    }

    public void advanceDate(int days){
        _day += days;
        for (Rental r: _rentals){
            r.setTime(r.getTime() - days);
            if (r.getTime() < 0){
                r.getClient().setDelay(r.getClient().getDelay() - r.getTime());
            }
        }
    }

    public int deliverVehicle(Rental rental){ // returns the price
        rental.getVehicle().setAvailable(true);
        rental.getClient().setHasRental(false);
        int price = rental.calcPrice() + 5 * rental.getClient().getDelay();
        rental.getClient().setDelay(0);
        _rentals.remove(rental);
        _completedRentals.add(rental);
        return price;
    }

    public void showAvailableVehicles(){
        for (Vehicle v: _vehicles){
            if (v.getAvailable()) System.out.println(v);
        }
    }

    public Vehicle getVehicleById(int id){
        for (Vehicle v: _vehicles){
            if(v.getId() == id) return v;
        }
        return null;
    }

    public Client getClientById(int id){
        for (Client c: _clients){
            if(c.getId() == id) return c;
        }
        return null;
    }

    public Rental getRentalById(int id){
        for (Rental r: _rentals){
            if(r.getId() == id) return r;
        }
        return null;
    }

    public int showDate(){
        return _day;
    }

}