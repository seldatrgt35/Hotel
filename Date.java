package hotels;

public class Date
{
	private int year;
	private int month;
	private int day;
	
	//____________________________________________________________Constructors________________________________________________________
	public Date(String s)
	{
		String temp[]=s.split("\\.");
		setYear(Integer.parseInt(temp[2]));
		setMonth(Integer.parseInt(temp[1]));
		setDay(Integer.parseInt(temp[0]));

	}
	
	
	public Date(int day , int month , int year)
	{
		setYear(year);
		setMonth(month);
		setDay(day);

	}
	
	
	//___________________________________________________________Setters_____________________________________________________________________
	public void setYear(int year) 
	{
		if(year==2024||year==24) 
			this.year = year;
		else 
		{
			System.out.println("Year must be 2024!");
			this.year=-1;
		}
	}
	
	public void setMonth(int month) {
		if(month>0&&month<13)
			this.month = month;
		else
		{
			System.out.println("Month must be in [1,12] range!");
			this.month=-1;
		}
	}
	
	public void setDay(int day)
	{
		if(this.month==1||this.month==3||this.month==5||this.month==7||this.month==8||this.month==10||this.month==12)
		
		{
			if(day>0&&day<32)	
				this.day=day;
			else
			{
				System.out.println("Day must be in [1,31] range!");
				this.day=-1;
			}
		}
		
		else if(this.month==4||this.month==6||this.month==9||this.month==11)
		{
			if(day>0&&day<31)	
				this.day=day;
			else
			{
				System.out.println("Day must be in [1,30] range!");
				this.day=-1;
			}
		}
		else
		
		{
			if(day>0&&day<30)
				this.day=day;
			else
			{
				System.out.println("Day must be in [1,29] range!");
				this.day=-1;
			}
		}
				
	}//end of setDay
	
	
	
	//_________________________________________________________Getters______________________________________________________________________
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public boolean isDateTrue()
	{
		boolean dateCheck=true;
		if(this.day==-1)
			dateCheck=false;
		else if(this.month==-1)
			dateCheck=false;
		else if(this.year==-1)
			dateCheck=false;
		
		return dateCheck;

			
	}
	//_______________________________________________________________Other method___________________________________________________
	public String displyDate()
	{
		String s=this.day+"."+this.month+"."+this.year;
		return s;
	}
	public int calculateDateOfYear()
	{
		int x=0;
		if(this.day!=-1&& this.month!=-1 && this.year!=-1)
		{
			if(this.month==1 )
				x=this.day;
			else if(this.month==2)
				x=(this.day+31);
			else if(this.month==3)
				x= (this.day+60);
			else if (this.month==4)
				x= (this.day+91);
			else if(this.month==5)
				x= (this.day+121);
			else if(this.month==6)
				x= (this.day+152);
			else if (this.month==7)
				x= (this.day+182);
			else if(this.month==8)
				x= (this.day+213);
			else if (this.month==9)
				x= (this.day+244);
			else if (this.month==10)
				x= (this.day+274);
			else if(this.month==11)
				x= (this.day+305);
			else
				x=  (this.day+335);
		}
		return x;
				
	}// end calculateDateOfYear 
	
	
	public int endOfMonth()
	{
		if(this.month==1||this.month==3||this.month==5||this.month==7||this.month==8||this.month==10||this.month==12)
			return 31;
		else if(this.month==4||this.month==6||this.month==9||this.month==11)
			return 30;
		else
			return 29;
	}

	public Date goToNextDay()
	{
		Date nextDay=new Date (this.day,this.month,this.year);
		if(this.month==1||this.month==3||this.month==5||this.month==7||this.month==8||this.month==10||this.month==12)
		{	
			if(this.day<31)		
			{
				this.day++;
			}
			else
			{
				this.day=1;
				this.month++;			
			}
		}	
		else if(this.month==4||this.month==6||this.month==9||this.month==11)
		{
			if(this.day<30)		
			{
				this.day++;
			}
			else
			{
				this.day=1;
				this.month++;			
			}
			
			
			
		}
		else
		{
			if(this.day<29)		
			{
				this.day++;
			}
			else
			{
				this.day=1;
				this.month++;			
			}
		}
			
			
			
		return this;
			
			
	}
	
	
}