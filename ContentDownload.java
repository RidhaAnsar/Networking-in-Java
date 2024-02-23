//download the content of file from net
import java.net.*;
import java.io.*;
import java.util.Date;

class ContentDownload {
	public static void main(String args[]) throws Exception {
	int c;
	URL u=new URL ("https://cs2113f18.github.io/java/JavaCheatSheet.pdf");
	URLConnection uc= u.openConnection();
	System.out.println("Date:"+new Date(uc.getDate()));
		System.out.println("Content-type: " + uc.getContentType());
		System.out.println("Expires: " + uc.getExpiration());
		System.out.println("Last-modified: " + new Date(uc.getLastModified()));
		int len = uc.getContentLength();
		System.out.println("content-length :"+len);
		if(len>0){
			FileOutputStream fout = new FileOutputStream("test.pdf");
			System.out.println("-----content-----");
			InputStream input =uc.getInputStream();
			int i = 0;
			while(((c = input.read()) !=-1) && i<len){
				fout.write((char)c);
				i++;
			}
			input.close();
			fout.close();
		}
		else{
			System.out.println("No content Available");
		}
	}
}
