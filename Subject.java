public class Subject {
    private String subjectID;
    private String nameSubject;
    private int tinChi;
    private float mark;

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getTinChi() {
        return tinChi;
    }

    public void setTinChi(int tinChi) {
        this.tinChi = tinChi;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
    public Subject(String subjectID, String nameSubject, int tinChi, float mark){
        this.subjectID = subjectID;
        this.nameSubject = nameSubject;
        this.tinChi = tinChi;
        this.mark = mark;
    }
}
