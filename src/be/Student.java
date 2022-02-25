package be;

public class Student {

    private final int id;
    String name;

    public Student(int id, String name){
        this.id=id;
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public int getID(){
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
