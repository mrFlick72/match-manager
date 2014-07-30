package it.valeriovaudi.matchmanager.service.ws.dto.team;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/6/14
 * Time: 3:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class AutenticationInfoModelDTO implements Serializable {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AutenticationInfo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
