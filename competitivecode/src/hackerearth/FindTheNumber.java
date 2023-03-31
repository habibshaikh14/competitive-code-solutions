package hackerearth;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTheNumber {

  public static void main(String[] args) {
    /** Sample test case */
    int n = 50;
    int x = 8;
    long k = 40001;
    String s = "69859241839387868941176158769631317592843734734832";

    String soln = solution(x, k, s, n);
    System.out.println(soln);
  }

  private static String solution(int x, long k, String s, int n) {
    StringBuilder result = new StringBuilder();

    // Create a list of blocks by splitting the string s into block of size x.
    ArrayList<String> blocks = new ArrayList<>();
    for (int start = 0; start < n; start = start + x) {
      int end = start + x;
      if (end > n) {
        end = n;
      }
      char[] block = s.substring(start, end).toCharArray();
      Arrays.sort(block); // sort the newly created block

      // remove duplicates from the block
      StringBuilder blockString = new StringBuilder();
      blockString.append(block[0]);
      for (int j = 1; j < block.length; j++) {
        if (block[j] != block[j - 1]) {
          blockString.append(block[j]);
        }
      }

      // add the final block into the list
      blocks.add(blockString.toString());
    }
    System.out.println(blocks);


    k--; // decrement the kth position value because decimal values start from 0.
    
    // traverse the blocks list in reverse order
    for (int i = blocks.size() - 1; i >= 0; i--) {
      String position = "0";
      String block = blocks.get(i);
      /**
       * convert the base 10 k value to base n value where n is the current block size.
       * skip this step if the value of k is 0
       * in every iteration of base conversion we will get the index of the value to be extracted from the block
       */
      if (k != 0) {
        position = String.valueOf(k % block.length());
        k /= block.length();
      }

      /**
       * after the index is extracted fetch the the value present at that index of the block.
       * append the value to the result
       */
      result.append(block.charAt(Integer.parseInt(position)));
      System.out.println(position);
    }
    return result.reverse().toString(); // reverse the result to get the final solution.
  }
}
