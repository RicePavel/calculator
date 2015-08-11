/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import calculator.CalcExecutor.Key;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Новый профиль
 */
public class Calculator {

  private static final CalcExecutor exec = new CalcExecutor();

  private static JLabel label;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    JFrame jf = new JFrame();
    jf.setVisible(true);
    jf.setSize(300, 300);
    
    JPanel panel = new JPanel();
    panel.setSize(250, 250);
    jf.add(panel);
    panel.setVisible(true);
    panel.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    label = new JLabel();
    label.setText("0");

    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 4;
    panel.add(label, c);

    addNumberButtons(panel);

    JButton buttonPlus = new JButton();
    setSize(buttonPlus);
    buttonPlus.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        enter(CalcExecutor.Key.PLUS);
      }

    });
    buttonPlus.setText("+");
    c = new GridBagConstraints();
    c.gridy = 1;
    c.gridx = 3;
    panel.add(buttonPlus, c);

    JButton buttonMinus = new JButton();
    buttonMinus.setText("-");
    setSize(buttonMinus);
    buttonMinus.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        enter(CalcExecutor.Key.MINUS);
      }

    });
    c = new GridBagConstraints();
    c.gridy = 2;
    c.gridx = 3;
    panel.add(buttonMinus, c);

    JButton buttonDiv = new JButton();
    setSize(buttonDiv);
    buttonDiv.setText("/");
    buttonDiv.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        enter(CalcExecutor.Key.DIV);
      }

    });
    c = new GridBagConstraints();
    c.gridy = 3;
    c.gridx = 3;
    panel.add(buttonDiv, c);

    JButton buttonMult = new JButton();
    setSize(buttonMult);
    buttonMult.setText("*");
    buttonMult.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        enter(CalcExecutor.Key.MULT);
      }

    });
    c = new GridBagConstraints();
    c.gridy = 4;
    c.gridx = 3;
    panel.add(buttonMult, c);

    JButton buttonOk = new JButton();
    buttonOk.setText("=");
    setSize(buttonOk);
    buttonOk.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        enter(CalcExecutor.Key.CALCULATE);
      }

    });
    c = new GridBagConstraints();
    c.gridy = 4;
    c.gridx = 2;
    panel.add(buttonOk, c);
    
    JButton buttonCancel = new JButton();
    buttonCancel.setText("C");
    setSize(buttonCancel);
    buttonCancel.addActionListener(new ActionListener() {
    
      @Override
      public void actionPerformed(ActionEvent e) {
        enter(CalcExecutor.Key.CANCEL);
      }
      
    });
    c = new GridBagConstraints();
    c.gridy = 4;
    c.gridx = 1;
    setSize(buttonCancel);
    panel.add(buttonCancel, c);

  }
  
  private static void setSize(JButton button) {
    button.setSize(50, 50);
  }

  private static void addNumberButtons(JPanel panel) {
    for (int i = 0; i <= 9; i++) {
      JButton button = new JButton(Integer.toString(i));
      setSize(button);
      final Key key = CalcExecutor.getKeyByInt(i);
      button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          if (key != null) {
            enter(key);
          }
        }

      });
      panel.add(button, constraintsForNumberButton(i));
    }
  }

  private static GridBagConstraints constraintsForNumberButton(int n) {
    GridBagConstraints c = new GridBagConstraints();
    switch (n) {
      case 1:
        c.gridy = 1;
        c.gridx = 0;
        break;
      case 2:
        c.gridy = 1;
        c.gridx = 1;
        break;
      case 3:
        c.gridy = 1;
        c.gridx = 2;
        break;
      case 4:
        c.gridy = 2;
        c.gridx = 0;
        break;
      case 5:
        c.gridy = 2;
        c.gridx = 1;
        break;
      case 6:
        c.gridy = 2;
        c.gridx = 2;
        break;
      case 7:
        c.gridy = 3;
        c.gridx = 0;
        break;
      case 8:
        c.gridy = 3;
        c.gridx = 1;
        break;
      case 9:
        c.gridy = 3;
        c.gridx = 2;
        break;
      case 0:
        c.gridy = 4;
        c.gridx = 0;
        break;
    }
    return c;
  }

  private static void enter(CalcExecutor.Key key) {
    String value = exec.enter(key);
    label.setText(value);
  }

}
