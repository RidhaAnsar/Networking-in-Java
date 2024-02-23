//Deserialization
class Dser {
	public static void main(String args[]) throws Exception {
	FileInputStream fin=new FileInputStream("f.txt");
	ObjectInputStream in=new ObjectInputStream(fin);
	student s=(student)in.readObject();
	s.disp();
	in.close(); 
  } 
}