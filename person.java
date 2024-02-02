package hotels;

public  abstract class person
{
	private String Name;
	private String Surname;
	private String Gender;
	private String Birthdate;
	private String Address;
	private String District;
	private String City;
	private String Phone;
	
	
	//____________________________________________________________Setters___________________________________________________________________________________
	public void setName(String name)
	{
		Name=name;			
	}
	public void setSurname(String surname)
	{
		Surname=surname;

	}
	public void setGender(String gender)
	{
		Gender=gender;

	}
	public void setBirthdate(String birthdate)
	{
		Birthdate=birthdate;

	}
	
	public void setAddress(String address)
	{
		Address=address;

	}
	public void setDistrict(String district)
	{
		District=district;

	}
	public void setCity(String city)
	{
		City=city;
	}
	public void setPhone(String phone)
	{
		Phone=phone;
	}
	
	//_____________________________________________________Getters__________________________________________________________
	
	public String getName()
	{
		return Name;
	}
		
	public String getSurName()
	{
		return Surname;
	}
	public String getGender()
	{
		return Gender;
	}
	public String getBirthdate()
	{
		return Birthdate;
	}
	public String getAddress()
	{
		return Address;
	}
	public String getDistrict()
	{
		return District;
	}
	public String getCity()
	{
		return City;
	}
	public String getPhone()
	{
		return Phone;
	}
	
		
	
	
}

