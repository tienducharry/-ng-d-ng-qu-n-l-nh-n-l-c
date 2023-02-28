abstract class Staff {
    private String id;
    private String name;
    private int age;
    private double payRate;
    private String startDay;
    private String workingDepartment;
    private int dayOff;

    public Staff() {

    }
    public Staff(String id, String name, int age, double payRate, String startDay, int dayOff, String workingDepartment) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.payRate = payRate;
        this.startDay = startDay;
        this.workingDepartment = workingDepartment;
        this.dayOff = dayOff;
    }



    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setWorkingDepartment(String workingDepartment) {
        this.workingDepartment = workingDepartment;
    }

    public String getWorkingDepartment() {
        return workingDepartment;
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }
    abstract double calculateSalary();

    abstract void displayInformation();
}
