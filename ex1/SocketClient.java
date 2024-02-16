package ex1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class SocketClient {
    public static void main(String argv[]) {
        int port = 0;
        String host = "";
        Scanner keyb = new Scanner(System.in);
        // demander l'adresse et le port du serveur
        System.out.print("Nom du serveur : ");
        host = keyb.next();
        System.out.print("Port du serveur : ");

        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le second paramètre n'est pas un entier.");
            System.exit(-1);
        }
        // l'essai de communiquer
        try {
            // conversion de l'adresse 
            InetAddress adr = InetAddress.getByName(host);
            // création de socket et connection au serveur 
            Socket socket = new Socket(adr, port);
            // création des buffers
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            // envoie d'un message au serveur
            output.writeObject(new String("ma première socket"));
            // réception d'un message du servuer
            String chaine = (String) input.readObject();
            System.out.println(" recu du serveur : " + chaine);
            socket.close();
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}
