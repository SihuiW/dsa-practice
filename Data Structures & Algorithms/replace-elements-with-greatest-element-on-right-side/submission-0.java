class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int pre = arr[n - 1];
        int rightMax = arr[n - 1];
        arr[n - 1] = -1; 
        for(int i = arr.length - 2; i >= 0; i--) {
            int temp = pre;
            pre = arr[i];
            arr[i] = Math.max(temp, rightMax);
            rightMax = arr[i];
            
            
        }
        return arr;
    }
}