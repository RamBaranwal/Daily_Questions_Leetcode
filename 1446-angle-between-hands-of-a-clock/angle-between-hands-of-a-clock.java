class Solution {
    public double angleClock(int hour, int minutes) {
        // for hour 
        double hourAngle = 0;
        if(hour == 12){
            hourAngle = 0;
        }
        else{
            hourAngle = 30 * hour;
        }

        // now add the degree due to min

        double hourDueToMin = (double) minutes / 2;
        hourAngle += hourDueToMin;

        // now see the min

        double minAngle = 6 * minutes;

        double angle = Math.abs(hourAngle - minAngle);

        return Math.min(360.0 - angle, angle);
    }
}