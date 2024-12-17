package prac19_2;

public class OrderProcessor {
    public void orderProcess(User user) throws InnException{
        if (!ValidateInn.isValid(user.getInn())){
            throw new InnException("Inn is not valid");
        }
        else{
            System.out.println("Order processed");
        }
    }
}
