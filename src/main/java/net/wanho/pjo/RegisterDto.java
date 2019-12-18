package net.wanho.pjo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Administrator on 2019/12/12.
 */
public class RegisterDto {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Length(min = 6,max = 18,message = "密码的长度必须在6~18之间")
    private String password;
    @Email(message = "邮箱格式不正确")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegisterDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public RegisterDto() {
    }

    @Override
    public String toString() {
        return "RegisterDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
