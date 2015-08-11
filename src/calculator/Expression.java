/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Rice Pavel
 */
public class Expression {
  
  public enum Operations {
    PLUS, MINUS, DIV, MULT;
  }
  
  private int value;
  
  public Expression(int n) {
    value = n;
  }
  
  public int getValue() {
    return value;
  }
  
  public void calculate(Operations operation, int value) {
    if (operation.equals(Operations.PLUS)) {
      this.value += value;
    } else if (operation.equals(Operations.MINUS)) {
      this.value -= value;
    } else if (operation.equals(Operations.DIV)) {
      if (value != 0) {
        this.value = this.value / value;
      }
    } else if (operation.equals(Operations.MULT)) {
      this.value = this.value * value;
    }
  }
  
}
