import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {
    DateTimeFormatter appointment = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

    public LocalDateTime schedule(String appointmentDateDescription) {
        return LocalDateTime.parse(appointmentDateDescription,appointment);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        return appointmentDate.getHour()>=12 && appointmentDate.getHour()<18;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        boolean am = appointmentDate.getHour()<12;
        String parseDay = capitaliseData(appointmentDate.getDayOfWeek().toString().toLowerCase());
        String parseMonth = capitaliseData(appointmentDate.getMonth().toString().toLowerCase());
        String parseMinute = appointmentDate.getMinute() < 10 ? ":0" + appointmentDate.getMinute() :
                ":" + appointmentDate.getMinute();
        return am ? ("You have an appointment on " + parseDay + ", " +
                parseMonth + " " + appointmentDate.getDayOfMonth() + ", " +
                appointmentDate.getYear() + ", at " + appointmentDate.getHour() +
                parseMinute + " AM.")
                :
                "You have an appointment on " + parseDay + ", " +
                        parseMonth + " " + appointmentDate.getDayOfMonth() + ", " +
                        appointmentDate.getYear() + ", at " + (appointmentDate.getHour()-12) +
                        parseMinute + " PM.";
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER,15);
    }

    public String capitaliseData(String data) {
        return data.substring(0,1).toUpperCase() + data.substring(1);
    }
}
