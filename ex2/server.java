package ex2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class server {
    public static void main(String argv[]) {
        Voiture karhabti;
        int port = 0,carburant;
        Scanner keyb = new Scanner(System.in);
        System.out.print("Port du serveur : ");

        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println();
            System.exit(-1);
        }

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            karhabti = (Voiture) input.readObject();
            System.out.println(" une voiture a été reçue " );
            System.out.println(" ca vient de : " + socket.getInetAddress() +
                    ":" + socket.getPort());
            System.out.println("choisir la quantité à remplir dans le réservoir:");
            try {
                carburant = keyb.nextInt();
                karhabti.setCarburant(carburant);
            } catch (NumberFormatException e) {
                System.err.println();
                System.exit(-1);
            }

            output.writeObject(new String("bien recu"));
            serverSocket.close();
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }

}
