public class Reservation {
    public String name;
    int pplInGroup;
    int timeResMade;
    int timeResFor;


    public Reservation(String Rname, int RpplInGroup, int RtimeResMade, int RtimeResFor){
        name=Rname;
        pplInGroup=RpplInGroup;
        timeResMade=RtimeResMade;
        timeResFor=RtimeResFor;
    }

    public void PrintReservation(){
        System.out.println(name+" made a reservation for "+pplInGroup+" people at "+timeResFor+" today. " +
                "They made the reservation at "+timeResMade+ " yesterday");
    }

    public void PrintforSorted(){
        System.out.println(timeResMade+" o 'clock: "+name+" made a " +
                "reservation for "+timeResFor+" o 'clock today, table for "+pplInGroup);
    }

    public void settime(int newTime){
       timeResMade=newTime;
    }

    public void setpeople(int newPeople){
        pplInGroup=newPeople;
    }

    public int getTimeResMade(){
        return timeResMade;
    }
    //constructor
    //print method


}
