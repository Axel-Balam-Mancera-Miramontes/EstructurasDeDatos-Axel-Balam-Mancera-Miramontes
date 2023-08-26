/**
 * @author Axel Balam Mancera Miramontes
 */

package tarea2.ejercicio_2.ui;

import tarea2.ejercicio_2.process.SoccerPlayer;
import tarea2.utils.cList;

import java.util.*;

/**
 * CLI contains all the data tha is going to be processed by the Passengers class.
 * CLI defines the details of the user menu and executes it.
 */
public class CLI {
    /**
     * Data used by process package.
     */
    private static cList<SoccerPlayer> soccerCapitains = new cList<>();
    private static cList<SoccerPlayer> soccerPlayers = new cList<>();
    private static LinkedList<cList<SoccerPlayer>> soccerTeams = new LinkedList<>();

    /**
     * Creating the user menu.
     */
    private static Menu menu = new Menu();

    /**
     *  Menu options.
     */
    private static String ADD_CAPITAINS = "Agregar capitanes.";
    private static String ADD_PLAYERS = "Agregar jugadores.";
    private static String MAKE_TEAMS = "Hacer equipos.";
    private static String SHOW_TEAMS = "Mostrar equipos.";

    /**
     * Other usefull texts.
     */
    private static String CAPITAIN_INFO = "Ingrese la información de los capitanes:";
    private static String ADD_CAPITAIN = "¿Qué desea hacer?\na) Agregar un nuevo capitan.\nb) Terminar de agregar capitanes:";
    private static String INPUT_CAPITAIN_DATA = "Ingrese la información del capitán a agregar:";
    private static String INPUT_CAPITAIN_NAME = "Ingrese el nombre del capitan:";
    private static String INPUT_CAPITAIN_SHIRT_NUMBER = "Ingrese el número de la camisa del capitan:";
    private static String PLAYER_INFO = "Ingrese la información de los jugadores:";
    private static String ADD_PLAYER = "¿Qué desea hacer?\na) Agregar un nuevo jugador.\nb) Terminar de agregar jugadores:";
    private static String INPUT_PLAYER_DATA = "Ingrese la información del jugador a agregar:";
    private static String INPUT_PLAYER_NAME = "Ingrese el nombre del jugador:";
    private static String INPUT_PLAYER_SHIRT_NUMBER = "Ingrese el número de la camisa del jugador:";
    private static String INPUT_TEAM = "Haga al equipo %d:\n";
    private static String INPUT_CAPITAIN_TEAM = "Indique el índice del capitan del equipo %d:\n";
    private static String INPUT_PLAYER_TEAM = "Indique el índice del jugador del equipo %d:\n";
    private static String SOCCER_PLAYER_ERROR = "El jugador ingresado ya está en otro equipo. Intente de nuevo.";
    private static String NUMERIC_TYPE_ERROR = "El valor ingresado no posee un formato numérico. Intente de nuevo: ";

    /**
     * Menu actions.
     */
    /**
     * Defines the action that adds the capitains into a list.
     */
    private static MenuActionPrototype add_capitains = () -> {
        while(true) {
            char option = ' ';
            String capitainName = " ";
            int capitainShirtNumber = -1;
            Scanner input = new Scanner(System.in);

            System.out.println(CAPITAIN_INFO);
            while (option != 'a' && option != 'b') {
                System.out.println(ADD_CAPITAIN);
                option = input.next().charAt(0);
            }

            if (option == 'a') {
                System.out.println(INPUT_CAPITAIN_DATA);
                System.out.println(INPUT_CAPITAIN_NAME);
                capitainName = input.next();

                System.out.println(INPUT_CAPITAIN_SHIRT_NUMBER);
                while (true) {
                    try {
                        capitainShirtNumber = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        input.nextLine();
                        System.out.print(NUMERIC_TYPE_ERROR);
                    }
                }

                soccerCapitains.add(new SoccerPlayer(capitainName, capitainShirtNumber, true));
            } else {
                break;
            }
        }
    };

    /**
     * Defines the action that adds the players into a list.
     */
    private static MenuActionPrototype add_players = () -> {
        while(true) {
            char option = ' ';
            String playerName = " ";
            int playerShirtNumber = -1;
            Scanner input = new Scanner(System.in);

            System.out.println(PLAYER_INFO);
            while (option != 'a' && option != 'b') {
                System.out.println(ADD_PLAYER);
                option = input.next().charAt(0);
            }

            if (option == 'a') {
                System.out.println(INPUT_PLAYER_DATA);
                System.out.println(INPUT_PLAYER_NAME);
                playerName = input.next();
                System.out.println(INPUT_PLAYER_SHIRT_NUMBER);
                playerShirtNumber = input.nextInt();

                soccerPlayers.add(new SoccerPlayer(playerName, playerShirtNumber, false));
            } else {
                break;
            }
        }
    };

    /**
     * Defines the action that makes the teams.
     */
    private static MenuActionPrototype make_teams = () -> {
        int index;
        char option = ' ';
        Scanner input = new Scanner(System.in);

        for(int i = 0; i < soccerCapitains.size(); ++i){
            System.out.printf(INPUT_TEAM, i);
            soccerTeams.add(new cList<>());

            //Adding capitain.
            while(true) {
                try {
                    System.out.printf(INPUT_CAPITAIN_TEAM, i);
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

                    SoccerPlayer soccerCapitain = soccerCapitains.get(index).get();
                    if (!soccerCapitain.getHasTeam()) {
                        soccerCapitain.setHasTeam(true);

                        soccerTeams.get(i).add(soccerCapitain);
                        break;
                    } else {
                        System.out.println(SOCCER_PLAYER_ERROR);
                    }

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Ha ocurrido el siguiente problema al ejecutar la operación: " + e);
                }
            }

            //Adding players.
            while(true){
                while (option != 'a' && option != 'b') {
                    System.out.println(ADD_PLAYER);
                    option = input.next().charAt(0);
                }
                if (option == 'a') {
                    try {
                        System.out.printf(INPUT_PLAYER_TEAM, i);
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

                        SoccerPlayer soccerPlayer = soccerPlayers.get(index).get();
                        if (!soccerPlayer.getHasTeam()) {
                            soccerPlayer.setHasTeam(true);
                            soccerTeams.get(i).add(soccerPlayer);
                            option = ' ';
                        } else {
                            System.out.println(SOCCER_PLAYER_ERROR);
                        }
                    }
                    catch (IndexOutOfBoundsException e){
                        System.out.println("Ha ocurrido el siguiente problema al ejecutar la operación: " + e);
                    }
                } else {
                    break;
                }
            }
        }
    };

    private static MenuActionPrototype showTeams = () -> {
        for (int i = 0; i < soccerTeams.size(); ++i) {
            System.out.println("Equipo " + i);
            for (int j = 0; j < soccerTeams.get(i).size(); j++) {
                Optional<SoccerPlayer> sc = soccerTeams.get(i).get(j);
                System.out.println(sc);
            }
        }
    };

        /**
         * Adding the menu options and actions.
         */
    static {
        menu
                .addOption(ADD_CAPITAINS, add_capitains)
                .addOption(ADD_PLAYERS, add_players)
                .addOption(MAKE_TEAMS, make_teams)
                .addOption(SHOW_TEAMS, showTeams)
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