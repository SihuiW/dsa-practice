class DynamicArray {

    int[] arr;
    int p = 0;

    public DynamicArray(int capacity) {
        this.arr = new int[capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (p == arr.length) {
            resize();
        }
        arr[p++] = n;
    }

    public int popback() {
        return arr[--p];
    }

    private void resize() {
        arr = Arrays.copyOf(arr, 2 * arr.length);
    }

    public int getSize() {
        return p;
    }

    public int getCapacity() {
        return arr.length;
    }
}
