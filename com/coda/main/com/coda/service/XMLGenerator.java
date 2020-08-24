package com.coda.service;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.coda.bean.UserBean;
import com.coda.impl.Generator;

public class XMLGenerator implements Generator {

	@Override
	public void generate(List<UserBean> userBeanList) {
		System.out.println("Start XML Generated");
		userBeanList.forEach(userbean -> {
			try {
				JAXBContext context = JAXBContext.newInstance(UserBean.class);
				Marshaller marshaller = context.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				StringWriter sw = new StringWriter();
				marshaller.marshal(userbean, sw);
				System.out.println(sw.toString());

			} catch (JAXBException ex) {
				ex.printStackTrace();
			}
		});

	}

}
