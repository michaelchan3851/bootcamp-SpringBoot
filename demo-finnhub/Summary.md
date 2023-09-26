1. @Contoller + @ResponseBody (@RestController)
   - Bean + Web Layer
2. @Service
   - Bean
3. @Repository (JPA + Hibernate)
   - Define Entity (with @Id & implements Serializable) per table operation, with non-RestFul interaction
   - Bean
   - JPA include basic CRUD operations
   - method name rules for Hibernate generating implementions
   - @Query -> JPQL (Entity) or Native SQL
   - nativeQuery = True
   - Isolate the Database implementation and Hiberate (MySQL, Oracle)
4.  @Configuration (Class Annotation)
    - @Bean (Method Annotation) -> Create Bean By Method
5. What is Depenedency Injection (DI)?
  - @Autowird
    - field injection (@Autowird on a field)
    - constructor injection (@Autowird on a constructor)
  - Controller dpends on Service (because controller autowired service)
  - AppConfig class depends on yml (for example, it used @Value)
6. What is Ioc (Inversion of Control)
  - Java: use new keyword to create object. You are the only one 
  to control the relationship between objects.
  - Spring or SpringBoot: Application Context plays a role of
   managing the depenedency between objects. It complains during the 
   server starts if it found some dependency is missing. 
7. @RestTemplate
  - getForObject
  - UriComponentsBuilder (with yml, @Value)
  - Define the return type (Object or Array)
8. model class (DTO) // Json properties -> business class
  - lombok
  - ModeMapper
  - mapper class 
9. @Scheduled
  - @FixRated, @FixDelay, @Scheduled (cron = ?)
10. CommandLineRunner (Interface)
  - @Component - @Autowird
  - Implements run method
  - this method will be executed during server start
  - Server start will fail if the run method fail
11. ApiResponse<T> 
  - generics of data
12. Custom Exception class (extends Exception.class)
  - BusinessException
13. GlobExceptionHandler
  - @ControllerAdvise (@RestControllerAdvise)
  - @ExceptionHandler (method)
  - Catch from child to parent (includes runtimes, checked exception)
14. DTO
  - Deserialization (Controller RequestBody: from JSON to Object)
  - Serialization (Controller ResponseBody: from Object to JSON)
  - ObjectMapper (test code)


6. test code
  - By Environment & Layer
    - @Test, @SpringBootTest
    - Web Layer
      - @WebMvcTest (@Controller only) 
      - @MockBean for Service (Controller Autowird Service)
      - Mockito, when & thenReturn for MockBean's behaviour/method
      - mockMvc.perform() -> test JSON structure
      - verify if service layer being called
    - Service Layer
      - @SpringBootTest
      - @MockBean for Repository (Service autowired Repository)
      - @Mock, @InjectMock -> mock normal java class & method
      - Mockito, when & thenReturn for MockBean's behaviour/method
      - Hamcrest (assertThat)
    - Respository Layer
      - @DataJpaTest
      - Autowired TestEntityManager
      - TestEntityManager.persist() -> prepare testing data
      - repository.save(), findById() -> test Hibernate