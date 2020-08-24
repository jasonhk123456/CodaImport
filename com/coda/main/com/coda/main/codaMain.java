package com.coda.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import javax.validation.constraints.Pattern;

import com.coda.bean.UserBean;
import com.coda.impl.GeneratorFactory;

public class codaMain {
	private final static String phonepattern = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
	private final static String emailpattern = "^(.+)@(.+)$";
	private final static String CSV_PATH = "C:\\Coda\\codaUser.csv";
	private final static String COMMA = ",";
	private static Stream<String> stream;
	private final static int MAX_Limit = 9999;
	private static boolean addbean = true;

	public static void main(String[] args) {

		String defaultfromat = "JSON"; // or XML

		List<UserBean> userBeanList = new ArrayList<UserBean>();
		try {
			stream = Files.lines(Paths.get(CSV_PATH));
			stream.limit(MAX_Limit).skip(1).forEach(linelist -> {
				List<String> column = Arrays.asList(linelist.split(COMMA));

				if (column.get(8).matches(phonepattern) == false || column.get(9).matches(phonepattern) == false) {
					System.out.println("phone format wrong");
					addbean = false;
				}
				if (column.get(10).matches(emailpattern) == false) {
					System.out.println("email format wrong");
					addbean = false;
				}

				if (addbean) {
					UserBean user = new UserBean();
					user.setFirst_name(column.get(0));
					user.setLast_name(column.get(1));
					user.setCompany_name(column.get(2));
					user.setAddress(column.get(3));
					user.setCity(column.get(4));
					user.setCounty(column.get(5));
					user.setState(column.get(6));
					user.setZip(Integer.parseInt(column.get(7)));
					user.setPhone1(column.get(8));
					user.setPhone2(column.get(9));
					user.setEmail(column.get(10));
					user.setWeb(column.get(11));

					userBeanList.add(user);
				}
				addbean = true;
			});

			GeneratorFactory generator = new GeneratorFactory();
			generator.getGenerator(defaultfromat).generate(userBeanList);

		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
