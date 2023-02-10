package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job () {
        this.id = nextId;
        nextId ++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;

    }

    @Override
    public boolean equals(Object toBeCompared) {
        if(toBeCompared == null) {
            return false;
        }
        if (toBeCompared.getClass() != getClass()) {
            return false;
        }
        Job theJob = (Job) toBeCompared;
        return theJob.id == id;
    }
    @Override
    public String toString(){
        StringBuilder outputString = new StringBuilder();
        outputString.append("\n");
        if(Objects.isNull(getName()) && Objects.isNull(getEmployer()) && Objects.isNull(getLocation()) && Objects.isNull(getPositionType()) && Objects.isNull(getCoreCompetency())) {
            outputString.append("OOPS! This job does not seem to exist.\n");
            return outputString.toString();
        }
        Integer idInt = getId();
        outputString.append(printFormattedLine("ID", idInt));
        outputString.append(printFormattedLine("Name", getName()));
        outputString.append(printFormattedLine("Employer",getEmployer()));
        outputString.append(printFormattedLine("Location", getLocation()));
        outputString.append(printFormattedLine("Position Type", getPositionType()));
        outputString.append(printFormattedLine("Core Competency",getCoreCompetency()));
        return outputString.toString();
    }
    public String printFormattedLine(String label, Object obj) {
        if(Objects.isNull(obj) || obj.toString() == "") {
            return label + ": Data not available\n";
        }
        return label +": " + obj.toString() + "\n";
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
