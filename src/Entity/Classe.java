package Entity;

import java.util.Objects;

public class Classe {

    private int class_id;
    private String class_name;
    private int class_nbr;

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getClass_nbr() {
        return class_nbr;
    }

    public void setClass_nbr(int class_nbr) {
        this.class_nbr = class_nbr;
    }

    @Override
    public String toString() {
        return class_name;
    }

    public Classe(int class_id, String class_name, int class_nbr) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.class_nbr = class_nbr;
    }
}
