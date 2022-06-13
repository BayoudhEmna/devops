package io.order.manager.food.order.manager.vo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class LoginForm {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
}
