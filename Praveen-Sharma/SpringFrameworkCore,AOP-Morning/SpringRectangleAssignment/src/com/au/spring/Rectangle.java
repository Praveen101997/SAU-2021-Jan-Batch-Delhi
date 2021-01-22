package com.au.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//import org.springframework.beans.factory.DisposableBean;
//InitializingBean is a marker for spring to call method of bean after initiliazation of bean
//import org.springframework.beans.factory.InitializingBean;

public class Rectangle { // implements InitializingBean , DisposableBean
	@Autowired
	@Qualifier("PointA")
	private Point PointA;

	@Autowired
	@Qualifier("PointB")
	private Point PointB;

	@Autowired
	@Qualifier("PointC")
	private Point PointC;

	@Autowired
	@Qualifier("PointD")
	private Point PointD;

	public Point getPointA() {
		return PointA;
	}

	public void setPointA(Point PointA) {
		this.PointA = PointA;
	}

	public Point getPointB() {
		return PointB;
	}

	public void setPointB(Point pointB) {
		this.PointB = pointB;
	}

	public Point getPointC() {
		return PointC;
	}

	public void setPointC(Point pointC) {
		this.PointC = pointC;
	}

	public Point getPointD() {
		return PointD;
	}

	public void setPointD(Point pointD) {
		this.PointD = pointD;
	}
	//

	public void draw() {
		System.out.println("PointA X: " + getPointA().getX() + " and Y: " + getPointA().getY());
		System.out.println("PointB X: " + getPointB().getX() + " and Y: " + getPointB().getY());
		System.out.println("PointC X: " + getPointC().getX() + " and Y: " + getPointC().getY());
		System.out.println("PointD X: " + getPointD().getX() + " and Y: " + getPointD().getY());
	}

	// when we dont want to implement interfaces specific to spring, write own
	// menthods and refer from xml
	public void onInit() {
		System.out.println("Rectangle bean initialized");
	}

	public void onCleanup() {
		System.out.println("Rectangle bean destroyed");
	}

}
