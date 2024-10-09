package prac4_1_2;

public class Phone {
    public String number;
    public int weight;
    public String model;

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", weight=" + weight +
                ", model='" + model + '\'' +
                '}';
    }

    public Phone(String number, int weight, String model){
        this(number, model);
        this.weight = weight;
    }
    public Phone(String number, String model){
        this.number = number;
        this.model = model;
    }

    public Phone(){
    }


    public void recieveCall(String caller){
        System.out.println(caller + " is calling");
    }
    public void recieveCall(String caller, String callerNumber){
        System.out.println(caller + " is calling " + callerNumber);
    }
    public void sendMessage(String... phoneNumbers){
        System.out.println(number + " sending message to ");
        for (String phoneNumber : phoneNumbers){
            System.out.println(phoneNumber + " ");
        }
    }

    public String getNumber(){
        return number;
    }

    public int getWeight(){
        return weight;
    }

    public String getModel(){
        return model;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }
    public void setModel(String model){
        this.model = model;
    }
}
