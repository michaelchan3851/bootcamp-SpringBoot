###
#### 18 Sep
- enum (Code.java, ApiResponse.java)
- BusinessException, JPHExecption
- Mapper Logic (UserMapper.java, used to convert from User -> UserDTO)
- WebMvcTest -> @Autowird MockMvc ->  @MockBean
- @SpringBootTest (Complete SB environment, full context)
- ResponseEntity (because sometimes we have to return non-200 status)
- GlobalExceptionHandler(ControllerAdvice)