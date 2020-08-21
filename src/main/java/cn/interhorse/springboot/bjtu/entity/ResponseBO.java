package cn.interhorse.springboot.bjtu.entity;

import lombok.Data;

/**
 * Web 返回封装实体
 *
 * @author Yuzhe Ma
 * @date 2020/07/30
 */
@Data
public class ResponseBO {
    // 消息
    private String msg = "Success";
    // 状态码。默认为 0，即成功
    private String code = "0";
    // 数据内容
    private Object data;

    public ResponseBO(){}

    public ResponseBO(Object data) {
        this.data = data;
    }
}
