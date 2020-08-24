package com.coda.impl;

import com.coda.service.JsonGenerator;
import com.coda.service.XMLGenerator;

public class GeneratorFactory extends GeneratorAbstractFactory{
	private final static String JSON = "JSON";
	private final static String XML = "XML";

	public Generator getGenerator(String defaultfromat) {
		Generator generator = null;
		switch (defaultfromat) {
		case JSON:
			generator = new JsonGenerator();
			break;
		case XML:
			generator = new XMLGenerator();
			break;
		default:
			break;
		}
		return generator;

	}

}
