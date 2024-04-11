package com.betrybe.agrix;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class PersonServiceTest {

  @Autowired
  PersonService personService;

  @Test
  public void testPersonCreation() {
    Person person = new Person();
    person.setUsername("testName");
    person.setPassword("test1234");
    person.setRole(Role.USER);

    Person personSaved = personService.create(person);

    assertNotNull(personSaved.getId());
    assertEquals(person.getUsername(), personSaved.getUsername());
    assertEquals(person.getPassword(), personSaved.getPassword());
    assertEquals(person.getRole(), personSaved.getRole());
  }

  @Test
  public void testPersonRetrievalById() {
    Person person = new Person();
    person.setUsername("testName2");
    person.setPassword("test1234");
    person.setRole(Role.USER);

    Person personSaved = personService.create(person);

    Person personRetrieved = personService.getPersonById(personSaved.getId());

    assertEquals(personSaved.getId(), personRetrieved.getId());
    assertEquals(personSaved.getUsername(), personRetrieved.getUsername());
    assertEquals(personSaved.getPassword(), personRetrieved.getPassword());
    assertEquals(personSaved.getRole(), personRetrieved.getRole());
  }

  @Test
  public void testPersonRetrievalByUsername() {
    Person person = new Person();
    person.setUsername("testName3");
    person.setPassword("test1234");
    person.setRole(Role.USER);

    Person personSaved = personService.create(person);

    Person personRetrieved = personService.getPersonByUsername(personSaved.getUsername());

    assertEquals(personSaved.getId(), personRetrieved.getId());
    assertEquals(personSaved.getUsername(), personRetrieved.getUsername());
    assertEquals(personSaved.getPassword(), personRetrieved.getPassword());
    assertEquals(personSaved.getRole(), personRetrieved.getRole());
  }

  @Test
  public void testPersonRetrievalByIdNotFound() {
    Person person = new Person();
    person.setUsername("testName4");
    person.setPassword("test1234");
    person.setRole(Role.USER);

    Person personSaved = personService.create(person);

    try {
      personService.getPersonById(personSaved.getId() + 1);
    } catch (Exception e) {
      assertEquals("Pessoa não encontrada!", e.getMessage());
    }
  }

  @Test
  public void testPersonRetrievalByUsernameNotFound() {
    Person person = new Person();
    person.setUsername("testName5");
    person.setPassword("test1234");
    person.setRole(Role.USER);

    Person personSaved = personService.create(person);

    try {
      personService.getPersonByUsername(personSaved.getUsername() + "1");
    } catch (Exception e) {
      assertEquals("Pessoa não encontrada!", e.getMessage());
    }
  }
}
