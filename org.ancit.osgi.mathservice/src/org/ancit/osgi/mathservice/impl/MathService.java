package org.ancit.osgi.mathservice.impl;

import org.ancit.osgi.mathservice.IMathService;

public class MathService implements IMathService{

	@Override
	public int sum(int a, int b) {
		return a+b;
	}

}
