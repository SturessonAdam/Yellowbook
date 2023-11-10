public class Adress {
    private final String city;
    private final String postcode;
    private final String streetname;
    private final String doornumber;

    public Adress(Builder builder){
        this.city = builder.city;
        this.postcode = builder.postcode;
        this.streetname = builder.streetname;
        this.doornumber = builder.doornumber;
    }

    public static class Builder {
        private String city;
        private String postcode;
        private String streetname;
        private String doornumber;

        public Builder() {}

        public Builder withCity(String city){
            this.city = city;
            return this;
        }
        public Builder withPostcode(String postcode){
            this.postcode = postcode;
            return this;
        }
        public Builder withStreetname(String streetname){
            this.streetname = streetname;
            return this;
        }
        public Builder withDoornumber(String doornumber){
            this.doornumber = doornumber;
            return this;
        }

        public Adress build() {
            return new Adress(this);
        }


    }

    public String getCity() {
        return city;
    }
    public String getPostcode() {
        return postcode;
    }
    public String getStreetname() {
        return streetname;
    }
    public String getDoornumber() {
        return doornumber;
    }

    @Override
    public String toString() {
        return "Adress - " +
                "city: " + city +
                ", postcode: " + postcode +
                ", streetname: " + streetname +
                ", doornumber: " + doornumber;
    }
}
