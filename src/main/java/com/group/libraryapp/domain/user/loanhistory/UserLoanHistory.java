package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.User;

import javax.persistence.*;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @ManyToOne // N:1 관계, ex) 학생과 교장
    private User user;

    private String bookName;

    private boolean isReturn; //boolean으로 처리하면 tinyint에 잘 매핑(0 -> false, 1 -> true)

    public UserLoanHistory() {
    }

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public void doReturn(){
        this.isReturn = true;
    }

}