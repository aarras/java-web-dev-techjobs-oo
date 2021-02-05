package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        String aName = this.name;
        String aEmployer = this.employer.getValue();
        String aLocation = this.location.getValue();
        String aPositionType = this.positionType.getValue();
        String aCoreCompetency = this.coreCompetency.getValue();

        if (aName.equals("")) { aName = "Data not available"; }
        if (aEmployer.equals("")) { aEmployer = "Data not available"; }
        if (aLocation.equals("")) { aLocation = "Data not available"; }
        if (aPositionType.equals("")) { aPositionType = "Data not available"; }
        if (aCoreCompetency.equals("")) { aCoreCompetency = "Data not available"; }

        if (aName.equals("Data not available") && aEmployer.equals("Data not available") && aLocation.equals("Data not available") && aPositionType.equals("Data not available") && aCoreCompetency.equals("Data not available")) {
            return "OOPS! This job does not seem to exist.";
        } else {
            return "\nID: " + id +
                    "\nName: " + aName +
                    "\nEmployer: " + aEmployer +
                    "\nLocation: " + aLocation +
                    "\nPosition Type: " + aPositionType +
                    "\nCore Competency: " + aCoreCompetency +
                    '\n';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Getters and Setters:

    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Employer getEmployer() { return employer; }

    public void setEmployer(Employer employer) { this.employer = employer; }

    public Location getLocation() { return location; }

    public void setLocation(Location location) { this.location = location; }

    public PositionType getPositionType() { return positionType; }

    public void setPositionType(PositionType positionType) { this.positionType = positionType; }

    public CoreCompetency getCoreCompetency() { return coreCompetency; }

    public void setCoreCompetency(CoreCompetency coreCompetency) { this.coreCompetency = coreCompetency; }

}
