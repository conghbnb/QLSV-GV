import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("*********MENU**********");
        System.out.println("1. Tạo một anh Sinh viên");
        System.out.println("2. Tạo một Giáo viên");
        System.out.println("3. Hiển thị tất cả Sinh Viên kèm điểm tổng kết");
        System.out.println("4. Hiển thị tất cả Giáo viên");
        System.out.println("5. Hiển thị theo lớp");
        System.out.println("6. Sửa thông sinh viên hoặc Giáo viên");
        System.out.println("7. Sửa điểm học phần theo mã học phần");
        System.out.println("8. Xoá toàn bộ thông tin theo mã SV");
        System.out.println("0. Exit!!!");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        ArrayList<Teacher> teacherArrayList = new ArrayList<Teacher>();
        for(; ;){
            System.out.println("***Không làm mà muốn có ăn thì chọn đi nào***");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 0:
                    System.out.println("Tạm biệt!!!");
                    System.exit(0);
                    break;
                case 1:
                    System.out.printf("Fill fullname, pls!!!    ");
                    String name = scanner.nextLine();
                    System.out.printf("Fill studentID, pls!!!   ");
                    String studentID = scanner.nextLine();
                    System.out.printf("Fill classID, pls!!!     ");
                    String classID = scanner.nextLine();
                    System.out.printf("Fill birth, pls!!!   ");
                    String birth = scanner.nextLine();
                    System.out.printf("Fill sex, pls!!!     ");
                    String sex = scanner.nextLine();
                    System.out.printf("Nhập số học phần:    ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    ArrayList<Subject> subjectArrayList = new ArrayList<Subject>();
                    for (int i = 0; i < n; i++){
                        System.out.println("Nhập thông tin học phần "+(i+1)+": ");
                        System.out.printf("    Fill SubjectID, pls!!!   ");
                        String subjectID = scanner.nextLine();
                        System.out.printf("    Fill NameSubject, pls!!!    ");
                        String nameSubject = scanner.nextLine();
                        System.out.printf("    Fill so tín chỉ, pls!!! ");
                        int tinChi =  scanner.nextInt();
                        System.out.printf("    Fill mark, pls!!!   ");
                        float mark = scanner.nextFloat();
                        scanner.nextLine();
                        Subject subject = new Subject(subjectID, nameSubject, tinChi, mark);
                        subjectArrayList.add(subject);
                    }
                    Student student = new Student(name, studentID, classID, birth, sex, subjectArrayList);
                    studentArrayList.add(student);
                    System.out.println("Thêm sinh viên thành công!!!");
                break;
                case 2:
                    System.out.printf("Fill fullname Teacher, pls!!!    ");
                    String name1 = scanner.nextLine();
                    System.out.printf("Fill teacherID, pls!!!   ");
                    String teacherID = scanner.nextLine();
                    System.out.printf("Fill classID, pls!!!     ");
                    String classID1 = scanner.nextLine();
                    System.out.printf("Fill birth, pls!!!   ");
                    String birth1 = scanner.nextLine();
                    System.out.printf("Fill sex, pls!!!     ");
                    String sex1 = scanner.nextLine();
                    Teacher teacher = new Teacher(name1, teacherID, classID1, birth1, sex1);
                    teacherArrayList.add(teacher);
                    System.out.println("Bạn đã thêm Giáo Viên thành công!!!");
                break;
                case 3:
                    if (studentArrayList.size() == 0)
                        System.out.println("Chưa có Sinh Viên trên hệ thống");
                    else {
                        System.out.println("*****DANH SACH SINH VIEN***** ");
                        float summark = 0, sumtinchi = 0;
                        for (Student st : studentArrayList) {
                            System.out.println("Fullname : " + st.getName());
                            System.out.println("    + StudentID : " + st.getStudentID());
                            System.out.println("    + Class : " + st.getClassID());
                            System.out.println("    + Birth : " + st.getBirth());
                            System.out.println("    + Sex : " + st.getSex());
                            System.out.println("    + Các học phần đã học: ");
                            for (Subject sj : st.getSubjectArrayList()) {
                                System.out.println("        *Namesubject :   " + sj.getNameSubject());
                                System.out.println("            SubjectID :    " + sj.getSubjectID());
                                System.out.println("            So tin chi :    " + sj.getTinChi());
                                System.out.println("            Mark :     " + sj.getMark());
                                summark += sj.getMark() * sj.getTinChi();
                                sumtinchi += sj.getTinChi();
                            }
                            System.out.println("            avgMark :    " + summark / sumtinchi);
                        }
                    }
                break;
                case 4:
                    if (teacherArrayList.size() == 0)
                        System.out.println("Chưa có Giáo Viên nào trong hệ thống!!!");
                    else {
                        System.out.println("***DANH SÁCH GIÁO VIÊN***");
                        for (Teacher tc : teacherArrayList) {
                            System.out.println("Fullname :  "+tc.getName());
                            System.out.println("    TeacherID : "+tc.getTeacherID());
                            System.out.println("    ClassID :   "+tc.getClassID());
                            System.out.println("    Birth :     "+tc.getBirth());
                            System.out.println("    Sex :       "+tc.getSex());
                        }
                    }
                break;
                case 5:
                    int dem1 = 0, dem2 = 0;
                    System.out.printf("Nhập ClassID cần tìm: ");
                    String classID2 = scanner.nextLine();
                    System.out.println("Giáo viên trong lớp :");
                    for (int i = 0; i < teacherArrayList.size(); i++){
                        if (teacherArrayList.get(i).getClassID().equals(classID2) ) {
                            System.out.println("    + " + teacherArrayList.get(i).getName());
                            dem1++;
                        }
                    }
                    System.out.println("Sinh Viên trong lớp: ");
                    for (int i = 0; i < studentArrayList.size(); i++){
                        if (studentArrayList.get(i).getClassID().equals(classID2) ) {
                            System.out.println("    + " + studentArrayList.get(i).getName());
                            dem2++;
                        }
                    }
                    if (dem2 == 0 && dem1 == 0) System.out.println("*Không tồn tại lớp*");
                break;
                case 6:
                    System.out.println("Nhập mã SV hoặc Gv cần sửa thông tin: ");
                    String id = scanner.nextLine();
                    int tp = 0;
                    for (int i = 0; i < studentArrayList.size(); i++) {
                        if (id.equals(studentArrayList.get(i).getStudentID())) {
                            System.out.println("Nhập thông tin mới: ");
                            System.out.printf("     Fullname :  ");
                            studentArrayList.get(i).setName(scanner.nextLine());
                            System.out.printf("     StudentID : ");
                            studentArrayList.get(i).setStudentID(scanner.nextLine());
                            System.out.printf("     ClassID : ");
                            studentArrayList.get(i).setClassID(scanner.nextLine());
                            System.out.printf("     Birth : ");
                            studentArrayList.get(i).setBirth(scanner.nextLine());
                            System.out.printf("     Sex : ");
                            studentArrayList.get(i).setSex(scanner.nextLine());
                            tp = 1;
                            break;
                        }
                    }
                        if (tp == 0){
                            for ( int i = 0; i < teacherArrayList.size(); i++) {
                                if (id.equals(teacherArrayList.get(i).getTeacherID())) {
                                    System.out.println("Nhập thông tin mới: ");
                                    System.out.printf("     Fullname :  ");
                                    teacherArrayList.get(i).setName(scanner.nextLine());
                                    System.out.printf("     TeacherID : ");
                                    teacherArrayList.get(i).setTeacherID(scanner.nextLine());
                                    System.out.printf("     ClassID : ");
                                    teacherArrayList.get(i).setClassID(scanner.nextLine());
                                    System.out.printf("     Birth : ");
                                    teacherArrayList.get(i).setBirth(scanner.nextLine());
                                    System.out.printf("     Sex : ");
                                    teacherArrayList.get(i).setSex(scanner.nextLine());
                                    tp = 1;
                                    break;
                                }
                            }
                        }
                        if (tp == 0) System.out.println("KHông tìm thấy SV hoặc GV nào :((\n");
                break;
                case 7:
                    System.out.println("Nhập StudentID cần sửa điểm: ");
                    String studentID4 = scanner.nextLine();
                    int tp1 = 0;
                    for (int i = 0; i < studentArrayList.size(); i++){
                        if (studentID4.equals(studentArrayList.get(i).getStudentID())){
                            System.out.printf("Nhập mã học phần cần sửa điểm : ");
                            String subjectID = scanner.nextLine();
                            for (int j = 0; j < studentArrayList.get(i).getSubjectArrayList().size();j++){
                                if (subjectID.equals(studentArrayList.get(i).getSubjectArrayList().get(j).getSubjectID())){
                                    System.out.println("Nhập điểm mới : ");
                                    studentArrayList.get(i).getSubjectArrayList().get(j).setMark(scanner.nextFloat());
                                    tp1 = 1;
                                    break;
                                }
                            }
                        }
                    }
                    if (tp1 == 0) System.out.println("Sai mã SV hoặc mã học phần");
                break;

                case 8:
                    int dem = 0;
                    System.out.printf("Nhập mã sinh viên cần xoá: ");
                    String studentID1 = scanner.nextLine();
                    for (int i=0 ; i<studentArrayList.size() ; i++){
                        if(studentID1.equals(studentArrayList.get(i).getStudentID())) {
                            studentArrayList.remove(i);
                            dem++;
                        }
                    }
                    if (dem == 0) System.out.println("Không tìm thấy sinh viên");
                break;

            }
        }
    }
}
