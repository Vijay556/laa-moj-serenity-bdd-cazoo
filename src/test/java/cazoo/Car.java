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

    // for some reason the above @Getter @Setter methods are not functioning for me hence I had to write these following setters and getters
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Car other = (Car) obj;
        if ((this.reg == null) ? (other.reg != null) : !this.reg.equals(other.reg)) {
            return false;
        }

        if (this.make != other.make) {
            return false;
        }

        return this.model == other.model;
    }
}
