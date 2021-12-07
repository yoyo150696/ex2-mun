package api;


public class GeoLocation {
    private double x;
    private double y;
    private double z;
    public GeoLocation(double x,double y,double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double z() {
        return z;
    }

    public double distance(GeoLocation g) {
        return Math.sqrt(Math.pow(Math.abs(this.x-g.x),2)+Math.pow(Math.abs(this.y-g.y),2));
    }
}
