
//@RestController 
//@CrossOrigin
//public class JwtAuthenticationController {
//
//@Autowired
//private AuthenticationManager authenticationManager;
//
//@Autowired
//private JwtTokenUtil jwtTokenUtil;
//
//@Autowired
//private UserService userServiceI;
//
//@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//
//authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//final UserDetails userDetails = userServiceI.loadUserByUsername(authenticationRequest.getUsername());
//
//final String token = jwtTokenUtil.generateToken(userDetails);
//
//return ResponseEntity.ok(new JwtResponse(token));
//}
//
//private void authenticate(String username, String password) throws Exception {
//try {
//authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//} catch (DisabledException e) {
//throw new Exception("USER_DISABLED", e);
//} catch (BadCredentialsException e) {
//throw new Exception("INVALID_CREDENTIALS", e);
//}
//}
//}
//
//
//	
//
