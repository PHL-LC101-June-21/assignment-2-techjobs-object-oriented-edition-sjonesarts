package org.launchcode.techjobs.oo;


public class Employer extends JobField {
    public Employer()
    {
        super();
    }

    public Employer(String value)
    {
        this();
        this.setValue( value );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        Employer employer = (Employer) o;
        return getId() == employer.getId();
    }
}