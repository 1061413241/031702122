//package AddressBook;


//import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try {
            File f = new File(args[0]);
            //File f = new File("in.txt");
            BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(f), "utf-8"));
            BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
            //File f2= new File("2.txt");
            //BufferedWriter out = new BufferedWriter(new FileWriter(f2));
            String l = null;
            JSONArray array = new JSONArray();
            while ((l = r.readLine()) != null ) 
            {
                String address = l;
                String split[] = address.split("!");
                
//                System.out.println(AddressUtil.addressResolutionVersion2(split[1],1));
                if (split[0].equals("1")){
                    array.put(Resolution.addressResolution(split[1],'1'));
                }else if (split[0].equals("2")){
                    array.put(Resolution.addressResolution(split[1],'2'));
                }else {
                	array.put(Resolution.addressResolution(split[1],'3'));
                }
            } 
	            out.write(array.toString());
	            out.close();
	            r.close();
		} catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

		
		
		
		
	}

}
