package ocp.comparable;

public class Users implements Comparable<Users>{

    private String name;
    private int age;

    public Users(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Users o) {
        if (o == null) throw new IllegalArgumentException("User object is null!");
        if (this.name == null && o.name == null) return 0;
        else if (this.name == null) return -1;
        else if (o.name == null) return 1;
        else return this.name.compareTo(o.name);
    }
}
