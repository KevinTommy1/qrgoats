package nl.delphinity.qrgoats.domain;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(
        name = "account",
        indexes = {
                @Index(columnList = "email", unique = true)
        }
)
public class Account {

    @Id
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "int default 1", nullable = false, length = 1)
    private Integer role;

    public Account() {

    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account(String email, String password, Integer role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;

        result = prime * result + ((email == null) ? 0 : email.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(email, account.email) && Objects.equals(password, account.password) && Objects.equals(role, account.role);
    }

    @Override
    public String toString() {
        return "Account{" +
                "email='" + email + '\'' +
                ", wachtwoord='" + password + '\'' +
                ", machtigingen=" + role +
                '}';
    }
}
