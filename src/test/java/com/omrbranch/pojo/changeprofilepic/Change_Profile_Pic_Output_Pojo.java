package com.omrbranch.pojo.changeprofilepic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Change_Profile_Pic_Output_Pojo {
	   public int status;
	    public String message;
	    public Picture_Details data;
	    public int cart_count;

}
