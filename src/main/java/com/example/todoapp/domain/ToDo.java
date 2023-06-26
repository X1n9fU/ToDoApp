package com.example.todoapp.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity(name = "Todo")
@Table(name="todo") //todo 테이블 만듬
//자동으로 생성자 만들기
@AllArgsConstructor //모든 것을 받는 생성자 만들기
@NoArgsConstructor(force = true) //아무것도 안받는 생성자
@Setter
@Getter
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String todo;
}
