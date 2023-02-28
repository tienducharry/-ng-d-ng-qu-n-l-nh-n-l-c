import java.util.ArrayList;
import java.util.List;

public class Department {
    private String id;
    private int numberOfStaff;
    private String name;
    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public void setNumberOfStaff(int numberOfStaff) {
        this.numberOfStaff = numberOfStaff;
    }

    public int getNumberOfStaff() {
        return numberOfStaff;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() { //ham hien thi thong tin bo phan
        String maBoPhan = "Ma bo phan   | ";
        String tenBoPhan = "Ten bo phan                 | ";
        String soNv = "So luong nhan vien hien tai  ";
        /// tinh khoang cach cho tung cot
        int n1 = maBoPhan.length() - this.id.length();
        int n2 = tenBoPhan.length() - this.name.length();
        int n3 = soNv.length() - ("" + this.numberOfStaff).length();

        //goi them ham multispace de can chinh cot
        return  (this.id + multiSpace(n1) +"| " + this.name + multiSpace(n2) + "| " + this.numberOfStaff + multiSpace(n3));

    }
    public String multiSpace (int n) {
        String a = "";
        for (int i = 0; i < n; i++) {
            a += " ";
        }
        return a;
    } //ham tao khoang cach

}
