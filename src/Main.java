public class Main {
    public static void main(String[] args) {

        System.out.println("--- Task 24 ---");
        //Созд.класс,описывающий промежуток времени. Сам промежуток в классе долж.задаваться тремя св-вами:
        //сек., мин.,часами. Сделать методы д./получ.полн.кол-ва секунд в объекте, сравн..двух объектов(долж.работать
        //аналогично CompareTo в строках). Созд.два конструктора: 1).Получающий общее кол-во сек., 2) Получающий часы,
        // мин.,сек. по отдельности. Сделать метод для вывода данных.

        TimeInterval interval = new TimeInterval (20, 3, 5);
        TimeInterval interval1 = new TimeInterval (4, 4, 2);
        TimeInterval interval3 = new TimeInterval(4900);

        System.out.println("Total Sec Count: " + GetSecTotalCount(interval));

        int answer = AnalogueCompareTo(interval,interval1);

        if (answer == 0) {
            System.out.println("Промежутки равны");
        } else if (answer > 0) {
            System.out.println("Промежуток 1 больше промежутка 2");
        } else {
            System.out.println("Промежуток 1 меньше промежутка 2");
        }

        System.out.println(interval3.hour + " часов " + interval3.min + " минут " + interval3.sec + " сек");
    }

    public static class TimeInterval {
        int sec;
        int min;
        int hour;

        public TimeInterval(int sec, int min, int hour) {
            this.sec = sec;
            this.min = min;
            this.hour = hour;
        }
        public TimeInterval (int totalSecCount) {
            this.hour = totalSecCount / 3600;
            this.min = (totalSecCount - (hour * 3600))/ 60;
            this.sec = totalSecCount % 60;
        }
    }
    public static int GetSecTotalCount (TimeInterval interval) {
        int SecTotalCount = 0;
        SecTotalCount += (interval.sec + interval.min * 60 + interval.hour * 3600);

        return SecTotalCount;
    }

    public static int AnalogueCompareTo (TimeInterval comparisonInterval, TimeInterval comparisonInterval1) {
        int isLarger;
        int firstIntervalSec = GetSecTotalCount(comparisonInterval);
        int secondIntervalSec = GetSecTotalCount(comparisonInterval1);

        if (firstIntervalSec > secondIntervalSec) {
            isLarger = 1;
        } else if (firstIntervalSec < secondIntervalSec) {
            isLarger = -1;
        } else {
            isLarger = 0;
        }
        return isLarger;
    }
}