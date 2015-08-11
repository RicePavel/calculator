/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Новый профиль
 */
public class Calculator {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    JFrame jf = new JFrame();
    
    JLabel label = new JLabel();
    label.setText("Hello!");
    jf.add(label);
    jf.setVisible(true);
    
    addNumberButtons(jf);
    
    JButton buttonPlus = new JButton();
    buttonPlus.setText("+");
    jf.add(buttonPlus);
    
    JButton buttonMinus = new JButton();
    buttonMinus.setText("-");
    jf.add(buttonMinus);
    
    JButton buttonDiv = new JButton();
    buttonDiv.setText("/");
    jf.add(buttonDiv);
    
    JButton buttonMult = new JButton();
    buttonMult.setText("*");
    jf.add(buttonMult);
    
    JButton buttonOk = new JButton();
    buttonOk.setText("=");
    jf.add(buttonOk);
    
  }
  
  private static void addNumberButtons(JFrame jf) {
    for (int i = 1; i <=9; i++) {
      JButton button = new JButton(Integer.toString(i));
      jf.add(button);
    }
  }

}
