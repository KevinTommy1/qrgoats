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
public class Account implements Comparable<Account> {

    @Id
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String wachtwoord;

    @Column(columnDefinition = "int default 1", nullable = false, length = 1)
    private Integer machtigingen;

    public Account() {

    }

    public Account(String email, String wachtwoord) {
        this.email = email;
        this.wachtwoord = wachtwoord;
    }

    public Account(String email, String wachtwoord, Integer machtigingen) {
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.machtigingen = machtigingen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public Integer getMachtigingen() {
        return machtigingen;
    }

    public void setMachtigingen(Integer machtigingen) {
        this.machtigingen = machtigingen;
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
        return Objects.equals(email, account.email) && Objects.equals(wachtwoord, account.wachtwoord) && Objects.equals(machtigingen, account.machtigingen);
    }

    @Override
    public int compareTo(Account other) {
        int temp = email.compareTo(other.email);
        if (temp == 0) {
            return wachtwoord.compareTo(other.wachtwoord);
        }
        return temp;
    }

    @Override
    public String toString() {
        return "Account{" +
                "email='" + email + '\'' +
                ", wachtwoord='" + wachtwoord + '\'' +
                ", machtigingen=" + machtigingen +
                '}';
    }

    // TODO: Implement this
    public boolean loginCheck() {

        return true;
    }

    // TODO: Implement this
    public boolean changePassword() {

        return true;
    }

}
