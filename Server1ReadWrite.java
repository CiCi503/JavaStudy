import java.io.*;
import java.net.*;
public class Server1ReadWrite {
	
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket (6666);
			String str;			
			Socket s = ss.accept();
			
			//读入数据
			InputStream is = s.getInputStream();//得到socket端输入
			DataInputStream dis = new DataInputStream (is);
			//System.out.println("Client: " + dis.readUTF());
			
			//从键盘读入数据
			InputStreamReader isr = new InputStreamReader (System.in);
			BufferedReader dis1 = new BufferedReader (isr);
			//str = "Hello,Server!";
			//System.out.println("Server: " + str);//在Server本端输出
			
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			//dos.writeUTF(str);//写入Client端
			
			 do {
				System.out.println("Client: " + dis.readUTF());
				str = dis1.readLine();
				System.out.println("Server: " + str);
				dos.writeUTF(str);
				dos.flush();
				
				
				
			}while (!str.equalsIgnoreCase("exit"));
			
			os.flush();
			dos.flush();
			is.close();
			dis.close();
			os.close();
			dos.close();
			s.close();
			isr.close();
			dis1.close();
				
			
		} catch(Exception e) {
				e.printStackTrace();
			}
	}
}