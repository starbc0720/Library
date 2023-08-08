package com.group.libraryapp.domain.user;

import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //Spring이 User 객체와 user 테이블을 같은 것으로 바라보게 만든다는 의미
public class User {

    @Id //해당 필드를 priamry key로 간주
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary key는 자동 생성되는 값으로 지정
    private Long id = null;

    @Column(nullable = false, length = 20) // name varchar(20)
    private String name;

    private Integer age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) //연관관계의 주인의 값이 설정되어야만 진정한 데이터가 저장
                                                                                    //cascade 옵션으로 인해 user가 생성되면 해당 user와 연관된 userloanhistory도 삭제됨
                                                                                    //orphan removal 옵션 -> 객체간의 관계가 끊어진 데이터 자동으로 제거
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();

    protected User() {
    } //JPA는 꼭 기본 생성자 필요

    public User(String name, Integer age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다", name));
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
