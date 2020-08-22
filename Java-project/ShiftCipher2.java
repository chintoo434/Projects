//ShiftCipher Encryption, Decryption and BruteForce Attack


package simple_program;

import java.io.*;

public class ShiftCipher2 {

	public static void main(String[] args) throws IOException
	{
		System.out.println("NOTE: This program work only small letter character");
		System.out.println("Shift Encryption and Decryption");
		System.out.println("_______________________________\n\n");
		
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		
		System.out.print("Enter plaintext to Encrypt: ");
		String s=br.readLine();
		System.out.print("Enter Decryption key: ");
		int key=Integer.parseInt(br.readLine());
		Encryption(s, key);
		System.out.println("\n\n");
		
		
		System.out.print("Enter Enceypted text: ");
		String ss=br.readLine();
		System.out.print("Enter Decryption key: ");
		int dekey=Integer.parseInt(br.readLine());
		Decryption(ss, dekey);
		System.out.println("\n\n\n");
		
		
		System.out.println("Bruteforce Attack: ");
		System.out.print("Enter Ciphertext: ");
		String sss= br.readLine();
		System.out.println("\nInitializing Bruteforce Attack......");
		bruteForce(sss);

	}
	
	static void Encryption(String s, int key)
	{
		StringBuffer br1=new StringBuffer();
		for(int i=0; i<s.length();i++)
		{
			char ch=s.charAt(i);
			//For small character Encryption
			if((int)ch>=97 && (int)ch<=122) 
			{
				if(((int)ch+key)<=122)
				{
					char c=(char)((int)ch+key);
					br1.append(c);
				}
				else
				{
					char c=(char)((int)ch+key+96-122);
					br1.append(c);
				}
			}
			//For capital character Encryption
			else if((int)ch>=65 && (int)ch<=90)
			{
				if(((int)ch+key)<=90)
				{
					char c=(char)((int)ch+key);
					br1.append(c);
				}
				else
				{
					char c=(char)((int)ch+key+64-90);
					br1.append(c);
				}
			}

			else if((int)ch==32)
			{
				if((int)ch==32)
				{
					br1.append(" ");
				}
				
			}
			
		}
		System.out.println("Encrpted text : "+br1);
		 
	}
	
	
	//abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890
	// cdefghijklmnopqrstuvwxyzab CDEFGHIJKLMNOPQRSTUVWXYZAB 3456789012 key=2
	
	
	static void Decryption(String ss, int dekey)
	{
		
		StringBuffer br2 = new StringBuffer();
		for(int i=0; i<ss.length();i++)
		{
			char x =ss.charAt(i);
			if((int)x>=97 && (int)x<=122)
			{
				if(((int)x-dekey<97))
				{
					char chd = (char)(((int)x-dekey)+26);
					br2.append(chd);
					
				}
				else
				{
					char chd=(char)((int)x-dekey);
					br2.append(chd);
				}

			}
			
			
			else if((int)x>=65 && (int)x<=90)
			{
				if(((int)x-dekey<65))
				{
					char chd = (char)(((int)x-dekey)+26);
					br2.append(chd);
					
				}
				else
				{
					char chd=(char)((int)x-dekey);
					br2.append(chd);
				}

			}
			

			else if((int)x==32)
			{
				br2.append(" ");
			}
		 
		}
		
		System.out.println("Decrypted text: "+br2);
	}
	
	
	static void bruteForce(String sss)
	{
		int fkey=1;
		System.out.println("BruteForce plaintext:");
		StringBuffer br3 = new StringBuffer();

		for(int i=0; i<26;i++)
		{
			
			
			for(int j=0; j<sss.length();j++)
			{
				char x =sss.charAt(j);
				if((int)x>=97 && (int)x<=122)
				{
					if(((int)x-fkey<97))
					{
						char chd = (char)(((int)x-fkey)+26);
						br3.append(chd);
						
					}
					else
					{
						char chd=(char)((int)x-fkey);
						br3.append(chd);
					}

				}
				
				else if((int)x>=65 && (int)x<=90)
				{
					if((((int)x-fkey)<65))
					{
						char chd = (char)(((int)x-fkey)+26);
						br3.append(chd);
						
					}
					else
					{
						char chd=(char)((int)x-fkey);
						br3.append(chd);
					}
				}
				
			
				else if((int)x==32)
				{
					br3.append(" ");
				}
			}
			
			System.out.println(br3);
			System.out.println("key: "+fkey+"\n\n");
			fkey++;
			br3.delete(0, sss.length());
		}
	}

}
