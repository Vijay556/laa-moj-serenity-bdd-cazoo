package cazoo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private String reg;
    private String make;
    private String model;

    public Car(String reg) {
        this.reg = reg;
    }

    public Car() {}

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return this.reg + " + " + this.make + " + " + this.model;
    }
}
