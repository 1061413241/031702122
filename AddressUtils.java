package AddressBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;

public class AddressUtils {
	
	static AddressInfo addressInfo = new AddressInfo();//定义地址对象
	
	/**
	 * 对地址进行处理，得到经纬度
	 * @param address
	 * @return
	 */
	public static String GetAddressData(String address) {
		StringBuilder sb=new StringBuilder();
		try {
			//cityname = URLEncoder.encode(cityName, "UTF-8");
			String address_url = "http://api.map.baidu.com/geocoding/v3/?address="+address+"&output=json&ak=rY101LiNwfFHb0jCw0wekvMDiwlLbV0E";
			
			
			URL url = new URL(address_url);
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			//GZIPInputStream gzin = new GZIPInputStream(is);//压缩出问题
			InputStreamReader isr = new InputStreamReader(is, "utf-8"); // 设置读取流的编码格式，自定义编码
			BufferedReader reader = new BufferedReader(isr);
			String line = null;
			while((line=reader.readLine())!=null)
				sb.append(line+" ");
			reader.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(sb.toString());
		return sb.toString();
		
	}
	
	
	/**
	 * 将JSON格式数据进行解析 ，返回经纬度
	 * @param str
	 * @return
	 */
	public static void GetAddress(String address){
		String addressInfobyJson=GetAddressData(address);
		
		JSONObject dataOfJson = JSONObject.fromObject(addressInfobyJson);
		//System.out.println(addressInfobyJson);
			

		//高德api
//		if(dataOfJson.containsKey("geocodes"))
//		{
//			JSONArray geocodes=dataOfJson.getJSONArray("geocodes");
//			dataOfJson=geocodes.getJSONObject(0);
//		}
//
//		
//		JSONObject result=dataOfJson.getJSONObject("0");
//		if(result.containsKey("location"))
//			addressInfo.setLocation(result.getString("location"));
		
		//百度api
		if(dataOfJson.isNullObject())
		{
			addressInfo.setLng(116.0);//经度
			addressInfo.setLat(39.0);//纬度
		}
		else
		{
			dataOfJson=dataOfJson.getJSONObject("result");
			if(dataOfJson.isNullObject())
			{
				addressInfo.setLng(116.0);//经度
				addressInfo.setLat(39.0);//纬度
			}
			else
			{
				dataOfJson=dataOfJson.getJSONObject("location");
				if(dataOfJson.isNullObject())
				{
					addressInfo.setLng(116.0);//经度
					addressInfo.setLat(39.0);//纬度
				}
				else
				{
					addressInfo.setLng(dataOfJson.getDouble("lng"));//经度
					addressInfo.setLat(dataOfJson.getDouble("lat"));//纬度
				}

			}

		}

		
		String info=GetAddressData2(addressInfo.getLng(), addressInfo.getLat());
		addressInfo=AddressUtils.GetAddress2(info);
//		return addressInfo;
	}
	/**
	 * 对经纬度进行二次处理，返回具体地址
	 * @param lng
	 * @param lat
	 * @return
	 */
	public static String GetAddressData2(double lng,double lat) {
		StringBuilder sb=new StringBuilder();
		try {
			//cityname = URLEncoder.encode(cityName, "UTF-8");
			String address_url = "http://api.map.baidu.com/reverse_geocoding/v3/?ak=rY101LiNwfFHb0jCw0wekvMDiwlLbV0E&output=json&location="+lat+","+lng;

			
			URL url = new URL(address_url);
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			//GZIPInputStream gzin = new GZIPInputStream(is);//压缩出问题
			InputStreamReader isr = new InputStreamReader(is, "utf-8"); // 设置读取流的编码格式，自定义编码
			BufferedReader reader = new BufferedReader(isr);
			String line = null;
			while((line=reader.readLine())!=null)
				sb.append(line+" ");
			reader.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(sb.toString());
		return sb.toString();
		
	}
	
	
	public static AddressInfo GetAddress2(String addressInfobyJson){
		JSONObject dataOfJson = JSONObject.fromObject(addressInfobyJson);
//		System.out.println(addressInfobyJson);
		
		//创建WeatherInfo对象，提取所需的天气信息
		//AddressInfo addressInfo = new AddressInfo();
		
		//从json数据中提取数据
//		String data = dataOfJson.getString("data");
//		
//		dataOfJson = JSONObject.fromObject(data);
//		addressInfo.setCityname(dataOfJson.getString("city"));;
//		addressInfo.setAirquality(dataOfJson.getString("aqi"));
//		
//		//获取预测的天气预报信息
//		JSONArray forecast = dataOfJson.getJSONArray("forecast");
//		//取得当天的
//		JSONObject result=forecast.getJSONObject(0);
//		
//		addressInfo.setDate(result.getString("date"));
//		
//		String high = result.getString("high").substring(2);
//		String low  = result.getString("low").substring(2);
//		
//		addressInfo.setTemperature(low+"~"+high);
//		
//		addressInfo.setWeather(result.getString("type"));
		
		//高德api
//		if(dataOfJson.containsKey("geocodes"))
//		{
//			JSONArray geocodes=dataOfJson.getJSONArray("geocodes");
//			dataOfJson=geocodes.getJSONObject(0);
//		}
//
//		
//		JSONObject result=dataOfJson.getJSONObject("0");
//		if(result.containsKey("location"))
//			addressInfo.setLocation(result.getString("location"));
		
		//百度api
//		dataOfJson=dataOfJson.getJSONObject("result");
//		dataOfJson=dataOfJson.getJSONObject("location");
//		addressInfo.setLng(dataOfJson.getDouble("lng"));//经度
//		addressInfo.setLat(dataOfJson.getDouble("lat"));//纬度
//		
		if(dataOfJson.isNullObject())
		{
			addressInfo.setProvince("");
			addressInfo.setCity("");
			addressInfo.setCounty("");
		}
		else
		{
			dataOfJson=dataOfJson.getJSONObject("result");
			if(dataOfJson.isNullObject())
			{
				addressInfo.setProvince("");
				addressInfo.setCity("");
				addressInfo.setCounty("");
			}
			else
			{
				dataOfJson=dataOfJson.getJSONObject("addressComponent");
				if(dataOfJson.isNullObject())
				{
					addressInfo.setProvince("");
					addressInfo.setCity("");
					addressInfo.setCounty("");
				}
				else
				{
					addressInfo.setProvince(dataOfJson.getString("province"));
					addressInfo.setCity(dataOfJson.getString("city"));
					addressInfo.setCounty(dataOfJson.getString("district"));
				}

			}

		}

		
		//确认直辖市省份信息
		String prov=addressInfo.getProvince();
		String cit=addressInfo.getCity();
		if(prov.equals(cit))
		{
			addressInfo.setProvince(prov.substring(0, prov.length()-1));
		}

		return addressInfo;
	}
	
	
	/**
	 * 处理后几级地址信息
	 * @param address
	 * @return
	 */
    public static void addressResolution(String address,char flag)
    {
        if(flag=='1')
        {
        	String regex="(?<town>[^区]+?区|.+?镇|.+?街道|.+?乡)?(?<village1>.*)";
            Matcher m=Pattern.compile(regex).matcher(address);
            String town=null,village1=null;
            if(m.find())
            {
                town=m.group("town");
                village1=m.group("village1");
            }
            //System.out.println(village1);
            addressInfo.setTown(town==null?"":town.trim());
            addressInfo.setVillage1(village1==null?"":village1.trim());
        }
        else if(flag=='2'||flag=='3')
        {
        	String regex="(?<town>[^区]+区|.+?镇|.+?街道|.+?乡)?(?<village1>.+?街|.+?路|.+?巷)?(?<village2>[\\d]+?号|[\\d]+.?道)?(?<village3>.*)";
            Matcher m=Pattern.compile(regex).matcher(address);
            String town=null,village1=null,village2=null,village3=null;
            if(m.find())
            {
                town=m.group("town");
                village1=m.group("village1");
                village2=m.group("village2");
                village3=m.group("village3");
            }
            
            addressInfo.setTown(town==null?"":town.trim());
            addressInfo.setVillage1(village1==null?"":village1.trim());
            addressInfo.setVillage2(village2==null?"":village2.trim());
            addressInfo.setVillage3(village3==null?"":village3.trim());
            
        }
        
        
        
//    	String regex="(?<province>[^省]+自治区|.*?省|.*?行政区)?(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)?(?<county>[^县]+县|.+?区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇|.+街道)?(?<village1>.*)";
//        Matcher m=Pattern.compile(regex).matcher(address);
//        String province=null,city=null,county=null,town=null,village1=null;
////        List<Map<String,String>> table=new ArrayList<Map<String,String>>();
////        Map<String,String> row=null;
////        while(m.find())
////        {
////            row=new LinkedHashMap<String,String>();
////            province=m.group("province");
////            row.put("province", province==null?"":province.trim());
////            city=m.group("city");
////            row.put("city", city==null?"":city.trim());
////            county=m.group("county");
////            row.put("county", county==null?"":county.trim());
////            town=m.group("town");
////            row.put("town", town==null?"":town.trim());
////            village=m.group("village");
////            row.put("village", village==null?"":village.trim());
////            table.add(row);
////        }
//        
//        if(m.find())
//        {
//            province=m.group("province");
//            city=m.group("city");
//            county=m.group("county");
//            town=m.group("town");
//            village1=m.group("village1");
//        }
//        System.out.println(village1);
//        addressInfo.setTown(town==null?"":town.trim());
//        
//        return addressInfo;
    }
}

