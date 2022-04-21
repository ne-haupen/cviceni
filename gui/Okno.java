package gui;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


import javax.swing.*;


public class Okno extends JFrame{
	String input = "";
	JLabel obrazovka = new JLabel("", JLabel.RIGHT);
	ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");

	Okno(){
		setSize(400,400);
		setTitle("kalkulacka");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Font f = new Font("Serif", Font.BOLD, 15);
		JPanel j1 = new JPanel(new BorderLayout());
		JPanel mid = new JPanel(new GridLayout(4,3));
		obrazovka.setFont(f);
		j1.add(obrazovka, BorderLayout.NORTH);
		j1.add(mid, BorderLayout.CENTER);
		input = "";
		String[] tl = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-"};
		for(String s: tl) {
			JButton button = new JButton(s);
			button.setFont(f);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if((s.equals("+") || s.equals("-")) && (input.endsWith("+")||input.endsWith("-")||input.isBlank())) {
						return;
					}else {
						input += s;
						obrazovka.setText(input);
					}
				}
			});
			mid.add(button);
		}
		JButton button = new JButton("=");
		button.setFont(f);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				obrazovka.setText(calculate(input));
			}
		});
		j1.add(button, BorderLayout.SOUTH);
		
		getContentPane().add(j1);
		setVisible(true);
	}
	
	String calculate(String s) {
		System.out.println(input);
		String operators[]=s.split("[0-9]+");
	    String operands[]=s.split("[+-]");
	    int result = Integer.parseInt(operands[0]);
	    for(int i=1;i<operands.length;i++){
	        if(operators[i].equals("+")) {
	        	result += Integer.parseInt(operands[i]);
	        }else {
	        	result -= Integer.parseInt(operands[i]);
	        }
	    }
	    //System.out.println(result);
	    return ((Integer)result).toString();

	}
}
