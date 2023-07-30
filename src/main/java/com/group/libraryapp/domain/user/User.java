package com.group.libraryapp.domain.user;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity //Spring이 User 객체와 user 테이블을 같은 것으로 바라보게 만든다는 의미
public class User {

    @Id //해당 필드를 priamry key로 간주
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary key는 자동 생성되는 값 의
    private Long id = null;

    @Column(nullable = false, length = 20) // name varchar(20)
    private String name;

    private Integer age;

    protected User(){} //JPA는 꼭 기본 생성자 필요

    public User(String name, Integer age){
        if(name == null || name.isBlank()){
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

    public void updateName(String name){
        this.name = name;
    }
}
