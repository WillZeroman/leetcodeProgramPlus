public class DayOfTheWeek {

    private String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
    private int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

    public String dayOfTheWeek(int day, int month, int year) {
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        for (int i = 0; i < month - 1; ++i) {
            days += monthDays[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        days += day;
        return week[(days + 3) % 7];
    }

    public static void main(String[] args) {
        System.out.println(new DayOfTheWeek().dayOfTheWeek(3,1,2022));
    }
}
