package concepts.map;

class Employee {
    private Integer id;
    private Integer salary;
    private Double taxes;

    private Employee(Integer id, Integer salary, Double taxes) {
        this.id = id;
        this.salary = salary;
        this.taxes = taxes;
    }

    static class Builder {
        private Integer id;
        private Integer salary;
        private Double taxes;

        public Builder(Integer id) {
            this.id = id;
        }

        public Builder withSalary(Integer salary) {
            this.salary = salary;
            return this;
        }

        public Builder withTaxes(Double tax) {
            this.taxes = tax;
            return this;
        }

        public Employee build() {
            return new Employee(this.id, this.salary, this.taxes);
        }


    }

    public Double obtainSalaryWithTaxes() {
        return salary - (salary * taxes);
    }

    @Override
    public String toString() {
        return "Employee id: " + id;
    }

    @Override
    public int hashCode() {
        return this.id * 31;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee e = (Employee) o;
        return e.id == this.id ;
    }
}
