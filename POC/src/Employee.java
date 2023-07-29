import java.util.Objects;

public class Employee {
    int age;
    String name;
    String gender;
    String department;

    /**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	public Employee(String name, int age,String gender,String department) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department= department;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return age == employee.age && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", gender=" + gender + ", department=" + department + "]";
	}

  
}
