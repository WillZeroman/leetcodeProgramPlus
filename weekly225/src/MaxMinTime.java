public class MaxMinTime {
    public String maximumTime(String time) {
        String[] data = time.split(":");
        String hour = data[0];
        String min = data[1];
        if(hour.contains("?")){
            if(hour.charAt(0) == '?') {
                if(hour.charAt(1) == '0' || hour.charAt(1) == '1' || hour.charAt(1) == '2' || hour.charAt(1) == '3'){
                    hour = "2" + hour.charAt(1);
                }else if(hour.charAt(1) == '?') {
                    hour = "23";
                } else {
                    hour = "1" + hour.charAt(1);
                }
            }
            else {
                if(hour.charAt(0) == '0' || hour.charAt(0) == '1'){
                    hour = hour.charAt(0) + "9";
                }else {
                    hour = "23";
                }
            }
        }

        if(min.contains("?")){
            if(min.charAt(0) == '?'){
                if(min.charAt(1)=='?'){
                    min = "59";
                }else {
                    min = "5" + min.charAt(1);
                }
            }else {
                min = min.charAt(0) + "9";
            }
        }
        return hour + ":" + min;
    }

    public static void main(String[] args) {
        System.out.println(new MaxMinTime().maximumTime("2?:?0"));
        System.out.println(new MaxMinTime().maximumTime("??:?0"));
        System.out.println(new MaxMinTime().maximumTime("1?:22"));
    }
}
