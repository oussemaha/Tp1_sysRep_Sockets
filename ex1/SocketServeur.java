package ex1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketServeur {
    public static void main(String argv[]) {
        int port = 0;
        Scanner keyb = new Scanner(System.in);
        // demander le port d'écout
        System.out.print("Port d'écoute : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le paramètre n'est pas un entier.");
            System.err.println("Usage : java ServeurUDP port-serveur");
            System.exit(-1);
        }
        try {
            // création d'un socket serveur
            ServerSocket serverSocket = new ServerSocket(port);
            // accepter la demande d'un client à se connecter

            Socket socket = serverSocket.accept();
            // création des buffers
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            // réception d'un message
            String chaine = (String) input.readObject();
            System.out.println(" recu : " + chaine);
            // affichage du message
            System.out.println(" ca vient de : " + socket.getInetAddress() +
                    ":" + socket.getPort());
            // l'émission d'un réponse
            output.writeObject(new String("bien recu"));
            serverSocket.close();
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}