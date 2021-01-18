package cn.eamon.enterprise.domain;

import lombok.Data;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/15 14:52
 */
@Data
public class Member {
    private String id;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;
}
