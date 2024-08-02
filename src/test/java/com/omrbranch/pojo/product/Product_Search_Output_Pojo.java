package com.omrbranch.pojo.product;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product_Search_Output_Pojo {
	public int status;
    public String message;
    public ArrayList<Product_List> data;
    public String currency;

}
