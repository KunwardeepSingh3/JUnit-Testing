package edu.qc.seclass;

public abstract class MyCustomString implements MyCustomStringInterface{

	/* (non-Javadoc)
	 * @see edu.qc.seclass.MyCustomStringInterface#getString()
	 */
	
	private String myString;
	@Override
	public String getString() {
		// TODO Auto-generated method stub
		if(myString.isEmpty()) {
            return null;
        	}
        else {
            return myString;
        	}
		}

	/* (non-Javadoc)
	 * @see edu.qc.seclass.MyCustomStringInterface#setString(java.lang.String)
	 */
	@Override
	public void setString(String string) {
		// TODO Auto-generated method stub
		string = myString; 
	}

	/* (non-Javadoc)
	 * @see edu.qc.seclass.MyCustomStringInterface#countNumbers()
	 */
	@Override
	public int countNumbers() {
		// TODO Auto-generated method stub
		int count = 0;
		boolean previous = false;
		if(myString.isEmpty()){
            return 0;
        	}
        else if(myString == null){
            throw new NullPointerException();
        	}	
        else{
            for(int i = 0; i < myString.length(); i++){
                if(Character.isDigit(myString.charAt(i))){
                    if(previous == false){
                        count++;
                        previous = true;
                    	}
                    else if(Character.isDigit(myString.charAt(i+1)) && previous == true){
                        previous = true;
                    	}
                	}
                else{
                    previous = false;
                	}
            	}
            return count;
        	}
		}

	/* (non-Javadoc)
	 * @see edu.qc.seclass.MyCustomStringInterface#getEveryNthCharacterFromBeginningOrEnd(int, boolean)
	 */
	@Override
	public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
		// TODO Auto-generated method stub
		 StringBuffer resultingString = new StringBuffer();

	        if(n <= 0){
	            throw new IllegalArgumentException();
	        }

	        else if(this.myString == null && n > 0){
	            throw new NullPointerException();
	        }

	        else {
	            if (n > this.myString.length()) {
	                return "";
	            } else {
	                if (startFromEnd == true) {
	                    for (int i = this.myString.length() - n; i >= 0; i -= n) {
	                        resultingString.insert(0, this.myString.charAt(i));
	                    }
	                    return resultingString.toString();
	                } else {
	                    for (int i = n - 1; i < this.myString.length(); i += n) {
	                        resultingString.append(this.myString.charAt(i));
	                    }
	                    return resultingString.toString();
	                }
	            }
	        }
	}

	/* (non-Javadoc)
	 * @see edu.qc.seclass.MyCustomStringInterface#convertDigitsToNamesInSubstring(int, int)
	 */
	@Override
	public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
		// TODO Auto-generated method stub
		if(startPosition > endPosition){
            throw new IllegalArgumentException();
        }

        else if((startPosition <= endPosition) && ((startPosition < 1 || endPosition > this.myString.length()))){
            throw new MyIndexOutOfBoundsException();

        }
        
        else if((startPosition <= endPosition) && ((startPosition > 0 && endPosition > 0 && this.myString == null))){
            throw new NullPointerException();
        }

        else{
            StringBuffer resultingString = new StringBuffer();
            for(int i = 0; i < this.myString.length(); i++){
                if(Character.isDigit(myString.charAt(i)) && i >= startPosition-1 && i <= endPosition -1){
                    switch(myString.charAt(i)){
                        case '0' : 
                            resultingString.append("Zero");
                            break;
                        case '1' : 
                            resultingString.append("One");
                            break;
                        case '2' : 
                            resultingString.append("Two");
                            break;
                        case '3' : 
                            resultingString.append("Three");
                            break;
                        case '4' : 
                            resultingString.append("Four");
                            break;
                        case '5' : 
                            resultingString.append("Five");
                            break;
                        case '6' : 
                            resultingString.append("Six");
                            break;
                        case '7' : 
                            resultingString.append("Seven");
                            break;
                        case '8' : 
                            resultingString.append("Eight");
                            break;
                        case '9' : 
                            resultingString.append("Nine");
                            break;

                    }
                }
                else{
                    resultingString.append(this.myString.charAt(i));
                }
            }
            this.myString = resultingString.toString();
        }
    }
}