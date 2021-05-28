public class GroupNameValidation extends Exception {
    public GroupNameValidation(){
        super("Invalid group name");
    }
    public GroupNameValidation(String txt){
        super(txt);
    }
}
