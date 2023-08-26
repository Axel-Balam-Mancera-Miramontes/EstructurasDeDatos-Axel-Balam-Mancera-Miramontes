/**
 * @author Axel Balam Mancera Miramontes
 */

package tarea2.ejercicio_1.ui;

import tarea2.ejercicio_1.process.Passenger;
import tarea2.utils.cList;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * CLI contains all the data tha is going to be processed by the Passengers class.
 * CLI defines the details of the user menu and executes it.
 */
public class CLI {
    /**
     * Data used by process package.
     */
    private static cList<Passenger> passengers = new cList<>();

    /**
     * Creating the user menu.
     */
    private static Menu menu = new Menu();

    /**
     *  Menu options.
     */
    private static String ADD_PASSENGER = "Agregar pasajero (al final de la lista).";
    private static String REMOVE_PASSANGER_AT = "Eliminar pasajero (especificado por el usuario).";
    private static String GET_PASSENGER_DATA = "Visualizar los datos de un pasajero determinado.";

    /**
     * Other usefull texts.
     */
    private static String INPUT_PASSENGER_DATA = "Ingrese la información del pasajero a agregar;";
    private static String INPUT_PASSENGER_TO_REMOVE_DATA = "Ingrese la información del pasajero a eliminar;";
    private static String INPUT_PASSENGER_NAME = "Ingrese el nombre del pasajero:";
    private static String IF_TICKET_ALREADY_BOUGHT = "¿El pasajero ya compró su ticket?\na) Sí.\nb) No.";
    private static String INPUT_TICKET_NUMBER = "Ingrese el número del ticket del pasajero:";
    private static String INPUT_PASSENGER_INDEX = "Ingrese el índice del pasajero:";
    private static String NUMERIC_TYPE_ERROR = "El valor ingresado no posee un formato numérico. Intente de nuevo: ";

    /**
     * Menu actions.
     */
    /**
     * Defines the action that adds a passenger at the end of the list.
     */
    private static MenuActionPrototype add_passenger = () -> {
        String passengerName = new String();
        char boughtTicket = ' ';
        int ticketNumber;
        Scanner input = new Scanner(System.in);

        System.out.println(INPUT_PASSENGER_DATA);

        System.out.println(INPUT_PASSENGER_NAME);
        passengerName = input.next();

        while(boughtTicket != 'a' && boughtTicket != 'b'){
            System.out.println(IF_TICKET_ALREADY_BOUGHT);
            boughtTicket = input.next().charAt(0);
        }
        if(boughtTicket == 'a'){
            System.out.println(INPUT_TICKET_NUMBER);
            while (true) {
                try {
                    ticketNumber = input.nextInt();
                    input.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    input.nextLine();
                    System.out.print(NUMERIC_TYPE_ERROR);
                }
            }
            passengers.add(new Passenger(passengerName, ticketNumber));
        }
        else if(boughtTicket == 'b'){
            passengers.add(new Passenger(passengerName));
        }
    };

    /**
     * Defines the action that removes a passenger given their name.
     */
    private static MenuActionPrototype remove_passenger_by_ticket = () -> {
        try {
            String passengerName = new String();
            char boughtTicket = ' ';
            int ticketNumber;
            Scanner input = new Scanner(System.in);
            Passenger p = null;

            System.out.println(INPUT_PASSENGER_TO_REMOVE_DATA);

            System.out.println(INPUT_PASSENGER_NAME);
            passengerName = input.next();

            while (boughtTicket != 'a' && boughtTicket != 'b') {
                System.out.println(IF_TICKET_ALREADY_BOUGHT);
                boughtTicket = input.next().charAt(0);
            }
            if (boughtTicket == 'a') {
                System.out.println(INPUT_TICKET_NUMBER);
                while (true) {
                    try {
                        ticketNumber = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        input.nextLine();
                        System.out.print(NUMERIC_TYPE_ERROR);
                    }
                }
                p = new Passenger(passengerName, ticketNumber);
            } else if (boughtTicket == 'b') {
                p = new Passenger(passengerName);
            }

            passengers.remove(p);
        }
        catch (NoSuchElementException e){
            System.out.println("Ha ocurrido el siguiente problema al ejecutar la operación: " + e);
        }
    };

    /**
     * Defines the action that plays the game in hard level.
     */
    private static MenuActionPrototype get_passenger_at = () -> {
        try {
            int index;
            Scanner input = new Scanner(System.in);

            System.out.println(INPUT_PASSENGER_INDEX);
            while (true) {
                try {
                    index = input.nextInt();
                    input.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    input.nextLine();
                    System.out.print(NUMERIC_TYPE_ERROR);
                }
            }

            System.out.println(passengers.get(index));
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Ha ocurrido el siguiente problema al ejecutar la operación: " + e);
        }
    };

    /**
     * Adding the menu options and actions.
     */
    static {
        menu
                .addOption(ADD_PASSENGER, add_passenger)
                .addOption(REMOVE_PASSANGER_AT, remove_passenger_by_ticket)
                .addOption(GET_PASSENGER_DATA, get_passenger_at)
                .addExitOption();
    }

    /**
     * Showing the menu and executing the actions associated to each option.
     */
    public static void launchApp() {
        do {
            menu.showMenu();
            menu.requestOption();
            int option = menu.readOption();
            menu.executeOption(option);
        } while (menu.isAlive());
    }
}