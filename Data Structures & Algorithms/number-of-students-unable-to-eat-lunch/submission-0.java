class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
       int s0 = 0;
       int s1 = 0;
       for(int i = 0; i < students.length; i++) {
            if(students[i] == 0) {
                s0++;
            } else {
                s1++;
            }
       }

       int i;

       for(i = 0; i < sandwiches.length; i++) {
            int curSand = sandwiches[i];
            if(curSand == 0 && s0 > 0) {
                s0--;
            } else if(curSand == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
       }

        return sandwiches.length - i;

    }
}