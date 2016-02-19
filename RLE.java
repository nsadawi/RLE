/**
 *
 * @author Dr Noureddin Sadawi
 */
public class RLE {
 
/**
 * Receives an array of ints and returns a String that has the form:
 * c1 v1 c2 v2 c3 c3 ... cn vn
 * The c is represents the count and the v is for the value
 * When passed {0,0,0,0,1,1,0,1,1,0,0,0,1,1,1,1,1} it returns 402110213051 
 *
 * @param  values  an array of ints
 * @return      a string 
 */
public static String encode(int[] values) {
    StringBuffer rle = new StringBuffer();
    for (int i = 0; i < values.length; i++) {
        int runLength = 1;
        while (i + 1 < values.length && values[i] == values[i + 1]) {
            runLength++;
            i++;
        }
        rle.append(runLength);
        rle.append(values[i]);
    }
    return rle.toString();
}

/**
 * Receives a String that has the form:
 * c1 v1 c2 v2 c3 c3 ... cn vn
 * The c is represents the count and the v is for the value
 * It returns an array of ints
 * When passed "402110213051" it returns {0,0,0,0,1,1,0,1,1,0,0,0,1,1,1,1,1}
 *
 * @param  source  a string representing an RLE
 * @return   an array of ints (the original values)
 */
public static int[] decode(String source) {
    int arrLength = 0;
    for(int i = 0; i < source.length(); i+=2){
        int count = Character.getNumericValue(source.charAt(i));
        arrLength+=count;
    }
    
    int array[] = new int[arrLength];
    int k=0;
    for(int i = 0; i < source.length(); i+=2){
        int count = Character.getNumericValue(source.charAt(i));
        for(int j = 0; j < count; j++){
          array[j+k] = Character.getNumericValue(source.charAt(i+1));
        }
        k+=count;
    }                    
    return array;
}


   public static void main(String[] args) {             
 	int a[] = {0,0,0,0,1,1,0,1,1,0,0,0,1,1,1,1,1};
 	String s = encode(a);
 	System.out.println(s);
 	int r[] = decode(s);
 	for(int x = 0; x < r.length; x++)
 	   System.out.print(r[x]);
 	System.out.println();
   }
}
