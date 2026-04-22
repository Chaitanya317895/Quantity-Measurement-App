public class Main {

    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(0.0328084);

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toFeet(double value) {
            return value * toFeet;
        }
    }

    static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        private double toFeet() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Quantity q = (Quantity) obj;
            return Double.compare(this.toFeet(), q.toFeet()) == 0;
        }
    }

    public static void main(String[] args) {

        System.out.println(new Quantity(1.0, LengthUnit.YARDS)
                .equals(new Quantity(3.0, LengthUnit.FEET)));

        System.out.println(new Quantity(1.0, LengthUnit.YARDS)
                .equals(new Quantity(36.0, LengthUnit.INCH)));

        System.out.println(new Quantity(2.0, LengthUnit.YARDS)
                .equals(new Quantity(2.0, LengthUnit.YARDS)));

        System.out.println(new Quantity(2.0, LengthUnit.CENTIMETERS)
                .equals(new Quantity(2.0, LengthUnit.CENTIMETERS)));

        System.out.println(new Quantity(1.0, LengthUnit.CENTIMETERS)
                .equals(new Quantity(0.393701, LengthUnit.INCH)));
    }
}