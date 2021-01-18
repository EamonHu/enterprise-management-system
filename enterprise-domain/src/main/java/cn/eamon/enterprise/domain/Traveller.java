package cn.eamon.enterprise.domain;

import lombok.Data;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/15 14:53
 */
@Data
public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;
    private String travellerTypeStr;
}
