package hotels;

public class Reservation
{
	private Date startDate;
	private Date endDate;
	private int RoomId;
	private int CustomerId;
	private static int count=0;
	private int countDayOfReservation;
	public static final String ANSI_MOR = "\u001B[35m";
//_________________________________________________________________Constructors__________________________________________________________________
	
	public Reservation(int customerid ,int roomId,Date startdate ,Date enddate) 
	{
		setReservation( customerid , roomId,startdate , enddate);
		setCountDayofReservation(startdate ,enddate);
	}
	
	
	
	
//__________________________________________________________________Setters________________________________________________________________________
	public void setStart(Date start)
	{
		this.startDate=start;
	}
	public void setEnd(Date end) 
	{	
		this.endDate=end;
	}
		
	public void setRoomId(int roomId) 
	{
			RoomId=roomId;
	}
	public void setCustomerId(int customerId)
	{
		CustomerId=customerId;
	}
	public void setReservation(int customerid ,int roomId,Date startdate ,Date enddate)
	{
		boolean checkAllinputs=true;
		if(customerid<=0 ||customerid>Customer.getCount())
			
		{
			System.out.println(ANSI_MOR+"CustomerId IS not Correct!!!!");
			checkAllinputs=false;
		}
		else
			CustomerId=customerid;
		if(roomId<=0 ||roomId>Room.getCount())	
		{
			System.out.println(ANSI_MOR+"RoomId IS not Correct!!!!");
			checkAllinputs=false;
		}
		else
			RoomId=roomId;
		this.startDate=startdate;
		this.endDate=enddate;
		if(checkAllinputs==true)
		{
			if(Hotel.getRoomFromId(roomId).isEmpty(startDate, enddate)==true)
			{			
				Hotel.addToList(this, count);
		
				count++;
				Hotel.getRoomFromId(roomId).takeRoomFull(startdate, enddate, customerid);
			}
			else
				System.out.println(ANSI_MOR+"Room Is not Empty!!!!!\nReservation has not Completed!");
		
		}
	}// end of setReservation
	public void setCountDayofReservation(Date d1 ,Date d2)
	{
		this.countDayOfReservation=d2.calculateDateOfYear()-d1.calculateDateOfYear();
	}
	//___________________________________________________________________Getters______________________________________________________________________
	public Date getStart() 
	{
		return startDate;
	}
	public Date getEnd() 
	{
		return endDate;
	}
	public int getRoomId() 
	{
		return RoomId;
	}
	public int getCustomerId() 
	{
		return CustomerId;
	}

	public int getCountDateofReservation()
	{
		return this.countDayOfReservation;
	}
	public static int getCount()
	{
		return count;
	}
	//_______________________________________________________________Other method______________________________________________________________________
	public String displyReservation()
	{
		String s="Room   #"+this.RoomId+"  "+Customer.getNameAndSurname(CustomerId)+"  "+this.startDate.displyDate()+"  "+this.endDate.displyDate();
		return s;			
	}
	
	public int incomeFromReservation()
	{
		int day=this.countDayOfReservation;
		int income=day*Hotel.getRoomFromId(this.RoomId).getPrice();
		return income;
		
	}

	
	
}
