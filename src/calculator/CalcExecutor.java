/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rice Pavel
 */
public class CalcExecutor {

  public enum Key {

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
    MULT,
    CALCULATE,
    CANCEL
  }

  private Expression expr;
  private Expression.Operations sign;
  private Integer temporaryNumber;

  /*
   public String enter(Key input) throws Exception {
   String valueOnScreen = "0";
   if (expr == null) {
   if (sign == null && temporaryNumber == null) {
   if (isNumberKey(input)) {
   addNumber(input);
   valueOnScreen = getTemporaryNumberToString();
   } else {
   expr = new Expression(0);
   valueOnScreen = getExpressionValue();
   sign = getSign(input);
   }
   } else if (sign == null && temporaryNumber != null) {
   if (isNumberKey(input)) {
   addNumber(input);
   valueOnScreen = getTemporaryNumberToString();
   } else {
   expr = new Expression(temporaryNumber);
   temporaryNumber = null;
   sign = getSign(input);
   valueOnScreen = getTemporaryNumberToString();
   }
   } else {
   throw new Exception();
   }
   } else {
   if (sign == null && temporaryNumber == null) {
   if (isNumberKey(input)) {
   expr = null;
   addNumber(input);
   } else {
   sign = getSign(input);
   }
   valueOnScreen = getExpressionValue();
   } else if (temporaryNumber != null && sign == null) {
   throw new Exception();
   } else if (temporaryNumber == null && sign != null) {
   if (isNumberKey(input)) {
   addNumber(input);
   valueOnScreen = getTemporaryNumberToString();
   } else {
   sign = getSign(input);
   valueOnScreen = getExpressionValue();
   }

   } else if (temporaryNumber != null && sign != null) {
   if (isNumberKey(input)) {
   addNumber(input);
   valueOnScreen = getTemporaryNumberToString();
   } else {
   int result = expr.getValue();
   temporaryNumber = null;
   sign = getSign(input);
   valueOnScreen = Integer.toString(result);
   }
   }
   }
   return valueOnScreen;
   }
   */
  private String valueOnScreen = "0";

  public String enter(Key input) {

    if (isNumberKey(input)) {
      if (expr == null) {
        addNumber(input);
        valueOnScreen = getTemporaryNumberToString();
      } else {
        if (sign != null) {
          addNumber(input);
          valueOnScreen = getTemporaryNumberToString();
        } else {
          expr = null;
          addNumber(input);
        }
      }

    } else if (isSignKey(input)) {
      if (expr == null) {
        if (sign == null && temporaryNumber == null) {
          expr = new Expression(0);
          valueOnScreen = getExpressionValue();
          sign = getSign(input);
        } else if (sign == null && temporaryNumber != null) {
          expr = new Expression(temporaryNumber);
          temporaryNumber = null;
          sign = getSign(input);
          valueOnScreen = getExpressionValue();
        }
      } else {
        if (sign == null && temporaryNumber == null) {
          sign = getSign(input);
        } else if (temporaryNumber == null && sign != null) {
          sign = getSign(input);
          valueOnScreen = getExpressionValue();
        } else if (temporaryNumber != null && sign != null) {
          expr.calculate(sign, temporaryNumber);
          temporaryNumber = null;
          sign = getSign(input);
          valueOnScreen = getExpressionValue();
        }
      }

    } else if (input.equals(Key.CALCULATE)) {
      if (temporaryNumber != null && sign != null) {
        expr.calculate(sign, temporaryNumber);
      }
      temporaryNumber = null;
      sign = null;
      valueOnScreen = getExpressionValue();
      
    } else if (input.equals(Key.CANCEL)) {
      expr = null;
      temporaryNumber = null;
      sign = null;
      valueOnScreen = "0";
    }
    return valueOnScreen;
  }

  private String getExpressionValue() {
    if (expr != null) {
      return Integer.toString(expr.getValue());
    } else {
      return "0";
    }
  }

  private String getTemporaryNumberToString() {
    if (temporaryNumber != null) {
      return Integer.toString(temporaryNumber);
    } else {
      return "0";
    }
  }

  private boolean isSignKey(Key key) {
    return (key.equals(Key.PLUS)
            || key.equals(Key.MINUS)
            || key.equals(Key.DIV)
            || key.equals(Key.MULT));
  }

  private Expression.Operations getSign(Key key) {
    Map<Key, Expression.Operations> map = new HashMap();
    map.put(Key.PLUS, Expression.Operations.PLUS);
    map.put(Key.MINUS, Expression.Operations.MINUS);
    map.put(Key.DIV, Expression.Operations.DIV);
    map.put(Key.MULT, Expression.Operations.MULT);
    return map.get(key);
  }

  private void addNumber(Key key) {
    if (isNumberKey(key)) {
      int value = getIntValue(key);
      if (temporaryNumber == null) {
        temporaryNumber = value;
      } else {
        temporaryNumber = temporaryNumber * 10 + value;
      }
    }
  }

  public static Key getKeyByInt(int n) {
    Map<Integer, Key> map = new HashMap();
    map.put(0, Key.NUM_0);
    map.put(1, Key.NUM_1);
    map.put(2, Key.NUM_2);
    map.put(3, Key.NUM_3);
    map.put(4, Key.NUM_4);
    map.put(5, Key.NUM_5);
    map.put(6, Key.NUM_6);
    map.put(7, Key.NUM_7);
    map.put(8, Key.NUM_8);
    map.put(9, Key.NUM_9);
    return map.get(n);
  }

  private int getIntValue(Key key) {
    Map<Key, Integer> map = new HashMap();
    map.put(Key.NUM_0, 0);
    map.put(Key.NUM_1, 1);
    map.put(Key.NUM_2, 2);
    map.put(Key.NUM_3, 3);
    map.put(Key.NUM_4, 4);
    map.put(Key.NUM_5, 5);
    map.put(Key.NUM_6, 6);
    map.put(Key.NUM_7, 7);
    map.put(Key.NUM_8, 8);
    map.put(Key.NUM_9, 9);
    return map.get(key);
  }

  private boolean isNumberKey(Key key) {
    return (key.equals(Key.NUM_0)
            || key.equals(Key.NUM_1)
            || key.equals(Key.NUM_2)
            || key.equals(Key.NUM_3)
            || key.equals(Key.NUM_4)
            || key.equals(Key.NUM_5)
            || key.equals(Key.NUM_6)
            || key.equals(Key.NUM_7)
            || key.equals(Key.NUM_8)
            || key.equals(Key.NUM_9));
  }

}
