package agency;


import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Agency agency = new Agency(1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        int option;
        int option2;
        int id;

        do{
            System.out.println("\n --- Menu ---");
            System.out.println("1. Adicionar");
            System.out.println("2. Remover");
            System.out.println("3. Listar");
            System.out.println("4. Entregar Veículo");
            System.out.println("5. Avançar dias");
            System.out.println("6. Mostrar data");
            System.out.println("7. Mostrar preços");
            System.out.println("8. Mostrar tempo máximo de aluguer");
            System.out.println("0. Sair");

            option = sc.nextInt();
            sc.nextLine(); 

            switch(option){
                case 1:
                    System.out.println("\n--- Adicionar ---");
                    System.out.println("1. Veículo");
                    System.out.println("2. Cliente");
                    System.out.println("3. Aluguer");
                    System.out.println("0. Nenhum");

                    option2 = sc.nextInt();
                    sc.nextLine();

                    switch(option2){
                        case 1:
                            System.out.println("Tipo(Carro, Mota, Camião): ");
                            String type = sc.nextLine();
                            System.out.println("Marca: ");
                            String brand = sc.nextLine();
                            System.out.println("Modelo: ");
                            String model = sc.nextLine();
                            System.out.println("Ano: ");
                            int year = sc.nextInt();
                            sc.nextLine();
                            if(type.equalsIgnoreCase("Carro")) agency.addCar(brand, model, year, true);
                            else if(type.equalsIgnoreCase("Mota")) agency.addBike(brand, model, year, true);
                            else if(type.equalsIgnoreCase("Camião")) agency.addTruck(brand, model, year, true);
                            else{
                                System.out.println("\nTipo de veículo inválido");
                            }
                            break;
                        
                        case 2:
                            System.out.println("Nome: ");
                            String name = sc.nextLine();
                            System.out.println("Email: ");
                            String email = sc.nextLine();
                            agency.addClient(name, email);
                            break;

                        case 3:
                            System.out.println("Id do veículo: ");
                            int vehicleId = sc.nextInt();
                            Vehicle v = agency.getVehicleById(vehicleId);
                            System.out.println("Id do Cliente: ");
                            int clientId = sc.nextInt();
                            Client c = agency.getClientById(clientId);
                            if(v == null){
                                System.out.println("\nVeículo inválido");
                                break;
                            }
                            else if(c == null){
                                System.out.println("\nCliente inválido");
                                break;
                            }
                            System.out.println("Tempo de Aluguer: ");
                            int time = sc.nextInt();
                            sc.nextLine();
                            agency.addRental(v, c, time);
                            break;

                        case 0:
                            break;
                    }
                    break;
                
                case 2:
                    System.out.println("\n--- Remover ---");
                    System.out.println("1. Veículo");
                    System.out.println("2. Cliente");
                    System.out.println("0. Nenhum");

                    option2 = sc.nextInt();
                    sc.nextLine();

                    switch(option2){
                        case 1:
                            System.out.println("Id do veículo: ");
                            id = sc.nextInt();
                            sc.nextLine();
                            agency.removeVehicle(id);
                            break;
                        
                        case 2:
                            System.out.println("Id do Cliente: ");
                            id = sc.nextInt();
                            sc.nextLine();
                            agency.removeClient(id);
                            break;
                        
                        case 0:
                            break;
                    
                    }
                    break;

                case 3:
                    System.out.println("\n--- Listar ---");
                    System.out.println("1. Todos os veículos");
                    System.out.println("2. Apenas veículos disponíveis");
                    System.out.println("3. Todos os clientes");
                    System.out.println("4. Alugueres ativos");
                    System.out.println("5. Alugueres terminados");
                    System.out.println("0. Nenhum");

                    option2 = sc.nextInt();
                    sc.nextLine();

                    switch(option2){
                        case 1:
                            agency.listVehicles();
                            break;
                        
                        case 2:
                            agency.showAvailableVehicles();
                            break;

                        case 3:
                            agency.listClients();
                            break;

                        case 4:
                            agency.listRentals();
                            break;
                        
                        case 5:
                            agency.listCompletedRentals();
                            break;
                        case 0:
                            break;
                    }
                    break;
                
                case 4:
                    System.out.println("Id do aluguer: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    Rental r = agency.getRentalById(id);
                    if(r == null){
                        System.out.println("\nAluguer inválido");
                        break;
                    }
                    System.out.println("\nPreço final: " + agency.deliverVehicle(r));
                    break;

                case 5:
                    System.out.println("Número de dias para avançar: ");
                    int days = sc.nextInt();
                    sc.nextLine();
                    agency.advanceDate(days);
                    break;

                case 6:
                    System.out.println("\n" + agency.showDate());
                    break;
                
                case 7:
                    System.out.println("\nCarro: 50€ por dia");
                    System.out.println("Mota: 30€ por dia");
                    System.out.println("Camião: 100€ por dia");
                    System.out.println("Por cada dia em atraso, o preço aumenta 20%");
                    break;

                case 8:
                    System.out.println("\nCarro: 30 dias");
                    System.out.println("Mota: 15 dias");
                    System.out.println("Camião: 7 dias");
                    break; 
            }

        } while (option != 0);

        sc.close();
    }
}