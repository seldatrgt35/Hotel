package hotels;

public class Employee extends person
{
	// name   surname   gender birthdate address district city phone 
	private String Work;
	private int Sallary;
	private static int count=0;
	//______________________________________________________Constructors_______________________________________________________________________________________
	
	public Employee(String name ,String surname ,String gender ,String birthdate , String address ,String district , String city , String phone ,String work ,int sallary)
	{
		super.setName(name);
		super.setSurname(surname);
		super.setGender(gender);
		super.setBirthdate(birthdate);
		super.setAddress(address);
		super.setDistrict(district);
		super.setCity(city);
		super.setPhone(phone);
		this.setSallary(sallary);
		this.setWork(work);
		Hotel.addToList(this, count);
		count++;
		
	}
	public Employee()
	{
		Hotel.addToList(this, count);
		count++;
		
		
	}
	//________________________________________________________________Setters________________________________________________________________________________________
	// the Setters methods from person class:
	
		//setName
		//setSurname
		//setGender
		//setBirthdate
		//setAddress
		//setdistrict
		//setCity
		//setPhone
		
			public void setSallary(int  sallary)
	{
		this.Sallary=sallary;
	}
	public void setWork(String work)
	{
		this.Work=work;
	}
	public static void setCountMinusMinus()
	{
		count--;
	}
	
//__________________________________________________________________Getters________________________________________________________________________________
	        //getName
			//getSurname
			//getGender
			//getBirthdate
			//getAddress
			//getdistrict
			//getCity
			//getPhone
			
	public String getWork()
	{
		return Work;
	}
	public int getSallary()
	{
		return Sallary;
	}
	public static int getCount()
	{
		return count;
	}
	
	
	
	//_____________________________________________________________other method____________________________________________________
	
	
	
	public String displyEmployee()
	{				
	
		String s="";
		s=super.getName()+" "+super.getSurName()+" "+super.getGender()+"   "+super.getBirthdate()+"   "+super.getCity()+"   "+super.getPhone()+"   "+this.getWork();
		return s;
	}
	
	
	
}
