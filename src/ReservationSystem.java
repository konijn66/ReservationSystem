import java.util.ArrayList;
import java.util.Scanner;

public class ReservationSystem {
    public ArrayList<Integer> adding;
    public String NAME;
    public int count =0;
    public ArrayList<Reservation>reservations;
    public ArrayList<String> AllNames;
    public ArrayList<Integer>TimeForSort;
    public ArrayList<Integer> sum;
    public ArrayList<Capacity>capacities;

   /* public int priority;
    public int capacity=16;
    public boolean ReachedCapacity=false;
    public int y;
    public ArrayList <Integer> ResTime;
    public ArrayList<Integer>PeopleNum;
    //public ArrayList<String>allnames; */

    public ReservationSystem() {
        reservations = new ArrayList<Reservation>();
        TimeForSort = new ArrayList<Integer>();
        AllNames=new ArrayList<String>();
        adding=new ArrayList<Integer>();
        capacities=new ArrayList<Capacity>();
        sum=new ArrayList<Integer>();

        for(int x=0;x<24;x++){
            capacities.add(null);
            sum.add(null);
        }

        while(true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("type 1 to add a reservation");
            System.out.println("type 2 to cancel a reservation");
            System.out.println("type 3 to change a reservation");
            System.out.println("type 4 to sort and display all reservations");
            System.out.println("type 5 to exit reservation system");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("type the name of your party");
                    String pName = scanner.next();
                    AllNames.add(pName);
                    NAME = pName;
                    //System.out.println(pName+", "+NAME);
                    System.out.println("type the number of people in your party");
                    int pPplInParty = scanner.nextInt();
                    System.out.println("type the current time in hours, on the 24 hour clock");
                    int timeResMadeAt = scanner.nextInt();
                    System.out.println("type the time you would like your reservation for");
                    int timeResIsFor = scanner.nextInt();
                    AddRes(pName, pPplInParty, timeResMadeAt, timeResIsFor);
                    //DisplayRes();
                    break;
                case 2:
                System.out.println("type your party's name.");
                String cName=scanner.next();
                System.out.println("press 1 to confirm your cancellation, or 0 to exit and keep your reservation");
                int cConfirm=scanner.nextInt();
                CancelRes(cName, cConfirm);
                break;

                case 3:
                   System.out.println("What is the name of your party?");
                   String NameForChangeRes= scanner.next();
                    System.out.println("press 1 to change the time of your reservation or 2 to change the number of people");
                    int WhatToChange=scanner.nextInt();
                    System.out.println("type the new value to enter");
                    int NewValue= scanner.nextInt();
                    System.out.println("press 1 to confirm change");
                    int ConfirmChange= scanner.nextInt();
                    ChangeRes(WhatToChange, NewValue,ConfirmChange, NameForChangeRes);
                    break;

                case 4:
                    SortRes();
                case 5:
                    System.exit(0);
            }
           /* if(choice==5){
                System.exit();
            }
            //allnames = new ArrayList<String>(); */
        }
    }

    public static void main(String[] args) {
        ReservationSystem myReservationSystem=new ReservationSystem();
    }

    public void AddRes(String pName, int pPl, int timeMade, int time){
      /*  try {
            capacities.get(time);
        }
        catch(IndexOutOfBoundsException e){
            capacities.set();
        } */
        if(capacities.get(time)!=null){
            System.out.println("changing capacities");
            capacities.get(time).settotal(pPl);
            capacities.get(time).PrintPeople();
            sum.set(time, sum.get(time)+pPl);
            //System.out.println(sum.get(time));
            System.out.println("At "+time+", "+sum.get(time)+" seats will be filled.");
           /* int total=capacities.get(time);
            capacities.set(time, capacities.get(time) + pPl); */
        }
        if (capacities.get(time)==null){
            System.out.println("adding item to capacities");
            sum.set(time, pPl);  //time is what's out of bounds
           // System.out.println(sum.get(time));
            capacities.set(time, new Capacity(sum.get(time)));
            System.out.println("At "+time+", "+sum.get(time)+" seats will be filled.");
        }
       /* for(int a=0;a<capacities.size();a++){
            sum=sum+capacities.get(a).totalpeopleforhour;
        } */
       // adding.add(time, pPl);
       // System.out.println(adding);
        if (sum.get(time)<=16) {
            //System.out.println(count);
            reservations.add(new Reservation(pName, pPl, timeMade, time));
            TimeForSort.add(timeMade);
            reservations.get(count).PrintReservation();
            count = count + 1;
        }
        if(sum.get(time)>16){
            System.out.println("We were not able to make you a reservation, " +
                    "because we have reached capacity for that time. Please " +
                    "change the time for your reservation.");
        }
    }

    public void DisplayRes(){
        for (int x=0; x<reservations.size();x++)
            reservations.get(x).PrintReservation();
        System.out.println(TimeForSort);
    }

    public void CancelRes(String partyName, int confirmation){
        if (confirmation==1){
            if(AllNames.contains(partyName)==true){
                System.out.println(reservations.indexOf(partyName)+1);
                reservations.remove(reservations.indexOf(partyName)+1);
                System.out.println("Your reservation has been canceled");
           /* System.out.println(partyName+", "+NAME);
            if(partyName.equals(NAME)==true){ */
            }
        }

    }

    public void ChangeRes(int whattochange, int newvalue, int confirmchange, String nameforchangeres){
        if (confirmchange==1){
            if(AllNames.contains(nameforchangeres)) {
                if (whattochange == 1) {       //change time of reservation
                    reservations.get(reservations.indexOf(nameforchangeres)+1).settime(newvalue);
                }
                if (whattochange == 2) {      //change num of people for reservation
                    reservations.get(reservations.indexOf(nameforchangeres)+1).setpeople(newvalue);
                }
            }
        }
    }


    public void SortRes(){

        for (int x=0;x<reservations.size();x++){
            for(int a=0;a< reservations.size()-1;a++){
                if (TimeForSort.get(a)>TimeForSort.get(a+1)){
                    Reservation tempReservation=reservations.get(a);
                    reservations.set(a,reservations.get(a+1));
                    reservations.set(a+1,tempReservation);

                    int tempTime = TimeForSort.get(a);
                    TimeForSort.set(a, TimeForSort.get(a + 1));
                    TimeForSort.set(a + 1, tempTime);
                    //used chatGPT to figure out that I needed the three lines above
                }

            }
        }
       for(int x=0;x<reservations.size();x++) {
           reservations.get(x).PrintforSorted();
       }

        /* Collections.sort(TimeForSort);
        //System.out.println(reservations.size());
        System.out.println("all reservations, sorted");
        for(int x=0;x< reservations.size();x++){
            //System.out.println("testing 2");
            reservations.get(x).PrintforSorted();
        } */

       /* for (int x=0;x<grades.length;x++) {
            for (int a = 0; a < grades.length -1; a++) {
                if(grades[a] > grades[a+1]) {
                    int hold = grades[a];
                    grades[a]=grades[a+1];
                    grades[a+1]=hold;

                }

            }
        }
        for (int x=0;x<grades.length;x++) {
            System.out.println("grades["+x+"] = "+grades[x]);
        } */

    }

   /* public int getTimeResMade(){
        return reservations.get(y).timeResMade;
    }

    */

    //add reservation
    //cancel reservation
    //sort reservation
    //change reservation
    //display reservation- user input

    /* public void ChooseName(){
        ArrayList<String> allnames= (Arrays.asList("Sara Farmer, Jamison Fields, Annie Blanchard, " +
                        "Adler Marks, Monica Bradshaw ,Emory Soto ,Brynlee Callahan ,Quinton Ortega ," +
                        "Lilah Villa ,Clay Price ,Piper Russell ,Weston Valdez ,Diana Morrison ," +
                        "Maximus Evans ,Eliana Murphy ,Cameron Schultz ,Briella Lucero ,Felipe Palacios ," +
                        "Bria Tucker ,Ivan Esparza ,Ramona Brady ,Reed Rush ,Maleah Cox ,Connor Rios ," +
                        "Brooke Wall, Issac James, Quinn Mullen , Shepard Pena, Rachel Franklin , Simon Todd ," +
                        "Zariah Johnston, Felix Lam , Karina Medrano , Arian Pace , Giana Davila , Grey Becker , " +
                        "Laura O’Neill , Marcel Rose , Magnolia Stokes , Santana Manning , Jennifer Henson , " +
                        "Bellamy Garcia , Amelia Galvan , Kingsley Gonzales , Hadley Moreno , Myles Faulkner , " +
                        "Ansley Cantrell , Harris Delacruz , Celine Bravo , Genesis Rivers , Kiana Pruitt , Gatlin Newton , " +
                        "Braelynn Lam , Bodie Madden , Violette Strong , Axl Conner , Alondra Turner , Joshua Curtis , " +
                        "Alexis Diaz , Nathan Parker , Aubrey Dougherty , Brett Maxwell , Kyla Magana , Rey Powers , " +
                        "Michelle Davis , Lucas Galindo , Corinne Nava , Stefan Howe , Persephone Booker , Dominik Mora  " +
                        "Jemma Graham , Giovanni Alfaro , Yasmin Cline , Cullen Church , Ayleen Raymond , Maurice Trevino , " +
                        "Priscilla McCoy , Jett Potts , Ellison Mullen , Shepard May , Adriana Pham , Russell Contreras , " +
                        "Daniela Benitez , Justice David , Haylee Newman , Anderson Grimes , Braelyn Waters , Maximilian Lucas , " +
                        "Phoenix Velasquez , Sullivan Santos , Alana Cochran , Danny Moses , Karter Boyd , " +
                        "Dean James , Quinn Reynolds , Vincent Le , Myla Huffman , Chris Atkins , " +
                "Mina Villa , Clay Haley" ));
    } */


}
