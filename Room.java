package hotels;

public class Room 
{
	private String type ;
	private boolean aircondition ;
	private boolean balcony;
	private int price;
	private int reservationState[];
	private static int count=0;
	
//_____________________________________________________Constructors____________________________________________________________
	public Room(String type,boolean aircondition , boolean balcony ,int price)
	{
		this.type=type;
		this.aircondition=aircondition;
		this.balcony=balcony;
		this.price=price;
		reservationState=new int [367];// index 0: countig reserved day index 1 ......366 day of year
		for(int x=0;x<=366;x++)		
			reservationState[x]=0;

		Hotel.addToList(this, count);
		count++;
		
		
	}
	public Room ()
	{
		reservationState=new int [367];
		for(int x=0;x<=366;x++)
			reservationState[x]=0;
		Hotel.addToList(this, count);
		count++;
		
	}
//_______________________________________________________Getters____________________________________________________________
	public String getType()
	{
		return type;
	}
	public boolean isAircondition() 
	{
		return aircondition;
	}
	public boolean isBalcony()
	{
		return balcony;
	}
	public int getPrice()
	{
		return price;
	}
	public static int getCount()
	{
		return count;
	}
	
	//____________________________________________________________Setters_____________________________________________________
	public void setType(String type)
	{
		this.type = type;
	}
	public void setAircondition(boolean aircondition)
	{
		this.aircondition = aircondition;
	}
	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}

	public void setPrice(int price) 
	{
		this.price = price;
	}
	//_______________________________________________other method__________________________________________________________

	

	public String displyRoom() //We use this method at print List Room
	{
		String s=this.type;
		if(this.aircondition==true)
			s=s+"  "+"aircondition";
		else 
			s=s+"  "+"no-aircondition";
		if(this.balcony==true)
			s=s+"  "+"balcony";
		else
			s=s+"  "+"no-balcony";
		s=s+"  "+this.price;
		return s;
	}
	
	public boolean isEmpty(String s1,String s2)
	{
		Date start=new Date(s1);
		Date end=new Date(s2);
		boolean isEmptyBool=true;
		for(int x=start.calculateDateOfYear();x<end.calculateDateOfYear();x++)
			if(reservationState[x]==1)
			{
				isEmptyBool=false;
				break;
			}
		return isEmptyBool;
	}
	public boolean isEmpty(Date d1,Date d2)
	{
		boolean isEmptyBool=true;
		for(int x=d1.calculateDateOfYear();x<d2.calculateDateOfYear();x++)
			if(reservationState[x]==1)
			{
				isEmptyBool=false;
				break;
			}
		return isEmptyBool;
	}
	public boolean isEmpty(int day)// day is number from  1 to 366
	{
		boolean isEmptyBool=true;
		if(reservationState[day]==1)
			 isEmptyBool=false;
			
		return isEmptyBool;
	}
	
	public  void takeRoomFull(Date start,Date end ,int customerid )
	{
		for(int x=start.calculateDateOfYear();x<end.calculateDateOfYear();x++)
			
		{	
			reservationState[x]=1;
			reservationState[0]++;	
			Hotel.getCustomerFromCustomerID(customerid).setCountReservedDayPlus1();
			
		}
		
	}
	
	public int getCountofReserved()
	{
		return this.reservationState[0];
	}
	
	
	
}
