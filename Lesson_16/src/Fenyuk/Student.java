package Fenyuk;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
	
	public String name;
	private String lastName;
	private int age;
	private double height;
	public int level;
	
	public Student() {
		super();
	}

	public Student(String name, int age, double height, int level) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.level = level;
	}

	public Student(int age, int level) {
		super();
		this.age = age;
		this.level = level;
	}

	public Student(String name, int age, double height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, height, level, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
				&& level == other.level && Objects.equals(name, other.name);
	}

	public void  changeOfCourse(String name, int courseNumber ){
		System.out.println("The student " + name + " transferred to the " + courseNumber + " course");
	}
	
	private void studentChangeOfCourse(String lastName){
		System.out.println("Student " + lastName + " transferred to the next course");
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", height=" + height + ", level=" + level + "]";
	}
	
	

}
