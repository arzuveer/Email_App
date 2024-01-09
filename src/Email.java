public class Email {
    private String id;
    private String password;

    public Email(String id) {
        this.id = id;
        this.password = "Project@123";
    }
    // we will not be making setters to make it more secure
    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    public String changePassword(String oldpassword, String newpassword)
    {
        if(oldpassword.equals(newpassword))
        {
            if(isValid(newpassword))
            {
               this.password= newpassword;
                return "password changed";
            }
            return "New password is invalid";
        }
        return "wrong password,try again";
    }
    public boolean isValid(String password)
    {
        boolean isUppercase=false;
        boolean islowercase=false;
        boolean isdigit=false;
        boolean isspecialcharacter=false;
        if(password.length()<8)
            return false;
        for(int i=0; i<password.length();i++)
        {
            char ch=password.charAt(i);
           if(ch >='A' && ch<='Z')
               isUppercase=true;
           else if(ch >='a' && ch<='z')
                islowercase=true;
           else if(ch >='0' && ch<='9')
                isdigit=true;
           else{
                isspecialcharacter=true;
            }
        }
        if(isUppercase && islowercase && isdigit && isspecialcharacter)
            return true;
        else
            return false;
    }
}
