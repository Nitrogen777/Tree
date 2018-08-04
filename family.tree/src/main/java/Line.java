public class Line {
    private Person p1;
    private Person p2;
    private Person p3;
    private String name;

    @Override
    public String toString() {
        return "Line{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }

    public Line(Person p1, Person p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.name = "" + p1.getName() + "-" + p2.getName();
    }

    public Line(Person p1, Person p2, Person p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.name = "" + p1.getName() + "-" + p2.getName()+"-"+p3.getName();
    }

    public Person getP1() {
        return p1;
    }

    public void setP1(Person p1) {
        this.p1 = p1;
    }

    public Person getP2() {
        return p2;
    }

    public void setP2(Person p2) {
        this.p2 = p2;
    }

    public Person getP3() {
        return p3;
    }

    public void setP3(Person p3) {
        this.p3 = p3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
