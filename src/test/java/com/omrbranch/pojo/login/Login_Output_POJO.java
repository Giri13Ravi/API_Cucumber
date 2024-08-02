package com.omrbranch.pojo.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login_Output_POJO {

	private int status;
    private String message;
    private Root_Login data;
    private String refer_msg;
    private int cart_count;
    private String role;
}
