/**
 * @author Axel Balam Mancera Miramontes
 */

package tarea4.ejercicio_1.ui;

import tarea4.utils.Cola;

import java.util.Optional;
import java.util.Scanner;

/**
 * CLI contains all the data tha is going to be processed by the Passengers class.
 * CLI defines the details of the user menu and executes it.
 */
public class CLI {
    /**
     * Data used by process package.
     */
    private static Cola<Integer> queue = new Cola<>();
    private static Scanner input = new Scanner(System.in);

    /**
     * Creating the user menu.
     */
    private static Menu menu = new Menu();

    /**
     *  Menu options.
     */
    private static String PUSH = "Agregar un nuevo elemento al final de la cola";
    private static String POP = "Eliminar el primer elemento de la cola";
    private static String PEEK = "Devolver el primer elemento de la cola";
    private static String SIZE = "Conocer el número de elementos almacenados en la cola";
    private static String IS_EMPTY = "Conocer si la cola está vacía";

    /**
     * Other usefull texts.
     */
    private static String QUEUE_PUSH = "Ingrese el valor del elemento a agregar al final de la cola:";
    private static String QUEUE_PEEK = "El valor del elemento almacenado el principio de la cola es: %s\n";
    private static String QUEUE_SIZE = "El número de elementos almacenados en la cola es: %d\n";
    private static String QUEUE_IS_EMPTY = "La cola está vacía.\n";
    private static String QUEUE_IS_NOT_EMPTY = "La cola no está vacía.\n";

    /**
     * Menu actions.
     */
    /**
     * Defines the action that adds the capitains into a list.
     */
    private static MenuActionPrototype queuePush = () -> {
        int newElmnt;

        System.out.println(QUEUE_PUSH);
        newElmnt = input.nextInt();

        queue.push(newElmnt);
    };

    private static MenuActionPrototype queuePop = () -> {
        queue.pop();
    };

    private static MenuActionPrototype queuePeek = () -> {
        System.out.printf(QUEUE_PEEK, queue.peek().get());
    };

    private static MenuActionPrototype queueSize = () -> {
        System.out.printf(QUEUE_SIZE, queue.size());
    };

    private static MenuActionPrototype queueIsEmpty = () -> {
        if(queue.isEmpty()){
            System.out.printf(QUEUE_IS_EMPTY);
        }
        else{
            System.out.printf(QUEUE_IS_NOT_EMPTY);
        }
    };

    /**
     * Adding the menu options and actions.
     */
    static {
        menu
                .addOption(PUSH, queuePush)
                .addOption(POP, queuePop)
                .addOption(PEEK, queuePeek)
                .addOption(SIZE, queueSize)
                .addOption(IS_EMPTY, queueIsEmpty)
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