package murach.business;

import java.io.Serializable;

public class Student implements Serializable {

    private String id;
    private String name;
    private String scholarship;
    private String type_scholarship;

    public Student() {
        id = "";
        name = "";
        scholarship = "";
        type_scholarship = "";
    }

    public Student(String id, String name, String scholarship, String type_scholarship) {
        this.id = id;
        this.name = name;
        this.scholarship = scholarship;
        this.type_scholarship = type_scholarship;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the scholarship
     */
    public String getScholarship() {
        return scholarship;
    }

    /**
     * @param scholarship the scholarship to set
     */
    public void setScholarship(String scholarship) {
        this.scholarship = scholarship;
    }

    /**
     * @return the type_scholarship
     */
    public String getType_scholarship() {
        return type_scholarship;
    }

    /**
     * @param type_scholarship the type_scholarship to set
     */
    public void setType_scholarship(String type_scholarship) {
        this.type_scholarship = type_scholarship;
    }

}
