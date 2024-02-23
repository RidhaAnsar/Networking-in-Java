import java.io.*;
class ser {
	public static void main(String args[]) throws Exception {
	student s1=new student(100, "abcd");
	FileOutputStream fout=new FileOutputStream("f.txt");
	ObjectOutputStream out=new ObjectOutputStream(fout);
	out.writeObject(s1);
	out.flush();
	System.out.println("SUCCESS"); 
} }