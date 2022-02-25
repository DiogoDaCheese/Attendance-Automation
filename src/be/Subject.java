package be;

public class Subject {

    int id;
    String name;
    //String weekday;

    //public Subject(int id, String name, String weekday){
    public Subject(int id, String name){
        this.id=id;
        this.name=name;
        //this.weekday=weekday;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    /*public String getWeekday(){
        return weekday;
    }*/

    @Override
    public String toString() {
        return name;
    }
}
