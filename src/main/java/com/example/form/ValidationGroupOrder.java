package com.example.form;

import jakarta.validation.GroupSequence;

/**
 * @author kariyafumihiko
 * バリデーションの実行順序を定義する
 */

@GroupSequence({ValidationGroupFirst.class, ValidationGroupSecond.class})
public interface ValidationGroupOrder {

}
