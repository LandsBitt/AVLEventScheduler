package org.example;
import java.util.Scanner;


        public class Main {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                Btree b = new Btree();


                int numEntradas = Integer.parseInt(scanner.nextLine());

                String[] comandos = new String[numEntradas];

                for (int i = 0; i < numEntradas; i++) {
                    comandos[i] = scanner.nextLine();
                }

                for (String comando : comandos) {
                    String[] partes = comando.split(" ");

                    if (partes[0].equals("ADD")) {
                        int event_id = Integer.parseInt(partes[1]);
                        int start_time = Integer.parseInt(partes[2]);
                        int end_time = Integer.parseInt(partes[3]);
                        String description = partes[4];



                        Evento e = new Evento( event_id ,start_time,end_time,description);
                        b.addEvent(e);

                    } else if (partes[0].equals("QUERY_TIME")) {
                        int start_time = Integer.parseInt(partes[1]);
                        b.findEventsAtTime(start_time);

                    } else if (partes[0].equals("QUERY_RANGE")) {
                    int start_time = Integer.parseInt(partes[1]);
                    int end_time = Integer.parseInt(partes[2]);

                    b.findEventsInRange(start_time,end_time);

                } else if (partes[0].equals("PRINT_INORDER")) {
                        b.printInorder();

                    } else if (partes[0].equals("REMOVE")) {
                    int start_time = Integer.parseInt(partes[1]);
                    b.removeEvent(start_time);

                    }
                }

            }
        }