package prac13.prac13_5;

public class NumberFormat {
    String phoneNumber;

    public NumberFormat(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String formatNumber(){
        String formattedPhoneNumber = "";
        if (phoneNumber.startsWith("+")){
            String countryCode = "+" + phoneNumber.substring(1, phoneNumber.length() - 10);
            String localNumber = phoneNumber.substring(phoneNumber.length() - 10);
            formattedPhoneNumber = countryCode + " " + formattedLocalNumber(localNumber);
        }else if(phoneNumber.startsWith("8") && phoneNumber.length() == 11){
            String countryCode = "+7";
            String localNumber = phoneNumber.substring(phoneNumber.length() - 10);
            formattedPhoneNumber = countryCode + " " + formattedLocalNumber(localNumber);
        }else{
            throw new IllegalArgumentException("Invalid phone number");
        }
        return formattedPhoneNumber;
    }

    public String formattedLocalNumber(String localNumber){
        return localNumber.substring(0,3) + "-"
                + localNumber.substring(3,6) + "-"
                + localNumber.substring(6);

    }
}
