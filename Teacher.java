public class Teacher {
    private String teacherID;
    private String classID;
    private String name;
    private String birth;
    private String sex;

    public void setTeacherID(String teacherID){
        this.teacherID = teacherID;
    }
    public String getTeacherID(){
        return teacherID;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public Teacher(String name, String teacherID, String classID, String birth, String sex){
        this.name = name;
        this.teacherID = teacherID;
        this.classID = classID;
        this.birth = birth;
        this.sex = sex;
    }
}
