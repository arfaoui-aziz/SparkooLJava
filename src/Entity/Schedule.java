package Entity;

public class Schedule {
private int scheduleId;
private int classId;
private String Seance1;
private String Seance2;
private String Seance3;
private String Seance4;
private String Day;
private String Week;

    public Schedule(int classId, String seance1, String seance2, String seance3, String seance4, String day, String week) {
        this.classId = classId;
        Seance1 = seance1;
        Seance2 = seance2;
        Seance3 = seance3;
        Seance4 = seance4;
        Day = day;
        Week = week;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getSeance1() {
        return Seance1;
    }

    public void setSeance1(String seance1) {
        Seance1 = seance1;
    }

    public String getSeance2() {
        return Seance2;
    }

    public void setSeance2(String seance2) {
        Seance2 = seance2;
    }

    public String getSeance3() {
        return Seance3;
    }

    public void setSeance3(String seance3) {
        Seance3 = seance3;
    }

    public String getSeance4() {
        return Seance4;
    }

    public void setSeance4(String seance4) {
        Seance4 = seance4;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getWeek() {
        return Week;
    }

    public void setWeek(String week) {
        Week = week;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", classId=" + classId +
                ", Seance1='" + Seance1 + '\'' +
                ", Seance2='" + Seance2 + '\'' +
                ", Seance3='" + Seance3 + '\'' +
                ", Seance4='" + Seance4 + '\'' +
                ", Day='" + Day + '\'' +
                ", Week='" + Week + '\'' +
                '}';
    }
}
