package hotels;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Main {

	public static void main(String[] args) throws  IOException 
	{
		Scanner input=new Scanner(System.in);
		File f1=new File("./deuceng.txt");
		ReadFile(f1);
		//_________________________________________________Menu_____________________________________________________________________________
		
		
		System.out.print("\n\nDo you want continue with menu?\n\n1)Yes\t\t2)No\n\nPlease select the action you want to do:");
		int slctmenu=input.nextInt();
		if (slctmenu==1)
		{
			boolean flag=true;
			while(flag==true)
			{
				printMainMenu();
				int slct=input.nextInt();
				switch (slct)
				{
				// Room
				case 1 :
				{
					boolean flagroom=true;
					while(flagroom==true)
					{
						printRoomMenu();
						int slctRoom=input.nextInt();
						switch (slctRoom) 
						{
						case 1:
						{					
							Hotel.printRoomList();
							break;		
						}
						case 2 :
						{
							addNewRoom();
							break;	
						}
						case 3:
						{
							SearchRoom();
							break;
						}
						case 4:
						{
							flagroom=false;
							break;
						}
						}// end of switch slctRoom
					}// end of while flagroom==true
					break;
				}// end of case 1
				// Employee
				case 2 :
				{
					boolean flagemployee=true;
					while(flagemployee==true)
					{
						printEmployeeMenu();
						int slctEmployee=input.nextInt();
						switch (slctEmployee)
						{
						case 1 :
						{
							Hotel.printEmployeeList();
							break;
						}
						case 2 :
						{
							addNewEmployee();
							break;
						}
						case 3 :
						{
							System.out.print("Please Enter EmployeeID:");
							int n=input.nextInt();
							if(n>Employee.getCount()||n<=0)
								System.out.println("\n\nEmployee #"+n+" Doesnt exist!");
							else
							{
								Hotel.deletEmployee(n);
								System.out.println("\n\nEmployee #"+n+" Deleted");
							}		
							break;
						}
						case 4 :
					
						{
							flagemployee=false;
							break;
						}
					
						}// end of switch slctemployee
					}//end of while flagemmployee==true 		
					break;
				}// end of case 2
			
				// Customer
				case 3 :
				{
					boolean flagcustomer=true;
					while(flagcustomer==true)
					{
						printCustomerMenu();
						int slctCustomer=input.nextInt();
						switch (slctCustomer)
						{
						case 1 :
						{
							Hotel.printCustomerList();
							break;
						}
						case 2 :
						{
							addNewCustomer();
							break;
						}
						case 3 :
						{
							System.out.println("Enter the name: ");
							input.nextLine();
							String name=input.nextLine();
							Hotel.searchCustomer(name);
							break;
						}
					
						case 4 :
						{
							flagcustomer=false;
							break;
						}
					
						}// end of switch slctCustomer
				
					}// end of while flagcustomer==true
					break;
				}
			
				//Reservation
				case 4 :
				{
					boolean flagReservation=true;
					while(flagReservation==true)
				
					{
						printReservationMenu();
						int slctReservation=input.nextInt();
						switch (slctReservation)
						{
						case 1:
						{
							Hotel.printReservationList();
							break;
						}
						case 2:
						{
							addNewReservation();
							break;
						}
						case 3:
						{
							SearchRoom();
							break;
						}
						case 4:
						{
							flagReservation=false;
							break;
						}		
						}// end of switch slctReservation
					}// end of while flagReservation
					break;
				}
				//Statistic
				case 5 :
				{
					boolean flagStatistic=true;
					while(flagStatistic==true)
					{
						printStatisticMenu();
						int slctStatistic=input.nextInt();
						switch (slctStatistic)
						{
						case 1 :
						{
							theMostReservedRoom();
							break;
						}
						case 2 :
						{
							theBestCustomer();
							break;
						}
						case 3 :
						{
							incomeInformation();
							break;
						}
						case 4 :
						{
							monthlyOccupancyRate();
							break;
						}
						case 5 :
						{
							flagStatistic=false;
							break;
						}
						}// end of switch slctStatistic				
				
					}// end of while flagStatistic 
					break;
				}
				//Simulation
				case 6 :
				{
					System.out.print("Enter simulation Information :\nStart Date :");
					Date start=new Date(input.next());
					if(start.isDateTrue()==true)
					{
						System.out.print("\nEnd Date :");
						Date end=new Date(input.next());
						if(start.isDateTrue()==true)
							simulation(start,end);
						else
							System.out.println("\nSimulation has Stopped!");							
					}
					else
						System.out.println("\nSimulation has Stopped!");
					break;	
				}
				// Close Program
				case 7 :
				{
					flag=false;
					break;	
				}
			
				}// end of swtch slct
			}// end of while flag=true	
			
		}// end of if (slctmenu==1)
	
	}// end of main
		
	public static void printMainMenu()
	{
		System.out.print("\n*****************************************\n" + "1)ROOMS INFORMATION \n\n"
				+ "2)EMPLOYEE INFORMATION\n\n" + "3)CUSTOMER INFORMATION \n\n" + "4)RESERVATION INFORMATION \n\n"
				+ "5)STATISTICS INFORMATION \n\n" +"6)Simulation\n\n"+"7)Close program\n\n"+"*******************************************\nPlease select the action you want to do: ");
	}
	public static void printRoomMenu()
	{
		System.out.print("\n\n1)List room\n\n2)Add new room\n\n3)Search room\n\n4)Back to main menu\n\nPlease select the action you want to do: ");
	}
	public static void printEmployeeMenu()
	{
		System.out.print("\n\n1)List employee\n\n2)Add new  employee\n\n3)Delet Employee\n\n4)Back to main menu\n\nPlease select the action you want to do:");
		
	}
	public static void printCustomerMenu()
	{
		System.out.print("\n\n1)List customer\n\n2)Add new customer\n\n3)Search customer\n\n4)Back to main menu\n\nPlease select the action you want to do:");
	}
	public static void printReservationMenu()
	{
		System.out.print("\n\n1)List Reservation\n\n2)Add new reservation\n\n3)Search Room\n\n4)Back to main menu\n\nPlease select the action you want to do:");

	}
	public static void printStatisticMenu()
	{
		System.out.print("\n\n1)The most reserved room\n\n2)The best customer\n\n3)Income Information\n\n4)Monhtly occupancy rate\n\n5)Back to main menu\n\nPlease select the action you want to do:");
		
	}
	
	public static void ReadFile(File f) throws FileNotFoundException
	{
		
		Scanner infile=new Scanner(f);
		while(infile.hasNext())
		{
			String tempLine[]=(infile.nextLine().split(";"));
			if(tempLine[0].equalsIgnoreCase("addRoom"))
			{
				Room tempRoom;
				int n=Integer.parseInt(tempLine[1]);
				for(int x=0;x<n;x++)
					 tempRoom=new Room(tempLine[2],Boolean.parseBoolean(tempLine[3]),Boolean.parseBoolean(tempLine[4]),Integer.parseInt(tempLine[5]));
			}
			else if(tempLine[0].equalsIgnoreCase("addEmployee"))
	
			{
				Employee tempEmployee=new Employee(tempLine[1],tempLine[2],tempLine[3],tempLine[4],tempLine[5],tempLine[6],tempLine[7],tempLine[8],tempLine[9],Integer.parseInt(tempLine[10]));			
			
			}
			else if(tempLine[0].equalsIgnoreCase("addCustomer"))
			{
				Customer tempCustomer=new Customer(tempLine[1],tempLine[2],tempLine[3],tempLine[4],tempLine[5],tempLine[6],tempLine[7],tempLine[8]);			
			}
			else if(tempLine[0].equals("addReservation"))
			{
				
				Date startDate=new Date(tempLine[3]);
				Date endDate=new Date(tempLine[4]);
				Reservation tempReservation=new Reservation(Integer.parseInt(tempLine[1]),Integer.parseInt(tempLine[2]),startDate,endDate);

				
			}
			else if(tempLine[0].equalsIgnoreCase("listRooms"))
			{
				Hotel.printRoomList();
			}
			else if(tempLine[0].equalsIgnoreCase("listEmployees"))
			{
				Hotel.printEmployeeList();
			}
			else if(tempLine[0].equalsIgnoreCase("listCustomers"))
			{
				Hotel.printCustomerList();
			}
			else if(tempLine[0].equalsIgnoreCase("listReservations"))
			{
				
				Hotel.printReservationList();
				
			}
			
			else if(tempLine[0].equalsIgnoreCase("deletEmployee"))
			{
				Hotel.deletEmployee(Integer.parseInt(tempLine[1]));
			}
			else if(tempLine[0].equalsIgnoreCase("searchCustomer"))
			{
			
				Hotel.searchCustomer(tempLine[1]);
			
			}
			else if(tempLine[0].equalsIgnoreCase("searchRoom"))
			{
				SearchRoom(tempLine[1] ,tempLine[2]);
			}
			else if(tempLine[0].equalsIgnoreCase("statistics"))
			{
				theMostReservedRoom();
				theBestCustomer();
				incomeInformation();
				monthlyOccupancyRate();
			}
			else if(tempLine[0].equalsIgnoreCase("simulation"))
			{
				Date start=new Date(tempLine[1]);
				Date end=new Date(tempLine[2]);
				simulation(start,end);
				
			}
		}// end of while(infile.hasNext())
	}// end of ReadFile
	public static final String ANSI_MOR = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_SARI = "\u001B[33m";
	
	public static void addNewCustomer()
	{
		Scanner input=new Scanner(System.in);
		Customer temp=new Customer();
		System.out.println("Enter Customer Information ");
		System.out.print("Name :");
		temp.setName(input.nextLine());
		System.out.print("SurName :");
		temp.setSurname(input.nextLine());
		System.out.print("Gender :");
		temp.setGender(input.nextLine());
		System.out.print("Birthdate :");
		temp.setBirthdate(input.nextLine());
		System.out.print("Address :");
		temp.setAddress(input.nextLine());
		System.out.print("District :");
		temp.setDistrict(input.nextLine());
		System.out.print("City :");
		temp.setCity(input.nextLine());
		System.out.print("Phone Number :");
		temp.setPhone(input.nextLine());
		System.out.println("\n\n"+temp.getName()+" " +"Successfully Added!");
	
	}// end of addNewRoom
	public static void addNewEmployee()
	{
		Scanner input=new Scanner(System.in);
		Employee temp=new Employee();
		System.out.println("Enter Employee Information ");
		System.out.print("Name :");
		temp.setName(input.nextLine());
		System.out.print("SurName :");
		temp.setSurname(input.nextLine());
		System.out.print("Gender :");
		temp.setGender(input.nextLine());
		System.out.print("Birthdate :");
		temp.setBirthdate(input.nextLine());
		System.out.print("Address :");
		temp.setAddress(input.nextLine());
		System.out.print("District :");
		temp.setDistrict(input.nextLine());
		System.out.print("City :");
		temp.setCity(input.nextLine());
		System.out.print("Phone Number :");
		temp.setPhone(input.nextLine());
		System.out.print("Sallary :");
		temp.setSallary(input.nextInt());
		System.out.print("Work position :");
		temp.setWork(input.nextLine());
		System.out.println("\n\n"+temp.getName() +" "+"Successfully Added!");
		
	}
	public static void addNewRoom()
	{
		Scanner input=new Scanner(System.in);
		Room temp=new Room();
		System.out.println("Enter Room Information ");
		System.out.print("Type of room :");
		temp.setType(input.nextLine());
		System.out.print("Aircondition  :\n\n1)yes\t\t2)no\n\nSelect Aircodition information:");
		int n=input.nextInt();
		if(n==1)
			temp.setAircondition(true);
		else
			temp.setAircondition(false);
		System.out.print("Balcony  :\n\n1)yes\t\t2)no\n\nSelect Balcony information:");
		n=input.nextInt();
		if(n==1)
			temp.setBalcony(true);
		else
			temp.setBalcony(false);
		System.out.print("Price: :");						
		temp.setPrice(input.nextInt());
		System.out.println("\n\nRoom Successfully Added!");

	}
	public static void addNewReservation()
	{
		Reservation r;
		Scanner input=new Scanner(System.in);
		System.out.println("\n\nInput reservation information :");
		System.out.print("Customer Id :");
		int CustomerId=input.nextInt();
		if(CustomerId>0&&CustomerId<=Customer.getCount())
			System.out.println("You are Setting reservation for "+Customer.getNameAndSurname(CustomerId));
		System.out.print("Room Id :");
		int RoomId=input.nextInt();
		System.out.print("Start Date :");
		Date d1=new Date(input.next());
		if(d1.isDateTrue()==false)
			System.out.println("Reservation has not Completed! ");
		else
		{
			System.out.print("End Date :");
			Date d2=new Date(input.next());
			if(d2.isDateTrue()==false)
				System.out.println("Reservation has not Completed! ");
			else
		
				 r=new Reservation (CustomerId,RoomId,d1,d2);
		}
	}
	public static void SearchRoom()
	{
		Scanner input=new Scanner(System.in);
		System.out.print("Start Date : ");
		Date start=new Date(input.next());
		if(start.isDateTrue()==true)
		{
			System.out.print("End Date : ");
			Date end=new Date(input.next());
			if(end.isDateTrue()==true)	
			{
				System.out.println("\nSearchRoom : from  "+start.displyDate()+" to "+end.displyDate()+"\n" );
				for(int x=0;x<Room.getCount();x++)
					if(Hotel.getRoomFromId(x+1).isEmpty(start, end)==true)
						System.out.println("Room  #"+(x+1)+"  "+Hotel.getRoomFromId(x+1).displyRoom());		
			}
			
		}
	}
	public static void SearchRoom(String  s1 , String s2)
	{
		Date start=new Date(s1);
		if(start.isDateTrue()==true)
		{
			Date end=new Date(s2);
			if(end.isDateTrue()==true)
			
			{
				System.out.println("\nSearchRoom : from  "+start.displyDate()+" to "+end.displyDate()+"\n" );
				for(int x=0;x<Room.getCount();x++)
					if(Hotel.getRoomFromId(x+1).isEmpty(start, end)==true)
						System.out.println("Room  #"+(x+1)+"  "+Hotel.getRoomFromId(x+1).displyRoom());	
				
			}
			
		}
	}
	public static void theMostReservedRoom()
	{
		int max=0;
		int idOfMax=-1;
		for(int x=0;x<Room.getCount();x++)
		
			if(Hotel.getRoomFromId(x+1).getCountofReserved()>max)
				
			{
				max=Hotel.getRoomFromId(x+1).getCountofReserved();
				idOfMax=x+1;
				
			}
		
		System.out.println( ANSI_CYAN+"\nThe most reserved room : Room  #"+idOfMax);
	}
	public static void theBestCustomer()
	{
		int idOfMax=0;
		int max=0;
		for(int x=0;x<Customer.getCount();x++)
		
			if(Hotel.getCustomerFromCustomerID((x+1)).getCountReservedDay()>max)
			{
				max=Hotel.getCustomerFromCustomerID(x+1).getCountReservedDay();
				idOfMax=x+1;
			}
			
		System.out.println( ANSI_CYAN+"\nThe best customer : "+Customer.getNameAndSurname(idOfMax)+"  "+max+" days");
	}
	public static void incomeInformation()
	{
		int income=0;
		for(int x=0;x<Reservation.getCount();x++)
		
			income+=Hotel.getRezervationFromIndex(x).incomeFromReservation();
		
		System.out.println("Income :"+income+"\n");
		int sallary=0;
		for(int x=0;x<Employee.getCount();x++)
			sallary+=Hotel.getEmployeeFromIndex(x).getSallary();
		sallary*=12;
		System.out.println( ANSI_CYAN+"Sallary : "+sallary+"\n");

		int profit=income-sallary-120000;
		System.out.println( ANSI_CYAN+"profit ="+ profit);

		
			
	}
	public static void monthlyOccupancyRate()
	{
		int reservationCountForEchMonth[]=new int [12];//index [0] for count of  all reservation in 1st month..............index[11] for count of  all reservation in 12th month. 
		
		for (int x=0;x<Room.getCount();x++)
		
			for(int y=1;y<366;y++)
			
				if(Hotel.getRoomFromId(x+1).isEmpty(y)==false)
				{
					if(y<=31)
						reservationCountForEchMonth[0]++;
					else if(y>=32&&y<=60)
						reservationCountForEchMonth[1]++;
					else if(y>=61&&y<=91)
						reservationCountForEchMonth[2]++;
					else if(y>=92&&y<=121)
						reservationCountForEchMonth[3]++;
					else if(y>=122&&y<=152)
						reservationCountForEchMonth[4]++;
					else if(y>=153&&y<=182)
						reservationCountForEchMonth[5]++;
					else if(y>=183&&y<=213)
						reservationCountForEchMonth[6]++;
					else if(y>=214&&y<=244)
						reservationCountForEchMonth[7]++;
					else if(y>=245&&y<=274)
						reservationCountForEchMonth[8]++;
					else if(y>=275&&y<=305)
						reservationCountForEchMonth[9]++;
					else if(y>=306&&y<=335)
						reservationCountForEchMonth[10]++;
					else
						reservationCountForEchMonth[11]++;
				}// end of if room is not empty
		double monthlyOccupancy[]=new double[12];//index [0] for 1st month ........index [11] for 12th month
		System.out.println( ANSI_CYAN+"\n\nMonthly occupancy rate:\n\n");
		System.out.println( ANSI_CYAN+"1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\t\t11\t\t12");

			for(int x=0;x<12;x++)
			{
				if (x==0||x==2||x==4||x==6||x==7||x==9||x==11) // in this month we have 31 days
					monthlyOccupancy[x]=100.0*reservationCountForEchMonth[x]/(31*Room.getCount());
				else if(x==3||x==5||x==8||x==10)//in this month we have 30 days
					monthlyOccupancy[x]=100.0*reservationCountForEchMonth[x]/(30*Room.getCount());
				else
					monthlyOccupancy[x]=100.0*reservationCountForEchMonth[x]/(29*Room.getCount());
				System.out.print( ANSI_CYAN+Math.round(monthlyOccupancy[x])+"%\t\t");
			}
		
	}
	public static void simulation(Date d1,Date d2)
	{
		
		if(d1.calculateDateOfYear()<=d2.calculateDateOfYear()&&
				d1.isDateTrue()==true&&d2.isDateTrue()==true)
		{
			System.out.println("\n\nSimulation : from "+ d1.displyDate() + " to "+d2.displyDate() +"\n\n");
			System.out.print("Day :\t\t");
			int count=d2.calculateDateOfYear()-d1.calculateDateOfYear()+1;
			int customerCount[]=new int [count];
			for(int x=0;x<count;x++)
			{
				System.out.print(d1.getDay()+"\t\t");
				for(int y=0;y<Room.getCount();y++)
					if(Hotel.getRoomFromId(y+1).isEmpty(d1.calculateDateOfYear())==false)
						 customerCount[x]++;
				d1.goToNextDay();
			}
			System.out.print("\nCustomesr :\t");
			for(int x=0;x<count;x++)
				System.out.print(customerCount[x]+"\t\t");
		
			System.out.print("\nSatisfaction :\t");
			double sum=0;//for sum of Satisfaction
			for(int x=0;x<count;x++)
			{
				if(customerCount[x]==0)
				{
					System.out.print("100%"+"\t\t");
					sum+=100;
				}
				else
				{
					double Satisfaction=3.0*getCountOfHouseKeeper()/customerCount[x];
					if( Satisfaction>=1)
					{
						System.out.print("100%"+"\t\t");
						sum+=100;
					}
					else
					{
						Satisfaction=Satisfaction*100;
						System.out.print(Math.round(Satisfaction)+"%"+"\t\t");
						sum+=Satisfaction;

					}
				}
					
			}
			
			System.out.print("\nAverage Satisfaction :\t"+Math.round(sum/count)+"%");

		}
		
	}
	public static int getCountOfHouseKeeper()
	{
		int count=0;
		for(int x=0;x<Employee.getCount();x++)
			if(Hotel.getEmployeeFromIndex(x).getWork().equalsIgnoreCase("housekeeper"))
				count++;
		
		return count;
	
	}
}// end of class
