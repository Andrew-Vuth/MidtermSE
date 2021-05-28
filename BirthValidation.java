public class BirthValidation extends Exception {
    public BirthValidation(){
        super("Date of birth must be in date Format!");
    }
    public BirthValidation(String msg){
        super(msg);
    }
}
