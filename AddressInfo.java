//package AddressBook;

public class AddressInfo {
	private String name="";//姓名
	private String phoneNumber="";//手机号
	private String province="";//省级
	private String city="";//市级
	private String county="";//县级
	private String town="";//镇
	private String village1="";//具体地址
	private String village2="";
	private String village3="";
	
	private double lng;//经度
	private double lat;//纬度
	//经度
	public double getLng()
	{
		return lng;
	}
	
	public void setLng(double lng)
	{
		this.lng=lng;
	}
	
	//纬度
	public double getLat()
	{
		return lat;
	}
	
	public void setLat(double lat)
	{
		this.lat=lat;
	}
	
	//姓名
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	//手机号
	public String getPhoneNumber() {
		return phoneNumber;
	}
 
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber= phoneNumber;
	}

	//省级
	public String getProvince() {
		return province;
	}
 
	public void setProvince(String province) {
		this.province= province;
	}
 
	//市级
	public String getCity() {
		return city;
	}
 
	public void setCity(String city) {
		this.city= city;
	}
 
	//县级
	public String getCounty() {
		return county;
	}
 
	public void setCounty(String county) {
		this.county= county;
	}
 
	//镇
	public String getTown() {
		return town;
	}
 
	public void setTown(String town) {
		this.town= town;
	}
 
	//具体地址1
	public String getVillage1() {
		return village1;
	}
 
	public void setVillage1(String village1) {
		this.village1= village1;
	}
	
	//2
	public String getVillage2() {
		return village2;
	}
 
	public void setVillage2(String village2) {
		this.village2= village2;
	}
	
	//3
	public String getVillage3() {
		return village3;
	}
 
	public void setVillage3(String village3) {
		this.village3= village3;
	}
	
	@Override
	public String toString() {
		return "AddressInfo [lng=" + lng+ ", lat=" + lat
				+ ", name="+name+", phone="+phoneNumber+", province=" + province + ", city=" + city
				+ ", county=" + county + ", town=" +town+", village1="+village1+", village2="+village2+", village3="+village3+"]";
	}
	
}