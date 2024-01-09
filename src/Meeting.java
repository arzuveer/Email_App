import java.time.LocalTime;
public class Meeting {
    private LocalTime startMeet;
    private LocalTime endMeet;

    public Meeting(LocalTime startMeet, LocalTime endMeet) {
        this.startMeet = startMeet;
        this.endMeet = endMeet;
    }

    public LocalTime getStartMeet() {
        return startMeet;
    }

    public LocalTime getEndMeet() {
        return endMeet;
    }
}
