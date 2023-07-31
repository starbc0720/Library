package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository<User, Long>은 mapping 할 Entity와 Entity의 id column type 넣어줌
public interface UserRepository extends JpaRepository<User, Long>{

    // By 앞에 들어갈 수 있는 기능들
    // find: 1건을 가져온다. 반환 타입은 객체 or Optional<타입>
    // findAll: 쿼리의 결과물이 N개인 경우 사용, List<타입> 반환
    // exists: 쿼리 결과가 존재하는지 확인, 반환 타입 boolean
    // count: SQL의 결과 개수 셈, 반환 타입은 Long

    // By 뒤에 들어갈 수 있는 기능들
    // ex) findAllByNameAndAge(String name, int age); -> select * from where name = ? AND age = ?;
    // ex) GreaterThan : 초과
    // ex) GreaterThanEqual : 이상
    // ex) LessThan : 미만
    // ex) LessThanEqual : 이하
    // ex) findAllByAgeBetween(int startAge, int endAge) -> select * from user where age between ? and ?;
    // ex) StartsWith : ~로 시작하는
    // ex) EndsWith : ~로 끝나는

    Optional<User> findByName(String name);
}
