package cl.grupopi.portafolio.models;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Project {

    private long idProject;
    private String name;
    private String description;
    private Date creation_date;
    private String name_business;

    public Project() {
        this.idProject = 0;
        this.name = "";
        this.description = "";
        this.creation_date = new Date();
        this.name_business = "";
    }

    public long getIdProject() {
        return idProject;
    }

    public void setIdProject(long idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public String getName_business() {
        return name_business;
    }

    public void setName_business(String name_business) {
        this.name_business = name_business;
    }
}
