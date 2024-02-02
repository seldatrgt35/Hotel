package hotels;

public class Customer extends person
{
	// name   surname   gender birthdate address district city phone 
	private static int count=0;
	private int countReservedDay;
	//__________________________________________________Constructors_____________________________________________________________________________
	
	
	public Customer(String name ,String surname ,String gender ,String birthdate , String address ,String district , String city , String phone)
	{
		super.setName(name);
		super.setSurname(surname);
		super.setGender(gender);
		super.setBirthdate(birthdate);
		super.setAddress(address);
		super.setDistrict(district);
		super.setCity(city);
		super.setPhone(phone);
		Hotel.addToList(this, count);
		count++;
		countReservedDay=0;
		

		
	}
	public Customer()
	{
		count++;
		countReservedDay=0;
	}
	
	//_______________________________________________Setters______________________________________________________________________________
	
	
	// the Setters methods from person class:
	
	//setName
	//setSurname
	//setGender
	//setBirthdate
	//setAddress
	//setdistrict
	//setCity
	//setPhone
	//setId
	
	public void setCountReservedDay(int countReservedDay)
	{
		this.countReservedDay = countReservedDay;
	}
	public void setCountReservedDayPlus1()
	{
		this.countReservedDay++;
	}

	
	//_________________________________________________Getters__________________________________________________________________________

	//getName
	//getSurname
	//getGender
	//getBirthdate
	//getAddress
	//getdistrict
	//getCity
	//getPhone
	//getId

	public static int getCount()
	{
		return count;
	}
	public int getCountReservedDay() {
		return countReservedDay;
	}
	
	
	//__________________________________________________Other method________________________________________
	public String displyCustomer()
	{
		String s="";
		s=super.getName()+"     "+super.getSurName()+"     "+super.getGender()+"     "+super.getBirthdate()+"     "+super.getCity()+"      "+super.getPhone();
		return s;
	}
	public static String getNameAndSurname(int id)
	{
		String s="";
		if(id<=0||id>count)
			 s="Customer  #"+id +" Not founded!!!";
		else
			s=Hotel.getCustomerFromCustomerID(id).getName()+"  "+Hotel.getCustomerFromCustomerID(id).getSurName();
		return s;
	}
	

	
	
	
}// end of class