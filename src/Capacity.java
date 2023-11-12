public class Capacity {
    public int totalpeopleforhour;

    public Capacity(int Ctotalpeopleforhour){
        totalpeopleforhour=Ctotalpeopleforhour;

    }

    public void settotal(int toadd){
        totalpeopleforhour=totalpeopleforhour+toadd;
    }

    public void PrintPeople(){
        System.out.println(totalpeopleforhour);
    }


}
