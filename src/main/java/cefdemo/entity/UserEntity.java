package cefdemo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_entity")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String login;
    private String IIN;
    private String BIN;
    private String password;
    private String date_of_registration;
    private String full_name;

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "userEntity")
//    mappedBy = "id",
    private Set<RequestEntity> requestEntities = new HashSet<>();



    public UserEntity(Long id, String login, String IIN, String BIN, String password, String date_of_registration, String full_name, Set<RequestEntity> requestEntities) {
        this.id = id;
        this.login = login;
        this.IIN = IIN;
        this.BIN = BIN;
        this.password = password;
        this.date_of_registration = date_of_registration;
        this.full_name = full_name;
    }

    public UserEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getIIN() {
        return IIN;
    }

    public void setIIN(String IIN) {
        this.IIN = IIN;
    }

    public String getBIN() {
        return BIN;
    }

    public void setBIN(String BIN) {
        this.BIN = BIN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate_of_registration() {
        return date_of_registration;
    }

    public void setDate_of_registration(String date_of_registration) {
        this.date_of_registration = date_of_registration;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Set<RequestEntity> getRequestEntities() {
        return requestEntities;
    }

    public void setRequestEntities(Set<RequestEntity> requestEntities) {
        this.requestEntities = requestEntities;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", IIN='" + IIN + '\'' +
                ", BIN='" + BIN + '\'' +
                ", password='" + password + '\'' +
                ", date_of_registration='" + date_of_registration + '\'' +
                ", full_name='" + full_name + '\'' +
                '}';
    }



    /*
     @JoinTable(name = "contest_partner_Link",
            joinColumns = @JoinColumn(name = "contest_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "partner_id", referencedColumnName = "ID"))
    @ManyToMany
    private List<Partner> partners;

    @JoinTable(name = "contest_jury_link",
            joinColumns = @JoinColumn(name = "contest_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "jury_id", referencedColumnName = "id"))
    @ManyToMany
    private List<Jury> jury;
     @OneToMany(mappedBy = "jury")
//

 @JoinTable(name = "solo_tournament_user",
            joinColumns = @JoinColumn(name = "tournament_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    @ManyToMany
     */
}
