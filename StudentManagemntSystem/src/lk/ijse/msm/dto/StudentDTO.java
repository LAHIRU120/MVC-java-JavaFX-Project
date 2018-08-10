/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.msm.dto;

/**
 *
 * @author LAHIRU SASANKA
 */
public class StudentDTO {
    
    private int sid;
    private String name;
    private String address;
    private String email;
    private String tell;

    public StudentDTO() {
    }
    
    public StudentDTO(String name, String address, String email, String tell) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.tell = tell;
    }

    public StudentDTO(int sid, String name, String address, String email, String tell) {
        this.sid = sid;
        this.name = name;
        this.address = address;
        this.email = email;
        this.tell = tell;
    }

    /**
     * @return the sid
     */
    public int getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(int sid) {
        this.sid = sid;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the tell
     */
    public String getTell() {
        return tell;
    }

    /**
     * @param tell the tell to set
     */
    public void setTell(String tell) {
        this.tell = tell;
    }
    
    
}
