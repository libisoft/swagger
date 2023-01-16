package co.com.libisoft.swagger.domain.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class AuthDto {

    private String accesToken;
    private Date tokenExpired;

    public AuthDto() {
    }

    public AuthDto(String accesToken, Date tokenExpired) {
        this.accesToken = accesToken;
        this.tokenExpired = tokenExpired;
    }

    public String getAccesToken() {
        return accesToken;
    }

    public void setAccesToken(String accesToken) {
        this.accesToken = accesToken;
    }

    public Date getTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(Date tokenExpired) {
        this.tokenExpired = tokenExpired;
    }
}
