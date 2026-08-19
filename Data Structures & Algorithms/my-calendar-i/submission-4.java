class MyCalendar {

    List<int[]> list = new ArrayList<>();

    public MyCalendar() {
        
    }
    
    public boolean book(int startTime, int endTime) {
        for (int[] event : list) {
            int ps = event[0];
            int pe = event[1];
            if (startTime < pe && endTime > ps) return false;
        }

        list.add(new int[]{startTime, endTime});
        return true;
    }
}

