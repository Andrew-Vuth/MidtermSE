import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Student {
    static Scanner sc = new Scanner(System.in);
    private int id;
    private String name;
    private Date dob;
    private String tel;
    private String city;
    private String country;
    private String group;

  


    public Student() {
    }

    public Student(int id, String name, Date dob, String tel, String city, String country, String group) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.tel = tel;
        this.city = city;
        this.country = country;
        this.group = group;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student id(int id) {
        setId(id);
        return this;
    }

    public Student name(String name) {
        setName(name);
        return this;
    }

    public Student dob(Date dob) {
        setDob(dob);
        return this;
    }

    public Student tel(String tel) {
        setTel(tel);
        return this;
    }

    public Student city(String city) {
        setCity(city);
        return this;
    }

    public Student country(String country) {
        setCountry(country);
        return this;
    }
    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

  

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", dob='" + getDob() + "'" +
            ", tel='" + getTel() + "'" +
            ", city='" + getCity() + "'" +
            ", country='" + getCountry() + "'" +
            ", group='" + getGroup() + "'" +
            "}";
    }


  
    public static void addStudent() throws ParseException, BirthValidation, TelValidation, GroupNameValidation {
        Student newStudent = new Student();


        System.out.println(".........Adding student......\n\n");
        System.out.print("Input name: ");
        String name = sc.nextLine();
        System.out.print("Input id: ");
        int id = sc.nextInt();
        newStudent.setId(id);

        String empString = sc.nextLine();
        boolean isRunning = true;
        Date dob;
        String tel;
        String groupName;
        while(isRunning){
            System.out.print("Input date of birth [dd-MM-yyyy]: ");
            String str_dob = sc.nextLine();
            dob = new SimpleDateFormat("dd-MM-yyyy").parse(str_dob);

            Calendar cal = Calendar.getInstance();
            cal.setTime(dob);
            int year = cal.get(Calendar.YEAR);
    
            Date today = new Date();
            cal.setTime(today);
            int nowYear = cal.get(Calendar.YEAR);
    
            if(nowYear - year < 15 ){
                throw new BirthValidation("Student must be 15 years old up!");
            }else{
                isRunning = false;
                newStudent.setDob(dob);;

            }
            
        }
        isRunning = true;
        while(isRunning){
            System.out.print("Input telephone number [ex: +855 010 23 23 12]: ");
            tel = sc.nextLine();
            String khTel = "+855";
            String indicator = "";
            for(int i =0; i<4; i++){
                indicator = indicator+tel.charAt(i);
            }
            if(!indicator.equals(khTel)){
                throw new TelValidation();
            }else{
                isRunning = false;
                newStudent.setTel(tel);
            }
        }

        System.out.print("Input city: ");
        String city = sc.nextLine();
        newStudent.setCity(city);
        System.out.print("Input country: ");
        String country= sc.nextLine();
        newStudent.setCountry(country);

        isRunning = true;
        while(isRunning){
            System.out.print("Input group name [I4A, I4B]:");
            groupName = sc.nextLine();

            char engineer = 'I';
            char tech = 'T';
            
            char first = groupName.charAt(0);
            char second = groupName.charAt(1);
            char third = groupName.charAt(2);

            int year = Integer.parseInt(String.valueOf(second));

            if(groupName.length()>3){
                throw new GroupNameValidation();
            }else if(!groupName.contains("I") && !groupName.contains("T")){
                throw new GroupNameValidation("Group name must starts with I or T");
            }
            if(Character.compare(first,engineer)==0){
                if(year == 0 || year >5){
                    throw new GroupNameValidation("Year must be between 1 to 5");
                }
            }
            if(Character.compare(first,tech)==0){
                if(year == 0 || year >2){
                    throw new GroupNameValidation("Year must be between 1 to 2");
                }
            }
            if(!Character.isUpperCase(third)){
                throw new GroupNameValidation("Label must be Latin Alphabets!");
            }
        
            isRunning = false;
            newStudent.setGroup(groupName);
            
            System.out.println(newStudent);
           
        }


       

    }
    public static void main(String[] args) throws ParseException, BirthValidation, TelValidation, GroupNameValidation {
        addStudent();
    }
   
    

}
