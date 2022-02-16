	package Assignment19;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegularExprassionAssignment 
{
	public static void main(String[] args) throws IOException  
	{
		try

		{
			BufferedReader br=new BufferedReader(new FileReader("D:\\Java Development\\Workspace\\core-project\\src\\Assignment19\\Notepadfile.txt"));
			String rgEx="[A-Za-z0-9][a-zA-Z0-9]*[^# &*%@][@][a-z]+[.][[a-z]{2,3}]";

			Pattern pattern=Pattern.compile(rgEx);
			ArrayList<String> al=new ArrayList<String>();
			int cnt=0;
			Matcher m;
			while(br.ready())
			{
				String line=br.readLine();
				while(line!=null&&line.substring(line.indexOf(".")+1).length()<=4)
				{
					m=pattern.matcher(line);
					if(m.find())
					{
						cnt++;
						al.add(line);
					}
					line=br.readLine();
				}
			}
			System.out.println("Total "+cnt+" IDs Founds\n");
			for(String str:al)
			{
				System.out.println(str);
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
