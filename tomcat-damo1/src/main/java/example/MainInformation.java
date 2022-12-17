package example;

public class MainInformation {
    private int id;
    private String number;
    private String lcofhome;
    private String mofhome;
    private String hofhome;
    private String cofhome;
    private int singlemoney;
    private float sofhome;
    private String description;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLcofhome() {
        return lcofhome;
    }

    public void setLcofhome(String lcofhome) {
        this.lcofhome = lcofhome;
    }

    public String getMofhome() {
        return mofhome;
    }

    public void setMofhome(String mofhome) {
        this.mofhome = mofhome;
    }

    public String getHofhome() {
        return hofhome;
    }

    public void setHofhome(String hofhome) {
        this.hofhome = hofhome;
    }

    public String getCofhome() {
        return cofhome;
    }

    public void setCofhome(String cofhome) {
        this.cofhome = cofhome;
    }

    public int getSinglemoney() {
        return singlemoney;
    }

    public void setSinglemoney(int singlemoney) {
        this.singlemoney = singlemoney;
    }

    public float getSofhome() {
        return sofhome;
    }

    public void setSofhome(float sofhome) {
        this.sofhome = sofhome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MainInformation{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", lcofhome='" + lcofhome + '\'' +
                ", mofhome='" + mofhome + '\'' +
                ", hofhome='" + hofhome + '\'' +
                ", cofhome='" + cofhome + '\'' +
                ", singlemoney=" + singlemoney +
                ", sofhome=" + sofhome +
                ", description='" + description + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
