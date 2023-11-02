package serveurPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//thread howa li 3ibara seveur tw w l main mawjouda juste bch t3ayet l thread
public class Serveur extends Thread {
private int nbr_client;

 public static void main(String[]args)
 {
//lezemni n3ayet l thread
//n3ayetlou bl methode run m serveur 5ater serveur extends ml thread donc howa zeda ynajm yestaaml start
(new Serveur()).start();

 }
 
 @Override
 public void run() {
//bch ngolha rak bch tesna3 un serveursocket
try {
ServerSocket ss=new ServerSocket(1234);
System.out.println("demarrage de serveur");
while(true) {
Socket s=ss.accept();
//naamlou classe o5ra extends thread bch tassna3 thread l ayy client yod5ol
//bch nessna3 une sous classe essmha clientProcess
new ClientProcess(s,++nbr_client).start();
//hedhi classe bch teriti mn aand thread donc test7a9 start
//hna l ++ heya li bch tsirelha l execution lawla
//yaaml ++ 9bal ma yb3ath ll client process
}


} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

 }
 
 public class ClientProcess extends Thread{
private int num_client;
private Socket s;
public ClientProcess(Socket s,int num_client) {
this.s=s;
this.num_client=num_client;
}
@Override
public void run(){
System.out.println("Le clien numéro"+num_client+"de l adresse id: "+s.getRemoteSocketAddress());
//le5raniya hedhika bch naaref kol adresse ip mta3 l machine li connecte aleha l client
try {
( new PrintWriter(s.getOutputStream(),true)).println("binevenue,vous etes le client num"+num_client);
   // operation op =(Operation)new ObjectInputStream(s.getInputStream()).readObject();
//switch(op.getoperation()) w feha { .setresult
//new ObjectOutputStream(s.getOutputStrm.writeObject(op)

} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}

 }
 
 
 
 
}
