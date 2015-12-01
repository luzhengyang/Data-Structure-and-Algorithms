// The API: int read4(char *buf) reads 4 characters at a time from a file.

// The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

// By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.




/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */



//NOTE: read4 function reads a file into buf. buf stores characters.


public class ReadNCharactersGivenRead4{
	 /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n){
    	// read a file into buf
        // the argument buf is used to store results

		// buf4 is used as the argument of read4 function
		// when read4 is called, buf4 is filled with chars
    	char[] buf4 = new char[4];
    	int from = 0;

    	while(true){
    		int numOfCharsRead = read4(buf4);
    		int len = Math.min(numOfCharsRead, n - len);
    		for(int i=0; i<len; i++){
    			buf[from + i] = buf4[i];
    		}
    		from += len;
    		if(from >= n || numOfCharsRead != 4){
    			return from;
    		}
    	}
    }
}
