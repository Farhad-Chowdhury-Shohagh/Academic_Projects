package AppointmentManagerProject;

import java.time.LocalDateTime;

class Appointment {
    private static int counter = 1;
    private final int id;
    private String clientName;
    private String serviceType;
    private LocalDateTime dateTime;
    private String notes;

    public Appointment(String clientName, String serviceType, LocalDateTime dateTime, String notes) {
        this.id = counter++;
        this.clientName = clientName;
        this.serviceType = serviceType;
        this.dateTime = dateTime;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }
    public String getClientName() {
        return clientName;
    }
    public String getServiceType() {
        return serviceType;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public String getNotes() {
        return notes;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Client: %s | Service: %s | Time: %s | Notes: %s", id, clientName, serviceType, dateTime, notes);
    }
}
