import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class PhoneRec {
    private List<String> phone, email;

    PhoneRec(String email, String... phone){
        this.phone = new ArrayList<>();
        this.phone.addAll(Arrays.asList(phone));
        this.email = new ArrayList<>();
        this.email.add(email);
    }

    public void addPhone(String phone) {
        this.phone.add(phone);
    }

    public void addEmail(String email) {
        this.email.add(email);
    }

    public String getPhones(){
        StringBuilder result = new StringBuilder();
        short num = 1;
        for (String phone :
                this.phone) {
            result.append(num).append(". ").append(phone).append("\n");
            num++;
        }
        return result.toString();
    }

    public String getEmails(){
        return this.email.toString();
    }

    @Override
    public String toString() {
        return "Phones - " + this.phone.toString() + "Emails - " + this.email.toString();
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (!(this == obj)) {
//            if (obj instanceof PhoneRec){
//                return this.getPhones().equals(((PhoneRec) obj).getPhones());
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        return this.phone.hashCode() ^ this.email.hashCode();
//    }
}
