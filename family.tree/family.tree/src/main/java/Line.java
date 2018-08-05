public class Line {
    private String p1name;
    private String p2name;
    private String p3name;
    private String name;

    @Override
    public String toString() {
        return "Line{" +
                "p1name='" + p1name + '\'' +
                ", p2name='" + p2name + '\'' +
                ", p3name='" + p3name + '\'' +
                ", name='" + name + '\'' +
                '}';
    }



    public Line(String p1name, String p2name) {
        this.p1name = p1name;
        this.p2name = p2name;
        this.name = "" + p1name + "-" + p2name;
    }

    public Line(String p1name, String p2name, String p3name) {
        this.p1name = p1name;
        this.p2name = p2name;
        this.p3name = p3name;
        this.name = "" + p1name + "-" + p2name+"-"+p3name;
    }

    public String getP1name() {
        return p1name;
    }

    public void setP1name(String p1name) {
        this.p1name = p1name;
    }

    public String getP2name() {
        return p2name;
    }

    public void setP2name(String p2name) {
        this.p2name = p2name;
    }

    public String getP3name() {
        return p3name;
    }

    public void setP3name(String p3name) {
        this.p3name = p3name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
