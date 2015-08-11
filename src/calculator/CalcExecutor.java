/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rice Pavel
 */
public class CalcExecutor {

  public enum Keys {
    NUM_1,
    NUM_2,
    NUM_3,
    NUM_4,
    NUM_5,
    NUM_6,
    NUM_7,
    NUM_8,
    NUM_9,
    NUM_0,
    PLUS,
    MINUS,
    DIV,
    MULT
  }

  private Expression expr;
  private Expression.Operations sign;
  private Integer number;

  public String getTopString() {
    
  }
  
  public String getBottomString() {
    
  }
  
  public void enter(Keys input) {
    if (isNumber(input)) {
      addNumber(input);
    } else if (isSign(input)) {
      Expression.sign newSign = getSign(input);
      if (expr == null) {
        if (number == null) {
          expr = new Expression(0);
        } else {
          expr = new Expression(number);
          number = null;
        }
        sign = newSign;
      } else {
        if (number == null && sign != null) {
          sign = newSign();
        }
      }
    }
  }
  
  

}
