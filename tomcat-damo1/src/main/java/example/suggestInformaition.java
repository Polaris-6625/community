package example;

public class suggestInformaition {
    private int id;
    private String act;
    private String actClass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getActClass() {
        return actClass;
    }

    public void setActClass(String actClass) {
        this.actClass = actClass;
    }

    @Override
    public String toString() {
        return "suggestInformaition{" +
                "id=" + id +
                ", act='" + act + '\'' +
                ", actClass='" + actClass + '\'' +
                '}';
    }
}
