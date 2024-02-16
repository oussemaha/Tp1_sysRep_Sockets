# Tp1_sysRep_Sockets

pour tester l'exécution en local il faut lancer le serveur au début et choisir un port, puis lancer le client et mettre comme addresse 127.0.0.1 ou localhost et le même port 

pour tester l'exécution sur deux machines : 
  sur le même réseau local LAN :
      lancer le serveur et choisir un port, lancer le client  et mettre comme addresse l'addresse de la machine qui tourne le programme du serveur dans le LAN et choisr le même port

  ne sont pas sur le m^éme LAN mais connectées à l'internet:
      faire le port forwarding sur le routeur du réseau qui contient la machine qui exécutera le programme du serveur ou utiliser un autre service de tunneling comme Ngrok si les configs du routeur ne sont pas accessibles ou créer un VPN en utilisant par exemple Hamachi.
      lancer le client et mettre comme addresse , l'addresse publique du routeur ou se trouve le serveur et mettre le port choisi dans la configuration du port forwarding 
