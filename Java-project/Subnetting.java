package simple_program;
import java.util.*;
import java.lang.Math; //122.199.100.163

public class Subnetting {

	public static void main(String[] args) {
		String ip;
		int bit;
		
		Scanner s = new Scanner(System.in);
		System.out.println("\nIP Format must be: 001.010.010.100");
		System.out.println("___________________________________\n\n\n");
		
		System.out.print("Enter IP: ");
		ip = s.nextLine();
		//System.out.println(ip);
		if(ip.length()!=15)
		{
			System.out.println("\nInvalid IP format.....");
			System.exit(0);
		}
		
		int ch=Integer.parseInt(ip.substring(0,3));
		int ch2=Integer.parseInt(ip.substring(4,7));
		int ch3=Integer.parseInt(ip.substring(8,11));
		int ch4=Integer.parseInt(ip.substring(12,15));
		if(!(ch>=0 && ch2>=0 && ch3>=0 && ch4>=0 && ch<256 && ch2<256 && ch3<256 && ch4<256))
		{
			System.out.println("\nEnter IP Out of Range....\nEnter Valid IP");
			System.exit(0);
		}
		
		System.out.print("Enter Network Bit: ");
		bit = s.nextInt();
		//System.out.println(bit);
		
		Calculation cal = new Calculation();
		cal.network(ip, bit);
	}

}

class Calculation
{
	void network(String ip, int bit)
	{
		int n, count=1;
		if(bit>=24 && bit<=30)
		{
			int a=(int)Math.pow(2,(32-bit));
			
			n=(int)(255/a);
			System.out.println();
			String sq = ip.substring(0, 12);
			System.out.print("    (Network ip)  \t");
			System.out.print("      (First valid ip)\t ");
			System.out.print("      (Last valid ip)\t");
			System.out.print("         (Broadcst ip)\t");
			System.out.println();
			
			for(int i=0; i<=n; i++)
			{	
				if(a<=256)
				{	
				
					System.out.print(count+")  ");
					System.out.print(sq+(i*a)+"\t\t");
					System.out.print(sq+(i*a)+"\t\t");
					System.out.print(sq+(((i+1)*a)-1)+"\t\t");
					System.out.print(sq+(((i+1)*a)-1)+"\t\t");
					System.out.println();
					count++;
				}
			}
			int p=(int)Math.pow(2, bit+1-24);
			System.out.println("\nExtra Wasted IP: "+(p-2));
			
		}
		
		
		
		if(bit>=16 && bit<24)
		{
			int a=(int)Math.pow(2,(24-bit));
			
			n=(int)(255/a);
			System.out.println();
			String sq = ip.substring(0, 8);
			System.out.print("(Network ip)  \t");
			System.out.print("      (First valid ip)\t ");
			System.out.print("      (Last valid ip)\t");
			System.out.print("         (Broadcst ip)\t");
			System.out.println();
			
			for(int i=0; i<=n; i++)
			{	
				if(a<=256)
				{
					System.out.print(count+")  ");
					System.out.print(sq+(i*a)+".0"+"\t\t");
					System.out.print(sq+(i*a)+".1"+"\t\t");
					System.out.print(sq+(((i+1)*a)-1)+".254"+"\t\t");
					System.out.print(sq+(((i+1)*a)-1)+".255"+"\t\t");
					System.out.println();
					count++;
				}
			}
			int p=(int)Math.pow(2, bit+1-16);
			System.out.println("\nExtra Wasted IP: "+(p-2));
			
		}
		
		if(bit>=8 && bit<16)
		{
			int a=(int)Math.pow(2,(16-bit));
			
			n=(int)(255/a);
			System.out.println();
			String sq = ip.substring(0, 3);
			System.out.print("(Network ip)  \t");
			System.out.print("      (First valid ip)\t ");
			System.out.print("      (Last valid ip)\t");
			System.out.print("         (Broadcst ip)\t");
			System.out.println();
			
			for(int i=0; i<=n; i++)
			{	
				if(a<=256)
				{	
					System.out.print(count+")  ");
					System.out.print(sq+"."+(i*a)+"."+"0.0"+"\t\t");
					System.out.print(sq+"."+(i*a)+"."+"0.1"+"\t\t");
					System.out.print(sq+"."+(((i+1)*a)-1)+"."+"255.254"+"\t\t");
					System.out.print(sq+"."+(((i+1)*a)-1)+"."+"255.255"+"\t\t");
					System.out.println();
					count++;
				}
			}
			int p=(int)Math.pow(2, bit+1-8);
			System.out.println("\nExtra Wasted IP: "+(p-2));
			
		}
		
		if(bit>=0 && bit<8)
		{
			int a=(int)Math.pow(2,(8-bit));
			
			n=(int)(255/a);
			System.out.println();
			
			System.out.print("(Network ip)  \t");
			System.out.print("      (First valid ip)\t ");
			System.out.print("      (Last valid ip)\t");
			System.out.print("         (Broadcst ip)\t");
			System.out.println();
			
			for(int i=0; i<=n; i++)
			{	
				if(a<=256)
				{	
					System.out.print((i*a)+".0.0.0"+"\t\t");
					System.out.print((i*a)+".0.0.1"+"\t\t");
					System.out.print((((i+1)*a)-1)+".255.255.254"+"\t\t");
					System.out.print((((i+1)*a)-1)+".255.255.255"+"\t\t");
					System.out.println();
					count++;
				}
			}
			int p=(int)Math.pow(2, bit+1);
			System.out.println("\nExtra Wasted IP: "+(p-2));
		}
		
		if(bit==31)
			System.out.println("\nsorry...\nHost Network is Zero for 31");
		else
			System.out.println("\nInvalid input");
		
	}
}







































