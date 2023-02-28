import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Manager extends Staff implements  ICalculator{
    private String level;
    private double salary;
    ////// dinh dang lai hien thi ket qua cho double salary
    Locale locale = new Locale("en", "EN");
    String pattern = "#########.00";
    DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
    //////
    public Manager(String id, String name, int age, double payRate, String startDay, int dayOff, String workingDepartment, String level) {
        super(id, name, age, payRate, startDay, dayOff, workingDepartment);
        this.level = level;
        this.salary = calculateSalary();
    }
    public Manager(Employee nhanVien){
        this.setId(nhanVien.getId());
        this.setName(nhanVien.getName());
        this.setAge(nhanVien.getAge());
        this.setPayRate(nhanVien.getPayRate());
        this.setStartDay(nhanVien.getStartDay());
        this.setDayOff(nhanVien.getDayOff());
        this.setWorkingDepartment(nhanVien.getWorkingDepartment());
    }

    public Manager() {

    }
    public double getSalary() {
        return (double) salary;
    }

    public void setSalary() {
        this.salary = calculateSalary();
    }

    public Manager(String level){
        this.level = level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    public String getLevel(){
        return level;
    }

    @Override
        //tuong tu Employee
    void displayInformation() {
        decimalFormat.applyPattern(pattern);
        String maNhanVien = "Ma nhan vien   | ";
        String tenNhanVien = "Ten nhan vien     | ";
        String tuoi = "Tuoi    | ";
        String hsLuong = "HS Luong    | ";
        String ngayVaolam = "Ngay vao lam    | ";
        String ngayNghiPhep = "Ngay nghi phep   | ";
        String boPhan = "Bo phan              | ";
        String soGioLamThem = "So gio lam them/Chuc vu   | ";
        String luong = "Luong       ";

        int[] n = new int[9];

        n[0] = maNhanVien.length() - this.getId().length();
        n[1] = tenNhanVien.length() - this.getName().length();
        n[2] = tuoi.length() - ("" + this.getAge()).length();
        n[3] = hsLuong.length() - ("" + this.getPayRate()).length();
        n[4] = ngayVaolam.length() - this.getStartDay().length();
        n[5] = ngayNghiPhep.length() - ("" + this.getDayOff()).length();
        n[6] = boPhan.length() - this.getWorkingDepartment().length();
        n[7] = soGioLamThem.length() - ("" + this.getLevel()).length();
        n[8] = luong.length() - ("" + this.getSalary()).length();

        String[] space = new String[9];
        for (int i = 0; i < 9; i++) {
            space[i] = multiSpace(n[i]);
        }
        System.out.println(this.getId() + space[0] + "| " + this.getName() + space[1] + "| " + this.getAge() + space[2] + "| " + this.getPayRate() + space[3] + "| " + this.getStartDay() + space[4] + "| " + this.getDayOff() + space [5] + "| " + this.getWorkingDepartment() + space[6] + "| " + this.getLevel() + space[7] +"| " + decimalFormat.format(this.getSalary()) + space[8]);
    }

    @Override
    public double calculateSalary() { //tinh luong phu hop theo chuc danh cua quan ly
        int levelSalary = 0;
        if (level.equalsIgnoreCase("Business Leader")) {levelSalary = 8000000;}
        else if (level.equalsIgnoreCase("Project Leader")) {levelSalary = 5000000;}
        else if (level.equalsIgnoreCase("Technical Leader")) {levelSalary = 6000000;}

        return (getPayRate() * 5000000) + levelSalary;
    }
    public String multiSpace (int n) {
        String a = "";
        for (int i = 0; i < n; i++) {
            a += " ";
        }
        return a;
    } //ham tao khoang cach
}
