import java.io.*;
import java.net.*;
public class server{
public static void main(String args[]) {
ServerSocket ss;
Socket sa;
DataInputStream sin;
DataOutputStream sout;
try {
     ss=new ServerSocket(1234);
     sa=ss.accept();
     sin=new DataInputStream(sa.getInputStream());
     sout=new DataOutputStream(sa.getOutputStream());
     sout.writeUTF("WELCOME CLIENT");
     String str=sin.readUTF();
     System.out.println("client says:"+str);
     System.in.read(); }
     catch(Exception e) {
     System.out.println(e); } } }