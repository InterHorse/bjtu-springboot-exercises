package cn.interhorse.springboot.bjtu.entity;

import lombok.Data;

/**
 * @author Yuzhe Ma
 * @date 2020/07/30
 */
@Data
public class ResponseBO {
    private String msg = "Success";
    private String code = "0";
    private Object data;

    public ResponseBO(){}

    public ResponseBO(Object data) {
        this.data = data;
    }
}
