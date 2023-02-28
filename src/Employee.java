import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.util.Locale;

public class Employee extends Staff implements  ICalculator{
    private double overtime;
    private double salary;
    //////// dinh dang lai hien thi ket qua cho double salary
    Locale locale = new Locale("en", "EN");
    String pattern = "#########.00";
    DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);

    ////////
    public Employee() {
        super();
    }
    public Employee(String id, String name, int age, double payRate, String startDay, int dayOff, String workingDepartment, double overtime) {
        super(id, name, age, payRate, startDay, dayOff, workingDepartment);
        this.overtime = overtime;
        this.salary = calculateSalary();
    }



    public void setOvertime(double overtime) {
        this.overtime = overtime;
    }

    public double getOvertime() {
        return overtime;
    }
    public void setSalary(){
        this.salary = calculateSalary();
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void displayInformation() {
        decimalFormat.applyPattern(pattern); // dinh dang lai hien thi ket qua cho double salary
        String maNhanVien = "Ma nhan vien     ";
        String tenNhanVien = "Ten nhan vien       ";
        String tuoi = "Tuoi      ";
        String hsLuong = "HS Luong      ";
        String ngayVaolam = "Ngay vao lam      ";
        String ngayNghiPhep = "Ngay nghi phep     ";
        String boPhan = "Bo phan                ";
        String soGioLamThem = "So gio lam them/Chuc vu     ";
        String luong = "Luong       ";

        int[] n = new int[9]; // tao array chua so khoang cach
        /// tinh khoang cach tung cot
            n[0] = maNhanVien.length() - this.getId().length();
            n[1] = tenNhanVien.length() - this.getName().length();
            n[2] = tuoi.length() - ("" + this.getAge()).length();
            n[3] = hsLuong.length() - ("" + this.getPayRate()).length();
            n[4] = ngayVaolam.length() - this.getStartDay().length();
            n[5] = ngayNghiPhep.length() - ("" + this.getDayOff()).length();
            n[6] = boPhan.length() - this.getWorkingDepartment().length();
            n[7] = soGioLamThem.length() - ("" + this.getOvertime()).length();
            n[8] = luong.length() - ("" + this.getSalary()).length();

        String[] space = new String[9]; // tao array chua khoang cach
        for (int i = 0; i < 9; i++) {
            space[i] = multiSpace(n[i]); //tao khoang cach de can chinh thanh tung cot
        }
        System.out.println(this.getId() + space[0] + "| " + this.getName() + space[1] + "| " + this.getAge() + space[2] + "| " + this.getPayRate() + space[3] + "| " + this.getStartDay() + space[4] + "| " + this.getDayOff() + space [5] + "| " + this.getWorkingDepartment() + space[6] + "| " + this.getOvertime() + space[7] +"| " + decimalFormat.format(this.getSalary()) + space[8]); //in ra thong tin
    }
    public double calculateSalary() {
        return (getPayRate() * 3000000) + (overtime * 200000);
    }
    public String multiSpace (int n) {
        String a = "";
        for (int i = 0; i < n; i++) {
            a += " ";
        }
        return a;
    } // ham tao khoang cach theo tham so nhap vao
}

