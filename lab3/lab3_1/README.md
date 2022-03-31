## a)
For example, in lines 53 and 75 of test A_EmployeeRepositoryTest:

assertThat(fromDb.getEmail()).isEqualTo( emp.getEmail());

assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());

Since we're using assertThat from AssertJ and using expressive methods chaining, with several different methods being called.

## b)
For example, in test B_EmployeeService_UnitTest we mock employeeRepository in line 33 so the tests of employeeService don't depend on the repository and consequently on a database. Also, just by being a unit test, we can conclude that it doesn't involve a database.


## c)
Both annotations create mock objects but with a slightly different purpose.
@Mock should be used when unit testing the business logic, while @MockBean should be used when writing a test that is backed up by a Spring Test Context and there is a need of adding or replacing a bean with a mock.
@Mock can be used whether working with Spring Boot or any other framework like Jakarta EE, Quarkus, Micronaut, Helidon... while @MockBean can only be used with the Spring Framework.

## d)
application-integrationtest.properties file is used to write the application-related properties, like the datasource url and the username and password for data accesses, every Spring Boot project must have it. In this specific case, database settings are stored so that integration tests can be executed.


## e)
In test C_EmployeeController_WithMockServiceTest, we use @WebMvcTest mode to simulate the behavior of an application server and @MockMvc to get a reference to the server context and providing an entry point to server-side testing and an expressive API. In this test, no database is involved.
On the other hand, there are tests D_EmployeeRestControllerIT and E_EmployeeRestControllerTemplateIT which are very similar themselves, but different from test C, since these are Integration tests.
Unlike test C, in tests D and E, several components participate in the tests (bearing in mind they're integration tests). Although, between these two last tests, there is a slightly difference. While test D uses MockMvc for server-side Spring MVC test support and test E uses TestRestTemplate to create realistic requests.

