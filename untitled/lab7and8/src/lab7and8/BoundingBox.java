package lab7and8;

public class BoundingBox {
    double xmin = Double.NaN;
    double xmax = Double.NaN;
    double ymin = Double.NaN;
    double ymax = Double.NaN;
    boolean isEmpty = isEmpty();



    @Override
    public String toString(){
        StringBuilder s1 = new StringBuilder();
        s1.append("xmin: ").append(this.xmin).append(" ");
        s1.append("xmax: ").append(this.xmax).append(" ");
        s1.append("ymin: ").append(this.ymin).append(" ");
        s1.append("ymax: ").append(this.ymax).append(" ");
        return s1.toString();
    }
    void addPoint(double x, double y){
        if(isEmpty){
            this.xmin = x;
            this.xmax = x;
            this.ymin = y;
            this.ymax = y;
        }
        else{
            if (x < xmin)
                xmin = x;
            else if (x > xmax)
                xmax = x;
            if (y < ymin)
                ymin = y;
            else if (y > ymax)
                ymax = y;
        }
        this.isEmpty = false;
    }
    boolean contains(double x, double y){
        if ( isEmpty()==false && x>=xmin && x<=xmax && y>=ymin && y<=ymax)
            return true;

        return false;
    }
    boolean contains(BoundingBox bb){
        if (isEmpty()==false && bb.isEmpty()==false && this.xmin<=bb.xmin && this.xmax>=bb.xmax && this.ymin<=bb.ymin && this.ymax>=bb.ymax)
            return true;


        return false;
    }
    boolean intersects(BoundingBox bb) {
        if (this.isEmpty() == false && bb.isEmpty() == false && this.xmax >= bb.xmin && this.xmin <= bb.xmax && this.ymax >= bb.ymin && this.ymin <= bb.ymax)
            return true;

        return false;
    }

    boolean isEmpty() {
        return Double.isNaN(xmin) && Double.isNaN(xmax) && Double.isNaN(ymin) && Double.isNaN(ymax);
    }

    double getCenterX(){
        if (isEmpty()==false)
            return (xmax+xmin)/2.0;
        else throw new RuntimeException("box is empty");

    }

    double getCenterY()
    {
        if (isEmpty()==false)
            return (ymax+ymin)/2.0;
        else throw new RuntimeException("box is empty");
    }

    double distanceTo(BoundingBox bb){
        if (this.isEmpty()==true || bb.isEmpty()==true)
            throw new RuntimeException("Box is Empty!");

        double _centerX = getCenterX();
        double _centerY = getCenterY();
        double bb_centerX = bb.getCenterX();
        double bb_centerY = bb.getCenterY();

        //Haversine
        double a = Math.min(_centerY, bb_centerY);
        double b = Math.min(_centerX, bb_centerX);
        double c = Math.max(_centerY, bb_centerY);
        double d = Math.max(_centerX, bb_centerX);

        return this.haversine(a,b,c,d);
    }
                                    //latitude       //longitude
    private double haversine(double startLat, double startLong, double endLat, double endLong ){
        double dLat  = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        double tmp1 = Math.pow(Math.sin(dLat/2),2)  + Math.cos(startLat)*Math.cos(endLat)*  Math.pow(Math.sin(dLong/2),2);
        double tmp2 = 2 * Math.atan2(Math.sqrt(tmp1),Math.sqrt(1-tmp1));

        return 6371*tmp2;   //EarthRadius * tmp2

    }










}
