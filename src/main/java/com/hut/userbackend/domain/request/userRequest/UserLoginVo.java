package com.hut.userbackend.domain.request.userRequest;

import lombok.Data;

/**
 * ClassName: UserRegisterVo <br/>
 * Description: <br/>
 * date: 2024/6/18 21:28<br/>
 *
 * @author Ikun<br />
 * @since 1.0.0
 */
@Data
public class UserLoginVo {
    public String userAccount;
    public String userPassword;
}
