package com.omrbranch.pojo.address;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserAddress_Output_Pojo {

	public int status;
    public String message;
    public ArrayList<GetUserAddress_Input_Pojo> data;
}
