import java.security.KeyPair;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Workspace extends Gmail {
    ArrayList<Meeting> calendar;

    public Workspace(String id) {
        super(id,Integer.MAX_VALUE);
        this.calendar= new ArrayList<>();
    }
    public String addMeeting(Meeting meeting)
    {
        calendar.add(meeting);
        return "meeting scheduled";
    }
    public int findMaxMeetings(){
       // as meetings are overlapping so calculate
        // max possible meeting to be attended by anyone
        // we will be sorting the meetings as per their ending time
        // meeting with least endtime will be covered first
        //iterate from left to right
        //pair.left= endtime
        //pair.right= index of meeting


        if(calendar.size() == 0) return 0;
        Collections.sort(calendar, new Comparator<Meeting>(){
            public int compare(Meeting a, Meeting b){
                return a.getEndMeet().compareTo(b.getEndMeet());
            }
        }) ;
        LocalTime limit = calendar.get(0).getEndMeet();
        int count =1;
        for(int i=1 ;i<calendar.size(); i++){
            if(calendar.get(i).getStartMeet().compareTo(limit)>0){
                count++;
                limit = calendar.get(i).getEndMeet();
            }
        }
        return count;
    
    }
}
