import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email{
    private int inboxCapacity;
   // private ArrayList<Triple<Date,String, String>> inbox;//Each mail has date (Date),
    // sender (String), message (String).
    // It is guaranteed that message is distinct for all mails.
    //private ArrayList<Triple<Date,String, String>> trash;
    private ArrayList<Mail> inbox;
    private ArrayList<Mail> trash;
    public Gmail(String id, int inboxCapacity) {
        super(id);
        this.inboxCapacity = inboxCapacity;
        this.inbox= new ArrayList<>();
        this.trash= new ArrayList<>();
    }

    public int getInboxCapacity() {
        return inboxCapacity;
    }
    public void receiveMail(Date date, String sender, String msg){
        // If the inbox is full,
        // move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order.
        // This means that the date of a new mail is greater
        // than equal to the dates of mails received already.
        if(inbox.size()==inboxCapacity)
        {
            Mail oldmail= inbox.get(0);
            inbox.remove(0);
            trash.add(oldmail);
        }
        Mail email= new Mail(date,sender,msg);
        inbox.add(email);
    }
    public String deleteMail(String msg){
        int index=-1;
        for(int i=0; i<inbox.size(); i++)
        {
            if(msg.equals(inbox.get(i).getMessage()))
            {// searching for given mail in data
                index=i;
                break;
            }

        }
        if(index != -1)
        {
            trash.add(inbox.get(index));// add that msg to trash folder
            inbox.remove(index);// also remove it from inbox
            return "mail deleted";
        }
        return "mail not found";
    }
    public String getOldMail() {
        return inbox.get(0).getMessage();
    }
    public String getNewMail() {
        return inbox.get(inbox.size()-1).getMessage();
    }
    public int getInboxSize(){
        return inbox.size();
    }
    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date

        int mailBetweenDates = 0;
        for(int i=0; i<inbox.size(); i++){
            Mail mail = inbox.get(i);
            if(mail.date.compareTo(start) >= 0 && mail.date.compareTo(end) <= 0){
                //if date>start +ve and date <end -ve as per compareto
                mailBetweenDates++;
            }
        }
        return mailBetweenDates;
    }
    public int getTrashSize(){
        return trash.size();
    }
    public void emptyTrash(){
        trash.clear();
    }

}
