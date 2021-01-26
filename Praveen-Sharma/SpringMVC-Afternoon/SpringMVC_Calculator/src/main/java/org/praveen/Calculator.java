package org.praveen;

import org.praveen.exceptions.ByZeroDivision;
import org.springframework.stereotype.Service;

@Service
public class Calculator {
	public float calculate(String fnum, String snum,String operation)  throws Exception {
		float res=0;
		float fNum = Float.parseFloat(fnum);
		float sNum = Float.parseFloat(snum);
		switch (operation) {
			case "add":
				res = fNum + sNum;
				break;
			case "sub":
				res = fNum - sNum;
				break;
			case "mul":
				res = fNum * sNum;
				break;
			case "div":
				if (sNum == 0.0) {
					throw new ByZeroDivision();
				}
				res = fNum / sNum;
				break;
			default:
				break;
		}
		return res;
	}

}