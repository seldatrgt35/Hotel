package hotels;

public abstract class Hotel
{
	private static Room RoomList[]=new Room[30];
	private static Employee EmployeeList[]=new Employee[50];
	private static Reservation ReservationList[]=new Reservation[500];
	private static Customer CustomerList[]=new Customer[1000];


//________________________________________________________Add to List_____________________________________________________
	
	public static void addToList(Room r,int c)
	{
		RoomList[c]=r;
	}
	public static void addToList(Employee e,int c)
	{
		EmployeeList[c]=e;
	}
	public static void addToList(Reservation r,int c)
	{
		ReservationList[c]=r;
	}
	public static void addToList(Customer C,int c)
	{
		CustomerList[c]=C;
	}
	
	
	//_______________________________________________________Get From List_________________________________________________
	
	
	public static Room getRoomFromId(int id)
	{
		return RoomList[id-1];
	}
	public static Employee getEmployeeFromIndex(int index)
	{
		return EmployeeList[index];
	}
	public static Reservation getRezervationFromIndex(int c)
	{
			return ReservationList[c];
	}
	public static Customer getCustomerFromCustomerID(int id)//useed in  reservation Constructor and searchRoom
	{
		Customer tempCustomer=CustomerList[id-1];
		return tempCustomer;
	}

	
	
	
		
	
	//_________________________________________________________print List___________________________________________________
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_SIYAH = "\u001B[30m";
	public static final String ANSI_KIRMIZI = "\u001B[31m";
	public static final String ANSI_YEŞİL = "\u001B[32m";
	public static final String ANSI_SARI = "\u001B[33m";
	public static final String ANSI_MAVI = "\u001B[34m";
	public static final String ANSI_MOR = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_BEYAZ = "\u001B[37m";

	public static void printEmployeeList()
	{
		System.out.println(ANSI_KIRMIZI+"\nList Employee:");
		for(int x=0;x<Employee.getCount();x++)
		
			System.out.println("Employee #"+(x+1)+"  "+EmployeeList[x].displyEmployee());
	}
	
	public static void printRoomList()
	{
		System.out.println(ANSI_MOR +"\nList Room : ");
		for(int x=0;x<Room.getCount();x++)
			System.out.println("Room  #"+(x+1)+"  "+RoomList[x].displyRoom());
	}
	public static void printReservationList()
	{
		System.out.println(ANSI_CYAN+"\nList Reservation:");
		for(int x=0;x<Reservation.getCount();x++)
			System.out.println(ReservationList[x].displyReservation());
	}
	public static void printCustomerList()
	{
		System.out.println(ANSI_SARI+"\nList Customer:");
		for(int x=0;x<Customer.getCount();x++)
			System.out.println("Employee #"+(x+1)+"  "+CustomerList[x].displyCustomer());
	}
	
	
	//_____________________________________________________________Other____________________________________________________
	
	public static void deletEmployee(int Id)
	{
		for(int x=(Id-1);x<Employee.getCount()-1;x++)
			EmployeeList[x]=EmployeeList[x+1];
		Employee.setCountMinusMinus();
		
	}
	public static void  searchCustomer(String key) {
        boolean found = false;
        System.out.println(ANSI_RESET +"\n"+"\n"+"Search Customer: "+key);
        key=key.replace(" ", "");
        if (key.contains("*")) {
            for (int i=0;i<Customer.getCount() ;i++) 
            {
            	String temp=CustomerList[i].getName();
            	temp =temp.replace(" ", "");
            	
                if (temp.startsWith(key.replace("*", ""))) {
                	
                	System.out.println(ANSI_RESET+"Customer# "+(i+1)+" "+CustomerList[i].displyCustomer());
                    found = true;
                }
            }
        } 
        else if (key.contains("?"))
        {
            for (int i=0;i<Customer.getCount() ;i++) {
            	String temp=CustomerList[i].getName();
            	temp =temp.replace(" ", "");
                if (temp.length() == key.length() && temp.startsWith(key.replace("?", ""))) {
                	
                	System.out.println("Customer# "+(i+1)+" "+CustomerList[i].displyCustomer());
                    found = true;
                }
            }
        } 
        else
        {
            for (int i=0;i<Customer.getCount() ;i++) {
            	String temp=CustomerList[i].getName();
            	temp =temp.replace(" ", "");
                if (temp.equals(key))
                {
                	
                	System.out.println("Customer# "+(i+1)+" "+CustomerList[i].displyCustomer());
                    found = true;
                }
            }
        }
        if (!found)
            System.out.println("No customer found with name \"" + key + "\".");
    }
	
	
	
	
	
}