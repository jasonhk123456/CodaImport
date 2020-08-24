package com.coda.service;

import java.util.List;

import com.coda.bean.UserBean;
import com.coda.impl.Generator;
import com.google.gson.Gson;

public class JsonGenerator implements Generator {

	@Override
	public void generate(List<UserBean> userBeanList) {
		Gson gson = new Gson();
		System.out.println("Start Json Generated");

		userBeanList.forEach(userbean -> {
			System.out.println(gson.toJson(userbean));
		});
	}
}
