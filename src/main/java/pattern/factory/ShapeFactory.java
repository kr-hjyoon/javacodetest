package pattern.factory;

public class ShapeFactory {
    public Shape getShape(String shapertype){
        if (shapertype == null){
            return null;
        }

        if (shapertype.equalsIgnoreCase("circle")){
            return new Circle();
        }else if (shapertype.equalsIgnoreCase("square")){
            return new Square();
        }else if (shapertype.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }
        return null;
    }
}
