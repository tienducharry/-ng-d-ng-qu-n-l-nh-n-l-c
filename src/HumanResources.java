import java.util.*;
class HumanResources {
    Scanner sc = new Scanner(System.in);
    ///tao array list chua toan bo nhan vien trong cong ty
    List<Staff> allStaff = new ArrayList<>();
    //// khoi tao thong tin ve 3 bo phan
    Department hc = new Department("HC", "Hanh chinh nhan su");
    Department it = new Department("IT", "Cong nghe thong tin");
    Department mkt = new Department("MKT", "Marketing");

    int choice;
    public static void main(String[] agrs){

        HumanResources hm = new HumanResources();
        hm.createInfo();
        do{hm.menu0();} while (hm.choice != 0);


    }
    public void createInfo(){
        Manager ntl = new Manager("M003", "Nguyen Thuy Linh", 34, 4.5, "3/3/2016", 4, "Hanh chinh nhan su", "Business Leader");
        Manager tvl = new Manager("M002", "Ta Van Luc", 32, 4.5, "01/11/2010", 1, "Cong nghe thong tin", "Technical Leader");
        Manager nva = new Manager("M001", "Nguyen Van An", 25, 2.5, "11/11/2010", 5, "Cong nghe thong tin", "Business Leader");
        Employee pth = new Employee("E001", "Phong Tuyet Hoa", 28, 3.2, "10/10/2010", 10, "Hanh chinh nhan su", 4.0);
        Employee nvq = new Employee("E003", "Ngo Van Que", 23, 2.1, "2/2/2020", 3, "Hanh chinh nhan su", 5.0);
        Employee ttb = new Employee("E002", "Tran Thi B", 24, 2.2, "09/10/2019", 7, "Hanh chinh nhan su", 3.0);
        allStaff.add(ntl);
        allStaff.add(tvl);
        allStaff.add(nva);
        allStaff.add(pth);
        allStaff.add(nvq);
        allStaff.add(ttb);
    } //ham khoi tao du lieu vi du ve nhan vien
    public void employEnter(Employee nhanVien){
        System.out.print("Nhap ma nhan vien: ");
        nhanVien.setId(sc.next());
        System.out.print("Nhap ten nhan vien: ");
        sc.nextLine(); /////
        nhanVien.setName(sc.nextLine());

        System.out.print("Nhap tuoi nhan vien: ");
        nhanVien.setAge(sc.nextInt());
        System.out.print("Nhap he so luong cua nhan vien: ");
        nhanVien.setPayRate(sc.nextDouble());
        System.out.print("Nhap ngay vao lam cua nhan vien: ");
        sc.nextLine(); //////
        nhanVien.setStartDay(sc.nextLine());

        System.out.print("Nhap so ngay nghi phep cua nhan vien: ");
        nhanVien.setDayOff(sc.nextInt());
        System.out.println("1. HC - Hanh chinh nhan su");
        System.out.println("2. IT - Cong nghe thong tin");
        System.out.println("3. MKT - Marketing");
        System.out.print("Ban chon bo phan: ");
        int departChoice = sc.nextInt();
        if (departChoice == 1) {
            nhanVien.setWorkingDepartment("Hanh chinh nhan su");
        } else if (departChoice == 2) {
            nhanVien.setWorkingDepartment("Cong nghe thong tin");
        } else if (departChoice == 3) {
            nhanVien.setWorkingDepartment("Marketing");
        }
    } //ham nhap du lieu nhan vien noi chung

    public void menu0(){
        System.out.println("1. Hien thi danh sach nhan vien hien co trong cong ty.");
        System.out.println("2. Hien thi cac bo phan trong cong ty.");
        System.out.println("3. Hien thi cac nhan vien theo tung bo phan.");
        System.out.println("4. Them nhan vien moi vao cong ty.");
        System.out.println("5. Tim kiem thong tin nhan vien theo ten hoac ma nhan vien.");
        System.out.println("6. Hien thi bang luong cua nhan vien toan cong ty.");
        System.out.println("7. Hien thi bang luong cua nhan vien theo thu tu tang dan.");
        System.out.println("0. Thoat chuong trinh.");
        System.out.print("Lua chon cua ban: ");
        choice = sc.nextInt();
        if (choice == 1) {menu1();}  /// goi menu theo so nhap vao
        else if (choice == 2) {menu2();}
        else if (choice == 3) {menu3();}
        else if (choice == 4) {menu4();}
        else if (choice == 5) {menu5();}
        else if (choice == 6) {menu6();}
        else if (choice == 7) {menu7();}
        else {System.out.println("Ban da thoat.");}
    } //giao dien menu ban dau
    public void menu1(){
        // tao tile cho bang hien thi
        System.out.println(createTitle());
        /////
        int nDash = createTitle().length();
        System.out.println(multiDash(nDash));

        for (int i = 0; i < allStaff.size(); i++) {
            allStaff.get(i).displayInformation();
        }

        menu0();
    }
    public void menu2(){
        String maBoPhan = "Ma bo phan     | ";
        String tenBoPhan = "Ten bo phan                   | ";
        String soNv = "So luong nhan vien hien tai    ";
        System.out.println(maBoPhan + tenBoPhan + soNv);
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; i < allStaff.size(); i++) {
            if (allStaff.get(i).getWorkingDepartment().equalsIgnoreCase(hc.getName())) {
                n1++;}

            if (allStaff.get(i).getWorkingDepartment().equalsIgnoreCase(it.getName())) {
                n2++;}

            if (allStaff.get(i).getWorkingDepartment().equalsIgnoreCase(mkt.getName())) {
                n3++;}
        }
        hc.setNumberOfStaff(n1);
        it.setNumberOfStaff(n2);
        mkt.setNumberOfStaff(n3);

        System.out.println(hc.toString());
        System.out.println(it.toString());
        System.out.println(mkt.toString());
        menu0();

    }
    public void menu3(){
        String[] list = {"Hanh chinh nhan su", "Cong nghe thong tin", "Marketing"};
        //duyet qua danh sach cac phong ban
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
            System.out.println(multiDash(30));
            System.out.println(createTitle());
            //duyet qua tung nhan vien
            for (int j = 0; j < allStaff.size(); j++) {
                if(allStaff.get(j).getWorkingDepartment().equalsIgnoreCase(list[i])) allStaff.get(j).displayInformation();
            }
            System.out.println();
        }
//        //hien thi danh sach nhan vien HC
//        System.out.println("Hanh chinh nhan su");
//        System.out.println(multiDash(30));
//
//        System.out.println(createTitle());
//        for (int i = 0; i < allStaff.size(); i++) {
//            if(allStaff.get(i).getWorkingDepartment().equalsIgnoreCase("Hanh chinh nhan su")) allStaff.get(i).displayInformation();
//        }
//        System.out.println();
//        //hien thi danh sach nhan vien IT
//        System.out.println("Cong nghe thong tin");
//        System.out.println(multiDash(30));
//        System.out.println(createTitle());
//
//        for (int i = 0; i < allStaff.size(); i++) {
//            if(allStaff.get(i).getWorkingDepartment().equalsIgnoreCase("Cong nghe thong tin")) allStaff.get(i).displayInformation();
//        }
//        System.out.println();
//        //hien thi danh sach nhan vien mkt
//        System.out.println("Marketing");
//        System.out.println(multiDash(30));
//        System.out.println(createTitle());
//
//        for (int i = 0; i < allStaff.size(); i++) {
//            if(allStaff.get(i).getWorkingDepartment().equalsIgnoreCase("Marketing")) allStaff.get(i).displayInformation();
//        }
//        System.out.println();
        menu0();
    }
    public void menu4(){
        Employee nhanVien = new Employee();
        System.out.println("1. Them nhan vien thong thuong");
        System.out.println("2. Them nhan vien la cap quan ly (co them chuc vu)");
        System.out.print("Ban chon: ");
        int typeChoice = sc.nextInt();
        if(typeChoice == 1) {
            employEnter(nhanVien);
            nhanVien.setSalary();
            allStaff.add(nhanVien);
        } else if (typeChoice == 2) {
            employEnter(nhanVien);
            Manager quanLy = new Manager(nhanVien);
        System.out.println("Chuc danh:");
        System.out.println("1. Business Leader");
        System.out.println("2. Project Leader");
        System.out.println("3. Technical Leader");
            System.out.print("Nhap chuc danh: ");
            int levelChoice = sc.nextInt();
            if (levelChoice == 1) {quanLy.setLevel("Business Leader");}
            else if (levelChoice == 2) {quanLy.setLevel("Project Leader");}
            else if (levelChoice == 3) {quanLy.setLevel("Technical Leader");}
        quanLy.setSalary();
        allStaff.add(quanLy);
    }}
    public void menu5(){
        System.out.println("1. Tim nhan vien bang ten:");
        System.out.println("2. Tim nhan vien bang ma nhan vien");
        System.out.print("Ban chon: ");
        int choice5 = sc.nextInt();
        System.out.println();
        if (choice5 == 1) {
            System.out.println("Nhap ten nhan vien can tim:");
            String name5 = sc.next().toLowerCase();
            System.out.println(createTitle());
            for (int i = 0; i < allStaff.size(); i++) {
                if (allStaff.get(i).getName().toLowerCase().contains(name5)) allStaff.get(i).displayInformation();
            }
            System.out.println(multiDash(50));
            menu0();
        } else if (choice5 == 2) {
            System.out.println("Nhap ma nhan vien can tim:");
            String id5 = sc.next().toLowerCase();

            System.out.println(createTitle());
            for (int i = 0; i < allStaff.size(); i++) {
                if (allStaff.get(i).getId().toLowerCase().contains(id5)) allStaff.get(i).displayInformation();
            }
            System.out.println(multiDash(50));
            menu0();
        }
    }
    public void menu6(){
        System.out.println(createTitle());

        List<Double> upSortedList = new ArrayList<>();

        for (int i = 0; i < allStaff.size(); i++) {
            upSortedList.add(allStaff.get(i).calculateSalary());
        }

        upSortedList.sort(Comparator.naturalOrder());
        for (int i = 0; i < allStaff.size(); i++) {
                for (int j = 0; j < upSortedList.size(); j++) {
                    if(upSortedList.get(i) == allStaff.get(j).calculateSalary()) {
                        allStaff.get(j).displayInformation();
                        continue;}
            }
        }
        menu0();
    }
    public void menu7(){
        System.out.println(createTitle());

        List<Double> downSortedList = new ArrayList<>();


        for (int i = 0; i < allStaff.size(); i++) {
            downSortedList.add(allStaff.get(i).calculateSalary());
        }
        downSortedList.sort(Comparator.reverseOrder());
        for (int i = 0; i < allStaff.size(); i++) {
            for (int j = 0; j < downSortedList.size(); j++) {
                if(downSortedList.get(i) == allStaff.get(j).calculateSalary()) {
                    allStaff.get(j).displayInformation();
                    continue;}
            }
        }
        menu0();
    }
    public String createTitle(){
        String maNhanVien = "Ma nhan vien     ";
        String tenNhanVien = "Ten nhan vien       ";
        String tuoi = "Tuoi      ";
        String hsLuong = "HS Luong      ";
        String ngayVaolam = "Ngay vao lam      ";
        String ngayNghiPhep = "Ngay nghi phep     ";
        String boPhan = "Bo phan                ";
        String soGioLamThem = "So gio lam them/Chuc vu     ";
        String luong = "Luong           ";
        return maNhanVien + "| " + tenNhanVien + "| " + tuoi + "| " + hsLuong + "| " + ngayVaolam + "| " + ngayNghiPhep + "| " + boPhan + "| " + soGioLamThem + "| " + luong;
    }

    public String multiDash (int n) {
        String b = "";
        for (int i = 0; i < n; i++) {
            b = b + "-";
        }
        return b;
    }
}
