import java.util.ArrayList;

public class Student {
    private String name;
    private String studentID;
    private String classID;
    private String birth;
    private String sex;
    private ArrayList<Subject> subjectArrayList = new ArrayList<Subject>();

    public Student(String name, String studentID, String classID, String birth, String sex, ArrayList<Subject> subjectArrayList){
        this.name = name;
        this.studentID = studentID;
        this.classID = classID;
        this.birth = birth;
        this.subjectArrayList = subjectArrayList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ArrayList<Subject> getSubjectArrayList() {
        return subjectArrayList;
    }

    public void setSubjectArrayList(ArrayList<Subject> subjectArrayList) {
        this.subjectArrayList = subjectArrayList;
    }
}
