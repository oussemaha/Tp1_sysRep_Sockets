package ex2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class client {
    public static void main(String argv[]) {
        int port = 0;
        Voiture karhabti;
        String host = "",typeV="",modelV="";
        Scanner keyb = new Scanner(System.in);
        
        System.out.print("Nom du serveur : ");
        host = keyb.next();
        System.out.print("Port du serveur : ");

        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le second paramètre n'est pas un entier.");
            System.exit(-1);
        }
        System.out.println("type de Voiture :");
        typeV = keyb.next();
        System.out.println("modèle de Voiture :");
        modelV = keyb.next();
        karhabti= new Voiture(typeV, modelV);
        try {
            InetAddress adr = InetAddress.getByName(host);
            Socket socket = new Socket(adr, port);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            output.writeObject(karhabti);
            String chaine = (String) input.readObject();
            System.out.println(" recu du serveur : " + chaine);
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }

}
