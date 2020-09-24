package lambda;

public class Apple {

    private String color;
    private Integer weight;

    public Apple(String color, Integer weight) {
        this.weight = weight;
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return this.color;
    }

    public Integer getWeight() {
        return this.weight;
    }
}
