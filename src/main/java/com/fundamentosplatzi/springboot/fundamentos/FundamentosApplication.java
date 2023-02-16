package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MiPrimerBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.bean.OperacionMatematica;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MiPrimerBean miPrimerBean;
	private OperacionMatematica operacionMatematica;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								  MiPrimerBean miPrimerBean, OperacionMatematica operacionMatematica,
								  MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.miPrimerBean = miPrimerBean;
		this.operacionMatematica = operacionMatematica;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args){
		//this.llamadoDeInstancias();
		this.saveUsersInDataBase();
		this.getInformationJPQLFromUser();

	}

	public void getInformationJPQLFromUser() throws Throwable {
		LOGGER.info("usando findByUserEmail: " + userRepository.findByUserEmail("karen@domain.com")
				.orElseThrow(() -> new RuntimeException("No se encontro el usuario")));

		userRepository.findAndSort("user", Sort.by("id").ascending())
				.stream().forEach(user -> LOGGER.info("usando findAndSort: " + user));


		userRepository.findByName("Marisol").stream().forEach(user -> LOGGER.info("Usuario con query method "  + user));

		LOGGER.info(userRepository.findByEmailAndName("paola@domain.com","Paola").
				orElseThrow( () -> new RuntimeException("Usuario no encontrado")));
	}

	private void saveUsersInDataBase(){
		User user1 = new User("John", "john@domain.com", LocalDate.of(2023, 3, 13));
		User user2 = new User("Marco", "marco@domain.com", LocalDate.of(2023, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2023, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2023, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2023, 1, 1));
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2023, 7, 7));
		User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2023, 11, 12));
		User user8 = new User("Luis", "luis@domain.com", LocalDate.of(2023, 2, 27));
		User user9 = new User("Paola", "paola@domain.com", LocalDate.of(2023, 4, 10));
		User user10 = new User("user10", "user10@domain.com", LocalDate.of(2023, 11, 12));
		User user11 = new User("user11", "user11@domain.com", LocalDate.of(2023, 2, 27));
		User user12 = new User("user12", "user12@domain.com", LocalDate.of(2023, 4, 10));
		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);
		list.forEach(userRepository::save);
	}

	public void llamadoDeInstancias(){
		this.componentDependency.hablar();
		this.miPrimerBean.print();
		this.operacionMatematica.realizarOperacion(10);
		System.out.println(this.myBeanWithProperties.function());
		System.out.println(this.userPojo.getEmail() + " - " + this.userPojo.getPassword() + " - " + this.userPojo.getAge());
		try {
			int valor = 10 / 0;
		}
		catch(Exception e){
			this.LOGGER.error("Error al intentar la operacion: " + e.getMessage());
		}
	}
}
