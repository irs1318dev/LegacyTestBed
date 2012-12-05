package org.usfirst.frc1318.shared;

import org.usfirst.frc1318.shared.constants.ButtonRef;

public class ButtonData {

	boolean[] buttons;
	boolean[] lastPressed;
	int[] type;
	
	public ButtonData(int numberOfButtons) {
		buttons = new boolean[numberOfButtons]; 
		lastPressed = new boolean[numberOfButtons];
		type = new int[numberOfButtons];
		for (int i = 0; i < numberOfButtons; i++) {
			type[i] = ButtonRef.PRESS_AND_HOLD;
		}
	}
	
	public void setAllButtons(boolean bool){
		for(int i = 0; i < buttons.length; i++){
			buttons[i] = bool;
		}
	}

	public boolean[] getAllButtons(){
		return buttons;
	}
	
	/**
	 * @deprecated
	 * This method is supposed to be used to set the button's initial value only. For repeated use, use the isPressed method
	 * @param buttonNumber
	 * @param bool
	 */
	private void setButton(int buttonNumber, boolean bool) {
		buttons[buttonNumber] = bool;
	}
	
	public void setButtonType(int buttonNumber, int type) {
		this.type[buttonNumber] = type;
	}
	
	public void setButton(int buttonNumber, int buttonType, boolean state) {
		buttons[buttonNumber] = state;
		type[buttonNumber] = buttonType;
	}
	
	public void overrideButton(int buttonNumber, boolean state) {
		buttons[buttonNumber] = state;
	} 
	
	/**
	 * Records the state of the button according to which kind of button the selected button is. Toggle buttons have some code to remove bugs.
	 * 
	 * @param buttonNumber
	 * @param state
	 */
	public void isPressed(int buttonNumber, boolean state) {
		if(type[buttonNumber]==ButtonRef.PRESS_AND_HOLD) {
			buttons[buttonNumber] = state;
		} else {
			if(type[buttonNumber]==ButtonRef.TOGGLE) {
				if(state) { //if the button is pressed
					if(!lastPressed[buttonNumber]) { //if the button was not pressed last time this was run
						buttons[buttonNumber] = !buttons[buttonNumber]; //toggle the state
					}
				}
			}
		}
		lastPressed[buttonNumber] = state;
	}
	
	public boolean getButton(int buttonNumber){
		return buttons[buttonNumber];
	}

	public boolean equals(Object otherData) {
		if(otherData==null) {
			return false;
		} else if(!otherData.getClass().equals(ButtonData.class)) {
			return false;
		}
		ButtonData that = (ButtonData) otherData;
		try {
			for(int i = 0; i < buttons.length; i++) {
				if(that.getButton(i) != buttons[i]) {
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean copyTo(ButtonData otherData) {
		if(otherData==null) {
			return false;
		} else if(!otherData.getClass().equals(ButtonData.class)) {
			return false;
		}
		ButtonData that = (ButtonData) otherData;
		try {
			for(int i = 0; i < buttons.length; i++) {
				that.setButton(i, buttons[i]);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
}
