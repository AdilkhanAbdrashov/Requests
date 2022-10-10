package cefdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data

@Entity
@Table(name = "request_entity")
public class RequestEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String date_and_time;
    private String sum;
    private String number;
    private String date_of_contract;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "user_entity")
    private UserEntity userEntity;


    public RequestEntity() {}

    public RequestEntity(Long id, String date_and_time, String sum, String number, String date_of_contract) {
        this.id = id;
        this.date_and_time = date_and_time;
        this.sum = sum;
        this.number = number;
        this.date_of_contract = date_of_contract;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate_and_time() {
        return date_and_time;
    }

    public void setDate_and_time(String date_and_time) {
        this.date_and_time = date_and_time;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate_of_contract() {
        return date_of_contract;
    }

    public void setDate_of_contract(String date_of_contract) {
        this.date_of_contract = date_of_contract;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", date_and_time='" + date_and_time + '\'' +
                ", sum='" + sum + '\'' +
                ", number='" + number + '\'' +
                ", date_of_contract='" + date_of_contract + '\'' +
                '}';
    }
}
