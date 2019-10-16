package com.mycompany.hibernate_demo_crud_demo.shared;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SharedEmployee {
	private String firstName;
	private String lastName;
	private String email;
	@Override
	public String toString() {
		return "SharedEmployee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	

}
