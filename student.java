//serialization
import java.io.Serializable;
public class student implements Serializable {
	private int id;
	private String name;
	public student(int id, String name) {
	this.id=id;
	String sname=name; }
	public void disp()  {
		System.out.println(id +" "+name); } }