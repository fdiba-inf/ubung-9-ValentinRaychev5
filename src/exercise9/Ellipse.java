package exercise9;

public class Ellipse {

  private Point start;
  private double height; //axis
  private double width;

  public Ellipse()  {
    this.start = new Point(0, 0);
    height = 1;
    width = 1;
  }

  public Ellipse(Point start, double height, double width) {
    this.start = new Point(start);//?
    this.height = height;
    this.width = width;
  }

  public Ellipse(Ellipse otherEllipse)  {
    this.start = new Point(otherEllipse.start);
    this.height = otherEllipse.height;
    this.width = otherEllipse.width;
  }

  public boolean isValid() {
    return width > 0 && height > 0;
  }

  public void initialize() {
    do {
      System.out.println("Start point: ");
      start.initialize();
      System.out.print("Enter height: ");
      height = Utils.INPUT.nextDouble();
      System.out.print("Enter width: ");
      width = Utils.INPUT.nextDouble();
    }while(!isValid());
  }

  public double calculatePerimeter()  {
    return Math.PI * (3*(height + width) - Math.sqrt((3*width + height)*(3*height + width)));
  }

  public double calculateArea() {
    return Math.PI * height * width;
  }

  public String getType() {
    return (height == width) ? "Circle" : "Ellipse";
  }

  public String toString()  {
    return String.format("%s-[%s, %s], %s, P=%s, A=%s", start, height, width, getType(), calculatePerimeter(), calculateArea());
  }

  public boolean isEqual(Ellipse otherEllipse)  {
    boolean equalHeight = Utils.equals(this.height, otherEllipse.height);
    boolean equalWidth = Utils.equals(this.width, otherEllipse.width);
    boolean reverseHeight = Utils.equals(this.height, otherEllipse.width);
    boolean reverseWidth = Utils.equals(this.width, otherEllipse.height);

    return ((equalHeight && equalWidth) || (reverseHeight && reverseWidth));
  }
}
